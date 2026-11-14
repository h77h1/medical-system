package org.example.medicalsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * 患者表
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Getter
@Setter
@Data
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 患者ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 患者姓名
     */
    @NotBlank(message = "患者姓名不能为空")
    private String patientName;

    /**
     * 身份证号
     */
    @NotBlank(message = "身份证不能为空")
    @Pattern(regexp = "(^\\d{15}$)|(^\\d{17}([0-9]|X|x)$)", message = "身份证格式不正确") // 正则校验身份证
    private String idCard;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确") // 正则校验手机号
    private String phone;

    /**
     * 性别(M男,F女)
     */
    private String gender;
}
