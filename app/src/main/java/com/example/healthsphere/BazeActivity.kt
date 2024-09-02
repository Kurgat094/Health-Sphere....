package com.example.healthsphere

import android.app.Dialog
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

open class BazeActivity : AppCompatActivity() {


    private lateinit var mprogressDialog: Dialog
    fun showErrorSnackBar(message: String, errorMessage: Boolean){
        val snackBar =
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val snackbarView = snackBar.view

        if(errorMessage){
            snackbarView.setBackgroundColor(
                ContextCompat.getColor(this, R.color.error_message)
            )
        }
        else{
            snackbarView.setBackgroundColor(
                ContextCompat.getColor(this,
                R.color.sucess_message
            ))
        }
        snackBar.show()
    }

    fun showProgressDialog(text: String){
        mprogressDialog = Dialog(this)
        //set the screen context from a layout resource the resource will be inflated adding all top level views to the screen
        mprogressDialog.setContentView(R.layout.dialog_progress)
//        tv_progress_text = findViewById(R.id.tv_progress_text)
        // Access the TextView inside the dialog and set its text
        val tv_progress_text = mprogressDialog.findViewById<TextView>(R.id.tv_progress_text)
        tv_progress_text.text = text

//        mprogressDialog.tv_progress_text = text = text
        mprogressDialog.setCancelable(true)
        mprogressDialog.setCanceledOnTouchOutside(false)
        mprogressDialog.show()
    }
    fun hideProgressDialog(){
        mprogressDialog.dismiss()
    }
//fun hideProgressDialog() {
//    // Check if the activity is finishing or destroyed before dismissing the dialog
//    if (mprogressDialog.isShowing && !isFinishing && !isDestroyed) {
//        try {
//            mprogressDialog.dismiss()
//        } catch (e: IllegalArgumentException) {
//            // Log the exception if needed
//            Log.e("BazeActivity", "Failed to dismiss dialog: ${e.message}")
//        }
//    }
//}

}