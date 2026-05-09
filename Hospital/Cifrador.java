

// ============================================================
// CLASE CIFRADOR
// Cifra contraseñas usando una tabla de sustitución basada
// en valores ASCII. Permite verificar credenciales sin
// almacenar la contraseña en texto plano.
// ============================================================
public class Cifrador {
    private final int[][] cifrado; // Tabla de sustitución 3x2
 
    // Constructor: define los valores de sustitución en la tabla
    public Cifrador() {
        this.cifrado = new int[3][2];
 
        this.cifrado[0][0] = 89; // 'Y'
        this.cifrado[0][1] = 76; // 'L'
        this.cifrado[1][0] = 42; // '*'
        this.cifrado[1][1] = 54; // '6'
        this.cifrado[2][0] = 33; // '!'
        this.cifrado[2][1] = 35; // '#'
    }
 
    // Cifra un texto plano carácter por carácter:
    // Cada carácter se convierte a ASCII y se usa para calcular
    // una fila y columna en la tabla de sustitución.
    public String cifrar(String textoPlano) {
        char[] texto = textoPlano.toCharArray();
        String resultado = "";
 
        for (int i = 0; i < texto.length; i++) {
            char actual = texto[i];
 
            // Convertir el carácter a su valor ASCII
            int vAscii = (int) actual;
 
            // Determinar posición en la tabla de sustitución
            int fila = vAscii % 3;
            int col  = vAscii % 2;
 
            // Obtener el carácter cifrado desde la tabla
            int textCifrado = cifrado[fila][col];
 
            resultado += (char) textCifrado;
        }
 
        return resultado;
    }
 
    // Verifica si el usuario y contraseña ingresados son correctos.
    // Cifra el intento y lo compara con la contraseña cifrada del sistema.
    public boolean verificar(String usuario, String intentoPass, String usuarioSistema, String passSistema) {
        String tryCifrado = this.cifrar(intentoPass);
        return tryCifrado.equals(passSistema) && usuario.equals(usuarioSistema);
    }
}