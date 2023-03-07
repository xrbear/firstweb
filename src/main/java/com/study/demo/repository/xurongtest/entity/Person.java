package com.study.demo.repository.xurongtest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author ：xurong02
 * @date ：2023/3/7 2:43 下午
 */
@Data
@TableName("Person")
public class Person {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer personId;

    private String personName;

    private Date gmtCreate;

    private Date gmtModified;
}
