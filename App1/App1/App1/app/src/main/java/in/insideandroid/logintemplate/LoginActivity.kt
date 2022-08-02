package `in`.insideandroid.logintemplate

import `in`.insideandroid.logintemplate.databinding.ActivityLoginBinding
import `in`.insideandroid.logintemplate.viewModel.MainViewModel
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {
    private val userDoc = "admin"
    private val passwordDoc = "admin"
    private val userInf = "inf"
    private val passwordInf = "inf"
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        setStatusBarTransparent(this@LoginActivity)
        binding.buttonSignin.setOnClickListener(){
            val userName = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            loginValidation(userName,password)
        }

    }

    private fun setStatusBarTransparent(activity: AppCompatActivity){
        //Make Status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        //Make status bar icons color dark
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            activity.window.statusBarColor = Color.WHITE
        }
    }
/*
*
* onclick : fonction de navigation
* entre les pages
* @return : none
*
* */
    fun onClick(view: View) {
         if(view.id == R.id.button_forgot_password){
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }
    }
/*
*
* onclick : validation de password and username
* @return : none
*
* */
  private fun loginValidation(user: String ,password: String)  {
      if (user == this.userDoc && password == this.passwordDoc){

        intent = Intent(applicationContext, MainActivity::class.java)
          mainViewModel.saveToDataStore("true")
          startActivity(intent)
      }else if(user == this.userInf && password == this.passwordInf){

          intent = Intent(applicationContext, MainActivity::class.java)
          mainViewModel.saveToDataStore("false")
          startActivity(intent)
      }
      else{

          Toast.makeText(applicationContext, "utilisateur or mot de passe incorrect", Toast.LENGTH_SHORT).show()
      }
  }
}


