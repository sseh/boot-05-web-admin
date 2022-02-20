package com.trachoma.boot.bean;

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
public class User {

    private String userName;
    private String password;
}
