package practica_2025_26;

import java.util.*;

public class Práctica_2025_26 {
    
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        
        //MODIFICACIÓN DE SINGLETON: Obtenemos la instancia única en lugar de hacer new
        I_Agregado_Personajes personajes=Agregado_Personajes.getInstancia();
        //I_Agregado_Personajes personajes=new Agregado_Personajes();
    
        Personaje conan=new Guerrero("Mari Conan", 2);
        Personaje freyja =new Guerrero("Freyja ", 3);
        Personaje kratos =new Guerrero("Kratos", 2);
        
        Personaje aloy =new Arquero("Aloy ",4);
        Personaje hanzo  =new Arquero("Hanzo  ",3);
        
        Personaje yennefer =new Mago ("Yennefer",3);
        Personaje solomon =new Mago ("Solomon" ,3);
        
        personajes.agregar(conan);
        personajes.agregar(freyja);
        personajes.agregar(kratos);
        personajes.agregar(aloy);
        personajes.agregar(hanzo);
        personajes.agregar(yennefer);
        personajes.agregar(solomon);
       for (int i = 0; i < 50; ++i) 
            System.out.println();

       do{
           for (int i = 0; i < 50; ++i) 
            System.out.println();

        
            System.out.println("\nMenú Principal:");
            System.out.println("1. Crear personaje(Factory Method)");
            System.out.println("2. Clonar personaje(futura)");
            System.out.println("3. Subir nivel de personaje (futura)");
            System.out.println("4. Listar personajes(futura)");
            System.out.println("5. Añade armas a personaje(futura)");
            
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion=scanner.nextInt();
            
            for (int i = 0; i < 50; ++i) 
            System.out.println();

            
            switch (opcion) {
                case 1:
                    System.out.println("Crearemos un personaje de uno de los tipos posibles (Guerrero, Mago, Arquero)");
                    System.out.println("Y lo añadiremos a una lista que hemos declarado en la main y "
                            + " que se llama personajes\n"
                            + "Será necesario darle valores a los atributos del personaje en cuestión (como nombre y nivel).\n"
                            + "El personaje creado se debe añadir a la lista global personajes");
                    System.out.println("-- CREACIÓN DE PERSONAJE FACTORY METHOD --");
                    System.out.println("¿Qué tipo de personaje desea crear?");
                    System.out.println("1. Guerrero\n2. Mago\n3. Arquero\n");
                    System.out.println("Elige una opción: ");
                    int tipo=scanner.nextInt();
                    scanner.nextLine();
                    String nombre;
                    System.out.println("Introduce el nombre del personaje: ");
                    nombre=scanner.nextLine();
                    int atributoEspecial=0;
                    if(tipo==1)
                    {
                        System.out.println("Introduce la fuerza del guerrero (1-100): ");
                        atributoEspecial=scanner.nextInt();
                    }
                    else if(tipo==2)
                    {
                        System.out.println("Introduce el nivel de magia del mago (1-100): ");
                        atributoEspecial=scanner.nextInt();
                    }
                    else if(tipo==3)
                    {
                        System.out.println("Introduce la puntería del arquero (1-100): ");
                        atributoEspecial=scanner.nextInt();
                    }
                    //Instancio al creador concreto (la factoría)
                    CreadorPersonaje factoria=new CreadorPersonajeConcreto();
                    //Creamos nuevo personaje
                    Personaje nuevoPersonaje=factoria.Factory_method(tipo, nombre, atributoEspecial);
                    //Añadimos el personaje a la lista si es que se creó correctamente
                    if(nuevoPersonaje!=null)
                    {
                        personajes.agregar(nuevoPersonaje);
                        if(tipo==1)
                        {
                            System.out.println("Guerrero creado con nombre "+nombre+" y "+atributoEspecial+ " de fuerza");
                        }
                        else if(tipo==2)
                        {
                            System.out.println("Mago creado con nombre "+nombre+" y "+atributoEspecial+ " de magia");
                        }
                        else if(tipo==3)
                        {
                            System.out.println("Arquero creado con nombre "+nombre+" y "+atributoEspecial+ " de puntería");
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: Tipo de personaje no válido.");
                    }
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                
                case 2:
                    System.out.println("Clonaremos un personaje ya creado "
                            + " modificando los datos que sean necesarios "
                            + "y se añadirá a la lista");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                
                case 3:
                    System.out.println("Subiremos el nivel de uno de los personajes, tendremos que elegir "
                            + "a uno de los añadidos por vosotros con anterioridad o de los ya existentes"
                            + " inicialmente");
                    System.out.println("Indicaremos al resto que se ha subido de nivel");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                
                case 4:
                    System.out.println("Se mostrarán los distintos personajes"
                            + " se podrían incluir opociones de muestreo, ejemplo solo los "
                            + "magos o por orden de mayor nivel, etc. "
                            + "Con un par bastaría. ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 5:    
                    System.out.println("Se añadirán armas a alguno de "
                            + "los personajes existentes añadiéndolas "
                            + "al String armas que tiene cada personaje ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;    
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
                    break;
               default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
            }
        
        }while(opcion!=6);
   }
    
}
