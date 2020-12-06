package com.shixin.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@EqualsAndHashCode
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
@NoArgsConstructor
@Where(clause = "deleted = 0")
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Nullable
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    protected Date createTime;

    @Nullable
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    protected Date updateTime;

    @Column(name = "deleted")
    @JsonIgnore
    protected Boolean deleted = false;
}
