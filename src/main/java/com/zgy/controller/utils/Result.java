package com.zgy.controller.utils;

import lombok.Data;

/*前后端数据协议*/
// 采用LomBok开发
@Data
public class Result {
    private Boolean flag;
    // 此处使用Object, 是因为可能存在集合、IPage等
    private Object data;
    private String msg;

    public Result() {
    }

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
