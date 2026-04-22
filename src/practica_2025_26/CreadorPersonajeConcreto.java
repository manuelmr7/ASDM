/**
 * UTILIZO FACTORY METHOD. ESTA SERÍA LA CLASE CREADOR_CONCRETO
 * DESCRITA EN EL DIAGRAMA QUE SE ENCUENTRA EN EL PDF DE FACTORY METHOD
 */
package practica_2025_26;


public class CreadorPersonajeConcreto extends CreadorPersonaje{
    public CreadorPersonajeConcreto()
    {
        super();
    }

    @Override
    public Personaje Factory_method(int tipo, String nombre, int atributo) {
        switch(tipo)
        {
            case 1:
                return new Guerrero(nombre, atributo);
            case 2:
                return new Mago(nombre,atributo);
            case 3:
                return new Arquero(nombre, atributo);
            default:
                System.out.println("Tipo no válido");
                return null;
        }
        
    }
    
}
