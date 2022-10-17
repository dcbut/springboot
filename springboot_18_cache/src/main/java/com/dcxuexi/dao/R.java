package com.dcxuexi.dao;

import lombok.Data;

/***
 * @Title R
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/10 21:22
 * @Version 1.0.0
 */
@Data
public class R {
    private Boolean flag;
    private Object data;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
