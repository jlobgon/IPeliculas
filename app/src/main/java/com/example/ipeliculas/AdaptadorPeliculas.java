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

    /**
     * Constructor del adaptador.
     *
     * @param c Contexto de la actividad donde se usa el adaptador.
     * @param listaPelicula Lista de películas que se mostrarán en el RecyclerView.
     */
    public AdaptadorPeliculas(Context c, ArrayList<Pelicula> listaPelicula) {
        this.c = c;
        this.listaPelicula = listaPelicula;
    }

    /**
     * Crea la vista de cada elemento del RecyclerView.
     *
     * @param parent El ViewGroup padre donde se insertará la vista.
     * @param viewType Tipo de vista (no se usa aquí, siempre 0).
     * @return ViewHolder con la vista inflada.
     */
    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(c);
        View v = li.inflate(R.layout.card_pelicula,parent,false);
        return new vh(v);
    }

    /**
     * Vincula los datos de la película con la vista correspondiente.
     *
     * @param holder ViewHolder que contiene las vistas de un elemento.
     * @param position Posición de la película en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        holder.tituloPelicula.setText(listaPelicula.get(position).getTitulo());
        holder.generoPelicula.setText(listaPelicula.get(position).getGenero());
        holder.descripcionPequenaPelicula.setText(listaPelicula.get(position).getDescripcionCorta());
        holder.fotoPelicula.setImageResource(listaPelicula.get(position).getImagenResID());
        holder.ratingBar.setRating(listaPelicula.get(position).getValoracion());

        // Maneja el clic sobre la imagen para abrir la actividad de detalle
        holder.fotoPelicula.setOnClickListener(v -> {
            Pelicula p = listaPelicula.get(position);
            Intent intent = new Intent(c, DetailActivity.class);
            intent.putExtra("pelicula",p);
            c.startActivity(intent);
        });
    }

    /**
     * Devuelve la cantidad de elementos en la lista de películas.
     *
     * @return Número de películas.
     */
    @Override
    public int getItemCount() {
        return listaPelicula.size();
    }

    public class vh extends RecyclerView.ViewHolder {
        TextView tituloPelicula,generoPelicula,descripcionPequenaPelicula;
        ImageView fotoPelicula;
        RatingBar ratingBar;

        /**
         * Constructor del ViewHolder.
         * Inicializa las vistas del layout de la tarjeta de película.
         *
         * @param itemView Vista del elemento del RecyclerView.
         */
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
