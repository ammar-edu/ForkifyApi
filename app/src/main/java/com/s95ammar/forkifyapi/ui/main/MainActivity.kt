package com.s95ammar.forkifyapi.ui.main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.s95ammar.forkifyapi.R
import com.s95ammar.forkifyapi.ui.main.adapter.DishesAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val searchEditText: EditText by lazy { findViewById(R.id.search_edit_text) }
    private val searchButton: Button by lazy { findViewById(R.id.search_Button) }
    private val dishesRecyclerView: RecyclerView by lazy { findViewById(R.id.dishes_recycler_view) }
    private val adapter: DishesAdapter by lazy { DishesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dishesRecyclerView.adapter = adapter

        searchButton.setOnClickListener {
            viewModel.search(searchEditText.text.toString())
        }

        viewModel.dishes.observe(this) { dishes ->
            adapter.submitList(dishes)
        }
    }
}