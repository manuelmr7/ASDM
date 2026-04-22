package practica_2025_26;
import java.util.ArrayList;
import java.util.List;

public abstract class PersonajeBase implements Personaje {
    protected String nombre;
    protected int nivel;
    protected String armas;
    protected String tipo;
    protected double precio;

        public PersonajeBase(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.armas="Hacha de piedra";
        this.precio=1;
    }

    @Override
    public void subirNivel() {
        nivel++;
    }

     public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + ", Nivel: " + nivel + ", Armas: " + armas);
    }    

}
