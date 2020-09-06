package com.example.songlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    LayoutInflater inflater;
    List<Song> songs;
    Context ctx;

    public Adapter( Context ANKIT,List<Song> songs) {
        this.songs = songs;
        this.ctx = ANKIT;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.songTitle.setText(songs.get(position).getTittle());
        holder.songArtists.setText(songs.get(position).getArtiats());
        Picasso.get().load(songs.get(position).getCoverImage()).into(holder.songCoverImage);

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView songTitle,songArtists;
        ImageView songCoverImage;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            songTitle =itemView.findViewById(R.id.songTitle);
            songArtists=itemView.findViewById(R.id.songArtist);
            songCoverImage=itemView.findViewById(R.id.coverImage);
        }
    }


}
