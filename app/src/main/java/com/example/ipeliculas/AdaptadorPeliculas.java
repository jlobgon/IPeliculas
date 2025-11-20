package com.example.ipeliculas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPeliculas extends RecyclerView.Adapter<AdaptadorPeliculas.vh> {
    Context c;
    ArrayList<Pelicula> listaPelicula;

    public AdaptadorPeliculas(Context c, ArrayList<Pelicula> listaPelicula) {
        this.c = c;
        this.listaPelicula = listaPelicula;
    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(c);
        View v = li.inflate(R.layout.card_pelicula,parent,false);
        return new vh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        holder.tituloPelicula.setText(listaPelicula.get(position).getTitulo());
        holder.generoPelicula.setText(listaPelicula.get(position).getGenero());
        holder.descripcionPequenaPelicula.setText(listaPelicula.get(position).getDescripcionCorta());
        holder.fotoPelicula.setImageResource(listaPelicula.get(position).getImagenResID());
        holder.ratingBar.setRating(listaPelicula.get(position).getValoracion());

        holder.fotoPelicula.setOnClickListener(v -> {
            Pelicula p = listaPelicula.get(position);
            Intent intent = new Intent(c, DetailActivity.class);
            intent.putExtra("pelicula",p);
            c.startActivity(intent);


        });


    }

    @Override
    public int getItemCount() {
        return listaPelicula.size();
    }

    public class vh extends RecyclerView.ViewHolder {
        TextView tituloPelicula,generoPelicula,descripcionPequenaPelicula;
        ImageView fotoPelicula;
        RatingBar ratingBar;

        public vh(@NonNull View itemView) {
            super(itemView);
            tituloPelicula = (TextView) itemView.findViewById(R.id.card_pelicula_textView_titulo);
            generoPelicula = (TextView) itemView.findViewById(R.id.card_pelicula_textView_genero);
            descripcionPequenaPelicula = (TextView) itemView.findViewById(R.id.card_pelicula_textView_descripcion);
            fotoPelicula = (ImageView) itemView.findViewById(R.id.card_pelicula_imageView);
            ratingBar = (RatingBar) itemView.findViewById(R.id.card_pelicula_rating_bar);




        }
    }
}
