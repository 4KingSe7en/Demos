package com.demo.news.entity;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 *  new entity
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "n_news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * news id
     */
    @TableId(value = "n_id", type = IdType.AUTO)
    private Long uuid;

    /**
     * news title
     */
    @NotBlank(message = "Title is require")
	@Size(min = 1,max = 40, message = "title length must between [1,40]")
    @TableField(value = "n_title")
    private String title;

    /**
     * news tag
     */
    @TableField(value = "n_tag")
    private String tag;

    /**
     * news content
     */
    @NotBlank(message = "Title is require")
    @TableField(value = "n_content")
    private String content;

    /**
     * news create time
     */
    // TODO:FIX reserved word
    @TableField(value = "n_create")
    private Date created;

    /**
     * news create by
     */
    @TableField(value = "n_create_by")
    private String createBy;

    /**
     * new modified time
     */
    @TableField(value = "n_modified")
    private Date modified;

    /**
     * new modified by
     */
    @TableField(value = "n_modified_by")
    private String modifiedBy;

}
