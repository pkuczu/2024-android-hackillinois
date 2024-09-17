package com.example.hackillinoisandroidchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackillinoisandroidchallenge.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val eventViewModel: EventViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val eventAdapter = EventAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = eventAdapter

        eventViewModel.eventsLiveData.observe(this, Observer { events ->
            events?.let {
                binding.recyclerView.adapter = EventAdapter(it)
            }
        })

        val jwtToken = "loremipsumdolorsitamet"  // Your JWT token
        eventViewModel.fetchEvents(jwtToken)
    }
}