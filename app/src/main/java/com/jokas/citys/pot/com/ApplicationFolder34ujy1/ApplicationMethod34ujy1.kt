package com.jokas.citys.pot.com

import android.content.Context
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun Context.mobileAdsSetup34ujy1 () {
    MobileAds.initialize(this)
    CoroutineScope(Dispatchers.IO).launch {
        try {
            AID34ujy1 =
                AdvertisingIdClient.getAdvertisingIdInfo(this@mobileAdsSetup34ujy1)?.id
        } catch (e34ujy1: Exception) {

        }
    }
}

fun Context.oneSignalSetup34ujy1 () {
    OneSignal.initWithContext(this)
    OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    OneSignal.setAppId(CODED_ONESIGNAL_34ujy1.decodeStrings34ujy1())
}

fun Context.appsFlyerSetup34ujy1 () {
    val appsFlyerConversion34ujy1 = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(dataMap34ujy1: MutableMap<String, Any>?) {
            dataMap34ujy1?.run {

                status34ujy1 =
                    if (getValue(APPSFLYER_STATUS_TAG_34ujy1).toString() == "Organic") "Organic" else "Non-organic"

                val paramsArray34ujy1 = mutableListOf<String>()
                getValue(APPSFLYER_CAMPAIGN_TAG_34ujy1)
                    .toString()
                    .split("||").drop(1)
                    .map {
                        paramsArray34ujy1.add(it.split(":")[1])
                    }

                key34ujy1 = if (paramsArray34ujy1.size >= 1) paramsArray34ujy1[0] else "empty"
                sub234ujy1 = if (paramsArray34ujy1.size >= 2) paramsArray34ujy1[1] else "empty"
                sub334ujy1 = if (paramsArray34ujy1.size >= 3) paramsArray34ujy1[2] else "empty"


                mediaSource34ujy1 = getValue(APPSFLYER_MEDIA_SOURCE_TAG_34ujy1).toString()
                afChannel34ujy1 = getValue(APPSFLYER_AF_CHANNEL_TAG_34ujy1).toString()
                adGroup34ujy1 = getValue(APPSFLYER_ADGROUP_TAG_34ujy1).toString()
                adSet234ujy1 = getValue(APPSFLYER_ADSET_TAG_34ujy1).toString()



            }
        }

        override fun onConversionDataFail(p0: String?) {
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(p0: String?) {
        }
    }
    AppsFlyerLib.getInstance().run {
        uid34ujy1 = getAppsFlyerUID(this@appsFlyerSetup34ujy1)
        init(
            CODE_APPSFLYER_34ujy1.decodeStrings34ujy1(),
            appsFlyerConversion34ujy1,
            this@appsFlyerSetup34ujy1
        )
        start(this@appsFlyerSetup34ujy1)
    }
}

