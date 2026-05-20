package practica_2025_26;

import java.util.ArrayList;
import java.util.List;

public class Agregado_Personajes implements I_Agregado_Personajes {

    private ArrayList<Personaje> personajes;
    //USAMOS SINGLETON PARA DECLARAR INSTANCIA ESTÁTICA PRIVADA
    private static Agregado_Personajes instancia;
    //DECLARAMOS EL CONSTRUCTOR COMO PRIVADO (SINGLETON)

    private Agregado_Personajes() {
        personajes = new ArrayList<>();
    }
    //MÉTODO DE ACCESO GLOBAL (SINGLETON)

    public static Agregado_Personajes getInstancia() {
        if (instancia == null) {
            instancia = new Agregado_Personajes();
        }
        return instancia;
    }

    @Override
    public void agregar(Personaje personaje) {
        personajes.add(personaje);
        System.out.println("-> Personaje guardado en la lista. Total actual: " + (personajes.size() - 1)); //AGREGADO PARA CONFIRMAR LA CORRECTA 
        //INSERCIÓN DE UN NUEVO PERSONAJE EN EL ARRAY
    }

    @Override
    public java.util.List<Personaje> getPersonajes() {//AGREGADO PARA QUE EN CASE 2 MUESTRE LA LISTA DE PERSONAJES Y DECIDA CUÁL CLONAR
        return personajes;
    }
    // --- MÉTODOS DE CREACIÓN DE ITERADORES ---
    @Override
    public Iterador crearIterador() {
        return new IteradorConcreto();
    }

    @Override
    public Iterador crearIteradorMagos() {
        return new IteradorMagos();
    }

    @Override
    public Iterador crearIteradorPorNivel() {
        return new IteradorNivel();
    }

    // --- CLASES INTERNAS (ITERADORES CONCRETOS) ---

    // 1. Iterador normal: Recorre todos los personajes
    private class IteradorConcreto implements Iterador {
        private int posicion = 0;

        @Override
        public boolean tieneSiguiente() {
            return posicion<personajes.size();
        }

        @Override
        public Object siguiente() {
            return personajes.get(posicion++);
        }
    }

    // 2. Iterador filtrado: Solo muestra Magos
    private class IteradorMagos implements Iterador {
        private int posicion = 0;

        @Override
        public boolean tieneSiguiente() {
            while(posicion<personajes.size())
            {
                if(personajes.get(posicion) instanceof Mago)
                    return true;
                posicion++;
            }
            return false;
        }

        @Override
        public Object siguiente() {
            return personajes.get(posicion++);
        }
    }

    // 3. Iterador ordenado: Muestra personajes por nivel (de mayor a menor)
    private class IteradorNivel implements Iterador {
        private List<Personaje> listaOrdenada;
        private int posicion = 0;

        public IteradorNivel() {
            // Copiamos la lista y la ordenamos por nivel
            listaOrdenada = new ArrayList<>(personajes);
            listaOrdenada.sort((p1, p2) -> Integer.compare(
                ((PersonajeBase)p2).getNivel(), 
                ((PersonajeBase)p1).getNivel()
            ));
        }
        @Override
        public boolean tieneSiguiente() {
            return posicion < listaOrdenada.size();
        }

        @Override
        public Object siguiente() {
            return listaOrdenada.get(posicion++);
        }
    }
}
