package org.example.medicalsystem.service.impl;

import org.example.medicalsystem.entity.Patient;
import org.example.medicalsystem.mapper.PatientMapper;
import org.example.medicalsystem.service.IPatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 患者表 服务实现类
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

}
