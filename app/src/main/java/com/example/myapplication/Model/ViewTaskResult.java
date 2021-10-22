package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewTaskResult
{
    @SerializedName("task")
    @Expose
    public String ttask;

    @SerializedName("remark")
    @Expose
    public String tremark;

    public String getTtask() {
        return ttask;
    }

    public void setTtask(String ttask) {
        this.ttask = ttask;
    }

    public String getTremark() {
        return tremark;
    }

    public void setTremark(String tremark) {
        this.tremark = tremark;
    }
}
