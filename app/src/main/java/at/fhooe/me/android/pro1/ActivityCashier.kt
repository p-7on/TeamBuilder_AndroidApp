package at.fhooe.me.android.pro1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.me.android.pro1.databinding.ActivityCashierBinding

class ActivityCashier : Activity() {
    lateinit var binding: ActivityCashierBinding
    private lateinit var connection: DBConnection
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter_Cashier
    var nameList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCashierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var thread = Thread {
            connection = DBConnection.getInstance()
            var names = connection.executeQuery("Select vollstaendiger_name From User")
            var i = 1
            while (names.next()) {
                nameList.add(names.getString(i))
                i.inc()
            }
            recyclerView = findViewById(R.id.activity_cashier_recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = RecyclerAdapter_Cashier(this, nameList)
            adapter.notifyDataSetChanged()
            recyclerView.adapter = adapter
        }
        thread.start()
    }
}