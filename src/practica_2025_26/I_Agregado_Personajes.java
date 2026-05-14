package practica_2025_26;


public interface I_Agregado_Personajes {
    
    void agregar(Personaje personaje);
    java.util.List<Personaje> getPersonajes();
    
    //Modificación patrón iterator
    Iterador crearIterador();  //Iterador normal (todos)
    Iterador crearIteradorMagos(); //Iterador para magos
    Iterador crearIteradorPorNivel();
    
}
