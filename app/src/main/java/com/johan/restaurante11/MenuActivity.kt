
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.johan.restaurante11.MenuProveer
import com.johan.restaurante11.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        iniciorecycler()
    }
    fun iniciorecycler(){

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerMenu)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=MenuAdapter(MenuProveer.Menulist)
    }
}