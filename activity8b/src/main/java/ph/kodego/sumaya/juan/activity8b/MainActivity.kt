package ph.kodego.sumaya.juan.activity8b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.kodego.sumaya.juan.activity8b.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}