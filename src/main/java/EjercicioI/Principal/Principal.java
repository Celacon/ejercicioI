package EjercicioI.Principal;
import EjercicioI.persona.Persona;
import rx.Observable;
import rx.functions.Func2;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

    List<Persona> personas = new ArrayList<>();

    Persona datoPersona = new Persona("Juan Arnoldo", 56);
    personas.add(datoPersona);
    personas.add(new Persona("Lucas Altamirano", 46));
        personas.add(new Persona("Marlon López", 75));
        personas.add(new Persona("Josue Manuel", 12));
        personas.add(new Persona("Tintan Martin", 300));
        personas.add(new Persona("Cantinflas Joel", 95));
        personas.add(new Persona("Melvin Timoteo", 65));
        personas.add(new Persona("Yanira Pancracia", 32));
        personas.add(new Persona("Marlen Anacleta", 49));


        Observable miObservable = Observable
                .from(personas.toArray())
                .map((result)->{
                    Persona persona =(Persona) result;
                    return persona.getEdad();
                        })
                .reduce(
                        new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer integer, Integer integer2) {
                               if(integer2>integer){
                                   integer=integer2;
                               }
                                return integer;
                            }
                        }

                );
        miObservable.subscribe((mayor)->{
            System.out.println("La edad Mayor es:"+mayor);
                }

        );


    }
}
