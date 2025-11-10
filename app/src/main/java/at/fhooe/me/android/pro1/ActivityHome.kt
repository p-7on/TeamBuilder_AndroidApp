package at.fhooe.me.android.pro1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import at.fhooe.me.android.pro1.databinding.ActivityHomeBinding


class ActivityHome : Activity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.activityHomeImagebuttonCalendar.setOnClickListener {
            val i: Intent = Intent(this, CalendarMain::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }
        binding.activityHomeImagebuttonAccept.setOnClickListener {
            val i: Intent = Intent(this, ActivityAccept::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }

        binding.activityHomeImagebuttonCashier.setOnClickListener {
            val i: Intent= Intent(this,ActivityCashier::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }

        binding.activityHomeImagebuttonSquad.setOnClickListener {
            val i: Intent = Intent(this, ActivitySquad::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }
    }
}