package practica_2025_26;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manue
 */
public class Ejercito implements Personaje{ //PATRÓN COMPOSITE. Interfaz Personaje actúa como el Componente,
                                            //las clases que heredan de PersonajeBase son las hojas y esta clase Ejército es el compuesto.
    private String nombre;
    private List<Personaje> miembros=new ArrayList<>();

    public Ejercito(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarMiembro(Personaje p)
    {
        miembros.add(p);
    }
    
    public void subirNivel() {
        for(Personaje p:miembros)
        {
            p.subirNivel();
        }
    }

    @Override
    public Personaje clonar() {
        //Aplico Prototype para clonar ejército al completo
        Ejercito clon=new Ejercito(this.nombre+" (Copia)");
        for(Personaje p:miembros)
        {
            clon.agregarMiembro(p.clonar());
        }
        return clon;
    }

    @Override
    public void mostrar() {
        System.out.println("Ejército "+nombre);
        //Hago llamada recursiva a cada componente
        for(Personaje p:miembros)
        {
            p.mostrar();
        }
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("El ejército "+nombre+" ha recibido un aviso. "
                + "Notificando a las tropas...");
        for(Personaje p:miembros)
        {
            p.actualizar(mensaje);
        }
    }
    
}
