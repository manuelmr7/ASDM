package practica_2025_26;

public class Mago extends PersonajeBase {
    
    private int nivel_magia;
    
       
    public Mago(String nombre, int nivel_magia) {
        super(nombre);
        this.nivel_magia=nivel_magia;
        this.tipo="Mago";
    }
    @Override
    public Personaje clonar()//PROTOTYPE
    {
        Arquero prototipo=new Arquero(this.nombre,this.nivel_magia);
        prototipo.nivel=this.nivel;
        prototipo.armas=this.armas;
        prototipo.precio=this.precio;
        return prototipo; 
    }
    
    
}
