package com.example.myapplication.API;



import android.widget.EditText;

import com.example.myapplication.Model.NewIncomeModel;
import com.example.myapplication.Model.TaskModel;
import com.example.myapplication.Model.ViewBatchModel;
import com.example.myapplication.Model.ViewIncomeModel;
import com.example.myapplication.Model.ViewStudentModel;
import com.example.myapplication.Model.NewStudentModel;
import com.example.myapplication.Model.ViewTaskModel;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Query;

public interface Webservices
{

    @POST("/fetch_studentdetail.php")
    public void viewStudentDetails(Callback<ViewStudentModel> callback);

    @POST("/view_income_details.php")
    public void viewIncomeDetails(Callback<ViewIncomeModel> callback);

    @POST("/studentdata.php")
    public void stu(@Query("s_name") String s_name,
                    @Query("s_course") String s_course,
                    @Query("s_semester") String s_semester,
                    @Query("s_fees") String s_fees,
                    @Query("s_date") String s_date,
                    @Query("s_description") String s_description,
                    Callback<NewStudentModel> callback);

    @POST("/new_batch.php")
    public void newBatch(@Query("batch_name") String batch_name,
                         @Query("batch_location") String batch_location,
                         Callback<NewStudentModel> callback);

    @POST("/new_income.php")
    public void newIncome(@Query("newincome") String batch_name,
                          @Query("newamount") String batch_location,
                          @Query("incomedate") String incomedate,
                          @Query("incomeremarks") String incomeremarks,
                          Callback<NewIncomeModel> callback);
    @POST("/task.php")
    public void newTask(@Query("task") String task,
                          @Query("remark") String remark,
                          Callback<TaskModel> callback);

    @POST("/view_task_detail.php")
    public void viewtask(Callback<ViewTaskModel> callback);

}
