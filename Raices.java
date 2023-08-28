// Ejercicio 3

public class Raices {
    private double a, b, c;

    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return (b * b) - (4 * a * c);
    }

    public boolean tieneRaices() {
        return getDiscriminante() >= 0;
    }

    public boolean tieneRaiz() {
        return getDiscriminante() == 0;
    }

    public void calcular() {
        if (tieneRaices()) {
            double x1 = (-b + Math.sqrt(getDiscriminante())) / (2 * a);
            double x2 = (-b - Math.sqrt(getDiscriminante())) / (2 * a);
            System.out.println("Solucion 1: " + x1);
            System.out.println("Solucion 2: " + x2);
        } else {
            System.out.println("No hay soluciones reales.");
        }
    }

    public void obtenerRaices() {
        calcular();
    }

    public void obtenerRaiz() {
        if (tieneRaiz()) {
            double x = -b / (2 * a);
            System.out.println("Unica raíz: " + x);
        } else {
            System.out.println("No hay una unica raiz.");
        }
    }

    public static void main(String[] args) {
        Raices ecuacion = new Raices(2, -5, 2);
        
        System.out.println("Discriminante: " + ecuacion.getDiscriminante());
        System.out.println("Tiene raices: " + ecuacion.tieneRaices());
        System.out.println("Tiene raiz unica: " + ecuacion.tieneRaiz());
        
        System.out.println("Posibles soluciones:");
        ecuacion.calcular();
        
        System.out.println("Obtener raices:");
        ecuacion.obtenerRaices();
        
        System.out.println("Obtener raiz unica:");
        ecuacion.obtenerRaiz();
    }
}
