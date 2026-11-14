package org.example.medicalsystem.service.impl;

import org.example.medicalsystem.entity.Medicine;
import org.example.medicalsystem.mapper.MedicineMapper;
import org.example.medicalsystem.service.IMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品库存表 服务实现类
 * </p>
 *
 * @author h77h1
 * @since 2026-11-14
 */
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements IMedicineService {

}
