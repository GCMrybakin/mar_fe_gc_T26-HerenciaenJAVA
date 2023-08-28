// Ejercicio 2

interface Entregable {
    void entregar();
    void devolver();
    boolean estaEntregado();
    int comparar(Object a);
}

class Serie implements Entregable {
    private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    public Serie() {
        this("", 3, false, "", "");
    }

    public Serie(String titulo, String creador) {
        this(titulo, 3, false, "", creador);
    }

    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this(titulo, numeroTemporadas, false, genero, creador);
    }

    public Serie(String titulo, int numeroTemporadas, boolean entregado, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.entregado = entregado;
        this.genero = genero;
        this.creador = creador;
    }

    // Implementación de métodos de la interfaz Entregable
    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean estaEntregado() {
        return entregado;
    }

    @Override
    public int comparar(Object a) {
        Serie otraSerie = (Serie) a;
        return Integer.compare(this.numeroTemporadas, otraSerie.numeroTemporadas);
    }

    @Override
    public String toString() {
        return "Serie [titulo=" + titulo + ", numeroTemporadas=" + numeroTemporadas +
               ", entregado=" + entregado + ", genero=" + genero + ", creador=" + creador + "]";
    }
}

class Videojuego implements Entregable {
    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String compania;

    public Videojuego() {
        this("", 10, false, "", "");
    }

    public Videojuego(String titulo, int horasEstimadas) {
        this(titulo, horasEstimadas, false, "", "");
    }

    public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
        this(titulo, horasEstimadas, false, genero, compania);
    }

    public Videojuego(String titulo, int horasEstimadas, boolean entregado, String genero, String compania) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = entregado;
        this.genero = genero;
        this.compania = compania;
    }

    // Implementación de métodos de la interfaz Entregable
    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean estaEntregado() {
        return entregado;
    }

    @Override
    public int comparar(Object a) {
        Videojuego otroVideojuego = (Videojuego) a;
        return Integer.compare(this.horasEstimadas, otroVideojuego.horasEstimadas);
    }

    @Override
    public String toString() {
        return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas +
               ", entregado=" + entregado + ", genero=" + genero + ", compania=" + compania + "]";
    }
}

public class PruebaSerie {
    public static void main(String[] args) {
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        series[0] = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        series[1] = new Serie("Friends", 10, "Comedia", "David Crane, Marta Kauffman");
        series[2] = new Serie("Stranger Things", 3, "Ciencia ficción", "Duffer Brothers");
        series[3] = new Serie("Game of Thrones", 8, "Fantasía", "David Benioff, D. B. Weiss");
        series[4] = new Serie("The Crown", 4, "Drama histórico", "Peter Morgan");

        series[0].entregar();
        series[2].entregar();

        videojuegos[0] = new Videojuego("The Witcher 3: Wild Hunt", 100, "RPG", "CD Projekt");
        videojuegos[1] = new Videojuego("Red Dead Redemption 2", 60, "Acción y aventura", "Rockstar Games");
        videojuegos[2] = new Videojuego("Portal 2", 10, "Puzle", "Valve");
        videojuegos[3] = new Videojuego("The Last of Us", 25, "Acción y aventura", "Naughty Dog");
        videojuegos[4] = new Videojuego("FIFA 21", 15, "Deportes", "EA Sports");

        videojuegos[1].entregar();
        videojuegos[4].entregar();

        int seriesEntregadas = contarEntregados(series);
        int videojuegosEntregados = contarEntregados(videojuegos);

        System.out.println("Series entregadas: " + seriesEntregadas);
        System.out.println("Videojuegos entregados: " + videojuegosEntregados);

        Serie serieConMasTemporadas = encontrarSerieConMasTemporadas(series);
        Videojuego videojuegoConMasHoras = encontrarVideojuegoConMasHoras(videojuegos);

        System.out.println("Serie con mas temporadas:\n" + serieConMasTemporadas);
        System.out.println("Videojuego con mas horas:\n" + videojuegoConMasHoras);
    }

    public static int contarEntregados(Entregable[] entregables) {
        int count = 0;
        for (Entregable entregable : entregables) {
            if (entregable.estaEntregado()) {
                count++;
            }
        }
        return count;
    }

    public static Serie encontrarSerieConMasTemporadas(Serie[] series) {
        Serie serieConMasTemporadas = series[0];
        for (Serie serie : series) {
            if (serie.comparar(serieConMasTemporadas) > 0) {
                serieConMasTemporadas = serie;
            }
        }
        return serieConMasTemporadas;
    }

    public static Videojuego encontrarVideojuegoConMasHoras(Videojuego[] videojuegos) {
        Videojuego videojuegoConMasHoras = videojuegos[0];
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.comparar(videojuegoConMasHoras) > 0) {
                videojuegoConMasHoras = videojuego;
            }
        }
        return videojuegoConMasHoras;
    }
}
