package com.jokas.citys.pot.com

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity34ujy1 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_34ujy1)
        getSharedPreferences("SP_34ujy1", MODE_PRIVATE).getString("Last_Page_34ujy1", null)?.let {
            startActivity(Intent(this, WebActivity34ujy1::class.java))
            finish()
        }
        clickSetup34ujy1 {
            it.isClickable = false
            TransitionManager.go(Scene.getSceneForLayout(findViewById(R.id.cl_34ujy1), R.layout.scene_main_34ujy1, this),ChangeBounds())
            lifecycleScope.launch {
                animationBackGround34ujy1()
                for (i34ujy1 in 0..100) {
                    findViewById<ProgressBar>(R.id.pb_34ujy1).progress = i34ujy1
                    delay(50)
                }
                parsedURL34ujy1 = BINOM_APPSFLYER_34ujy1.decodeStrings34ujy1()
                startActivity(Intent(this@MainActivity34ujy1, WebActivity34ujy1::class.java),
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity34ujy1,
                        findViewById(R.id.v_34ujy1),
                        "view_in")
                        .toBundle())

            }
        }

    }

    override fun onStop() {
        finish()
        super.onStop()
    }
}