package com.example.firestore
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.healthsphere.RegisterActivity
import com.example.healthsphere.SignIn
import com.example.models.User
import com.example.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {
    private val mFirestore = FirebaseFirestore.getInstance()
    fun registerUser(activity: RegisterActivity, userInfo: User){
        // the "users" is collection name .If collection already exist then it will not create the same users
        mFirestore.collection(Constants.USERS)
            // document id for the users  field
            .document(userInfo.id)
            //here the user info are field and setOption are set to merge
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                //here we call the activity of base activity for transferring the result to it
                activity.userRegistrationSucceess()
            }
            .addOnFailureListener { e ->
                activity.hideProgressDialog()
                Log.e(
                    activity.javaClass.simpleName, "error while registering user", e
                )
            }
    }
    fun getCurrentUserID(): String {
        // an instance of current user using FirebaseAuth
        val currentUser = FirebaseAuth.getInstance().currentUser
        //variable to assign current user if it is not null or else it will be blank.
        var currentUserID = ""
        if(currentUser != null){
            currentUserID = currentUser.uid
        }
        return currentUserID
    }

    fun getUserDetails(activity: Activity){
        //here we pass the collection name from which we want the data
        mFirestore.collection(Constants.USERS)
            //the document id to get the Fields of users
            .document(getCurrentUserID()).get().addOnSuccessListener { document ->
                Log.i(activity.javaClass.simpleName, document.toString())
                //here we have received the document snapshot which is converted into user Data model object
                val user = document.toObject(User::class.java)!!


                val sharedPreferences = activity.getSharedPreferences(
                    Constants.HEALTHAPP_PREFERENCES,
                    Context.MODE_PRIVATE
                )
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                //key : logged_in_username
                //value: Username
                editor.putString(
                    Constants.LOGGED_IN_USERNAME, "${user.userName}"
                )
                editor.apply()

                when( activity){
                    is SignIn -> {
                        //call a base activity function to transfer result to it
                        activity.userLoggedInSuccess(user)
                    }
                }
                //END
            }
            .addOnFailureListener {e ->
                when(activity){
                    is SignIn ->{
                        activity.hideProgressDialog()
                    }
                }
            }
    }
}