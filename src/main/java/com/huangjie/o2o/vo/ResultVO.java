package com.huangjie.o2o.vo;

/**
 * @author huangjie
 * @date 2019/09/04
 * @blame 黄杰
 **/
public class ResultVO<T> {
    /**
     * 状态吗
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据.
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
