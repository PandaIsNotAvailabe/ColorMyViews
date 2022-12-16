package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding
import android.content.Context


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val boxName: BoxName = BoxName("box_one","box_two", "box_three",
        "box_four", "box_five_text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.boxNameData = boxName
        setListeners()
    }

    /**
     * Attaches listeners to all the views.
     */
    private fun setListeners() {
        val b1 = binding.boxOneText
        val b2 = binding.boxTwoText
        val b3 = binding.boxThreeText
        val b4 = binding.boxFourText
        val b5 = binding.boxFiveText
        var constr = binding.constraintLayout
        val redbtn = binding.redBtn
        val greenbtn = binding.greenBtn
        val yellowbtn = binding.yellowBtn
        val clickableViews: List<View> =
            listOf(b1, b2, b3, b4, b5, constr, redbtn, greenbtn, yellowbtn)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        val b3 = binding.boxThreeText
        val b4 = binding.boxFourText
        val b5 = binding.boxFiveText

        when (view.id) {

            // Boxes using Color class colors for background
                R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
                R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
                R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
                R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
                R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom color for background
                R.id.red_btn -> b3.setBackgroundResource(R.color.my_red)
                R.id.yellow_btn -> b4.setBackgroundResource(R.color.my_yellow)
                R.id.green_btn -> b5.setBackgroundResource(R.color.my_green)

                else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}













