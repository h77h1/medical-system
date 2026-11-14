package org.example.medicalsystem.service;

import org.example.medicalsystem.entity.Registration;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 挂号记录表 服务类
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
public interface IRegistrationService extends IService<Registration> {

    //核心挂号方法
    String register(Registration registration, Long medicineId);
}
