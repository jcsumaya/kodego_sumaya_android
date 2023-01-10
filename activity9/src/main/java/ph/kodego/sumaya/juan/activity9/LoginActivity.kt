package ph.kodego.sumaya.juan.activity9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.sumaya.juan.activity9.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: String
    private lateinit var password: String

    private val launchRegister = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data

        Snackbar.make(binding.root,
            "Registered ${data!!.getStringExtra("email")}",
            Snackbar.LENGTH_LONG).show()
    }

    private val launchForgotPassword = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data

        Snackbar.make(binding.root,
            "Sent Reset Password Instructions to ${data!!.getStringExtra("checkEmail")}",
            Snackbar.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{

            email = binding.emailText.text.toString()
            password = binding.passwordText.text.toString()

            val goToHome = Intent(this, MainActivity::class.java)

            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putString("password", password)
            goToHome.putExtras(bundle)

            goToHome.putExtra("something", "Extra")

            startActivity(goToHome)
            finish()
        }

        binding.btnRegister.setOnClickListener {
            val goToRegister = Intent(this, RegisterActivity::class.java)
            launchRegister.launch(goToRegister)
        }

        binding.btnForgotpwd.setOnClickListener {
            val goToForgotPassword = Intent(this, ForgotPassword::class.java)
            launchForgotPassword.launch(goToForgotPassword)
        }
    }

    override fun onBackPressed() {
    }
}