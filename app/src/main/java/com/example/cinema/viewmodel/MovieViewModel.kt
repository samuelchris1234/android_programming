package com.example.cinema.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cinema.model.Movie
import com.example.cinema.view.MainActivity
import com.example.cinema.view.MovieAdapter
import org.json.JSONArray
import org.json.JSONException
import java.util.ArrayList

class MovieViewModel (application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    var movieList: MutableList<Movie> = ArrayList()
    private var recyclerView: RecyclerView

    fun loadMovies(){
        val stringRequest = StringRequest(Request.Method.GET, URL,
                { response ->
                    try {
                        val array = JSONArray(response)
                        for (i in 0 until array.length()) {
                            val movies = array.getJSONObject(i)
                            movieList.add(Movie(
                                    movies.getString("name"),
                                    "http://10.0.2.2:8080/android/" + movies.getString("image"),
                                    "Rating : " + movies.getString("rating"),
                                    movies.getString("description"),
                                    movies.getString("airtime_1"),
                                    movies.getString("airtime_2"),
                                    movies.getString("airtime_3"),
                                    movies.getString("airtime_4"),
                                    movies.getString("airtime_5")
                            ))
                            val adapter = MovieAdapter(context, movieList)
                            recyclerView!!.adapter = adapter
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
        ) { }
        Volley.newRequestQueue(context).add(stringRequest)
    }

    companion object {
        private const val URL = "http://10.0.2.2:8080/android/movies.php"
    }

}