package at.fhooe.me.android.pro1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.me.android.pro1.databinding.ActivityAcceptBinding


class ActivityAccept : Activity() {
    lateinit var binding: ActivityAcceptBinding
    private lateinit var connection: DBConnection
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter
    var nameList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcceptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var thread = Thread {
            connection = DBConnection.getInstance()
            var names = connection.executeQuery("Select vollstaendiger_name From User")
            var i = 1
            while (names.next()) {
                nameList.add(names.getString(i))
                i.inc()
            }
            recyclerView = findViewById(R.id.activity_accept_recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = RecyclerAdapter(this, nameList)
            adapter.notifyDataSetChanged()
            recyclerView.adapter = adapter
        }
        thread.start()
    }
}