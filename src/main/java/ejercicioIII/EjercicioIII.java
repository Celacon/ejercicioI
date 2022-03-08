package ejercicioIII;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.MathObservable;

public class EjercicioIII {
    public static void main(String[] args) {



        Integer[] lista = {2,5,6,8,10,35,2,10};

        Observable miObservable = Observable.from(lista);
        MathObservable
                .from(miObservable)
                .averageInteger(miObservable)
                .subscribe((promedio) -> {
                    System.out.println("El Promedio del precio es: " + promedio);
                });

        Observable
                .from(lista)
                .filter(
                        new Func1<Integer, Boolean>() {
                            @Override
                            public Boolean call(Integer actual) {
                                return actual>=10;

                            }
                        }
                )
                .subscribe((valor)->{

                    System.out.println("valores mayores: "+valor);
                });

        Observable sumaObservable = Observable
                        .from(lista)
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                                    @Override
                                    public Integer call(Integer acumulador, Integer actual) {
                                        return acumulador + actual;
                                    }
                                }
                        );

        sumaObservable.subscribe((sumatoria) -> {
            System.out.println("La suma total: " + sumatoria);

        });

    }
}
