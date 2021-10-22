package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by win on 09-04-2017.
 */
public class ViewStudentModel
{
    @SerializedName("studentdata")
    @Expose
    public List<ViewStudentResult> studentdata = null;

    public List<ViewStudentResult> getStudentdata()
    {
        return studentdata;
    }
    public void setStudentdata(List<ViewStudentResult> studentdata)
    {
        this.studentdata = studentdata;
    }
}
