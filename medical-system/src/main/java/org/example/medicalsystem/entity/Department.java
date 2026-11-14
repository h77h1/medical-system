package org.example.medicalsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 科室表
 * </p>
 *
 * @author h77h1
 * @since 2026-11-13
 */
@Getter
@Setter
@Data
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 科室ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 科室描述
     */
    private String description;
}
