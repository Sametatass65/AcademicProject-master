package com.sky.academicproject.sevice

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sky.academicproject.model.NewResponse
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewAPIService {

    private val BASE_URL = "https://newsapi.org/"
    private val API_KEY = "47c5d14a75c645988221b3ce3d5a17af"
    private val API_KEY_V2 = "9d2eef0782bc4a969cfab65164ebd4ef"
    private val API_KEY_V3 = "0a0e65dd8b88459f9ceed1833a224404"
    private val API_KEY_V4 = "883a86607a5a4c638769b5eac2e20609"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(NewAPI::class.java)
    //.addCallAdapterFactory(CoroutineCallAdapterFactory())

    fun getData(word: String,pageSize: Int): Call<NewResponse> {

        return api.getData(word,pageSize,API_KEY)
    }
    suspend fun getDataDirectSuspend() : NewResponse
    {
        return api.getDataDirectWithinSuspendCall()
    }

    suspend fun getDataWithinSuspend(word:String, pageSize: Int) : NewResponse
    {
        return api.getDataSuspend(word,pageSize,API_KEY_V4)
    }

    suspend fun getDataSuspendResponse(word: String, pageSize: Int): Response<NewResponse>
    {
        return api.getDataSuspendNetworkResponse(word,pageSize,API_KEY)
    }

      fun getDataDeferredAsync(word:String, pageSize:Int) : Deferred<Response<NewResponse>>
    {
        return api.getDataDeferredAsync(word,pageSize,API_KEY)
    }
}