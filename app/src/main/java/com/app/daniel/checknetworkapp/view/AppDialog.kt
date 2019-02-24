package com.app.daniel.checknetworkapp.view

import android.app.Dialog
import android.content.Context
import android.view.Window

class AppDialog constructor(context: Context) : Dialog(context) {


    fun createDialog(message: String, dialogLayout: Int): AppDialog {
        var dialog = AppDialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(dialogLayout)
        dialog.setTitle(message)
        return dialog
    }
}
