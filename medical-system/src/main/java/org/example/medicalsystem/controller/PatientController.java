
package org.example.medicalsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.medicalsystem.entity.Patient;
import org.example.medicalsystem.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 患者表 前端控制器
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */

@RestController
@RequestMapping("/patient")
@Validated // 开启参数校验
public class PatientController {

    @Autowired
    private IPatientService patientService;

    // 1. 多条件组合分页查询
    @GetMapping("/page")
    public Page<Patient> getPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone) {

        Page<Patient> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Patient> wrapper = new LambdaQueryWrapper<>();

        // 这里的查询条件就是防注入的体现：MyBatis-Plus 底层使用 #{} 预编译，而不是 ${} 字符串拼接
        if (name != null && !name.trim().isEmpty()) {
            wrapper.like(Patient::getPatientName, name);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            wrapper.eq(Patient::getPhone, phone);
        }
        return patientService.page(page, wrapper);
    }

    // 2. 新增患者 (包含手机号和身份证严格校验)
    @PostMapping("/add")
    public String addPatient(@RequestBody @Validated Patient patient) {
        boolean success = patientService.save(patient);
        return success ? "新增成功" : "新增失败";
    }

    // 3. 修改患者
    @PutMapping("/update")
    public String updatePatient(@RequestBody @Validated Patient patient) {
        boolean success = patientService.updateById(patient);
        return success ? "修改成功" : "修改失败";
    }

    // 4. 删除患者
    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        boolean success = patientService.removeById(id);
        return success ? "删除成功" : "删除失败";
    }
}