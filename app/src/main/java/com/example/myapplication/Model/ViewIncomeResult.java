package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewIncomeResult {

    @SerializedName("newincome")
    @Expose
    public String newincome;

    @SerializedName("newamount")
    @Expose
    public String newamount;

    @SerializedName("incomedate")
    @Expose
    public String incomedate;

    @SerializedName("incomeremarks")
    @Expose
    public String incomeremarks;

    public String getNewincome() {
        return newincome;
    }

    public void setNewincome(String newincome) {
        this.newincome = newincome;
    }

    public String getNewamount() {
        return newamount;
    }

    public void setNewamount(String newamount) {
        this.newamount = newamount;
    }

    public String getIncomedate() {
        return incomedate;
    }

    public void setIncomedate(String incomedate) {
        this.incomedate = incomedate;
    }

    public String getIncomeremarks() {
        return incomeremarks;
    }

    public void setIncomeremarks(String incomeremarks) {
        this.incomeremarks = incomeremarks;
    }
}
