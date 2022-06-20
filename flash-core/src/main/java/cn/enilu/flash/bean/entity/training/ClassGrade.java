package cn.enilu.flash.bean.entity.training;


import cn.enilu.flash.bean.entity.BaseEntity;
import cn.enilu.flash.bean.entity.system.User;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 班级实体类
 */
@Entity(name = "t_train_class")
@Table(appliesTo = "t_train_class", comment = "班级")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ClassGrade extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(32) COMMENT '班名'")
    private String name;
    @Column(columnDefinition = "INT COMMENT '班级类型'")
    private Integer type;
    @Column(columnDefinition = "VARCHAR(12) COMMENT '班主任'")
    private User teacher;
}
