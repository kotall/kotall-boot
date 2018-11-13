package com.kotall.rms.core.enums;

/**
 * 通用字典
 */
public enum DictType {

    /**
     * 类型
     */
    TYPE(0),

    /**
     * 参数
     */
    PARAM(1);

    private int value;

    DictType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
