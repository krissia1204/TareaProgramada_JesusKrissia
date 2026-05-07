

public class Paciente
{
    private String nombre;
    private int edad;
    private String espcRequerida;
    private String nvlUrgencia;
    private Doctor docAsignado;
    /**
     * Constructor for objects of class Paciente
     */
    public Paciente(String nom, int laEdad, String especialidad,String nivel )
    {
        this.nombre = nom;
        this.edad = laEdad;
        this.espcRequerida = especialidad;
        this.nvlUrgencia = nivel;
        this.docAsignado = null;
       
    }

   
    public String getNombre()
    {
        
        return this.nombre;
    }
    
    public int getEdad()
    {
        
        return this.edad;
    }
    
    public String getEspecialidad()
    {
        
        return this.espcRequerida ;
    }
    
    public String getNvlUrgencia()
    {
        
        return this.nvlUrgencia ;
    }
    
    public Doctor getDocAsignado(){
        return this.docAsignado;
    }
    
    public void setDocAsignado(Doctor d) {
        this.docAsignado = d;
    }
}