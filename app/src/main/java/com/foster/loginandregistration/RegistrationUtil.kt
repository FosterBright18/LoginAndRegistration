package com.foster.loginandregistration

// object keyword makes it so all the functions are static functions
object RegistrationUtil {



    // curse word filter
    // already taken
    // other requirments
    // real name can't be in it
    // min num of characters
    fun validateUsername(username : String) : Boolean{
        return true
    }

    // password meets security requirements
    // passwords match'
    fun validatePassword(password : String, confirmPassword : String) : Boolean{
        return true
    }

    fun validateName(name : String) : Boolean{
        return true
    }

    // make sure it isn't empty
    // make sure email isn't used
    // make sure email is in proper format
    fun validateEmail(email : String) : Boolean {
        return true
    }
}