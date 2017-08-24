package mx.aedr2.petagram3;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private Toolbar miActionBar;
    //Arreglo de mascotas
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mejoresMascotas;
    private RecyclerView rvMascotas;

    ActionMenuView paw, star;
    //private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paw = (ActionMenuView) findViewById(R.id.amvPaw);
        star = (ActionMenuView) findViewById(R.id.amvStar);

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se obtienen los gatos primeros
                obtenerMejoresGatos();
                //Se van a enviar mediante un Intent
                Intent i = new Intent(MainActivity.this, MejoresMascotas.class);

                for(int j = 0; j < 5; j++) {
                    i.putExtra("imagen" + j, mejoresMascotas.get(j).getImagen());
                    i.putExtra("nombre" + j, mejoresMascotas.get(j).getNombre());
                    i.putExtra("ranking" + j, mejoresMascotas.get(j).getRanking());

                }
                startActivity(i);
            }
        });

        //Se genera la barra de titulo de la aplicacon
        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.cat_acrobat, "Esnut", 10));
        mascotas.add(new Mascota(R.drawable.cat_ball, "Rito", 10));
        mascotas.add(new Mascota(R.drawable.cat_banjo, "Catus", 10));
        mascotas.add(new Mascota(R.drawable.cat_bat, "Natacha", 10));
        mascotas.add(new Mascota(R.drawable.cat_bd, "Bold", 10));
        mascotas.add(new Mascota(R.drawable.cat_birdhouse, "Volkova", 10));
        mascotas.add(new Mascota(R.drawable.cat_box, "Morado", 10));
        mascotas.add(new Mascota(R.drawable.cat_cage, "Calabazate", 10));
        mascotas.add(new Mascota(R.drawable.cat_cart, "Boris", 10));
        mascotas.add(new Mascota(R.drawable.cat_clean, "Kirby", 10));
        mascotas.add(new Mascota(R.drawable.cat_cupid, "Pepinut", 10));
        mascotas.add(new Mascota(R.drawable.cat_drink, "Chip", 10));
        mascotas.add(new Mascota(R.drawable.cat_drunk, "Tomper", 10));
        mascotas.add(new Mascota(R.drawable.cat_eyes, "Gato", 10));
        mascotas.add(new Mascota(R.drawable.cat_fat, "Nala", 10));
        mascotas.add(new Mascota(R.drawable.cat_fight, "Pumpkin", 10));
        mascotas.add(new Mascota(R.drawable.cat_fish, "Gordolobo", 10));
        mascotas.add(new Mascota(R.drawable.cat_fisht, "Parche", 10));
        mascotas.add(new Mascota(R.drawable.cat_food, "Sebastian", 10));
        mascotas.add(new Mascota(R.drawable.cat_fridge, "Sammy Davis Junior", 10));
        mascotas.add(new Mascota(R.drawable.cat_ghost, "Lola", 10));
        mascotas.add(new Mascota(R.drawable.cat_gift, "Alfalfa", 10));
        mascotas.add(new Mascota(R.drawable.cat_hiss, "Tofo", 10));
        mascotas.add(new Mascota(R.drawable.cat_hungry, "Baguira", 10));
        mascotas.add(new Mascota(R.drawable.cat_lady, "Copernico", 10));
        mascotas.add(new Mascota(R.drawable.cat_laptop, "Mimo", 10));
        mascotas.add(new Mascota(R.drawable.cat_laptop_2, "Principe George", 10));
        mascotas.add(new Mascota(R.drawable.cat_makeup, "Mustafá", 10));
        mascotas.add(new Mascota(R.drawable.cat_mask, "Simeón", 10));
        mascotas.add(new Mascota(R.drawable.cat_moustache, "Tigroso", 10));
        mascotas.add(new Mascota(R.drawable.cat_mummy, "Kitty", 10));
        mascotas.add(new Mascota(R.drawable.cat_paper, "Patas", 10));
        mascotas.add(new Mascota(R.drawable.cat_phone, "Ringo", 10));
        mascotas.add(new Mascota(R.drawable.cat_pirate, "Matesito", 10));
        mascotas.add(new Mascota(R.drawable.cat_plain, "Bigotes", 10));
        mascotas.add(new Mascota(R.drawable.cat_poo, "Orejas", 10));
        mascotas.add(new Mascota(R.drawable.cat_pumpkin, "vatoloco", 10));
        mascotas.add(new Mascota(R.drawable.cat_purr, "redondo", 10));
        mascotas.add(new Mascota(R.drawable.cat_radio, "coco", 10));
        mascotas.add(new Mascota(R.drawable.cat_rascal, "chocolate", 10));
        mascotas.add(new Mascota(R.drawable.cat_sing, "vainilla", 10));
        mascotas.add(new Mascota(R.drawable.cat_skull, "pelos", 10));
        mascotas.add(new Mascota(R.drawable.cat_sleep, "bigoton", 10));
        mascotas.add(new Mascota(R.drawable.cat_slippers, "tigro", 10));
        mascotas.add(new Mascota(R.drawable.cat_smoke, "tigra", 10));
        mascotas.add(new Mascota(R.drawable.cat_sulky, "bigotona", 10));
        mascotas.add(new Mascota(R.drawable.cat_tied, "cacto", 10));
        mascotas.add(new Mascota(R.drawable.cat_toilet, "copo", 10));
        mascotas.add(new Mascota(R.drawable.cat_torture, "dante", 10));
        mascotas.add(new Mascota(R.drawable.cat_vampire, "mambo", 10));
        mascotas.add(new Mascota(R.drawable.cat_vote, "neron", 10));
        mascotas.add(new Mascota(R.drawable.cat_upsidedown, "billyboy", 10));
        mascotas.add(new Mascota(R.drawable.cat_walk, "donatello", 10));
        mascotas.add(new Mascota(R.drawable.cat_wizard, "cletus", 10));
        mascotas.add(new Mascota(R.drawable.cat_yarn, "pantera", 10));
        mascotas.add(new Mascota(R.drawable.shadow_ball, "tito", 10));
        mascotas.add(new Mascota(R.drawable.shadow_cat, "vicho", 10));
        mascotas.add(new Mascota(R.drawable.shadow_fly, "tigrillo", 10));
        mascotas.add(new Mascota(R.drawable.shadow_lady, "santi", 10));
        mascotas.add(new Mascota(R.drawable.shadow_lion, "rolo", 10));
        mascotas.add(new Mascota(R.drawable.shadow_whale, "ronro", 10));
        Collections.sort(mascotas);
    }

    //Metodo que obtiene los gatos con ranking mas alto
    public void obtenerMejoresGatos(){
        mejoresMascotas = new ArrayList<>();
        //Se ordena el array de mascotas por ranking
        for (Mascota gato: mascotas) gato.setOrdenar(false);
        Collections.sort(mascotas);
    }
}
