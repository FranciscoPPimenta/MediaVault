//++Added on 6thMay2025 15:48
package com.example.mediavault

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    //SharedPreferences reference
    //It's purpose it's
    private val pref: SharedPreferences

    //Editor for SharedPreferences
    //Edits and saves the information inside the companion object
    private val editor: SharedPreferences.Editor

    //SharedPreferences keys
    //Saves info about user and check if it's logged
    companion object{
        private const val PREF_NAME = "AppPrefs"
        private const val IS_LOGIN = "IsLoggedIn"
        const val KEY_USER_ID = "user_id"
    }

    //Initializes the variables
    init {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    //function to get user id
    fun getUserID(): String {
        return pref.getString(SessionManager.KEY_USER_ID,"")?: ""
    }


    //Function to create the session after logging in the user
    fun createLoginSession( userId: String) {
        //Changes the boolean to true so it confirms it's logged in
        editor.putBoolean(IS_LOGIN, true)

        //Cahnges the id key string to the users ID
        editor.putString(KEY_USER_ID, userId)

        //Applies the changes
        editor.apply()
    }

    //Checks if user is logged in
    fun isLoggedIn(): Boolean {
        //returns the boolean state (True or False)
        return pref.getBoolean(IS_LOGIN, false)
    }

    //Clears the keys on the companion and saves it
    fun logoutUser(){
        //Clears the keys
        editor.clear()
        //Applies changes
        editor.apply()
    }
}