package at.fhooe.me.android.pro1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import at.fhooe.me.android.pro1.databinding.ActivityRegisterBinding
import java.sql.Connection
import java.sql.Statement

class ActivityRegister : Activity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var connection: DBConnection


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.activityRegisterButtonRegist.setOnClickListener {
            var thread = Thread {
                connection = DBConnection.getInstance()
                if (connection == null) {
                    Toast.makeText(this, "No Connection to Database!", Toast.LENGTH_SHORT)
                } else {
                    val vollername = findViewById<TextView>(R.id.activity_register_plain_text_entire_name).text.toString()
                    val benutzername = findViewById<TextView>(R.id.activity_register_plain_text_username).text.toString()
                    val pw = findViewById<TextView>(R.id.activity_register_plain_text_password).text.toString()
                    var idrolle: Int = 0
                    if (findViewById<Spinner>(R.id.activity_register_spinner_function).selectedItem.toString().equals("Spieler")) {
                        idrolle = 1
                    } else {
                        idrolle = 2
                    }
                    val idverein: Int = 1
                    connection.insertNewUser(vollername, benutzername, pw, idrolle, idverein)
                }
            }
            thread.start()

            val i: Intent = Intent(this, ActivityHome::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }

        val PersonFunction: Spinner = findViewById(R.id.activity_register_spinner_function);
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.functions,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        PersonFunction.setAdapter(adapter)
    }

}

