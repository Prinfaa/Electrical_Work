package com.jawg.electricalshow.Entries;

public class MituType {


    /**
     * id : 1
     * type : 室内消火栓
     * valueUnit : Mpa
     * note : a
     * valueType : 水压监测
     */

    private String id;
    private String type;
    private String valueUnit;
    private String note;
    private String valueType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}
