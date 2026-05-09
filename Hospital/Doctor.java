

// ============================================================
// CLASE DOCTOR
// Representa a un médico del hospital. Lleva registro de
// cuántos pacientes activos tiene (máximo 4 por doctor).
// ============================================================
public class Doctor {
    private String nombre;
    private String especialidad;
    private int pActivos; // Cantidad de pacientes activos asignados
 
    // Constructor: el doctor comienza sin pacientes
    public Doctor(String nom, String espc) {
        this.nombre = nom;
        this.especialidad = espc;
        this.pActivos = 0;
    }
 
    public String getEspecialidad() {
        return this.especialidad;
    }
 
    public String getNombre() {
        return this.nombre;
    }
 
    public int getPacientes() {
        return this.pActivos;
    }
 
    // Suma un paciente al contador cuando se le asigna uno
    public void incrementarPA() {
        this.pActivos += 1;
    }
 
    // Resta un paciente al contador cuando un paciente es dado de alta
    public void quitarPA() {
        this.pActivos -= 1;
    }
 
    // Imprime nombre, especialidad y carga actual del doctor
    public void imprimirDetalles() {
        int carga = 4;
        if (pActivos == 4) {
            System.out.printf("  %-10s  (%.3s) : %d/%d  [LLENO]\n", nombre, especialidad.toUpperCase(), pActivos, carga);
        } else {
            System.out.printf("  %-10s  (%.3s) : %d/%d  [OK   ]\n", nombre, especialidad.toUpperCase(), pActivos, carga);
        }
    }
 
    // Indica si el doctor puede aceptar más pacientes
    public boolean tieneCupo() {
        return this.pActivos < 4;
    }
}