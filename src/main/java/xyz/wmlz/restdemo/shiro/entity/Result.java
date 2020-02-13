package xyz.wmlz.restdemo.shiro.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Result implements Serializable {

    private static final long serialVersionUID = -1802122468331526708L;
    private String status;
    private Integer errCode = -1;
    private String message = "";
    private Map<String, Object> data = new HashMap<>();

    private Result() {
    }

    private Result(String status, Integer errCode, String message) {
        this.status = status;
        this.errCode = errCode;
        this.message = message;
    }

    private Result(String status, Integer errCode, String message, Map<String, Object> data) {
        this.status = status;
        this.errCode = errCode;
        this.message = message;
        this.data = data;
    }

    public static Result suc() {
        return new Result("suc", -1, "");
    }

    public static Result suc(String message) {
        message = message == null ? "" : message;
        return new Result("suc", -1, message);
    }

    public static Result suc(String message, Map<String, Object> data) {
        message = message == null ? "" : message;
        return new Result("suc", -1, message, data);
    }

    public static Result err(Integer errCode, String message) {
        message = message == null ? "" : message;
        return new Result("err", errCode, message);
    }

    public static Result err(Integer errCode, String message, Map<String, Object> data) {
        message = message == null ? "" : message;
        return new Result("err", errCode, message, data);
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void removeData(String key) {
        data.remove(key);
    }

    public Result putData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}