package com.tsm.daggerhiltretroiftmvvm.Api

import com.tsm.daggerhiltretroiftmvvm.Helper.Constants
import com.tsm.daggerhiltretroiftmvvm.Model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}