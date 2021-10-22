package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewTaskModel
{
    @SerializedName("taskdata")
    @Expose
    public List<ViewTaskResult> taskdata = null;

    public List<ViewTaskResult> getTaskdata()
    {
        return taskdata;
    }

    public void setTaskdata(List<ViewTaskResult> taskdata)
    {
        this.taskdata = taskdata;
    }
}
