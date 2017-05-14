package com.mislbd.ababil.modelclass;

/**
 * Created by smartmux on 3/21/16.
 */
public class HistoryItem {


     String type;
     String time;
     String amount;

    public HistoryItem(String type, String time, String amount) {
        this.type = type;
        this.time = time;
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
