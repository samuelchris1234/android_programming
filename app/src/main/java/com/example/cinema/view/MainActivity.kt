package com.example.cinema.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cinema.R
import com.example.cinema.model.Movie
import com.example.cinema.viewmodel.MovieViewModel
import org.json.JSONArray
import org.json.JSONException
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    var movieList: MutableList<Movie> = ArrayList()

    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstancedState: Bundle?) {

        super.onCreate(savedInstancedState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

//        val adapter = MovieAdapter(this, movieList)
//        recyclerView!!.adapter = adapter
        movieViewModel.loadMovies()

//        val stringRequest = StringRequest(Request.Method.GET, URL,
//                { response ->
//                    try {
//                        val array = JSONArray(response)
//                        for (i in 0 until array.length()) {
//                            val movies = array.getJSONObject(i)
//                            movieList.add(Movie(
//                                    movies.getString("name"),
//                                    "http://10.0.2.2:8080/android/" + movies.getString("image"),
//                                    "Rating : " + movies.getString("rating"),
//                                    movies.getString("description"),
//                                    movies.getString("airtime_1"),
//                                    movies.getString("airtime_2"),
//                                    movies.getString("airtime_3"),
//                                    movies.getString("airtime_4"),
//                                    movies.getString("airtime_5")
//                            ))
//                            val adapter = MovieAdapter(this, movieList)
//                            recyclerView!!.adapter = adapter
//                        }
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                }
//        ) { }
//        Volley.newRequestQueue(this).add(stringRequest)
    }

//    companion object {
//        private const val URL = "http://10.0.2.2:8080/android/movies.php"
//    }
}