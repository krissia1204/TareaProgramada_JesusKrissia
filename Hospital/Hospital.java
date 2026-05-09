

// ============================================================
// CLASE HOSPITAL
// Clase principal que gestiona el sistema hospitalario:
// - Arreglo de 8 doctores (2 por especialidad)
// - Matriz de camas: 4 pisos x 6 camas = 24 camas totales
// - Lista de espera para pacientes que no pudieron ser internados
// ============================================================
public class Hospital {
    private Doctor[]    doctores; // Arreglo de 8 doctores
    private ListaEspera le;       // Lista de espera de pacientes
    private Paciente[][] camas;   // Matriz [4 pisos][6 camas]
    private Nodo cabeza;          // Cabeza local usada en asignarCamaMP
 
    // Constructor: inicializa estructuras y registra los 8 doctores del hospital
    public Hospital() {
        this.doctores = new Doctor[8];
        this.le       = new ListaEspera();
        this.camas    = new Paciente[4][6];
        this.cabeza   = null;
 
        // 2 doctores por cada una de las 4 especialidades
        doctores[0] = new Doctor("Dr. Campos", "Cardiologia");
        doctores[1] = new Doctor("Dr. Acosta", "Cardiologia");
        doctores[2] = new Doctor("Dr. Mora",   "Traumatologia");
        doctores[3] = new Doctor("Dr. Salas",  "Traumatologia");
        doctores[4] = new Doctor("Dr. Nunez",  "Pediatria");
        doctores[5] = new Doctor("Dr. Blanco", "Pediatria");
        doctores[6] = new Doctor("Dr. Fallas", "Neurologia");
        doctores[7] = new Doctor("Dr. Reyes",  "Neurologia");
    }
 
    // Reemplaza un doctor en una posición específica del arreglo
    public void setDoctor(int posicion, Doctor doc) {
        if (posicion >= 0 && posicion < doctores.length) {
            this.doctores[posicion] = doc;
        } else {
            System.out.println("Índice fuera de rango");
        }
    }
 
    // --------------------------------------------------------
    // Intenta ingresar un paciente al hospital. Hay tres casos:
    // 1. Hay cama libre y doctor disponible → ingreso directo.
    // 2. No hay camas, pero el paciente es CRITICO → desplaza
    //    a un paciente NORMAL si existe alguno.
    // 3. No se cumplen condiciones → va a lista de espera.
    // --------------------------------------------------------
    public void ingresarPaciente(Paciente p) {
        Doctor doctorAsignado = this.buscarMD(p); // Busca el doctor más adecuado
 
        int filaEncontrada    = -1;
        int columnaEncontrada = -1;
        boolean camaEncontrada = false;
 
        // Buscar la primera cama libre en la matriz
        for (int i = 0; i < 4 && !camaEncontrada; i++) {
            for (int j = 0; j < 6 && !camaEncontrada; j++) {
                if (camas[i][j] == null) {
                    filaEncontrada    = i;
                    columnaEncontrada = j;
                    camaEncontrada    = true;
                }
            }
        }
 
        // CASO 1: hay cama libre y doctor disponible
        if (camaEncontrada && doctorAsignado != null) {
            doctorAsignado.incrementarPA();
            p.setDocAsignado(doctorAsignado);
            camas[filaEncontrada][columnaEncontrada] = p;
            System.out.println("Paciente ingresado exitosamente");
        }
<<<<<<< Updated upstream
 
        // CASO 2: no hay camas pero el paciente es CRITICO
        else if (p.getNvlUrgencia().equals("CRITICO") && !camaEncontrada && doctorAsignado != null) {
            int filaEncontradaPC    = -1;
            int columnaEncontradaPC = -1;
            boolean camaEncontradaPC = false;
 
            // Buscar una cama con paciente NORMAL para liberarla
            for (int i = 0; i < 4 && !camaEncontradaPC; i++) {
                for (int j = 0; j < 6 && !camaEncontradaPC; j++) {
                    if (camas[i][j].getNvlUrgencia().equals("NORMAL")) {
                        // Liberar la cama: quitar paciente NORMAL y reducir carga de su doctor
                        camas[i][j].getDocAsignado().quitarPA();
                        camas[i][j] = null;
                        filaEncontradaPC    = i;
                        columnaEncontradaPC = j;
                        camaEncontradaPC    = true;
 
                        // Asignar la cama liberada al paciente CRITICO
                        doctorAsignado.incrementarPA();
                        p.setDocAsignado(doctorAsignado);
                        camas[filaEncontradaPC][columnaEncontradaPC] = p;
                        System.out.println("Cama con paciente NORMAL liberada, paciente ingresado exitosamente");
                        return;
                    } else {
                        // Todas las camas tienen pacientes CRITICOS, no se puede desplazar
                        System.out.println("Todas las camas estan ocupadas por pacientes CRITICOS, el paciente será agregado a la lista de espera");
                        le.agregarAlFinal(p);
=======
        
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
                    
                    if (anterior == null){ le.setCabeza( actual.getNext());}
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
            Nodo actualN = le.getCabeza();
            Nodo anteriorN= null;
            while(actualN!=null&& !encontrado){

                if (actualN.getPaciente().getNvlUrgencia().equals("NORMAL")){
                    
                    Doctor ideal = this.buscarMD(actualN.getPaciente());
                    if(ideal!=null){
                        p= actualN.getPaciente();
                        encontrado =true;
                        ideal.incrementarPA();
                        
                        if (anteriorN == null){ le.setCabeza( actualN.getNext());}
                        else{ anteriorN.setNext(actualN.getNext());}
                        }
                    else {
                        anteriorN=actualN;
                        actualN= actualN.getNext();
>>>>>>> Stashed changes
                    }
                }
            }
        }
 
        // CASO 3: no se cumplen las condiciones → lista de espera
        else {
            System.out.println("Hospital no cumple condiciones para aceptar este paciente, será agregado a lista de espera");
            le.agregarAlFinal(p);
        }
    }
 
    // Muestra todos los pacientes actualmente en la lista de espera
    public void imprimirLE() {
        if (this.le == null) {
            System.out.println("Lista de espera vacia, no se han ingresado pacientes");
        } else {
            System.out.println("Pacientes en lista de espera: ");
            le.mostrar();
        }
    }
 
    // Muestra la carga de pacientes de cada doctor
    public void verCargaDoc() {
        System.out.println("LISTA DE DOCTORES: ");
        for (int i = 0; i < doctores.length; i++) {
            doctores[i].imprimirDetalles();
        }
    }
 
    // --------------------------------------------------------
    // Da de alta al paciente en la cama indicada (piso, cama).
    // Luego revisa la lista de espera para ocupar esa cama.
    // --------------------------------------------------------
    public void darAlta(int piso, int cama) {
        if (camas[piso][cama] == null) {
            System.out.println("\nCAMA VACIA, NO SE PUEDE DAR DE ALTA");
        } else {
            // Reducir la carga del doctor y liberar la cama
            camas[piso][cama].getDocAsignado().quitarPA();
            camas[piso][cama] = null;
            System.out.println("\nALTA EXITOSA, SE PROCEDE A REVISAR LISTA DE ESPERA");
 
            // Intentar traer al mejor candidato de la lista de espera
            camas[piso][cama] = this.asignarCamaMP();
        }
    }
 
    // --------------------------------------------------------
    // Busca en la lista de espera el mejor candidato para la
    // cama recién liberada. Prioriza pacientes CRITICOS;
    // si no hay ninguno con doctor disponible, busca entre NORMALES.
    // --------------------------------------------------------
    private Paciente asignarCamaMP() {
        Nodo actual   = le.getCabeza();
        Nodo anterior = null;
        boolean encontrado = false;
        Paciente p = null;
 
        // Primera pasada: buscar paciente CRITICO con doctor disponible
        while (actual != null && !encontrado) {
            if (actual.getPaciente().getNvlUrgencia().equals("CRITICO")) {
                Doctor ideal = this.buscarMD(actual.getPaciente());
                if (ideal != null) {
                    p = actual.getPaciente();
                    encontrado = true;
                    ideal.incrementarPA();
 
                    // Eliminar el nodo de la lista de espera
                    if (anterior == null) {
                        cabeza = actual.getNext();
                    } else {
                        anterior.setNext(actual.getNext());
                    }
                } else {
                    // No hay doctor disponible para este CRITICO, pasar al siguiente
                    anterior = actual;
                    actual   = actual.getNext();
                }
            } else {
                anterior = actual;
                actual   = actual.getNext();
            }
        }
 
        // Segunda pasada: si no se encontró CRITICO, buscar paciente NORMAL
        if (!encontrado) {
            Nodo actualN   = cabeza;
            Nodo anteriorN = null;
 
            while (actualN != null && !encontrado) {
                if (actualN.getPaciente().getNvlUrgencia().equals("NORMAL")) {
                    Doctor ideal = this.buscarMD(actualN.getPaciente());
                    if (ideal != null) {
                        p = actualN.getPaciente();
                        encontrado = true;
                        ideal.incrementarPA();
 
                        // Eliminar el nodo de la lista de espera
                        if (anteriorN == null) {
                            cabeza = actualN.getNext();
                        } else {
                            anteriorN.setNext(actualN.getNext());
                        }
                    } else {
                        anteriorN = actualN;
                        actualN   = actualN.getNext();
                    }
                } else {
                    anteriorN = actualN;
                    actualN   = actualN.getNext();
                }
            }
        }
 
        return p; // null si no hay candidato válido en lista de espera
    }
 
    // --------------------------------------------------------
    // Busca el doctor más adecuado para un paciente:
    // - Debe tener la misma especialidad que el paciente.
    // - Debe tener menos de 4 pacientes activos (cupo disponible).
    // - Entre los candidatos, elige el que tenga menos pacientes
    //   (balanceo de carga).
    // Retorna null si no encuentra ningún doctor disponible.
    // --------------------------------------------------------
    private Doctor buscarMD(Paciente p) {
        Doctor actual          = null;
        Doctor mejorCandidato  = null;
 
        for (int i = 0; i < doctores.length; i++) {
            actual = doctores[i];
 
            if (actual.getEspecialidad() == p.getEspecialidad() && actual.getPacientes() < 4) {
                // Prefiere al doctor con menor carga actual
                if (mejorCandidato == null || actual.getPacientes() < mejorCandidato.getPacientes()) {
                    mejorCandidato = actual;
                }
            }
        }
 
        return mejorCandidato;
    }
 
    // Muestra el estado visual de las camas: piso a piso, indicando
    // si están vacías o el nombre/especialidad del paciente.
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
                    System.out.print("[---      ] "); // Cama vacía
                } else {
                    String nombre = camas[i][j].getNombre();
                    String esp    = camas[i][j].getEspecialidad().toUpperCase();
                    System.out.printf("[%s/%.3s] ", nombre, esp);
                    camasOcupadasPiso++;
                    camasTotalOcupadas++;
                }
            }
            System.out.println();
        }
 
        System.out.println("Camas ocupadas: " + camasTotalOcupadas + "/24");
        System.out.println("Camas libres: "   + (24 - camasTotalOcupadas) + "/24");
    }
 
    // Busca un paciente por nombre en todas las camas e imprime sus datos
    public void buscarPaciente(String nombre) {
        boolean pacienteEncontrado = false;
 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (camas[i][j] != null && camas[i][j].getNombre().equals(nombre)) {
                    System.out.println("Paciente encontrado: ");
                    System.out.println("Nombre: "  + camas[i][j].getNombre());
                    System.out.println("Edad: "    + camas[i][j].getEdad());
                    System.out.println("Piso: "    + (i + 1));
                    System.out.println("Cama: "    + (j + 1));
                    System.out.println("Urgencia: "+ camas[i][j].getNvlUrgencia());
                    System.out.println("Doctor: "  + camas[i][j].getDocAsignado().getNombre());
                    pacienteEncontrado = true;
                }
            }
        }
 
        if (!pacienteEncontrado) {
            System.out.println("No se ha encontrado ningun paciente");
        }
    }
 
    // Genera un reporte completo: ocupación por piso, pacientes por
    // especialidad y carga actual de cada doctor.
    public void reporteGeneral() {
        System.out.println("============================================================");
        System.out.println("                      REPORTE GENERAL");
        System.out.println("============================================================");
 
        // --- Sección 1: Ocupación por piso ---
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
        System.out.printf("\nTotal hospital: %d/24 camas ocupadas (%.1f%%)\n",
                          camasTotalOcupadas, porcentajeTotal);
 
        // --- Sección 2: Pacientes activos por especialidad ---
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
 
        // --- Sección 3: Carga de doctores ---
        System.out.println("\nCarga de doctores:");
        for (int i = 0; i < doctores.length; i++) {
            doctores[i].imprimirDetalles();
        }
    }
}