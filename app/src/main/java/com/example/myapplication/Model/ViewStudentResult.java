package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by win on 09-04-2017.
 */
public class ViewStudentResult
{

    @SerializedName("s_name")
    @Expose
    public String name;

    @SerializedName("s_course")
    @Expose
    public String course;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getCourse()
    {
        return course;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }
}
