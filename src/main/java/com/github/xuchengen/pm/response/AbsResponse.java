package com.github.xuchengen.pm.response;

/**
 * 抽象响应模型<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/16 2:09 下午<br>
 */
public abstract class AbsResponse {

    /**
     * 错误消息
     */
    public String errorMessage;

    /**
     * 是否成功标识
     */
    public boolean success;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "AbsResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                ", success=" + success +
                '}';
    }
}
