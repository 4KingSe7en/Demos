package com.demo.user.entity;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.user.enmu.UserType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * News user entity
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */

// TODO:FIX request body null
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "n_user")
public class User implements Serializable {


	private static final long serialVersionUID = 1L;

    /**
     * uuid
     */
    @TableId(type = IdType.AUTO,value = "n_id")
    private Long uuid;

    /**
     * user account
     */
    @NotBlank(message = "Account is require")
	@Size(min = 6,max = 20, message = "account length must between [6,20]")
    @TableField(value = "n_account")
    private String account;

    /**
     * user password
     */
    // TODO:FIX reserved word
    @NotBlank(message = "Password is require")
    @Size(min = 6,max = 20, message = "password length must between [6,20]")
    @TableField(value = "n_password")
    private String pwd;

    /**
     * user type
     */
    @EnumValue
    @TableField(value = "n_type")
    private UserType type  = UserType.APP;

    /**
     * createtime
     */
    // TODO:FIX reserved word
    @TableField(value = "n_create")
    private Date created;

    /**
     * create by
     */
    @TableField(value = "n_create_by")
    private String createBy;

    /**
     * modify time
     */
    @TableField(value = "n_modified")
    private Date modified;

    /**
     * modify by
     */
    @TableField(value = "n_modified_by")
    private String modifiedBy;
    
}
