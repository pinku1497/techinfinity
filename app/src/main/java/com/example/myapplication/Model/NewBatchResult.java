package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewBatchResult
{
    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("msg")
    @Expose
    private String msg;


    private Integer getStatus(){return status;}

    public void setStatus(Integer status){this.status=status;}

    public String getMsg(){return msg;}

    public void setMsg(String msg){this.msg=msg;}
}
