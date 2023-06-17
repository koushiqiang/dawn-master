package com.neutrino.dawn.security.service;

import com.neutrino.dawn.security.bean.User;
import com.neutrino.dawn.security.mapper.security.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author kousq
 * @Date 2023/05/01 17:51
 * @Version 1.0.0
 * @Description:
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional
    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.save(user);
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
