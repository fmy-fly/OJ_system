package com.yupi.oj_system.model.dto.questionsubmit;

import com.baomidou.mybatisplus.annotation.TableField;
import com.yupi.oj_system.model.dto.question.JudgeCase;
import com.yupi.oj_system.model.dto.question.JudgeConfig;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {


    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;


    private Long questionId;






    private static final long serialVersionUID = 1L;
}