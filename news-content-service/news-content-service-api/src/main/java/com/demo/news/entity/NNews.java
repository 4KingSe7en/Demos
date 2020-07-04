package com.demo.news.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
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
    private String nTitle;

    /**
     * news tag
     */
    private String nTag;

    /**
     * news content
     */
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
