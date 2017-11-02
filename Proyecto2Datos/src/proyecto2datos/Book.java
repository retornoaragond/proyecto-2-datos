
package proyecto2datos;

public class Book {

    public Book(String nombre, String codigo, String autor, String Descripcion, int tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.autor = autor;
        this.Descripcion = Descripcion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getTipo() {
        return tipo;
    }
    
    private final String nombre;
    private final String codigo;// codigo ISBN
    private final String autor;
    private final String Descripcion;
    private final int tipo;
}
