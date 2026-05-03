

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
        Doctor doctorAsignado= this.buscarMD(p);
    
        int filaEncontrada= -1;
        int columnaEncontrada= -1;
        boolean camaEncontrada= false;
    
        for(int i=0;i<4&&!camaEncontrada;i++){
            for(int j=0;j<6&& !camaEncontrada; j++){
              if(camas[i][j]==null){
                  filaEncontrada=i;
                  columnaEncontrada=j;
                  camaEncontrada=true;
              }
            }
        }
    
    
        if(camaEncontrada&&doctorAsignado!=null){
            doctorAsignado.incrementarPA();
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
    
    public void darAlta(int piso, int cama){
        
        if(camas[piso][cama]==null){
            System.out.println("CAMA VACIA, NO SE PUEDE DAR DE ALTA");
        }
        else{
            camas[piso][cama].getDocAsignado().quitarPA();
            camas[piso][cama]= null;
        
            camas[piso][cama]=this.asignarCamaMP();
        }
        
        
    }
    
    
    private Paciente asignarCamaMP(){
        Nodo actual = cabeza;
        Nodo anterior= null;
        boolean encontrado = false;
        Paciente p= null;
        while(actual!=null&& !encontrado){

            if (actual.getPaciente().getNvlUrgencia().equals("Critico")){

                Doctor ideal = this.buscarMD(actual.getPaciente());
                if(ideal!=null){
                    p= actual.getPaciente();
                    encontrado =true;
                    ideal.incrementarPA();
                    
                    if (anterior == null){ cabeza = actual.getNext();}
                    else{ anterior.setNext(actual.getNext());}
                }
                else {
                anterior=actual;
                actual= actual.getNext();}
                }
            

            else {
            anterior=actual;
            actual= actual.getNext();}
        }
        
        if(!encontrado){
            Nodo actualN = cabeza;
            Nodo anteriorN= null;
            while(actualN!=null&& !encontrado){

                if (actualN.getPaciente().getNvlUrgencia().equals("NORMAL")){
                    
                    Doctor ideal = this.buscarMD(actualN.getPaciente());
                    if(ideal!=null){
                        p= actualN.getPaciente();
                        encontrado =true;
                        ideal.incrementarPA();
                        
                        if (anteriorN == null){ cabeza = actualN.getNext();}
                        else{ anteriorN.setNext(actualN.getNext());}
                        }
                    else {
                        anteriorN=actualN;
<<<<<<< HEAD
                        actualN= actualN.getNext();
                    }
                }
            
               

                else {
                anteriorN=actualN;
                actualN= actualN.getNext();
                }
=======
                        actualN= actualN.getNext();}
                }
            
                

            else {
                anteriorN=actualN;
                actualN= actualN.getNext();}
>>>>>>> 47e21b19aa10da0f1482a81d62f22c2e7ed57d2f
            }
        }
        
        return p;
        
<<<<<<< HEAD
=======
    }
    
    private Doctor buscarMD(Paciente p){
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
        
        return mejorCandidato;
>>>>>>> 47e21b19aa10da0f1482a81d62f22c2e7ed57d2f
    }
    
    private Doctor buscarMD(Paciente p){
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
        
        return mejorCandidato;
    }
    
    
    public void mostrarEstadoHospi() {
        System.out.println("============================================================");
        System.out.println("                  ESTADO DEL HOSPITAL");
        System.out.println("============================================================");
        System.out.println("        Cam1        Cam2        Cam3        Cam4        Cam5        Cam6");
    
        int camasTotalOcupadas = 0;
    
        for (int i = 0; i < 4; i++) {
            System.out.print("Piso " + (i + 1) + ": ");
            int camasOcupadasPiso = 0;
    
            for (int j = 0; j < 6; j++) {
                if (camas[i][j] == null) {
                    System.out.print("[---      ] ");
                } else {
                    String nombre = camas[i][j].getNombre();
                    String esp = camas[i][j].getEspecialidad().substring(0, 3).toUpperCase();
                    System.out.print("[" + nombre + "/" + esp + "] ");
                    camasOcupadasPiso++;
                    camasTotalOcupadas++;
                }
            }
            System.out.println();
        }
    
        System.out.println("Camas ocupadas: " + camasTotalOcupadas + "/24");
        System.out.println("Camas libres: " + (24 - camasTotalOcupadas) + "/24");
    }
    
    
    
}