package com.shixin.framework.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 基础视图类，用作返回给前端的POJO类，其余视图类继承该类
 *
 * @author shixin
 * @date 2020/10/11 8:47 上午
 */
@Data
public class BaseVO implements Serializable {
    /**
     * 数据Id
     */
    Integer id;
}
