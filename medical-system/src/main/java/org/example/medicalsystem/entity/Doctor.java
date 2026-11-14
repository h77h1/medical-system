package org.example.medicalsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 医生表
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Getter
@Setter
@Data
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医生ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属科室ID
     */
    private Long deptId;

    /**
     * 医生名称
     */
    private String doctorName;

    /**
     * 职称
     */
    private String title;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 每日最大接诊量
     */
    private Integer dailyLimit;
}
