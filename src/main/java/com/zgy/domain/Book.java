package com.zgy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

// 由于数据库表名称有前缀, 采用该注解指定表名称, 避免无法识别
@TableName("tb_book")
// lombok开发
/*// 生成Setter方法
@Setter
// 生成Getter方法
@Getter
// 生成toString()
@ToString*/
// 生成除开构造方法的一切方法
@Data
public class Book {
    // 在使用BaseMapper<T>时, 为避免因为默认id是雪花算法递增方式而报错
    // 因此, 采用该注解标明数据库表中id的增加方式
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String description;
}
