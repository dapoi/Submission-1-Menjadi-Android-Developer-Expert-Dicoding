package com.dapoidev.catmov.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dapoidev.catmov.core.ui.MovieAdapter
import com.dapoidev.catmov.databinding.ActivityFavoriteBinding
import com.dapoidev.catmov.detail.DetailActivity
import com.dapoidev.catmov.favorite.di.favoriteModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var favBinding: ActivityFavoriteBinding
    private val favViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favBinding.root)

        loadKoinModules(favoriteModule)

        favBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        val favAdapter = MovieAdapter()
        favAdapter.onItemClick = { movie ->
            Intent(this, DetailActivity::class.java).also {
                it.putExtra(DetailActivity.DATA, movie)
                startActivity(it)
            }
        }

        favViewModel.favMovie.observe(this, {
            favAdapter.setData(it)
            favBinding.viewEmpty.root.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
        })

        favBinding.rvMovie.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = favAdapter
        }
    }
}