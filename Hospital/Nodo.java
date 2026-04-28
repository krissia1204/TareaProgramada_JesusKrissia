

public class Nodo
{
    private Paciente paciente;
    private Nodo next;
    
    public Nodo(Paciente p)
    {
        this.paciente= p;
        this.next=null;

    }
    
    
    public void setPaciente(Paciente p){
        this.paciente= p;
    }
    
    public void setNext(Nodo n){
        this.next= n;
    }
    
    public Paciente getPaciente(){
        return this.paciente;
    }
    
    public Nodo getNext(){
        return this.next;
    }
}

    