package org.example.medicalsystem.service.impl;

import org.example.medicalsystem.entity.Prescription;
import org.example.medicalsystem.mapper.PrescriptionMapper;
import org.example.medicalsystem.service.IPrescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电子处方表 服务实现类
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Service
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements IPrescriptionService {

}
