package practica_2025_26;

public class Arquero extends PersonajeBase {
    
    private int puntería;
    
    public Arquero (String nombre, int punteria) {
        super(nombre);
        this.puntería=punteria;
        this.tipo="Arquero";
    }
    @Override
    public Personaje clonar()//PROTOTYPE
    {
        Arquero prototipo=new Arquero(this.nombre,this.puntería);
        prototipo.nivel=this.nivel;
        prototipo.armas=this.armas;
        prototipo.precio=this.precio;
        return prototipo; 
    }
}
