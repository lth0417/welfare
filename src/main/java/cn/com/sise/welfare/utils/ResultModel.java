package cn.com.sise.welfare.utils;
/**
 * @Description: 自定义响应数据结构
 * 这个类是提供给门户，ios，安卓，微信商城用的
 * 门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 其他自行处理
 * 200：表示成功
 * 500：表示错误，错误信息在msg字段中
 * 501：bean验证错误，不管多少个错误都以map形式返回
 * 502：拦截器拦截到用户token出错
 * 555：异常抛出信息
 */
public class ResultModel {
    // 响应业务状态
    private Integer code;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;

    private Long count;

    public static ResultModel build(Integer code, String msg, Object data) {
        return new ResultModel(code, msg, data);
    }
    public static ResultModel ok(Object data) {
        return new ResultModel(data);
    }
    public static ResultModel ok(String msg) {
        return new ResultModel(msg);
    }
    public static ResultModel ok() {
        return new ResultModel(null);
    }
    public static ResultModel ok(Long count,Object data) {
        return new ResultModel(0,"",data,count);
    }
    public static ResultModel errorMsg(String msg) {
        return new ResultModel(500, msg, null);
    }
    public static ResultModel errorMap(Object data) {
        return new ResultModel(501, "error", data);
    }
    public static ResultModel errorTokenMsg(String msg) {
        return new ResultModel(502, msg, null);
    }
    public static ResultModel errorException(String msg) {
        return new ResultModel(555, msg, null);
    }
    public ResultModel() {

    }
    public ResultModel(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }
    public ResultModel(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }

    public ResultModel(Integer code, String msg, Object data, Long count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
