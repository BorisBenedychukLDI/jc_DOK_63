package com.jokas.citys.pot.com

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.animation.doOnEnd
import androidx.core.app.ActivityOptionsCompat

class InternetConnectionActivity34ujy1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_connection_activity34ujy1)
        findViewById<Button>(R.id.b_internet_34ujy1).setOnClickListener {
            if (internetChecker34ujy1()) {
                ObjectAnimator.ofFloat(findViewById(R.id.tv_internet_34ujy1), View.ALPHA, 1f, 0f).run {
                    duration = 400
                    start()
                }
                ObjectAnimator.ofFloat(findViewById(R.id.b_internet_34ujy1), View.ALPHA, 1f, 0f).run {
                    duration = 400
                    start()
                    doOnEnd {
                        startActivity(Intent(this@InternetConnectionActivity34ujy1, WebActivity34ujy1::class.java)
                        ,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(this@InternetConnectionActivity34ujy1, findViewById(R.id.v_web_34ujy1), "view_in").toBundle())
                    }
                }
            }
        }
    }

    override fun onStop() {
        finish()
        super.onStop()
    }
}