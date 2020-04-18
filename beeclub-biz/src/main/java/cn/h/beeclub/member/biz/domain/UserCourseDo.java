package cn.h.beeclub.member.biz.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserCourseDo {
    private Long userId;
    private Long courseId;
    private Integer duration;
    private Boolean evaluated;
    private Integer evaluationLevel;
    private String evaluation;
    private Date createTime;
}
