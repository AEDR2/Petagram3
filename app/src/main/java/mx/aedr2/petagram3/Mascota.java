package mx.aedr2.petagram3;

/**
 * Created by alejandraperez on 23/08/17.
 */

public class Mascota implements Comparable<Mascota> {
    private int imagen;
    private String nombre;
    private int ranking = 10;
    private boolean bOrdenarNombre;

    public Mascota(int imagen, String nombre, int ranking) {
        this.imagen = imagen;
        this.nombre = nombre;
        //this.ranking = ranking;
        bOrdenarNombre = true;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setOrdenar(boolean bOrdenarNombre){ this.bOrdenarNombre = bOrdenarNombre;}
    @Override
    public int compareTo(Mascota o) {
        // TODO Auto-generated method stub
        if(bOrdenarNombre == true)
            return (this.getNombre().compareTo(o.getNombre()));
        else {
            if(this.getRanking() < o.getRanking()) return -1;
            else if(this.getRanking() == o.getRanking()) return 0;
            else return 1;
        }
    }
}