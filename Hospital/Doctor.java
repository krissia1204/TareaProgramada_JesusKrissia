

public class Doctor
{
    private String nombre;
    private String especialidad;
    private int pActivos;

    
    public Doctor(String nom, String espc)
    {
        this.nombre = nom;
        this.especialidad = espc;
        this.pActivos = 0;
    }

   
    public String getEspecialidad(){
        return this.especialidad;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getPacientes(){
        return this.pActivos;
    }
    
    public void incrementarPA(){
        this.pActivos+=1;
    }
    
    public void quitarPA(){
        this.pActivos-=1;
    }
    
    public void imprimirDetalles(){
        int carga = 4;
        if (pActivos == 4) {
            System.out.printf("  %-10s  (%.3s) : %d/%d  [LLENO]\n", nombre, especialidad.toUpperCase(), pActivos, carga);
        } else {
            System.out.printf("  %-10s  (%.3s) : %d/%d  [OK   ]\n", nombre, especialidad.toUpperCase(), pActivos, carga);
        }
        
    }
    
    public boolean tieneCupo() {
        return this.pActivos < 4;
    }
}