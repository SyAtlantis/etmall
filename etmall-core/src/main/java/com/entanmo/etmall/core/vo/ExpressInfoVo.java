package com.entanmo.etmall.core.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExpressInfoVo {

    @JsonProperty("LogisticCode")
    private String LogisticCode;
    @JsonProperty("ShipperCode")
    private String ShipperCode;
    @JsonProperty("Traces")
    private List<TracesVo> Traces;
    @JsonProperty("State")
    private String State;
    @JsonProperty("EBusinessID")
    private String EBusinessID;
    @JsonProperty("Success")
    private boolean Success;
    @JsonProperty("Reason")
    private String Reason;

    private String ShipperName;

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public List<TracesVo> getTraces() {
        return Traces;
    }

    public void setTraces(List<TracesVo> traces) {
        Traces = traces;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getShipperName() {
        return ShipperName;
    }

    public void setShipperName(String shipperName) {
        ShipperName = shipperName;
    }

    @Override
    public String toString() {
        return "ExpressInfoVo{" +
                "LogisticCode='" + LogisticCode + '\'' +
                ", ShipperCode='" + ShipperCode + '\'' +
                ", Traces=" + Traces +
                ", State='" + State + '\'' +
                ", EBusinessID='" + EBusinessID + '\'' +
                ", Success=" + Success +
                ", Reason='" + Reason + '\'' +
                ", ShipperName='" + ShipperName + '\'' +
                '}';
    }
}
