

public class Doctor
{
    private String nombre;
    private String especialidad;
    private int pActivos;

    
    public Doctor(String nom, String espc)
    {
        this.nombre= nom;
        this.especialidad= espc;
        this.pActivos=0;
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
        int carga= 4-pActivos;
        System.out.println("-Doctor: "+nombre+ " -Especialidad: "+especialidad+" -Numero de pacientes activos: "+pActivos+ " -Cupos disponibles: "+carga);
    }
}