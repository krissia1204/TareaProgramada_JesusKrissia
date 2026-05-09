

// ============================================================
// CLASE PACIENTE
// Representa a un paciente del hospital con sus datos
// personales, especialidad requerida, nivel de urgencia
// y el doctor que se le asigna al ser internado.
// ============================================================
public class Paciente {
    private String nombre;
    private int edad;
    private String espcRequerida; // Especialidad médica que necesita
    private String nvlUrgencia;   // "NORMAL" o "CRITICO"
    private Doctor docAsignado;   // Doctor asignado al momento del ingreso
 
    // Constructor: inicializa el paciente sin doctor asignado todavía
    public Paciente(String nom, int laEdad, String especialidad, String nivel) {
        this.nombre = nom;
        this.edad = laEdad;
        this.espcRequerida = especialidad;
        this.nvlUrgencia = nivel;
        this.docAsignado = null;
    }
 
    public String getNombre() {
        return this.nombre;
    }
 
    public int getEdad() {
        return this.edad;
    }
 
    public String getEspecialidad() {
        return this.espcRequerida;
    }
 
    public String getNvlUrgencia() {
        return this.nvlUrgencia;
    }
 
    public Doctor getDocAsignado() {
        return this.docAsignado;
    }
 
    // Asigna el doctor que atenderá a este paciente
    public void setDocAsignado(Doctor d) {
        this.docAsignado = d;
    }
 
    // Imprime los datos del paciente en consola
    public void imprimirDetalles() {
        System.out.println("Nombre del paciente:  " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Especialidad requerida: " + espcRequerida);
        System.out.println("Nivel de urgencia: " + nvlUrgencia);
    }
}