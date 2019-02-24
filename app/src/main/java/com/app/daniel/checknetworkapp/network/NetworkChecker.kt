package com.app.daniel.checknetworkapp.network

import android.content.Context
import android.net.ConnectivityManager

class NetworkChecker constructor(private val context: Context) {

    fun isConnectedToNetwork(networkListener: NetworkListener) {
        val connectivityManager =
            context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return networkListener.hasConnectivity(activeNetwork != null && activeNetwork.isConnected)
    }
}