package com.daza.edner.nyecompanyusers.interfaces;

import com.daza.edner.nyecompanyusers.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserInterface {

    //http://localhost:8080/
    @POST("saveOrUpdate")
    Call<List<User>> setUsers(@Body User user);

    @GET("getUsers")
    Call<List<User>> getUsers();
}
