package com.yupi.oj_system.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件上传业务类型枚举
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public enum JudgeInfoMessgaeEnum {

    ACCEPTED("成功", "Accepted"),
    WRONG_ANSWER("答案错误", "Wrong answer"),
    COMPILE_ERROR("Compile Error", "编译错误"),
    MEMORY_LIMIT_EXCEED("Memory Limit Exceeded", "内存溢出"),
    TIME_LIMIT_EXCEED("Time Limit Exceeded", "超时"),
    PRESENTATION_ERROR("Presentation Error", "展示错误"),
    WAITING("Waiting", "等待中"),
    Runtime_Error("Runtime Error", "运行错误"),
    Dangerous_Operation("Dangerous Operation", "危险操作"),
    OutPut_Limit("Output_Limit_Exceeded", "输出溢出"),
    System_Error("System Error", "系统错误");


    private final String text;

    private final String value;

    JudgeInfoMessgaeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessgaeEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessgaeEnum anEnum : JudgeInfoMessgaeEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
