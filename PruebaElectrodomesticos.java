// Ejercicio 1
class Electrodomestico {
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    private final double PRECIO_BASE_DEFAULT = 200;
    private final String COLOR_DEFAULT = "blanco";
    private final char CONSUMO_ENERGETICO_DEFAULT = 'B';
    private final double PESO_DEFAULT = 5;

    private final String[] COLORES_DISPONIBLES = {"blanco", "metal", "rojo", "verde", "azul"};

    public Electrodomestico() {
        this.precioBase = PRECIO_BASE_DEFAULT;
        this.color = COLOR_DEFAULT;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFAULT;
        this.peso = PESO_DEFAULT;
    }

    public Electrodomestico(double precioBase, double peso) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        } else {
            return CONSUMO_ENERGETICO_DEFAULT;
        }
    }

    private String comprobarColor(String color) {
        for (String colorDisponible : COLORES_DISPONIBLES) {
            if (colorDisponible.equals(color)) {
                return color;
            }
        }
        return COLOR_DEFAULT;
    }

    public double precioFinal() {
        double precio = precioBase;
        switch (consumoEnergetico) {
            case 'A':
                precio += 100;
                break;
            case 'B':
                precio += 85;
                break;
            case 'C':
                precio += 60;
                break;
            case 'D':
                precio += 50;
                break;
            case 'E':
                precio += 30;
                break;
            case 'F':
                precio += 10;
                break;
        }

        if (peso >= 0 && peso < 20) {
            precio += 10;
        } else if (peso >= 20 && peso < 50) {
            precio += 50;
        } else if (peso >= 50 && peso < 80) {
            precio += 80;
        } else if (peso >= 80) {
            precio += 100;
        }

        return precio;
    }
}

class Lavadora extends Electrodomestico {
    private double carga;

    private final double CARGA_DEFAULT = 5;

    public Lavadora() {
        super();
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(double carga, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        if (carga > 30) {
            precio += 50;
        }
        return precio;
    }
}

class Television extends Electrodomestico {
    private int resolucion;
    private boolean sintonizadorTDT;

    private final int RESOLUCION_DEFAULT = 20;
    private final boolean SINTONIZADOR_TDT_DEFAULT = false;

    public Television() {
        super();
        this.resolucion = RESOLUCION_DEFAULT;
        this.sintonizadorTDT = SINTONIZADOR_TDT_DEFAULT;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_DEFAULT;
        this.sintonizadorTDT = SINTONIZADOR_TDT_DEFAULT;
    }

    public Television(int resolucion, boolean sintonizadorTDT, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        if (resolucion > 40) {
            precio *= 1.3;
        }
        if (sintonizadorTDT) {
            precio += 50;
        }
        return precio;
    }
}

public class PruebaElectrodomesticos {
    public static void main(String[] args) {
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        electrodomesticos[0] = new Lavadora(300, 25);
        electrodomesticos[1] = new Television(50, true, 400, "negro", 'C', 20);
        electrodomesticos[2] = new Electrodomestico(150, "rojo", 'A', 10);
        electrodomesticos[3] = new Lavadora(250, 15);
        electrodomesticos[4] = new Television(60, false, 300, "azul", 'E', 30);
        electrodomesticos[5] = new Lavadora(180, 10);
        electrodomesticos[6] = new Television(70, true, 500, "blanco", 'B', 40);
        electrodomesticos[7] = new Electrodomestico(200, "verde", 'D', 12);
        electrodomesticos[8] = new Lavadora(350, 30);
        electrodomesticos[9] = new Television(55, false, 250, "metal", 'F', 18);

        double precioTotalElectrodomesticos = 0;
        double precioTotalLavadoras = 0;
        double precioTotalTelevisores = 0;

        for (Electrodomestico electrodomestico : electrodomesticos) {
            if (electrodomestico instanceof Lavadora) {
                precioTotalLavadoras += electrodomestico.precioFinal();
            } else if (electrodomestico instanceof Television) {
                precioTotalTelevisores += electrodomestico.precioFinal();
            }
            precioTotalElectrodomesticos += electrodomestico.precioFinal();
        }

        System.out.println("Precio total de electrodomesticos: " + precioTotalElectrodomesticos);
        System.out.println("Precio total de lavadoras: " + precioTotalLavadoras);
        System.out.println("Precio total de televisores: " + precioTotalTelevisores);
    }
}
