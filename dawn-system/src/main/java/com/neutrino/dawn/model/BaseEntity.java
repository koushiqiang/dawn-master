package com.neutrino.dawn.model;

/**
 * Package: com.neutrino.dawn.model Description: Date:  2020/5/23 15:38 Author: kousq Modified By:
 */

import com.dawn.common.constants.GlobalConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * Package: com.neutrino.dawn.model Description: Date: Base基类
 * 2020/5/18 0:09 Author: kousq Modified By:
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String searchValue;
    /**
     * 创建者
     */
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String remark;

    private transient Map<String, Object> params;

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>(GlobalConstants.INITIAL_CAPACITY);
        }
        return params;
    }
}
