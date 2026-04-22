package practica_2025_26;

public class Guerrero extends PersonajeBase {
    
    private int fuerza;
    
    public Guerrero(String nombre, int fuerza) {
        super(nombre);
        this.fuerza=fuerza;
        this.tipo="Guerrero";
    }
    @Override
    public Personaje clonar()//PROTOTYPE
    {
        Guerrero prototipo=new Guerrero(this.nombre,this.fuerza);
        prototipo.nivel=this.nivel;
        prototipo.armas=this.armas;
        prototipo.precio=this.precio;
        return prototipo; 
    }

    
}
