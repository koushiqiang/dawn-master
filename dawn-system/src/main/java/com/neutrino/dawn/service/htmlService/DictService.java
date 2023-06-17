package com.neutrino.dawn.service.htmlService;


import com.neutrino.dawn.model.SysDictData;
import com.neutrino.dawn.service.ISysDictDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.neutrino.dawn.service Description: 调用 thymeleaf 实现字典读取
 * Date:  2020/5/23 12:22 Author: kousq
 * Modified By:
 */
@Service("dict")
public class DictService {

    private final ISysDictDataService dictDataService;

    @Autowired
    public DictService(ISysDictDataService dictDataService) {
        this.dictDataService = dictDataService;
    }

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType) {
        return dictDataService.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue) {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }
}
