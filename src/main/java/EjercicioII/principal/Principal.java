package EjercicioII.principal;

import EjercicioII.producto.Producto;
import rx.Observable;
import rx.functions.Func2;
import rx.observables.MathObservable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        Producto listadoProducto = new Producto("ps4", 300);
        productos.add(listadoProducto);
        productos.add(new Producto("gamecube", 300));
        productos.add(new Producto("external disk", 200));
        productos.add(new Producto("laptop", 800));
        productos.add(new Producto("vr", 230));

        Observable miobservable =
                Observable
                        .from(productos.toArray())
                        .map((result) -> {
                            Producto pro = (Producto) result;
                            return pro.getPrecio();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                                    @Override
                                    public Integer call(Integer acumulador, Integer actual) {

                                        return acumulador + actual;
                                    }
                                }
                        );

        miobservable.subscribe((sumatoria) -> {
            System.out.println("" +
                    "Sumatoria:" + sumatoria);
        });

Observable<Producto> produc= Observable.from(productos);
     MathObservable
                .from(produc)
                .max(Comparator.comparing(Producto::getPrecio)
                ).subscribe((mayor) -> {
                    System.out.println("El precio mayor es:" + mayor.getPrecio());
                });



    }
}

