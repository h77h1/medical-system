package org.example.medicalsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 挂号记录表
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Getter
@Setter
@Data
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 挂号ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 患者ID
     */
    private Long patientId;

    /**
     * 医生ID
     */
    private Long doctorId;

    /**
     * 挂号时间
     */
    private LocalDateTime regTime;

    /**
     * 状态(1待就诊,2已完成,3已取消)
     */
    private Integer status;

    /**
     * 挂号费
     */
    private BigDecimal fee;
}
