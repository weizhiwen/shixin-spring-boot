package com.example.entity;

import com.shixin.dal.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author shixin
 * @date 2021/2/25
 */
@Table(name = "user")
@Entity
@Data
public class User extends BaseEntity {
    /**
     * 用户名
     */
    @Column(name = "name")
    String name;

    /**
     * 密码
     */
    @Column(name = "password")
    String password;
}
