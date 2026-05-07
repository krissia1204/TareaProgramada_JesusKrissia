import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Hospital hospital = new Hospital();
        
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
            sc.nextLine();
            
            switch(opcion) {
                case 1:
                    hospital.mostrarEstadoHospi();
                    break;
                case 2:
                    System.out.print("\nNombre del paciente    : ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad                   : ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Especialidad requerida :");
                    System.out.println("  1. Cardiologia \n  2. Traumatologia \n  3. Pediatria \n  4. Neurologia");
                    System.out.print("Seleccione especialidad  : ");
                    int esp = sc.nextInt();
                    
                    String especialidad = "";
                    if (esp == 1) {
                        especialidad = "Cardiologia";
                    } else if (esp == 2) {
                        especialidad = "Traumatologia";
                    } else if (esp == 3) {
                        especialidad = "Pediatria";
                    } else if (esp == 4) {
                        especialidad = "Neurologia";
                    }
                    
                    System.out.println("Nivel de urgencia        :");
                    System.out.println("  1. NORMAL \n  2. CRITICO");
                    System.out.print("Seleccione urgencia      : ");
                    int urg = sc.nextInt();
                    
                    String nivel = "";
                    if (urg == 1) {
                        nivel = "NORMAL";
                    } else if (urg == 2) {
                        nivel = "CRITICO";
                    }
                    
                    Paciente p = new Paciente(nombre, edad, especialidad, nivel);
                    hospital.ingresarPaciente(p);
                    break;
                case 3:
                    System.out.println("\n--- DAR DE ALTA ---");
                    System.out.print("Selecione el piso en el que está el paciente (1-4): ");
                    int piso = sc.nextInt();
                    System.out.print("Selecione la cama en la que está el paciente (1-6): ");
                    int cama = sc.nextInt();
                    hospital.darAlta(piso, cama);
                    break;
                case 4:
                    //listaEspera
                    break;
                case 5:
                    hospital.verCargaDoc();
                    break;
                case 6:
                    System.out.print("Digite el nombre del paciente que desea buscar: ");
                    String buscarNombre = sc.nextLine();
                    hospital.buscarPaciente(buscarNombre);
                    break;
                case 7:
                    hospital.reporteGeneral();
                    break;
                case 8:
                    System.out.println("Sistema cerrado");
                    break;
            }
        } while (opcion != 8);
        
        sc.close();
    }
}