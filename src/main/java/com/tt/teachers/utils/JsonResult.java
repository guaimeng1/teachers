package com.tt.teachers.utils;
/**
 * @作者：cao
 * @时间：2018/12/20 16:13
 * @描述：json数据的工具类
 */
public class JsonResult {
    //1.相应状态码
    private Integer status;
    //2.消息
    private String myMsg;
    //3.数据
    private Object myData;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMyMsg() {
        return myMsg;
    }

    public void setMyMsg(String myMsg) {
        this.myMsg = myMsg;
    }

    public Object getMyData() {
        return myData;
    }

    public void setMyData(Object myData) {
        this.myData = myData;
    }

    public JsonResult() {
    }

    public JsonResult(Integer status, String myMsg, Object myData) {
        this.status = status;
        this.myMsg = myMsg;
        this.myData = myData;
    }

    //成功的时候调用ok
    public static JsonResult ok(String myMsg, Object myData){
        return new JsonResult(200,myMsg,myData);
    }
    //失败的时候调用ok
    public static JsonResult no(String myMsg, Object myData){
        return new JsonResult(502,myMsg,myData);
    }
}
