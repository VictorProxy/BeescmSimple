package cn.beescm.commonbusiness.data.remote.model;

/**
 * Created by zhangshaofang on 2017/6/30
 */
public class BaseError {
    private int error_code;
    private String error_msg;
    private Throwable throwable;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
