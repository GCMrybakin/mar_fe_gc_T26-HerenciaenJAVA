import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Ejercicio 5

class Persona {
    private String nombre;
    private int edad;
    private String genero;

    public Persona(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getgenero() {
        return genero;
    }
}

class Estudiante extends Persona {
    private double calificacion;

    public Estudiante(String nombre, int edad, String genero, double calificacion) {
        super(nombre, edad, genero);
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean hacerNovillos() {
        Random random = new Random();
        return random.nextDouble() < 0.5;
    }
}

class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, int edad, String genero, String materia) {
        super(nombre, edad, genero);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public boolean estaDisponible() {
        Random random = new Random();
        return random.nextDouble() > 0.2;
    }
}

class Aula {
    private int id;
    private int maxEstudiantes;
    private String materiaDestinada;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Aula(int id, int maxEstudiantes, String materiaDestinada, Profesor profesor) {
        this.id = id;
        this.maxEstudiantes = maxEstudiantes;
        this.materiaDestinada = materiaDestinada;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public boolean puedeDarseClase() {
        int numEstudiantes = estudiantes.size();
        int numAprobados = (int) estudiantes.stream().filter(e -> e.getCalificacion() >= 5).count();

        return profesor.estaDisponible() && profesor.getMateria().equals(materiaDestinada)
                && numEstudiantes > 0.5 * maxEstudiantes && numAprobados > 0.5 * numEstudiantes;
    }

    public int contarAprobados(String genero) {
        return (int) estudiantes.stream()
                .filter(e -> e.getCalificacion() >= 5 && e.getgenero().equalsIgnoreCase(genero))
                .count();
    }
    
    public String motivoNoClase() {
        if (!profesor.estaDisponible()) {
            return "El profesor no está disponible.";
        }
        if (!profesor.getMateria().equals(materiaDestinada)) {
            return "El profesor no imparte la materia requerida para el aula.";
        }
        int numEstudiantes = estudiantes.size();
        if (numEstudiantes <= 0.5 * maxEstudiantes) {
            return "No hay suficientes estudiantes para dar clase.";
        }
        int numAprobados = (int) estudiantes.stream().filter(e -> e.getCalificacion() >= 5).count();
        if (numAprobados <= 0.5 * numEstudiantes) {
            return "No hay suficientes estudiantes aprobados para dar clase.";
        }
        return "Otro motivo desconocido.";
    }
}

public class Ejercicio5 {
	public static void main(String[] args) {
        Profesor profesor = new Profesor("Profesor1", 40, "Masculino", "Matemáticas");
        Aula aula = new Aula(1, 30, "Matemáticas", profesor);

        for (int i = 0; i < 30; i++) {
            String genero = i % 2 == 0 ? "Femenino" : "Masculino";
            double calificacion = Math.random() * 10;
            Estudiante estudiante = new Estudiante("Estudiante" + i, 18, genero, calificacion);
            aula.agregarEstudiante(estudiante);
        }

        boolean profesorDisponible = profesor.estaDisponible();
        System.out.println("Profesor disponible: " + profesorDisponible);

        if (aula.puedeDarseClase() && profesorDisponible) {
            System.out.println("Se puede dar clase en el aula.");
            int aprobadosMasculinos = aula.contarAprobados("Masculino");
            int aprobadosFemeninos = aula.contarAprobados("Femenino");
            System.out.println("Aprobados masculinos: " + aprobadosMasculinos);
            System.out.println("Aprobados femeninos: " + aprobadosFemeninos);
        } else {
            String motivoNoClase = aula.motivoNoClase();
            System.out.println("No se puede dar clase en el aula. Motivo: " + motivoNoClase);
        }
    }
}
