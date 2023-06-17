package com.neutrino.dawn.security.service;

import com.neutrino.dawn.security.bean.Role;
import com.neutrino.dawn.security.bean.User;
import com.neutrino.dawn.security.mapper.security.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author kousq
 * @Date 2023/05/01 17:29
 * @Version 1.0.0
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userRepository;

    // todo 在这里实现自定义登录逻辑
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 从DB查询用户, 如果用户不存在, 则抛出异常
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // 2. 如果用户存在, 则返回SpringSecurity的User对象，比较密码
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRoles().stream()
                        .map(Role::getAuthority)
                        .toArray(String[]::new)));
    }
}
