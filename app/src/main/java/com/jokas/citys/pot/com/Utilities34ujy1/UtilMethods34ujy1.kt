package com.jokas.citys.pot.com

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Environment
import android.util.Base64
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun Context.checkPermissions34ujy1 () {
    Dexter.withContext(this)
        .withPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
        .withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: MutableList<PermissionRequest>?,
                p1: PermissionToken?
            ) {

            }
        }).check()
}

fun Context.createTempFile34ujy1 (): File {
    val date34ujy1 = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        .format(Date())
    val fileDir34ujy1 = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile("TMP${date34ujy1}_34ujy1", ".jpg", fileDir34ujy1)
}

fun String.decodeStrings34ujy1 () = String(Base64.decode(this, Base64.DEFAULT))

fun Context.internetChecker34ujy1 (): Boolean {
    val connectivityManager34ujy1 = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val networkCapabilities34ujy1 = connectivityManager34ujy1.getNetworkCapabilities(connectivityManager34ujy1.activeNetwork) ?: return false
        return networkCapabilities34ujy1.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    } else {
        for (network34ujy1 in connectivityManager34ujy1.allNetworks) {
            connectivityManager34ujy1.getNetworkInfo(network34ujy1)?.let {
                if (it.isConnected) return true
            }
        }
        return false
    }
}