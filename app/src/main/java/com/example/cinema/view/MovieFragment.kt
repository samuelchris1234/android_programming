package com.example.cinema.view

import android.os.Bundle
import androidx.fragment.app.ListFragment
import androidx.fragment.app.viewModels
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

class MovieFragment : ListFragment() {

    private val model: MovieViewModel by viewModels()
    var coverList: MutableList<Movie> = ArrayList()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = recyclerView.findViewById(R.id.movie_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val stringRequest = StringRequest(Request.Method.GET, URL,
                { response ->
                    try {
                        val array = JSONArray(response)
                        for (i in 0 until array.length()) {
                            val movies = array.getJSONObject(i)
                            coverList.add(Movie(
                                    movies.getString("name"),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                            ))
                            val adapter = MovieAdapter(requireContext(), coverList)
                            recyclerView.adapter = adapter
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
        ) { }

        Volley.newRequestQueue(context).add(stringRequest)
    }

    companion object {
        private const val URL = "http://10.0.2.2/android/movies.php"
    }

}