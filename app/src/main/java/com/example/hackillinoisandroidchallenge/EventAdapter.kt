package com.example.hackillinoisandroidchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackillinoisandroidchallenge.databinding.ItemEventBinding

class EventAdapter(private val events: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.binding.apply {
            eventName.text = event.name
            eventDescription.text = event.description
            // Optionally format the event time
            // eventTime.text = "Start: ${formatTime(event.startTime)}, End: ${formatTime(event.endTime)}"
        }
    }

    override fun getItemCount(): Int = events.size
}