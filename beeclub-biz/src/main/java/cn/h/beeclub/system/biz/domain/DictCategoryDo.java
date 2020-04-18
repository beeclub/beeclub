package cn.h.beeclub.system.biz.domain;

import cn.h.beeclub.common.base.domain.Domain;
import lombok.Data;

import java.util.List;

@Data
public class DictCategoryDo extends Domain.BaseDo {
    private Long id;
    private String code;
    private String name;
    private String srcSql;

    private List<DictItemDo> items;
}
