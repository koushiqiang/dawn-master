package com.neutrino.dawn.security.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author kousq
 * @Date 2023/05/01 17:26
 * @Version 1.0.0
 * @Description:
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private Long id;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private Set<Role> roles;
}
