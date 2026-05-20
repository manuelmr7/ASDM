/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

/**
 *
 * @author manue
 */
public class Fachada {
    private CreadorPersonaje factoria;
    private I_Agregado_Personajes agregado;

    public Fachada() {
        this.factoria = new CreadorPersonajeConcreto();
        this.agregado = Agregado_Personajes.getInstancia();
    }
    
    public void mostrarDatos(String nombreEjercito, int tipoTropa, String nombreTropa, int atributoEspecial, int numeroTropas)
    {
        //1. Factory Method
        Personaje tropaBase=factoria.Factory_method(tipoTropa, nombreTropa+" Base", atributoEspecial);
        if(tropaBase!=null)
        {
            //2. Composite
            Ejercito nuevoEjercito=new Ejercito(nombreEjercito);
            
            //3. Prototype
            for (int i = 0; i < numeroTropas; i++) {
                Personaje clon=tropaBase.clonar();
                clon.setNombre(nombreTropa+" #"+(i+1));
                nuevoEjercito.agregarMiembro(clon);
            }
            agregado.agregar(nuevoEjercito);
            nuevoEjercito.mostrar();
        }
        else
        {
            System.out.println("Error: no se pudo crear la tropa base\n");
        }
    }
}
