

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
    
    
    public void ingresarPaciente(Paciente p){
        boolean encontrado= false;
        Doctor actual= null;
        Doctor mejorCandidato= null;
        for(int i=0; i<doctores.length;i++){
            
            actual= doctores[i];
            if(actual.getEspecialidad()==p.getEspecialidad()&&actual.getPacientes()<4){
                if (mejorCandidato==null || actual.getPacientes()<mejorCandidato.getPacientes()){
                    
                    mejorCandidato=actual;
                    
               }
               
           }
       
        }
    
        int filaEncontrada= -1;
        int columnaEncontrada= -1;
        boolean camaEncontrada= false;
    
        for(int i=0;i<4&&!camaEncontrada;i++){
            for(int j=0;j<6&& !encontrado; j++){
              if(camas[i][j]==null){
                  filaEncontrada=i;
                  columnaEncontrada=j;
                  camaEncontrada=true;
              }
            }
        }
    
    
        if(camaEncontrada&&mejorCandidato!=null){
            mejorCandidato.incrementarPA();
            camas[filaEncontrada][columnaEncontrada]= p;
            
            System.out.println("Paciente ingresado exitosamente");
        }
   
    }
    
    
    public void verCargaDoc(){
        System.out.println("LISTA DE DOCTORES; ");
        for(int i=0; i<doctores.length;i++){
          doctores[i].imprimirDetalles();  
        }
    }
}