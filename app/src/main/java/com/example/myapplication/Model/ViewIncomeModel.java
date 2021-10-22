package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewIncomeModel {

    @SerializedName("incomedata")
    @Expose
    public List<ViewIncomeResult> incomedata = null;

    public List<ViewIncomeResult> getIncomedata()
    {
        return incomedata;
    }

    public void setIncomedata(List<ViewIncomeResult> incomedata)
    {
        this.incomedata = incomedata;
    }
}
