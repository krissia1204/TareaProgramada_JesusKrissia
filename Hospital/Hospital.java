

public class Hospital
{
    private Doctor[] doctores;
    private ListaEspera le;
    private Paciente [][] camas;
    private Nodo cabeza;
    public Hospital()
    {
        this.doctores= new Doctor[8];
        this.le= null;
        this.camas= new Paciente[4][6];
        this.cabeza= null;
        
    }

   
}