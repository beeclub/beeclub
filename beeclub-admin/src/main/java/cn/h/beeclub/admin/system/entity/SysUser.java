package cn.h.beeclub.admin.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 3255735922497907455L;
    private Long userId;
    private String mobile;
    private String password;
    private String name;
    private Integer status;
}
