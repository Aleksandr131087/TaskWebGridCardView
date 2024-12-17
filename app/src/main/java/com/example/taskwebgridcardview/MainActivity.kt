package com.example.taskwebgridcardview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



private lateinit var toolbar: Toolbar
private lateinit var GridView: GridView
    private var websites = mutableListOf(
        GridViewModel("http://www.yandex.ru", R.drawable.ya),
        GridViewModel("http://www.gismeteo.ru", R.drawable.ic_launcher_foreground),
         GridViewModel("https://www.championat.com", R.drawable.ic_launcher_foreground)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        GridView = findViewById(R.id.GridView)
val adapter=GridViewAdapter(list = websites, this@MainActivity)
GridView.adapter = adapter
GridView.onItemClickListener=AdapterView.OnItemClickListener{_,_,position, _ ->
    val intent = Intent(this, ActivityWebView::class.java)
    intent.putExtra("url", websites[position].url)
    startActivity(intent)
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websites[position].url)))
}




    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}