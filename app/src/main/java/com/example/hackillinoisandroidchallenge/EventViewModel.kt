package com.example.hackillinoisandroidchallenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventViewModel : ViewModel() {

    val eventsLiveData: MutableLiveData<List<Event>> = MutableLiveData()

    fun fetchEvents(jwtToken: String) {
        RetrofitInstance.api.getEvents("Bearer $jwtToken").enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        eventsLiveData.postValue(it.events)
                    }
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                // handle error
            }
        })
    }
}
