package at.fhooe.me.android.pro1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.fhooe.me.android.pro1.databinding.ActivityCalendarBinding


class ActivityCalendar : Activity() {
    lateinit var binding: ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}