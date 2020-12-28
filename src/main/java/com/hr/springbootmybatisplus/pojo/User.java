package com.hr.springbootmybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
public class User {
    //IdType.ID_WORKER   Long类型的mybatis-plus生成id策略
    //IdType.ID_WORKER_STR   String类型的mybatis-plus生成id策略
//    @TableId(type = IdType.ID_WORKER)   默认就是IdType.ID_WORKER
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //自填充时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    //逻辑删除标志
    @TableLogic
    private Integer deleted;
}
