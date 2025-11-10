package at.fhooe.me.android.pro1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.fhooe.me.android.pro1.databinding.ActivityLogInBinding


class ActivityLogIn : Activity() {
    lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityLogInButtonConfirm.setOnClickListener {
            val i: Intent = Intent(this, ActivityHome::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }



    }
}