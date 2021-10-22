package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewIncomeModel
{
    @SerializedName("result")
    @Expose
    private List<NewIncomeResult> result =null;
    public List<NewIncomeResult> getResult()

    {return result;}
    public void setResult(List<NewIncomeResult>result)
    {this.result=result;}
}
