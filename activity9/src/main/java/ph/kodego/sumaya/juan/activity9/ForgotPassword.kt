package ph.kodego.sumaya.juan.activity9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.kodego.sumaya.juan.activity9.databinding.ActivityForgotPasswordBinding

class ForgotPassword : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendEmail.setOnClickListener{
            val intent = Intent()
            intent.putExtra("checkEmail", binding.checkEmailInput.text.toString())
            setResult(1, intent)
            finish()
        }
    }
}