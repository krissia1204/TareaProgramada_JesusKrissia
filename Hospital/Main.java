
// ============================================================
// CLASE MAIN
// Punto de entrada del sistema. Maneja el login con hasta
// 3 intentos y muestra el menú principal de gestión del hospital.
// ============================================================
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        Cifrador cifrado = new Cifrador();
        Hospital hospital = new Hospital();
 
        int intento   = 0;
        String usuario = "";
        String password = "";
 
        // Bucle de autenticación: máximo 3 intentos
        do {
            System.out.println("\n============================================");
            System.out.println(" Digite un usuario valido para ingresar al sistema.");
            System.out.println("============================================");
            usuario = sc.nextLine();
 
            System.out.println("\n============================================");
            System.out.println(" Digite la contraseña.");
            System.out.println("============================================");
            password = sc.nextLine();
 
            // Verificar credenciales usando el cifrador
            if (cifrado.verificar(usuario, password, "admin", "#Y6L!6*6")) {
 
                // Login exitoso: mostrar menú principal
                int opcion;
                do {
                    System.out.println("\n============================================");
                    System.out.println("              MENU PRINCIPAL");
                    System.out.println("============================================");
                    System.out.println(" 1. Ver estado del hospital");
                    System.out.println(" 2. Ingresar paciente");
                    System.out.println(" 3. Dar de alta");
                    System.out.println(" 4. Ver lista de espera");
                    System.out.println(" 5. Ver carga de doctores");
                    System.out.println(" 6. Buscar paciente");
                    System.out.println(" 7. Reporte general");
                    System.out.println(" 8. Salir");
                    System.out.println("============================================");
                    System.out.print(" Seleccione una opcion: ");
 
                    opcion = sc.nextInt();
                    sc.nextLine(); // Limpiar el salto de línea tras nextInt()
 
                    switch (opcion) {
                        case 1:
                            // Muestra la ocupación visual de todas las camas
                            hospital.mostrarEstadoHospi();
                            break;
 
                        case 2:
                            // Recolecta datos del nuevo paciente y lo ingresa
                            System.out.print("\nNombre del paciente    : ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad                   : ");
                            int edad = sc.nextInt();
                            sc.nextLine();
 
                            System.out.println("Especialidad requerida :");
                            System.out.println("  1. Cardiologia \n  2. Traumatologia \n  3. Pediatria \n  4. Neurologia");
                            System.out.print("Seleccione especialidad  : ");
                            int esp = sc.nextInt();
 
                            // Convertir opción numérica a nombre de especialidad
                            String especialidad = "";
                            if (esp == 1)      especialidad = "Cardiologia";
                            else if (esp == 2) especialidad = "Traumatologia";
                            else if (esp == 3) especialidad = "Pediatria";
                            else if (esp == 4) especialidad = "Neurologia";
 
                            System.out.println("Nivel de urgencia        :");
                            System.out.println("  1. NORMAL \n  2. CRITICO");
                            System.out.print("Seleccione urgencia      : ");
                            int urg = sc.nextInt();
 
                            // Convertir opción numérica a nivel de urgencia
                            String nivel = "";
                            if (urg == 1)      nivel = "NORMAL";
                            else if (urg == 2) nivel = "CRITICO";
 
                            Paciente p = new Paciente(nombre, edad, especialidad, nivel);
                            hospital.ingresarPaciente(p);
                            break;
 
                        case 3:
                            // Da de alta al paciente en la cama indicada
                            System.out.println("\n--- DAR DE ALTA ---");
                            System.out.print("Selecione el piso en el que está el paciente (0-3): ");
                            int piso = sc.nextInt();
                            System.out.print("Selecione la cama en la que está el paciente (0-5): ");
                            int cama = sc.nextInt();
                            hospital.darAlta(piso, cama);
                            break;
 
                        case 4:
                            // Muestra los pacientes en lista de espera
                            hospital.imprimirLE();
                            break;
 
                        case 5:
                            // Muestra la carga de cada doctor
                            hospital.verCargaDoc();
                            break;
 
                        case 6:
                            // Busca un paciente por nombre en las camas
                            System.out.print("Digite el nombre del paciente que desea buscar: ");
                            String buscarNombre = sc.nextLine();
                            hospital.buscarPaciente(buscarNombre);
                            break;
 
                        case 7:
                            // Genera el reporte general del hospital
                            hospital.reporteGeneral();
                            break;
 
                        case 8:
                            System.out.println("Sistema cerrado");
                            break;
                    }
                } while (opcion != 8); // Repetir menú hasta que el usuario elija salir
 
            } else {
                // Credenciales incorrectas: contar intento y avisar intentos restantes
                intento++;
                int rest = 3 - intento;
                System.out.println("Credenciales incorrectas intente de nuevo. Intentos restantes: " + rest);
            }
 
        } while (intento < 3 && !cifrado.verificar(usuario, password, "admin", "#Y6L!6*6"));
        // El sistema se cierra si se agotan los 3 intentos o el login es exitoso
 
        sc.close();
    }
}
