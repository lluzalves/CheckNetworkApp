package com.app.daniel.checknetworkapp.base

import android.app.Activity
import android.widget.Toast
import com.app.daniel.checknetworkapp.R
import com.app.daniel.checknetworkapp.network.InternetChecker
import com.app.daniel.checknetworkapp.network.NetworkChecker
import com.app.daniel.checknetworkapp.network.NetworkListener
import com.app.daniel.checknetworkapp.view.AppDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class BaseActivity : Activity() {

    protected fun checkNetworkStatus() {
        val networkDialog = AppDialog(this).createDialog(getString(R.string.network_check), R.layout.loading_dialog)
        val result = StringBuilder()
        networkDialog.show()
        GlobalScope.launch {
            val networkListener = object : NetworkListener {
                override fun hasConnectivity(isConnected: Boolean) {
                    if (isConnected) {
                        result.append(getString(R.string.connected_to_network))
                        InternetChecker(this).execute()
                    } else {
                        result.append(getString(R.string.not_connected_to_network))
                        showToast(result.toString())
                    }
                }

                override fun isOnline(status: Boolean) {
                    networkDialog.dismiss()
                    if (status) {
                        result.append(getString(R.string.connected_to_internet))
                    } else {
                        result.append(getString(R.string.not_connected_to_internet))
                    }
                    showToast(result.toString())
                }
            }
            NetworkChecker(window.context).isConnectedToNetwork(networkListener)
        }

    }

    private fun showToast(message: String) = runOnUiThread {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }
}