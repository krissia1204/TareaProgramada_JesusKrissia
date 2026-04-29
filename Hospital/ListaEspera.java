

public class ListaEspera
{
    Nodo cabeza;
    public ListaEspera()
    {
      this.cabeza=null;
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
    
}