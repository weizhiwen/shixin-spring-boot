package com.shixin.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础数据库实体类，其他实体类继承该类
 *
 * @author shixin
 */
@Data
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
@Where(clause = "deleted = 0")
public class BaseEntity implements Serializable {
    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 数据创建时间
     */
    @Nullable
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    protected Date createTime;

    /**
     * 数据更新时间
     */
    @Nullable
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    protected Date updateTime;

    /**
     * 是否删除
     */
    @Column(name = "deleted")
    @JsonIgnore
    protected Boolean deleted = false;
}
