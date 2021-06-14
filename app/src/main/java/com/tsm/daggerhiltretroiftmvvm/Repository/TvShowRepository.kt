package com.tsm.daggerhiltretroiftmvvm.Repository

import com.tsm.daggerhiltretroiftmvvm.Api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject
constructor(private val apiService: ApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}