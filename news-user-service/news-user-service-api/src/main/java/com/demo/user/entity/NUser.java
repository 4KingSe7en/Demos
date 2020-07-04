package com.demo.user.entity;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.demo.user.enmu.UserType;

import java.io.Serializable;
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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uuid
     */
    @TableId(type = IdType.AUTO)
    private Long nId;

    /**
     * user account
     */
    @NotBlank(message = "Account is require")
	@Size(min = 6,max = 20, message = "account length must between [6,20]")
    private String nAccount;

    /**
     * user password
     */
    @NotBlank(message = "Password is require")
    @Size(min = 6,max = 20, message = "password length must between [6,20]")
    private String nPassword;

    /**
     * user type
     */
    private UserType nType  = UserType.APP;

    /**
     * createtime
     */
    private LocalDateTime nCreate;

    /**
     * create by
     */
    private String nCreateBy;

    /**
     * modify time
     */
    private Date nModified;

    /**
     * modify by
     */
    private String nModifiedBy;

}
