package com.neutrino.dawn.model;

import com.dawn.common.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: com.neutrino.dawn.model Description:字典数据表
 * Date:  2020/5/23 12:32 Author: kousq Modified By:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictData extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "字典编码")
    private Long dictCode;

    @Excel(name = "字典排序")
    private Long dictSort;

    @Excel(name = "字典标签")
    private String dictLabel;

    @Excel(name = "字典键值")
    private String dictValue;

    @Excel(name = "字典类型")
    private String dictType;

    @Excel(name = "字典样式")
    private String cssClass;

    private String listClass;

    @Excel(name = "是否默认", readConverterExp = "Y=是,N=否")
    private String isDefault;

    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;
}
