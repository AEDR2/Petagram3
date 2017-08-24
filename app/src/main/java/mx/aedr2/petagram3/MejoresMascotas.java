package mx.aedr2.petagram3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by alejandraperez on 24/08/17.
 */

public class MejoresMascotas extends AppCompatActivity {
    ArrayList<Mascota> mejoresMascotas;
    private RecyclerView rvMejoresMascotas;
    private Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se genera la barra de titulo de la aplicacon
        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rvMejoresMascotas = (RecyclerView) findViewById(R.id.rvMejoresMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMejoresMascotas.setLayoutManager(llm);
        obtenerGatos();
        inicializarAdaptador();

    }

    //Metodo que obtiene los elementos del arrayList de mascotas
    public void obtenerGatos(){
        Bundle parametros = getIntent().getExtras();
        for(int i = 0; i < 5; i ++)
            mejoresMascotas.add(new Mascota(parametros.getInt("imagen" + i), parametros.getString("nombre" + i), parametros.getInt("ranking" + i)));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mejoresMascotas, this);
        rvMejoresMascotas.setAdapter(adaptador);
    }
}
