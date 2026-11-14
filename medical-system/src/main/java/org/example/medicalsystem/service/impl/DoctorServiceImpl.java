package org.example.medicalsystem.service.impl;

import org.example.medicalsystem.entity.Doctor;
import org.example.medicalsystem.mapper.DoctorMapper;
import org.example.medicalsystem.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医生表 服务实现类
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

}
