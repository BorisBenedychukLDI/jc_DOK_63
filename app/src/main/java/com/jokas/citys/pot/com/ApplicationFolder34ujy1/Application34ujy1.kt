package com.jokas.citys.pot.com.ApplicationFolder34ujy1

import android.app.Application
import com.jokas.citys.pot.com.appsFlyerSetup34ujy1
import com.jokas.citys.pot.com.mobileAdsSetup34ujy1
import com.jokas.citys.pot.com.oneSignalSetup34ujy1

class Application34ujy1 : Application() {

    override fun onCreate() {
        appsFlyerSetup34ujy1()
        mobileAdsSetup34ujy1()
        oneSignalSetup34ujy1()
        super.onCreate()
    }
}