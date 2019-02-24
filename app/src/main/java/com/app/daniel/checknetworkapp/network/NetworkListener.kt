package com.app.daniel.checknetworkapp.network

interface NetworkListener {

    fun hasConnectivity(isConnected : Boolean)
    fun isOnline(status: Boolean)
}