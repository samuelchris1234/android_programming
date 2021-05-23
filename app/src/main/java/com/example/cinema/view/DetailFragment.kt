package com.example.cinema.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
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
import java.util.ArrayList

class DetailFragment : Fragment(){

    private val model: MovieViewModel by viewModels()
    private lateinit var tvArticle: TextView
    var movieList: MutableList<Movie> = ArrayList()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        recyclerView = recyclerView.findViewById(R.id.detail_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        tvArticle = inflater.inflate(R.layout.detail_view, recyclerView, false) as TextView
        return tvArticle
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stringRequest = StringRequest(Request.Method.GET, URL,
                { response ->
                    try {
                        val array = JSONArray(response)
                        for (i in 0 until array.length()) {
                            val movies = array.getJSONObject(i)
                            movieList.add(Movie(
                                    movies.getString("name"),
                                    movies.getString("image"),
                                    movies.getString("rating"),
                                    movies.getString("description"),
                                    movies.getString("airtime_1"),
                                    movies.getString("airtime_2"),
                                    movies.getString("airtime_3"),
                                    movies.getString("airtime_4"),
                                    movies.getString("airtime_5")
                            ))
                            val adapter = MovieAdapter(requireContext(), movieList)
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
        private const val URL = "http://10.0.2.2:8080/android/movies.php"
    }

}