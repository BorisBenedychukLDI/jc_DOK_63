package com.jokas.citys.pot.com

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

fun MainActivity34ujy1.clickSetup34ujy1(
    uiComponents: (
        view34ujy1: View
    ) -> Unit
) {
    findViewById<View>(R.id.v_34ujy1).setOnClickListener {
        uiComponents(it)
    }
    findViewById<TextView>(R.id.tv_start_34ujy1).setOnClickListener {
        uiComponents(it)
    }

}



fun MainActivity34ujy1.animationBackGround34ujy1  () {
    ValueAnimator.ofArgb(resources.getColor(R.color.white_34ujy1), resources.getColor(R.color.theme_purple_2_34ujy1)).run {
        setEvaluator(ArgbEvaluator())
        duration = 5000
        addUpdateListener { findViewById<ConstraintLayout>(R.id.cl_second_34ujy1).setBackgroundColor(it.animatedValue.toString().toInt()) }
        start()
    }
}