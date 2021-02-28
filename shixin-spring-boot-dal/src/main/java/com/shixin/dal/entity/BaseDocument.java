package com.shixin.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础数据表类，其他Mongo实体类继承该类
 *
 * @author shixin
 * @date 2021/2/25
 */
@Data
@DynamicInsert
@DynamicUpdate
public abstract class BaseDocument implements Serializable {
    @Id
    String id;

    @CreatedDate
    protected Date createTime;

    @LastModifiedDate
    protected Date updateTime;

    protected Boolean deleted = false;
}
