

public class ListaEspera
{
    Nodo cabeza;
    public ListaEspera()
    {
      this.cabeza=null;
    }
    
    public Nodo getCabeza(){
        return this.cabeza;
    }
    
    public void agregarAlFinal(Paciente p){
        Nodo nuevo= new Nodo(p);
        Nodo actual=cabeza;
        if(cabeza==null){
            this.cabeza= nuevo;
        }
        
        else{
            while(actual.getNext()!=null){
                actual= actual.getNext();
            }
            actual.setNext(nuevo);
        }
    }
    
    public Paciente extraerPosicion(int posicion){
        
        int contador=0;
        Paciente p= null;
        Nodo actual= cabeza;
        if(posicion==0){
            p=cabeza.getPaciente();
            cabeza=cabeza.getNext();
            }
        else{
            while(actual!=null&& contador<posicion-1){
                actual= actual.getNext();
                contador++;
            }
        
            Nodo extraer= actual.getNext();
            p= extraer.getPaciente();
            actual.setNext(extraer.getNext());
            }
            
           
        
        return p;
    }
    
    public Paciente buscarCandidato(String nombre){
        Paciente p= null;
        Nodo actual= cabeza;
        while(actual!=null){
            if (actual.getPaciente().getNombre().equalsIgnoreCase(nombre)){
                p= actual.getPaciente();
            }
            actual=actual.getNext();
        }
        
        return p;
    }
    
     public void mostrar(){
        //imprimir todos los pacientes por medio de recorrido con while
        Nodo actual= cabeza;
        int contador=0;
       
        while(actual!=null){
            contador++;
            actual.getPaciente().imprimirDetalles();
            System.out.println("Posicion del paciente en LE: "+contador);
            actual=actual.getNext();
            
        }
    }
    
    
    
}