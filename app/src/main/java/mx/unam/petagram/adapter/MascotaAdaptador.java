package mx.unam.petagram.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.unam.petagram.pojo.Mascota;
import mx.unam.petagram.R;

/**
 * Created by Daniel on 19/07/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    Fragment fragment;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //le da vida al cardview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) { //asocia cada elemento de la lista con cada view
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(String.valueOf(((Mascota) mascotas.get(position)).getLikes()));

        mascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de elementos
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCV;
        private ImageButton btnLikeCV;
        private TextView tvNombreCV;
        private TextView tvRatingCV;
        private ImageView ivHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            btnLikeCV = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);
            ivHueso = (ImageView) itemView.findViewById(R.id.ivHueso);
        }
    }
}


