package com.sky.academicproject.sevice

import com.sky.academicproject.model.NewResponse
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewAPI {

    // url -> https://newsapi.org/v2/everything?q=bitcoin&pageSize=1&apiKey=47c5d14a75c645988221b3ce3d5a17af
    // base url -> https://newsapi.org/


    @GET(" v2/everything")
    fun getData
                ( @Query("q") word: String,
                  @Query("pageSize") pageSize: Int,
                  @Query("apiKey") apiKey: String
                 ) : Call<NewResponse>


    @GET("v2/everything?q=bitcoin&pageSize=50&apiKey=47c5d14a75c645988221b3ce3d5a17af")
    suspend fun getDataDirectWithinSuspendCall() :NewResponse

    @GET(" v2/everything")
    suspend fun getDataSuspend
                ( @Query("q") word: String,
                  @Query("pageSize") pageSize: Int,
                  @Query("apiKey") apiKey: String
    ) : NewResponse

    @GET(" v2/everything")
    suspend fun getDataSuspendNetworkResponse
                ( @Query("q") word: String,
                  @Query("pageSize") pageSize: Int,
                  @Query("apiKey") apiKey: String
    ) : Response<NewResponse>


    @GET(" v2/everything")
     fun getDataDeferredAsync
                ( @Query("q") word: String,
                  @Query("pageSize") pageSize: Int,
                  @Query("apiKey") apiKey: String
    ) : Deferred<Response<NewResponse>>
}