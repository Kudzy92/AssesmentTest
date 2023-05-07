package app.kudzy.model;

import app.kudzy.constants.CircuitType;

public class ResistanceCal {
    private CircuitType circuitType;
    private int resNo;
    private String resValueStr;
    private Double resTotal;

    public ResistanceCal() {
    }

    public ResistanceCal(CircuitType circuitType, int resNo, String  resistorList, Double resTotal) {
        this.circuitType = circuitType;
        this.resNo = resNo;
        this.resValueStr = resistorList;
        this.resTotal = resTotal;
    }

    public CircuitType getCircuitType() {
        return circuitType;
    }

    public void setCircuitType(CircuitType circuitType) {
        this.circuitType = circuitType;
    }

    public int getResNo() {
        return resNo;
    }

    public void setResNo(int resNo) {
        this.resNo = resNo;
    }

    public String  getResValueStr() {
        return resValueStr;
    }

    public void setResValueStr(String resistorList) {
        this.resValueStr = resistorList;
    }

    public Double getResTotal() {
        return resTotal;
    }

    public void setResTotal(Double resTotal) {
        this.resTotal = resTotal;
    }
}
