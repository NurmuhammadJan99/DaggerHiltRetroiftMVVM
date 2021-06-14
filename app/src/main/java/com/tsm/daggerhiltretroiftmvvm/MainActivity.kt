package com.tsm.daggerhiltretroiftmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsm.daggerhiltretroiftmvvm.Adapter.TvShowAdapter
import com.tsm.daggerhiltretroiftmvvm.ViewModel.TvShowViewModel
import com.tsm.daggerhiltretroiftmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TvShowViewModel

    private lateinit var tvShowAdapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        viewModel.responseTvShow.observe(this, Observer { listTvShows ->
            tvShowAdapter.tvShows = listTvShows
        })
    }

    fun init() {
        viewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)

        tvShowAdapter = TvShowAdapter()
        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )

            setHasFixedSize(true)
        }

    }
}