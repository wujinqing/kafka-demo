package com.jin.kafka.logstash;

/**
 * @author wu.jinqing
 * @date 2017年12月05日
 */
public class AccessLog {
    private String tranCode;
    private String crtDt;
    private String msg;

    public AccessLog(String tranCode, String crtDt, String msg) {
        this.tranCode = tranCode;
        this.crtDt = crtDt;
        this.msg = msg;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(String crtDt) {
        this.crtDt = crtDt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
