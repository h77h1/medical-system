package org.example.medicalsystem.service.impl;

import org.example.medicalsystem.entity.Department;
import org.example.medicalsystem.mapper.DepartmentMapper;
import org.example.medicalsystem.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 科室表 服务实现类
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
