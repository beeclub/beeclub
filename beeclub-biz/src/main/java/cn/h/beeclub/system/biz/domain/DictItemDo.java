package cn.h.beeclub.system.biz.domain;

import cn.h.beeclub.common.base.domain.Domain;
import cn.h.beeclub.common.base.entity.BaseTree;
import lombok.Data;

@Data
public class DictItemDo extends Domain.BaseDo {

    private String id;
    private String cateCode;
    private String code;
    private String name;
    private String label;
    private Integer sort = 0;
    private Boolean defaulted = Boolean.FALSE;

}
