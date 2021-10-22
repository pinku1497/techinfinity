package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewBatchModel
{
    @SerializedName("result")
    @Expose
    private List<NewBatchResult> result =null;
    public List<NewBatchResult> getResult()
    {return result;}
    public void setResult(List<NewBatchResult>result)
    {
        this.result=result;
    }
}
