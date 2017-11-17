
package proyecto2datos;

/*Lisandra Agüero Ruíz.
Jose Fabio Alfaro Quesada.
Esteban Espinoza Fallas.
*/

import java.io.Serializable;



public  class Book implements Comparable<Book>, Serializable{

    public Book(String nombre, String codigo, String autor, String Descripcion, int tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.autor = autor;
        this.Descripcion = Descripcion;
        this.tipo = tipo;
    }

    public Book() {
        this.nombre = "Empty";
        this.codigo = "Empty";
        this.autor = "Empty";
        this.Descripcion = "None";
        this.tipo = 0;
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
    
    public String toString(){
        return "Nombre: "+nombre +"\nCodigo: "+codigo+
                "\nAutor: "+autor+"\nDescripcion: "+Descripcion+
                "\nTipo: "+String.valueOf(tipo);
    }
    
    private final String nombre;
    private final String codigo;// codigo ISBN
    private final String autor;
    private final String Descripcion;
    private final int tipo;

  
//    @Override
//    public int compareTo(Book o) {
//         return Integer.parseInt(o.codigo);
//    }

    @Override
    public int compareTo(Book o) {
      if (codigo.equals(o.codigo)){
            return tipo - o.tipo;
      }
        return codigo.compareTo(o.codigo);
    }

}
