package org.soin.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author soin
 * @since 2021-08-20
 */
@TableName("t_systemdictionarydetail")
public class Systemdictionarydetail extends Model<Systemdictionarydetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    @TableField("types_id")
    private Long typesId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypesId() {
        return typesId;
    }

    public void setTypesId(Long typesId) {
        this.typesId = typesId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Systemdictionarydetail{" +
        ", id=" + id +
        ", name=" + name +
        ", typesId=" + typesId +
        "}";
    }
}
