package com.jokas.citys.pot.com

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class WebActivity34ujy1 : AppCompatActivity() {

    private lateinit var wv34ujy1: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_activity34ujy1)
        setupWebViewLayout34ujy1()
        circleChecker34ujy1()
    }

    override fun onBackPressed() =
        if (wv34ujy1.canGoBack() && wv34ujy1.isFocused) wv34ujy1.goBack() else super.onBackPressed()

    override fun onActivityResult(
        requestCode34ujy1: Int,
        resultCode34ujy1: Int,
        data34ujy1: Intent?
    ) {
        if (filePathCallBack34ujy1 != null && requestCode34ujy1 == 0) {
            val uriResult34ujy1 =
                if (data34ujy1 == null || resultCode34ujy1 != RESULT_OK) null else data34ujy1.data
            if (uriResult34ujy1 != null) {
                filePathCallBack34ujy1?.onReceiveValue(arrayOf(uriResult34ujy1))
            } else {
                filePathCallBack34ujy1?.onReceiveValue(arrayOf(uriView34ujy1))
            }
            filePathCallBack34ujy1 = null
        }
        super.onActivityResult(requestCode34ujy1, resultCode34ujy1, data34ujy1)
    }

    private fun splashAnimation34ujy1() {
        findViewById<View>(R.id.v_web_34ujy1).let { circleWeb34ujy1 ->
            AnimatorSet().play(
                ObjectAnimator.ofPropertyValuesHolder(
                    circleWeb34ujy1, PropertyValuesHolder.ofFloat(
                        View.SCALE_X, 1f, 0.5f
                    ), PropertyValuesHolder.ofFloat(
                        View.SCALE_Y, 1f, 0.5f
                    )
                ).apply {
                    duration = 500
                    start()
                }
            ).before(
                ObjectAnimator.ofFloat(circleWeb34ujy1, View.ALPHA, 1f, 0f).apply {
                    duration = 500
                    start()
                }
            ).with(
                ObjectAnimator.ofPropertyValuesHolder(
                    circleWeb34ujy1, PropertyValuesHolder.ofFloat(
                        View.SCALE_X, 1f, 25f
                    ), PropertyValuesHolder.ofFloat(
                        View.SCALE_Y, 1f, 25f
                    )
                ).apply {
                    duration = 500
                    start()
                }
            )

        }
    }




    private fun returnCircle34ujy1 () {
        findViewById<View>(R.id.v_web_34ujy1).run {
            animate().alpha(1f).run { duration = 500}
            animate().scaleX(1f).run { duration = 500 }
            animate().scaleY(1f).run { duration = 500 }
        }
    }

    private fun WebActivity34ujy1.circleChecker34ujy1 () {
        lifecycleScope.launch {
            delay(500)
            splashAnimation34ujy1()
            while (isActive) {
                if(!internetChecker34ujy1()) {
                    returnCircle34ujy1()
                    delay(500)
                    startActivity(Intent(this@WebActivity34ujy1, InternetConnectionActivity34ujy1::class.java),
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this@WebActivity34ujy1,
                            findViewById(R.id.v_web_34ujy1),
                            "view_internet" )
                            .toBundle())
                    cancel()
                }
                delay(500)
            }
        }
    }

    override fun onStop() {
        finish()
        super.onStop()
    }

    private fun setupWebViewLayout34ujy1 () {
        wv34ujy1 = findViewById(R.id.wv_34ujy1)
        wv34ujy1.run {
            settings.run {
                loadWithOverviewMode = true
                displayZoomControls = false
                useWideViewPort = true
                javaScriptEnabled = true
                loadsImagesAutomatically = true
                cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                builtInZoomControls = true
                displayZoomControls = false
                domStorageEnabled = true
                mediaPlaybackRequiresUserGesture = false

            }

            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view34ujy1: WebView?,
                    request34ujy1: WebResourceRequest?
                ): Boolean {
                    val prohibitedLinks34ujy1 = listOf("facebook")
                    val modifiedLinks34ujy1 = listOf("mailto:", "tel:")
                    return when {
                        prohibitedLinks34ujy1.find {
                            request34ujy1?.url.toString().contains(it)
                        } != null -> true
                        modifiedLinks34ujy1.find {
                            request34ujy1
                                ?.url.toString().startsWith(it)
                        } != null -> {
                            view34ujy1?.context?.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    request34ujy1?.url
                                )
                            )
                            true
                        }
                        else -> false
                    }
                }

                override fun onPageFinished(view34ujy1: WebView?, url34ujy1: String?) {
                    getSharedPreferences("SP_34ujy1", MODE_PRIVATE).edit()
                        .putString("Last_Page_34ujy1", url34ujy1 ?: return).apply()
                    super.onPageFinished(view34ujy1, url34ujy1)
                }

                override fun onReceivedSslError(
                    view34ujy1: WebView?,
                    handler34ujy1: SslErrorHandler?,
                    error34ujy1: SslError?
                ) {
                    handler34ujy1?.proceed()
                    super.onReceivedSslError(view34ujy1, handler34ujy1, error34ujy1)
                }
            }

            webChromeClient = object : WebChromeClient() {
                override fun onShowFileChooser(
                    webView34ujy1: WebView?,
                    filePathCallback34ujy1s: ValueCallback<Array<Uri>>?,
                    fileChooserParams34ujy1: FileChooserParams?
                ): Boolean {
                    checkPermissions34ujy1()
                    filePathCallBack34ujy1 = filePathCallback34ujy1s
                    val captureIntent34ujy1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if (captureIntent34ujy1.resolveActivity(packageManager) != null) {
                        val providedFile34ujy1 = createTempFile34ujy1()
                        uriView34ujy1 = FileProvider.getUriForFile(
                            this@WebActivity34ujy1,
                            "${packageName}.provider",
                            providedFile34ujy1
                        )
                        captureIntent34ujy1.run {
                            putExtra(MediaStore.EXTRA_OUTPUT, uriView34ujy1)
                            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        }
                        val actionIntent34ujy1 = Intent(Intent.ACTION_GET_CONTENT).apply {
                            addCategory(Intent.CATEGORY_OPENABLE)
                            type = "image/*"
                        }
                        val intentChooser34ujy1 = Intent(Intent.ACTION_CHOOSER).apply {
                            putExtra(Intent.EXTRA_INTENT, captureIntent34ujy1)
                            putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(actionIntent34ujy1))
                        }
                        startActivityForResult(intentChooser34ujy1, 0)
                        return true

                    }
                    return super.onShowFileChooser(
                        webView34ujy1,
                        filePathCallback34ujy1s,
                        fileChooserParams34ujy1
                    )
                }
            }
            getSharedPreferences("SP_34ujy1", MODE_PRIVATE).getString("Last_Page_34ujy1", null)
                ?.let {
                    loadUrl(it)
                    return@run
                }
            loadUrl(parsedURL34ujy1 ?: return)
            Log.d("TEST_URL", parsedURL34ujy1 ?: return)
        }

        findViewById<SwipeRefreshLayout>(R.id.srl_34ujy1)?.let {
            it.setOnRefreshListener {
                wv34ujy1.loadUrl(wv34ujy1.url ?: return@setOnRefreshListener)
                it.isRefreshing = false
            }
        }
    }
}