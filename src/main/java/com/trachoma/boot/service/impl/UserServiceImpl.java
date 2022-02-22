package com.trachoma.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trachoma.boot.bean.User;
import com.trachoma.boot.mapper.UserMapper;
import com.trachoma.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2022-02-22 22:49
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
