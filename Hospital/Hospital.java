

public class Hospital
{
    private Doctor[] doctores;
    private ListaEspera le;
    private Paciente[][] camas;
    private Nodo cabeza;
    public Hospital()
    {

        this.doctores = new Doctor[8];
        this.le = new ListaEspera();
        this.camas = new Paciente[4][6];
        this.cabeza = null;
        
        doctores[0] = new Doctor("Dr. Campos", "Cardiologia");
        doctores[1] = new Doctor("Dr. Acosta", "Cardiologia");
        doctores[2] = new Doctor("Dr. Mora", "Traumatologia");
        doctores[3] = new Doctor("Dr. Salas", "Traumatologia");
        doctores[4] = new Doctor("Dr. Nunez", "Pediatria");
        doctores[5] = new Doctor("Dr. Blanco", "Pediatria");
        doctores[6] = new Doctor("Dr. Fallas", "Neurologia");
        doctores[7] = new Doctor("Dr. Reyes", "Neurologia");
        
    }
    
    public Doctor[] getDoctores() {
        return this.doctores;
    }
    public void setDoctor(int posicion, Doctor doc) {
    if (posicion >= 0 && posicion < doctores.length) {
        this.doctores[posicion] = doc;
    } else {
        System.out.println("Índice fuera de rango");
    }
    }
    
    
    public void ingresarPaciente(Paciente p) {
        Doctor doctorAsignado = this.buscarMD(p);
    
        int filaEncontrada= -1;
        int columnaEncontrada= -1;
        boolean camaEncontrada= false;
    
        for(int i = 0; i < 4 && !camaEncontrada; i++){
            for(int j = 0; j < 6 && !camaEncontrada; j++){
              if(camas[i][j] == null){
                  filaEncontrada = i;
                  columnaEncontrada = j;
                  camaEncontrada = true;
              }
            }
        }
    
    
        if(camaEncontrada && doctorAsignado != null){
            doctorAsignado.incrementarPA();
            p.setDocAsignado(doctorAsignado);
            camas[filaEncontrada][columnaEncontrada] = p;
            
            System.out.println("Paciente ingresado exitosamente");
        }
        
        else if (p.getNvlUrgencia().equals("CRITICO")&&!camaEncontrada&&doctorAsignado!=null){
             int filaEncontradaPC= -1;
             int columnaEncontradaPC= -1;
              boolean camaEncontradaPC= false;
    
            for(int i=0;i<4&&!camaEncontradaPC;i++){
                for(int j=0;j<6&& !camaEncontradaPC; j++){
                      if(camas[i][j].getNvlUrgencia().equals("NORMAL")){
                          camas[i][j].getDocAsignado().quitarPA();
                          camas[i][j]=null;
                          filaEncontradaPC=i;
                          columnaEncontradaPC=j;
                          camaEncontradaPC=true;
                          doctorAsignado.incrementarPA();
                          p.setDocAsignado(doctorAsignado);
                          camas[filaEncontradaPC][columnaEncontradaPC]= p;
                          System.out.println("Cama con paciente NORMAL liberada,paciente ingresado exitosamente");
                          return;
                      }
                      
                      else{
                          System.out.println("Todas las camas estan ocupadas por pacientes CRITICOS, el paciente será agregado a la lista de espera");
                          le.agregarAlFinal(p);
                      }
                }
            } 
            
            
         
        }
        else{
            System.out.println("Hospital no cumple condiciones para aceptar este paciente, será agregado a lista de espera");
            le.agregarAlFinal(p);
        }
   
    }
    
    public void imprimirLE(){
        if(this.le==null){
            System.out.println("Lista de espera vacia, no se han ingresado pacientes");
        }
        else{
            System.out.println("Pacientes en lista de espera: ");
            le.mostrar();
        }
        
    }
    
    
    public void verCargaDoc(){
        System.out.println("LISTA DE DOCTORES: ");
        for(int i = 0; i < doctores.length; i++){
          doctores[i].imprimirDetalles();  
        }
    }
    
    public void darAlta(int piso, int cama){
        if(camas[piso][cama] == null){
            System.out.println("\nCAMA VACIA, NO SE PUEDE DAR DE ALTA");
        }
        else{
            camas[piso][cama].getDocAsignado().quitarPA();
            camas[piso][cama]= null;
            System.out.println("\nALTA EXITOSA, SE PROCEDE A REVISAR LISTA DE ESPERA");
            camas[piso][cama]=this.asignarCamaMP();
        }
        
        
    }
    
    
    private Paciente asignarCamaMP(){
        Nodo actual = le.getCabeza();
        Nodo anterior= null;
        boolean encontrado = false;
        Paciente p= null;
        while(actual!=null&& !encontrado){

    
            if (actual.getPaciente().getNvlUrgencia().equals("CRITICO")){

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
                        actualN= actualN.getNext();
                    }
                }
            
               

                else {
                anteriorN=actualN;
                actualN= actualN.getNext();
                }
            }
        }
        
        return p;
        
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
                    String esp = camas[i][j].getEspecialidad().toUpperCase();
                    System.out.printf("[%s/%.3s] ", nombre, esp);
                    camasOcupadasPiso++;
                    camasTotalOcupadas++;
                }
            }
            System.out.println();
        }
    
        System.out.println("Camas ocupadas: " + camasTotalOcupadas + "/24");
        System.out.println("Camas libres: " + (24 - camasTotalOcupadas) + "/24");
    }
    
    
    public void buscarPaciente(String nombre) {
        boolean pacienteEncontrado = false;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (camas[i][j] != null && camas[i][j].getNombre().equals(nombre)) {
                   System.out.println("Paciente encontrado: ");
                   System.out.println("Nombre; " + camas[i][j].getNombre());
                   System.out.println("Edad: " + camas[i][j].getEdad());
                   System.out.println("Piso: " + (i + 1));
                   System.out.println("Cama: " + (j + 1));
                   System.out.println("Urgencia: " + camas[i][j].getNvlUrgencia());
                   System.out.println("Doctor : " + camas[i][j].getDocAsignado().getNombre());
                   pacienteEncontrado = true; 
                }
            }    
        }
        
        if (!pacienteEncontrado) {
            System.out.println("No se ha encontrado ningun paciente");
        }
    }
    
    public void reporteGeneral() {
        System.out.println("============================================================");
        System.out.println("                      REPORTE GENERAL");
        System.out.println("============================================================");
        
        // ocupacion por piso
        
        System.out.println("Ocupacion por piso:");
        
        int camasTotalOcupadas = 0;
        
        for (int i = 0; i < 4; i++) {
            System.out.print("  Piso " + (i + 1) + ": ");
            int camasOcupadasPiso = 0;
            
            for (int j = 0; j < 6; j++) {
                if (camas[i][j] != null) {
                    camasOcupadasPiso++;
                }
            }
            
            camasTotalOcupadas += camasOcupadasPiso;
            double porcentaje = (camasOcupadasPiso / 6.0) * 100;
            System.out.printf(" %d/6 camas ocupadas (%.1f%%)\n", camasOcupadasPiso, porcentaje);
        }
        
        double porcentajeTotal = (camasTotalOcupadas / 24.0) * 100;
        System.out.printf("\nTotal hospital: %d/24 camas ocupadas (%.1f%%)\n", camasTotalOcupadas, porcentajeTotal);
        
        // pacientes por especialidad
        
        System.out.println("\nPacientes por especialidad:");
        String[] especialidades = {"Cardiologia", "Pediatria", "Traumatologia", "Neurologia"};
        
        for (String esp : especialidades) {
            int contPaAc = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 6; j++) {
                    if (camas[i][j] != null && camas[i][j].getEspecialidad().equals(esp)) {
                         contPaAc++;
                    }
                }
            }
            System.out.printf("  %-13s : %d pacientes activos\n", esp, contPaAc);
        }
        
        // carga de doctores
        
        System.out.println("\nCarga de doctores:");
          
        for(int i=0; i<doctores.length;i++){
          doctores[i].imprimirDetalles();  
        }
        
        // lista de espera falta
    }
}