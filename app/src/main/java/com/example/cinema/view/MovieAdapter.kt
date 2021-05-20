package com.example.cinema.view

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.cinema.R
import com.bumptech.glide.Glide
import com.example.cinema.model.Movie

class MovieAdapter(private val context: Context, private var movieList: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movies, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        Glide.with(context)
                .load(movie.image)
                .into(holder.imageView)
        holder.nameView.text = movie.name
        holder.ratingView.text = movie.rating
        holder.descriptionView.text = movie.description
        holder.at1View.text = movie.airtime_1
        holder.at2View.text = movie.airtime_2
        holder.at3View.text = movie.airtime_3
        holder.at4View.text = movie.airtime_4
        holder.at5View.text = movie.airtime_5
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView = itemView.findViewById(R.id.image_view)
    var nameView: TextView = itemView.findViewById(R.id.text_view_name)
    var ratingView: TextView = itemView.findViewById(R.id.text_view_rating)
    var descriptionView: TextView = itemView.findViewById(R.id.text_view_description)
    var at1View: TextView = itemView.findViewById(R.id.text_view_at1)
    var at2View: TextView = itemView.findViewById(R.id.text_view_at2)
    var at3View: TextView = itemView.findViewById(R.id.text_view_at3)
    var at4View: TextView = itemView.findViewById(R.id.text_view_at4)
    var at5View: TextView = itemView.findViewById(R.id.text_view_at5)
}