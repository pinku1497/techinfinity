package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewStudentModel {
    @SerializedName("result")
    @Expose
    private List<NewStudentResult> result =null;
    public List<NewStudentResult> getResult()

    {return result;}
    public void setResult(List<NewStudentResult>result)
    {this.result=result;}
}
