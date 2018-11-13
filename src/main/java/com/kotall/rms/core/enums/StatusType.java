package com.kotall.rms.core.enums;

/**
 * 通用变量，表示可用、禁用、显示、隐藏
 */
public enum StatusType {

    /**
     * 禁用，隐藏
     */
    DISABLE(0),

    /**
     * 可用，显示
     */
    ENABLE(1),

    /**
     * 显示
     */
    SHOW(1),

    /**
     * 隐藏
     */
    HIDDEN(0);

    private int value;

    StatusType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
