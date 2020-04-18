package cn.h.beeclub.admin.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class SysAdmin implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4485980508867552581L;
	private Long id;
    private String mobile;
    private String name;
    private String password;
    private String avatar;
    private String email;
    private String note;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;
    private boolean available;
    private Set<String> roles;
    private Set<String> permissions;
    private String loginIp;
    private boolean editable;

    public boolean isSuperAdmin(){
        return id == 1;//"admin".equals(this.mobile);
    }
}
