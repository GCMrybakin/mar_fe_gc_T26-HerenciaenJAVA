import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Ejercicio 6

class Pelicula {
    String titulo;
    int duracion;
    int edadMinima;
    String director;

    Pelicula(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }
}

class Espectador {
    String nombre;
    int edad;
    double dinero;
	public char fila;
	public int columna;

    Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }
}

class Asiento {
    char fila;
    int columna;
    boolean ocupado;

    Asiento(char fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.ocupado = false;
    }
}

class Cine {
    Pelicula peliculaActual;
    double precioEntrada;
    Asiento[][] asientos;

    Cine(double precioEntrada) {
        this.precioEntrada = precioEntrada;
        this.asientos = new Asiento[8][9];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                asientos[i][j] = new Asiento((char) ('1' + i), j + 1);
            }
        }
    }

    void reproducirPelicula(Pelicula pelicula) {
        peliculaActual = pelicula;
    }

    boolean sentarEspectador(Espectador espectador) {
        if (peliculaActual == null || espectador.edad < peliculaActual.edadMinima || espectador.dinero < precioEntrada) {
            return false;
        }

        List<Asiento> asientosDisponibles = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (!asientos[i][j].ocupado) {
                    asientosDisponibles.add(asientos[i][j]);
                }
            }
        }

        if (asientosDisponibles.isEmpty()) {
            return false;
        }

        Random random = new Random();
        Asiento asientoAleatorio = asientosDisponibles.get(random.nextInt(asientosDisponibles.size()));
        asientoAleatorio.ocupado = true;
        espectador.fila = asientoAleatorio.fila;
        espectador.columna = asientoAleatorio.columna;

        return true;
    }
}

public class Ejercicio6 {
	public static void main(String[] args) {
        Cine cine = new Cine(10.0);

        Pelicula pelicula = new Pelicula("Aventura Espacial", 120, 12, "John Director");
        cine.reproducirPelicula(pelicula);

        for (int i = 0; i < 50; i++) {
            Espectador espectador = new Espectador("Espectador " + i, 15 + i, 20 + i);
            if (cine.sentarEspectador(espectador)) {
                System.out.println(espectador.nombre + " sentado en el asiento " + espectador.fila + espectador.columna);
            } else {
                System.out.println(espectador.nombre + " no pudo ser sentado.");
            }
        }

        System.out.println("\nEstado de los asientos:");
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 9; j++) {
                if (cine.asientos[i][j].ocupado) {
                    System.out.print("X ");
                } else {
                    System.out.print(cine.asientos[i][j].fila + "" + cine.asientos[i][j].columna + " ");
                }
            }
            System.out.println();
        }
    }
}
