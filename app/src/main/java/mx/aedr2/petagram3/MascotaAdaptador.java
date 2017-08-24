package mx.aedr2.petagram3;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alejandraperez on 23/08/17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity actividad;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity actividad) {
        this.mascotas = mascotas;
        this.actividad = actividad;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgFoto.setImageResource(mascota.getImagen());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRanking.setText(String.valueOf(mascota.getRanking()));
        holder.btnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setRanking(mascota.getRanking() + 1);
                holder.tvRanking.setText(String.valueOf(mascota.getRanking()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private ImageView imgHueso;
        private TextView tvNombre, tvRanking;
        private ImageButton btnHueso;
        public MascotaViewHolder(View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgHueso = (ImageView) itemView.findViewById(R.id.ivHueso);
            btnHueso = (ImageButton) itemView.findViewById(R.id.btnHueso);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRanking = (TextView) itemView.findViewById(R.id.tvRanking);
        }
    }

}

