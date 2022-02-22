package com.trachoma.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author trachoma
 * @create 2022-02-20 19:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_tbl")
public class User {

    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
