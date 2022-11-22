package com.jitusolution.week8materialapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_playlist.view.*

class PlaylistAdapter(val playlists:ArrayList<Playlist>):RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {
    class PlaylistViewHolder(val v: View):RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.card_playlist, parent, false)
        return PlaylistViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val url = playlists[position].image_url
        Picasso.get().load(url).into(holder.v.imgPlaylist)
        holder.v.txtTitle.text = playlists[position].title
        holder.v.txtSubtitle.text = playlists[position].subtitle
        holder.v.txtDesc.text = playlists[position].description
        holder.v.btnLike.text = playlists[position].num_likes.toString()
    }

    override fun getItemCount(): Int {
        return playlists.size
    }
}