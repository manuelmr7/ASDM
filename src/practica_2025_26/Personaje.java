package practica_2025_26;

public interface Personaje {
    void subirNivel();
    Personaje clonar(); //PROTOTYPE
    void mostrar();
    String getNombre(); //PROTOTYPE
    void setNombre(String nombre); //PROTOTYPE
}
