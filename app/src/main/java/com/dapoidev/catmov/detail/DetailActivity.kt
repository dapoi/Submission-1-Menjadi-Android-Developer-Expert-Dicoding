package com.dapoidev.catmov.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dapoidev.catmov.R
import com.dapoidev.catmov.core.domain.model.Movie
import com.dapoidev.catmov.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = "data"
    }

    private lateinit var detailBinding: ActivityDetailBinding
    private val detailViewModel: DetailMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        val detailMovie = intent.getParcelableExtra<Movie>(DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            with(detailBinding) {
                Glide.with(this@DetailActivity)
                    .load("https://image.tmdb.org/t/p/w500" + detailMovie.coverMovie)
                    .transform(RoundedCorners(20))
                    .into(imgDetail)

                tvTitleDetail.text = detailMovie.title
                tvDateDetail.text = detailMovie.date
                tvRatingDetail.text = detailMovie.vote_average.toString()
                tvDescDetail.text = detailMovie.desc

                var favStatus = detailMovie.isFav
                setStatusFav(favStatus)
                fab.setOnClickListener {
                    favStatus = !favStatus
                    detailViewModel.setMovieFav(detailMovie, favStatus)
                    setStatusFav(favStatus)
                }
            }
        }
    }

    private fun setStatusFav(statusFav: Boolean) {
        if (statusFav) {
            detailBinding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_love_true))
        } else {
            detailBinding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fav_false))
        }
    }
}