package org.example.medicalsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.medicalsystem.entity.*;
import org.example.medicalsystem.exception.BusinessException;
import org.example.medicalsystem.mapper.*;
import org.example.medicalsystem.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements IRegistrationService {
    // ⚠️ 注意上面这行：保留 extends ServiceImpl 和 implements IRegistrationService

    // 注入其他表的 Mapper（RegistrationMapper 已经在父类 ServiceImpl 里自带了，这里不用再注入了）
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private MedicineMapper medicineMapper;

    // ⚠️ 核心考点：声明式事务
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String register(Registration registration, Long medicineId) {

        // 1. 校验患者是否存在
        Patient patient = patientMapper.selectById(registration.getPatientId());
        if (patient == null) {
            throw new BusinessException("挂号失败：患者不存在！");
        }

        // 2. 异常处理校验：重复挂号
        LambdaQueryWrapper<Registration> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Registration::getPatientId, registration.getPatientId())
                .eq(Registration::getDoctorId, registration.getDoctorId())
                .eq(Registration::getStatus, 1);
        // 注意这里用 this.count() 或 this.list()，因为父类有现成的方法
        if (this.count(wrapper) > 0) {
            throw new BusinessException("挂号失败：您已挂过该医生的号，请勿重复挂号！");
        }

        // 3. 校验医生号源
        Doctor doctor = doctorMapper.selectById(registration.getDoctorId());
        if (doctor == null) {
            throw new BusinessException("挂号失败：医生不存在！");
        }
        if (doctor.getDailyLimit() <= 0) {
            throw new BusinessException("挂号失败：该医生今日号源已满！");
        }

        // 4. 扣减号源
        doctor.setDailyLimit(doctor.getDailyLimit() - 1);
        doctorMapper.updateById(doctor);

        // 5. 保存挂号记录
        registration.setRegTime(LocalDateTime.now());
        registration.setStatus(1);
        // 注意：父类 ServiceImpl 自带 this.save() 方法，比去调 Mapper.insert 更优雅
        this.save(registration);

        // 6. 模拟处方生成与药品库存扣减
        if (medicineId != null) {
            Medicine medicine = medicineMapper.selectById(medicineId);
            if (medicine != null) {
                if (medicine.getStock() <= 0) {
                    throw new BusinessException("挂号失败：所需药品库存不足！");
                }
                medicine.setStock(medicine.getStock() - 1);
                medicineMapper.updateById(medicine);
            }
        }

        // 7. 模拟异常测试
        if (registration.getFee() != null && registration.getFee().doubleValue() == 0) {
            throw new RuntimeException("模拟系统断电异常，测试事务回滚！");
        }

        return "挂号成功！";
    }
}