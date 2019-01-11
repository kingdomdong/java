package com.znv.cop.hrm.vo;

public class InterfaceLogVo {

    private String time;

    private String serviceCode;

    private String serviceName;

    private String apiName;

    private long duration;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

}
