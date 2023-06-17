package com.neutrino.dawn.security.mapper.security;

import com.neutrino.dawn.security.bean.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {
    User findByUsername(String username);

    User findById( Long id);

    void save(User user);
}
