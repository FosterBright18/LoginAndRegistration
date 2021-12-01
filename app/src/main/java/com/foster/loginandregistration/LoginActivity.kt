package com.foster.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.foster.loginandregistration.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    // any time you need what wold have been a "static" variable in java, you use
    // a companion object in Kotlin.  You access it with lassName.VARIABLE_NAME like math.PI
    companion object {
        // key for the key-value pairs for the intent extras
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    // starting an activity for a result
    // step 1 register activity with a contract
    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        // decide what to do if the result was successful
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent
            // note: editTexts are different from text vuews in that you have to call setText
            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }
        // decide what to do if the result was unsuccessful
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewLoginCreateAccount.setOnClickListener{
            // launch registration activity
            // take values of username and password from login activity to registration activity
            // step 1 extract any information you might need from the edit text
            val username = binding.editTextLoginUsername.text.toString()
            val password = binding.editTextLoginPassword.text.toString()
            // step 2 create intent and package the extras
            // the content is the activity you are in
            val registrationIntent = Intent(this, RegistrationActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }

            // step 3 launch the activity
            // startActivity(registrationIntent)

            // step 3b alternate:  Could launch the activity for a result
            // use the variable from the register for result contract above
            startRegistrationForResult.launch(registrationIntent)
        }
    }

}