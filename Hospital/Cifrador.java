

public class Cifrador
{   
    private final int [][] cifrado;
    
    public Cifrador()
    {
       this.cifrado= new int [3][2];
       
       this.cifrado[0][0]=89; 
       this.cifrado[0][1]=76; 
       this.cifrado[1][0]=42;
       this.cifrado[1][1]=54;
       this.cifrado[2][0]= 33;
       this.cifrado[2][1]= 35;
    }
    
    public String cifrar(String textoPlano){
       char[] texto= textoPlano.toCharArray(); 
       String resultado= "";
       
       for(int i=0; i<texto.length;i++){
           char actual= texto[i];
           
           //convertir a ascii
           int vAscii = (int) actual;
           
           //sustitución
           
           int fila= vAscii%3;
           int col= vAscii%2;
           
           int textCifrado= cifrado[fila][col];
           
           resultado+= (char) textCifrado;
           
           
       }
       return resultado;
    }
    
    public boolean verificar(String usuario, String intentoPass,String usuarioSistema, String passSistema){
       String tryCifrado= this.cifrar(intentoPass);
       
       return tryCifrado.equals(passSistema)&&usuario.equals(usuarioSistema);
        
    }
    
    

    
}