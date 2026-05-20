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
            System.out.println("1. Crear personaje (Factory Method)");
            System.out.println("2. Clonar personaje (Prototype)");
            System.out.println("3. Crear ejércitos (Composite)");
            System.out.println("4. Morir en combate (Observer)");
            System.out.println("5. Listar personajes(Iterator)");
            System.out.println("6. Case final (Facade)");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion=scanner.nextInt();
            
            for (int i = 0; i < 50; ++i) 
            System.out.println();

            
            switch (opcion) {
                case 1:
                    /*System.out.println("Crearemos un personaje de uno de los tipos posibles (Guerrero, Mago, Arquero)");
                    System.out.println("Y lo añadiremos a una lista que hemos declarado en la main y "
                            + " que se llama personajes\n"
                            + "Será necesario darle valores a los atributos del personaje en cuestión (como nombre y nivel).\n"
                            + "El personaje creado se debe añadir a la lista global personajes");*/
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
                    /*System.out.println("Clonaremos un personaje ya creado "
                            + " modificando los datos que sean necesarios "
                            + "y se añadirá a la lista");
                    System.out.println("Presiona para continuar");*/
                    scanner2.nextLine();
                    System.out.println("-- CLONADO DE PERSONAJE CON PROTOTYPE --");
                    List<Personaje> listaPersonajes=personajes.getPersonajes();
                    if(listaPersonajes.isEmpty())
                    {
                        System.out.println("No hay personajes disponibles para clonar...");
                    }
                    else
                    {
                        System.out.println("Elija el personaje que desea clonar");
                        for (int i = 0; i < listaPersonajes.size(); i++) {
                            System.out.println(i+". ");
                            listaPersonajes.get(i).mostrar();
                        }
                        System.out.println("Su elección es: ");
                        int numClon=scanner.nextInt();
                        scanner.nextLine();
                        
                        if(numClon>=0 && numClon<listaPersonajes.size())
                        {
                            Personaje original=listaPersonajes.get(numClon);
                            for (int i = 0; i < 20; i++) {
                                //APLICO PROTOTYPE
                                Personaje clonado=original.clonar();
                                
                                //Genero un nombre distinto para cada uno de los 20 clones
                                String nuevoNombre=original.getNombre()+" (Clon "+(i+1)+")";
                                clonado.setNombre(nuevoNombre);
                                
                                //Guardo el clon en el array
                                personajes.agregar(clonado);
                                
                            }
                            System.out.println("Presiona para continuar");
                            scanner2.nextLine();
                        }
                        else
                        {
                            System.out.println("ERROR: Índice incorrecto");
                        }
                    }
                    
                    break;
                
                case 3:
                    /*System.out.println("En este apartado vamos a crear ejercitos, un ejercito estará formado por un ´numero de guerreros (en principio solo de guerreros)"
                            + "\nse valora la posibilidad de crear ejercitos de arqueros o magos.)"
                            + "\nCada ejercito a su vez puede estar formados por otros ejercitos, por ejemplo, creo un ejercito llamado"
                            + " \nlos Segundos Hijos (con 4 guerreros) y creo otro llamados los Inmaculados (con 6 guerreros), creo un tercero llamado Casa Daenerys Targaryen"
                            + "\ny añado por ejemplo 5 guerreros a este último y los dos ejercitos creados con anterioridad, después debo mostrar"
                            + "el nombre de todos los guerreros que forman el ejercito Casa Daenerys Targaryen"
                            + "\nSe valora el uso del patrón del case 2");
                    System.out.println("Indicaremos al resto que se ha subido de nivel");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();*/
                    
                    //Prototype para crear guerreros
                    Personaje guerreroBase=new Guerrero("Guerrero base",10);
                    int e;
                    //Creo ejército "Los Segundos Hijos" con 4 guerreros
                    Ejercito E_SegundosHijos=new Ejercito("Los Segundos Hijos");
                    for(int i=0;i<4;i++)
                    {
                        Personaje g=guerreroBase.clonar();
                        g.setNombre("Guerrero SH"+(i+1));
                        E_SegundosHijos.agregarMiembro(g);
                    }
                    
                    //Creo ejército "Los Inmaculados" con 6 guerreros
                    Ejercito E_Inmaculados=new Ejercito("Los Inmaculados");
                    for(int i=0;i<6;i++)
                    {
                        Personaje g=guerreroBase.clonar();
                        g.setNombre("Guerrero IN"+(i+1));
                        E_Inmaculados.agregarMiembro(g);
                    }
                    
                    //Creo "Casa Daenerys Targaryen" con sus unidades (5) y le añado los 2 ejércitos creados anteriormente
                    Ejercito E_casaDaenerysTargaryen=new Ejercito("Casa Daenerys Targaryen");
                    for(int i=0;i<5;i++)
                    {
                        Personaje g=guerreroBase.clonar();
                        g.setNombre("Guerrero CDT"+(i+1));
                        E_casaDaenerysTargaryen.agregarMiembro(g);
                    }
                    //Muestro jerarquía
                    System.out.println("Introduzca ejército a visualizar: ");
                    System.out.println("1. Los Segundos Hijos\n2. Los Inmaculados\n3. Casa Daenerys Targaryen");
                    e=scanner.nextInt();
                    if(e==1)
                    {
                        E_SegundosHijos.mostrar();
                    }
                    else if(e==2)
                    {
                        E_Inmaculados.mostrar();
                    }
                    else if(e==3)
                    {
                        System.out.println("¿Qué guerreros quiere msotrar?: ");
                        System.out.println("1. Autóctonos\n2. Todos");
                        int c;
                        c=scanner.nextInt();
                        if(c==1)
                        {
                            E_casaDaenerysTargaryen.mostrar();
                        }
                        else if(c==2)
                        {
                            E_casaDaenerysTargaryen.agregarMiembro(E_SegundosHijos);
                            E_casaDaenerysTargaryen.agregarMiembro(E_Inmaculados);
                            E_casaDaenerysTargaryen.mostrar();
                        }
                        else
                        {
                            System.out.println("ERROR: Eso no es posible...");
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: No válido");
                    }
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                
                case 4:
                    /*System.out.println("Práctica Observer, Vamos a simular que un personaje "
                            + "(Guerrero, Mago o Arquero muere en combate, con lo cual debemos "
                            + "eliminarlo de la lista de personajes. Debemos a continuación indicar, "
                            + "comunicar al resto de  los personajes que dicho personaje ha fallecido "
                            + "en combate. Como extra se puede hacer la modificación de comunicar únicamente "
                            + "a los integrantes del ejercito al que pertenecía Como pista indicar que no es "
                            + "necesario añadir clases extras a las ya creadas, solo modificar las existentes.  ");
                    System.out.println("Indicaremos al resto que se ha subido de nivel");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();*/
                    System.out.println("-- MORIR EN COMBATE (OBSERVER) --");
                    List<Personaje> listaActual=personajes.getPersonajes();
                    if(listaActual.isEmpty())
                    {
                        System.out.println("No hay personajes vivos en el agregado general.");
                        
                    }
                    else
                    {
                        System.out.println("Elige quién muere.");
                        for (int i = 0; i < listaActual.size(); i++) {
                            System.out.println(i+". "+listaActual.get(i).getNombre());
                            
                        }
                        System.out.println("Introduce el número: ");
                        int victima=scanner.nextInt();
                        scanner.nextLine();
                        if(victima>=0 && victima < listaActual.size())
                        {
                            Personaje muerto=listaActual.get(victima);
                            //Al llamar a eliminar, Observer notifica al resto
                            personajes.eliminar(muerto);
                        }
                        else
                        {
                            System.out.println("Error: Índice incorrecto");
                        }
                    }
                    break;

                case 5:
                    System.out.println("-- LISTAR PERSONAJES (ITERATOR) --");
                    System.out.println("Elije modo de visualización: ");
                    System.out.println("1. Mostrar todos\n"+ "2. Solo magos\n" +"3. Ordenador por nivel (Mayor a menor)");
                    System.out.println("Opción: ");
                    int modo=scanner.nextInt();
                    Iterador it;
                    switch(modo)
                    {
                        case 2:
                            it=personajes.crearIteradorMagos();
                            break;
                        case 3:
                            it=personajes.crearIteradorPorNivel();
                            break;
                        default:
                            it=personajes.crearIterador();
                            break;
                            
                    }
                    System.out.println("Resultados: ");
                    while(it.tieneSiguiente())
                    {
                        Personaje p=(Personaje) it.siguiente();
                        p.mostrar();
                    }
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;   
                case 6:
                    System.out.println("Crear una interfaz simple y "
                            + "unificada para acceder al conjunto de "
                            + "funcionalidades de nuestro juego. ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    System.out.println("-- INTERFAZ (FACADE) --");
                    Fachada fachada=new Fachada();
                    System.out.println("Nombre del ejército: ");
                    String nombreEjercito=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Tipo de tropa\n"
                            + "1. Guerrero\n"
                            + "2. Mago\n"
                            + "3. Arquero\n");
                    int tipoTropa=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nombre genérico de la tropa: ");
                    String nombreTropa=scanner.nextLine();
                    System.out.println("Atributo especial (fuerza/magia/puntería): ");
                    atributoEspecial=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("¿Cuántas tropas deseas crear?");
                    int numeroTropas=scanner.nextInt();
                    scanner.nextLine();
                    fachada.mostrarDatos(nombreEjercito, tipoTropa, nombreTropa, atributoEspecial, numeroTropas);
                    System.out.println("Presiona para continuar");
                    scanner.nextLine();
                    break; 
                case 7:
                    System.out.println("Saliendo del programa...");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
               default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
            }
        
        }while(opcion!=7);
   }
    
}
