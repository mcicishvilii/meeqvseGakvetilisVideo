package com.example.mexute_gakvetili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mexute_gakvetili.databinding.ActivityMainBinding
import com.example.mexute_gakvetili.detailsScreen.MovieDetailsFragment
import com.example.mexute_gakvetili.listScreen.MovieListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent,MovieListFragment())
            addToBackStack(MovieListFragment::javaClass.name)
            commit()
        }



    }
}