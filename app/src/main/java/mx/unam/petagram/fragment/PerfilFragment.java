package mx.unam.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.unam.petagram.R;
import mx.unam.petagram.adapter.MascotaAdaptador;
import mx.unam.petagram.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.rc_mascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(glm);

        inicializarMascotas();
        inicializarAdaptador();

        return v;

    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.corgi, 6));
        mascotas.add(new Mascota(R.drawable.corgi, 11));
        mascotas.add(new Mascota(R.drawable.corgi, 8));
        mascotas.add(new Mascota(R.drawable.corgi, 3));
        mascotas.add(new Mascota(R.drawable.corgi, 1));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        recyclerView.setAdapter(adaptador);
    }

}
