package com.mislbd.ababil.modelclass;

/**
 * Created by smartmux on 3/21/16.
 */
public class MiniStatementItem {

    String date;
    String narration;
    String instalment;
    String acc_no;
    String amount;

    public MiniStatementItem(String date, String amount, String narration, String acc_no, String instalment) {
        this.date = date;
        this.amount = amount;
        this.narration = narration;
        this.acc_no = acc_no;
        this.instalment = instalment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getInstalment() {
        return instalment;
    }

    public void setInstalment(String instalment) {
        this.instalment = instalment;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
