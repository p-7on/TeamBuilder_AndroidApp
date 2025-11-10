package at.fhooe.me.android.pro1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import at.fhooe.me.android.pro1.databinding.ActivityMainBinding

const val TAG: String = "FußballApp"

class MainActivity : Activity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var connection: DBConnection

    override fun onCreate(savedInstanceState: Bundle?) {
    //test123

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
     //   setContentView(R.layout.activity_main)

        binding.activityMainButtonLogin.setOnClickListener {
            val i: Intent = Intent(this, ActivityLogIn::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }

        binding.activityMainButtonRegist.setOnClickListener {
            val i: Intent = Intent(this, ActivityRegister::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }

        binding.activityMainButtonEnd.setOnClickListener {
            finish()
        }
    }

    //get connection and select data from database
    override fun onResume() {
        super.onResume()
        var thread = Thread {
            connection = DBConnection.getInstance()
            var rs = connection.executeQuery("select * from `Verein`")

            while (rs.next()) {
                this@MainActivity.runOnUiThread{
                   // binding.activityMainButtonLogin.text = rs.getString(2)
                }
            }
        }
        thread.start()
    }

    //deconnect database
    override fun onPause() {
        super.onPause()
        //connection.close()
    }
}