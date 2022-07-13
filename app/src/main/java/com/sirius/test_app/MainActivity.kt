package com.sirius.test_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.sirius.test_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private val dataModel = DataModel()
    private fun initView(data: DataModel) {
        val tagAdapter = TagAdapter(data)
        val comAdapter = CommentAdapter(data.reviews)
        with(bind) {
            gameName.text = data.name
            ratingBarTitle.apply {
                numStars = 5
                rating = data.rating
            }
            ratingBarCopy.apply {
                numStars = 5
                rating = data.rating
            }
            countRait.text = data.gradeCnt
            tagsGames.adapter = tagAdapter
            comment.adapter = comAdapter
            descriptionGame.text = data.description
            countReviews.text = data.gradeCnt
            backgroundImage.load(data.image)
            gameImage.load(data.logo)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        initView(dataModel)
    }
}
