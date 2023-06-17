package com.neutrino.dawn.model;

import lombok.Data;

/**
 * Package: com.neutrino.dawn.model Description:部门表
 * Date:  2020/5/17 13:55 Author: kousq Modified By:
 */
@Data
public class SysDept {

    private static final long serialVersionUID = 1L;

    private Long deptId;

    private Long parentId;

    private String ancestors;

    private String deptName;

    private String orderNum;

    private String leader;

    private String phone;

    private String email;

    private String status;

    private String delFlag;

    private String parentName;

}
