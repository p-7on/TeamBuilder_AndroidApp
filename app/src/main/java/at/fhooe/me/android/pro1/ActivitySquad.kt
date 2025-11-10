package at.fhooe.me.android.pro1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.fhooe.me.android.pro1.databinding.ActivitySquadBinding

class ActivitySquad : AppCompatActivity() {
    lateinit var binding: ActivitySquadBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}