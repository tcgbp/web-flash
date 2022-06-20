package cn.enilu.flash.bean.entity.training;


import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 学生实体类
 */
@Entity(name = "t_train_student")
@Table(appliesTo = "t_train_student", comment = "学生")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Student extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(32) COMMENT '姓名'")
    private String name;
    @Column(columnDefinition = "DATE COMMENT '生日'")
    private Date birthday;
    @Column(columnDefinition = "INT COMMENT '性别:1:男,2:女'")
    private Integer sex;
    @Column(columnDefinition = "VARCHAR(64) COMMENT 'email'")
    private String email;
    @Column(columnDefinition = "VARCHAR(16) COMMENT '手机号'")
    private String phone;
    @Column(columnDefinition = "INT COMMENT '状态1:启用,2:禁用'")
    private Integer status;
    @Column(columnDefinition = "INT COMMENT '版本'")
    private Integer version;
    @JoinColumn(name = "classid", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.EAGER)
    private ClassGrade joinedClass;
}
