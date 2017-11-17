
package proyecto2datos;

/*Lisandra Agüero Ruíz.
Jose Fabio Alfaro Quesada.
Esteban Espinoza Fallas.
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ImplementTree implements Serializable {
    public AvlTree<Book> avl;
    
    public ImplementTree(AvlTree<Book> avl) {
        this.avl=avl;
    }

    public ImplementTree() {
        avl=new AvlTree<Book>();
    }
    public void insert(Book b){ //insertar A
        avl.insert(b);
    }
     public void searchA(String autor){ //<------------ B
        autor_search(avl,autor);
    }
      public void searchTy(int type){ //<------------ C
        type_search(avl,type);
    }
        public void searchNa(String name){ //<------------ D
        name_search(avl,name);
    }
       public void searchCo(String cod){ //<------------ E
        code_search(avl,cod);
    }
    public boolean complete(){ //completo F
        return avl.is_complete();
    }
   public boolean isPerfect(){
       return avl.perfectB(); //Perfecto G
   }
    public boolean full(){ //lleno H
        return avl.isFull();
    }
     public int Hight(){ //altura I
      return  avl.treeHeight();
    }
     public int level(){ //niveles J
        return avl.level();
    }
     public int weight(){ //peso K
        return avl.treeWeight();
    }
     
     //L
   
    public void delete_type(int ty){ //<------------ M
        List<Book> list=type(avl,ty);
        
        for(int i=0; i<list.size(); i++){
            avl.remove(list.get(i));
        } 
    } 
    public void delete_code(String cod){ //<------------ N
        List<Book> list=code(avl,cod);
        
        for(int i=0; i<list.size(); i++){
            avl.remove(list.get(i));
        }
    }
    
   
    
    
    private void autor_search(AvlTree<Book> avl, String autor){
        int cont=0;
        int x=0;
        
        if(avl!=null){
            for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getAutor()==autor){
                    cont++;
                                      
                }
               
            }
             String[] array=new String[cont];
             for(int j=0; j<avl.list.size(); j++){
             
                if(avl.list.get(j).getAutor()==autor){
                    array[x]=avl.list.get(j).getNombre();
                    x++;
                                      
                
             }
            
        }
       

        sort(array,1);
    }
    }
   
    
    private void type_search(AvlTree<Book> avl, int type){
           int cont=0;
        int x=0;
        if(avl!=null){
            for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getTipo()==type){
                    cont++;
                                      
                }
            }
            String[] array=new String[cont];
             for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getTipo()==type){
                    array[x]=avl.list.get(i).getNombre();
                     x++;                 
                }
            
        }
        sort(array,1);
    }
    }
        
    private void name_search(AvlTree<Book> avl, String name){
           int cont=0;
           int x=0;
        
        if(avl!=null){
            for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getNombre()==name){
                    cont++;
                                      
                }
            }
            String[] array=new String[cont];
             for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getNombre()==name){
                    array[x]=avl.list.get(i).getNombre();
                    x++;
                                      
                }
            
        }
        sort(array,1);
    }
    }
  
    
    private void code_search(AvlTree<Book> avl, String cod){
           int cont=0;
           int x=0;
        
        if(avl!=null){
            for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getCodigo()==cod){
                    cont++;
                                      
                }
            }
            String[] array=new String[cont];
             for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getCodigo()==cod){
                    array[x]=avl.list.get(i).getNombre();
                    x++;
                                      
                }
            
        }
        sort(array,1);
    }
    }
    
    //Elimina
    
    private List<Book> code(AvlTree<Book> avl, String cod){
        List<Book> list=new ArrayList<Book>();
    
        if(avl!=null){
            for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getCodigo()==cod){
                list.add(avl.list.get(i));
                }
            }
            return list;
    }
    return null;
}
      
     private List<Book> type(AvlTree<Book> avl, int ti){
        List<Book> list=new ArrayList<Book>();
    
        if(avl!=null){
            for(int i=0; i<avl.list.size(); i++){
                if(avl.list.get(i).getTipo()==ti){
                list.add(avl.list.get(i));
                }
            }
            return list;
    }
    return null;
}
 
    //RADIX
    
      
    private static void sort (String[] a, int w) {
    
        int n = a.length;
        int R = 256;   // Esto es de ASCII
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {
        
            int[] contS = new int[R+1];
            for (int i = 0; i < n; i++)
                contS[a[i].charAt(d)+1]++;
    
                  for (int r = 0; r < R; r++)
                     contS[r+1] += contS[r];


                     for (int i = 0; i < n; i++)
                       aux[contS[a[i].charAt(d)]++] = a[i];

 
                         for (int i = 0; i < n; i++)
                            a[i] = aux[i];
        }
        for(int i=0; i<aux.length; i++){ //verificar si los está ordenando
            System.out.println(aux[i].toString());
        }
    }
    
     public void writeToFile(String fileName, List<Book> books) throws IOException {
        File f = new File(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(books);
        oos.flush();
        oos.close();
    }
      public void ReadFromFile(String fileName, List<Book> books) throws IOException, ClassNotFoundException {
        File f = new File(fileName);
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(f));
        oos.readObject();
        oos.available();
        oos.close();
    }
  
}
