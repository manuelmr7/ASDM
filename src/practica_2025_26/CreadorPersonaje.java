/**
 * UTILIZO FACTORY METHOD. ESTA SERÍA LA CLASE CREADOR
 * DESCRITA EN EL DIAGRAMA QUE SE ENCUENTRA EN EL PDF DE FACTORY METHOD
 */
package practica_2025_26;

/**
 *
 * @author manue
 */
public abstract class CreadorPersonaje {
    public CreadorPersonaje()
    {
        
    }
    public abstract Personaje Factory_method(int tipo,String nombre,int atributo);
    
}

