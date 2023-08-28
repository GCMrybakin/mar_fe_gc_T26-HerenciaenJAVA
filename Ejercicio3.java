// Ejercicio 4

class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numeroPaginas;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String toString() {
        return "El libro con ISBN " + ISBN + " creado por " + autor + " tiene " + numeroPaginas + " páginas.";
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
    	Libro libro1 = new Libro();
        libro1.setISBN("978-0061120084");
        libro1.setTitulo("Matar a un ruiseñor");
        libro1.setAutor("Harper Lee");
        libro1.setNumeroPaginas(336);

        Libro libro2 = new Libro();
        libro2.setISBN("978-0307474278");
        libro2.setTitulo("Cien años de soledad");
        libro2.setAutor("Gabriel García Márquez");
        libro2.setNumeroPaginas(432);

        System.out.println(libro1.toString());
        System.out.println(libro2.toString());

        if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
            System.out.println("El libro 1 tiene mas paginas.");
        } else if (libro2.getNumeroPaginas() > libro1.getNumeroPaginas()) {
            System.out.println("El libro 2 tiene mas páginas.");
        } else {
            System.out.println("Ambos libros tienen la misma cantidad de paginas.");
        }
    }
}
