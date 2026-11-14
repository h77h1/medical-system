package org.example.medicalsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 药品库存表
 * </p>
 *
 * @author h77h1
 * @since 2026-11-14
 */
@Getter
@Setter
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 药品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 药品名称
     */
    private String medicineName;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 单价
     */
    private BigDecimal price;
}
