package mx.unam.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import mx.unam.petagram.adapter.MascotaAdaptador;
import mx.unam.petagram.pojo.Mascota;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    Toolbar miActioBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        miActioBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(miActioBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Duque", R.drawable.dalmatian, 12));
        mascotas.add(new Mascota("Marshall", R.drawable.malamute, 8));
        mascotas.add(new Mascota("Buck", R.drawable.pomeranian, 5));
        mascotas.add(new Mascota("Toby", R.drawable.corgi, 3));
        mascotas.add(new Mascota("Uma", R.drawable.chihuahua, 1));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

}
