package practica_2025_26;

import java.util.ArrayList;

public class Agregado_Personajes implements I_Agregado_Personajes{
        private ArrayList<Personaje> personajes;
        //USAMOS SINGLETON PARA DECLARAR INSTANCIA ESTÁTICA PRIVADA
        private static Agregado_Personajes instancia;
        //DECLARAMOS EL CONSTRUCTOR COMO PRIVADO (SINGLETON)
        private Agregado_Personajes(){
            personajes = new ArrayList<>();
        }
        //MÉTODO DE ACCESO GLOBAL (SINGLETON)
        public static Agregado_Personajes getInstancia()
        {
            if(instancia==null)
            {
                instancia=new Agregado_Personajes();
            }
            return instancia;
        }
        @Override
        public void agregar(Personaje personaje) {
            personajes.add(personaje);
            System.out.println("-> Personaje guardado en la lista. Total actual: "+(personajes.size()-1)); //AGREGADO PARA CONFIRMAR LA CORRECTA 
                                                                                                           //INSERCIÓN DE UN NUEVO PERSONAJE EN EL ARRAY
        }
        @Override
        public java.util.List<Personaje> getPersonajes() {//AGREGADO PARA QUE EN CASE 2 MUESTRE LA LISTA DE PERSONAJES Y DECIDA CUÁL CLONAR
        return personajes;
        }
    
}
