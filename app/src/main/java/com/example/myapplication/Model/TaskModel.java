package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaskModel
{
    @SerializedName("result")
    @Expose
    private List<TaskResult> results =null;

    public List<TaskResult> getResults() {
        return results;
    }

    public void setResults(List<TaskResult> results) {
        this.results = results;
    }
}
