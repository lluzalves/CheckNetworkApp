package com.app.daniel.checknetworkapp

import android.os.Bundle
import com.app.daniel.checknetworkapp.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkNetworkStatus()
    }
}
