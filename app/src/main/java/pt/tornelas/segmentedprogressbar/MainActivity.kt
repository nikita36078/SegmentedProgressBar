package pt.tornelas.segmentedprogressbar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pt.tornelas.segmentedprogressbar.databinding.ActivityMainBinding
import pt.tornelas.segmentedprogressbar.standard.StandardExampleActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        const val LAYOUT_TYPE_STANDARD = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStandardLayout.setOnClickListener { loadExample(LAYOUT_TYPE_STANDARD) }
    }

    private fun loadExample(type: Int){
        startActivity(
            Intent(
                this,
                when (type){
                    LAYOUT_TYPE_STANDARD -> StandardExampleActivity::class.java
                    else -> throw RuntimeException("Unrecognized activity")
                }
            )
        )
    }
}
