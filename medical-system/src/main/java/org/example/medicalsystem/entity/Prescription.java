package org.example.medicalsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 电子处方表
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Getter
@Setter
@Data
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 处方ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 挂号记录ID
     */
    private Long regId;

    /**
     * 药品详情
     */
    private String medicineInfo;

    /**
     * 医嘱
     */
    private String advice;

    private LocalDateTime createTime;
}
