package org.example.medicalsystem.controller;

import org.example.medicalsystem.entity.Registration;
import org.example.medicalsystem.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    // 接收挂号请求，附带一个药品ID用于扣减库存
    @PostMapping("/book")
    public String book(@RequestBody Registration registration, @RequestParam(required = false) Long medicineId) {
        return registrationService.register(registration, medicineId);
    }
}