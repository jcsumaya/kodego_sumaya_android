package ph.kodego.sumaya.juan.activity9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.sumaya.juan.activity9.adapter.ItemAdapter
import ph.kodego.sumaya.juan.activity9.databinding.ActivityMainBinding
import ph.kodego.sumaya.juan.activity9.model.GroceryItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var items: ArrayList<GroceryItem> = ArrayList()
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        itemAdapter = ItemAdapter(items)

        binding.list.layoutManager = LinearLayoutManager(applicationContext)
        binding.list.adapter = itemAdapter
    }

    fun init(){
        items.add(GroceryItem("Apple", 30))
        items.add(GroceryItem("Banana", 25))
        items.add(GroceryItem("Mango", 20))
        items.add(GroceryItem("Orange", 10))
        items.add(GroceryItem("Strawberry", 10))
    }
}