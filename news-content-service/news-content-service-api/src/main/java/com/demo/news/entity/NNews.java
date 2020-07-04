package com.demo.news.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
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
public class NNews implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * news id
     */
    @TableId(value = "n_id", type = IdType.AUTO)
    private Long nId;

    /**
     * news title
     */
    @NotBlank(message = "Title is require")
	@Size(min = 1,max = 20, message = "title length must between [1,40]")
    private String nTitle;

    /**
     * news tag
     */
    private String nTag;

    /**
     * news content
     */
    @NotBlank(message = "Title is require")
    private String nContent;

    /**
     * news create time
     */
    private LocalDateTime nCreate;

    /**
     * news create by
     */
    private String nCreateBy;

    /**
     * new modified time
     */
    private LocalDateTime nModified;

    /**
     * new modified by
     */
    private String nModifiedBy;

}
