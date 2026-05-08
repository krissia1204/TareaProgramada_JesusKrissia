import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Cifrador cifrado= new Cifrador();
        
        Hospital hospital = new Hospital();
        int intento= 0;
        
        String usuario= "";
        String password= "";
        
        do{
        
        System.out.println("\n============================================");
        System.out.println(" Digite un usuario valido para ingresar al sistema.");
        System.out.println("============================================");
        usuario= sc.nextLine();
        System.out.println("\n============================================");
        System.out.println(" Digite la contraseña.");
        System.out.println("============================================");
        password = sc.nextLine();
        
        
      
            if(cifrado.verificar(usuario,password,"admin","#Y6L!6*6")){
        
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
            }   while (opcion != 8);
            }
    
        else{
        intento ++;
        int rest= 3-intento;
        System.out.println("Credenciales incorrectas intente de nuevo. Intentos restantes: "+rest);
        }
    } while(intento<3&&!cifrado.verificar(usuario,password,"admin","#Y6L!6*6"));
        
        sc.close();
    }
}
/*public class Main
{
   public static void main (String[] args){
       
       Paciente p1 = new Paciente("Luis",22, "Cardiologia", "CRITICO");
       Paciente p2 = new Paciente("Ana",19, "Cardiologia", "CRITICO");
       Paciente p3 = new Paciente("Jose",2, "Pediatria", "CRITICO");
       Paciente p4 = new Paciente("Gonzalo",13, "Pediatria", "NORMAL");
       
       Doctor d1= new Doctor ("José", "Cardiologia");
       Doctor d2= new Doctor ("Carlos", "Cardiologia");
       Doctor d3= new Doctor ("Jesus", "Traumatologia");
       Doctor d4= new Doctor ("Maria", "Traumatologia");
       Doctor d5= new Doctor ("Krissia", "Pediatria");
       Doctor d6= new Doctor ("Domingo", "Pediatria");
       Doctor d7= new Doctor ("Cristian", "Neurologia");
       Doctor d8= new Doctor ("Cristina", "Neurologia");
       
       Hospital h= new Hospital();
       h.setDoctor(0,d1);
       h.setDoctor(1,d2);
       h.setDoctor(2,d3);
       h.setDoctor(3,d4);
       h.setDoctor(4,d5);
       h.setDoctor(5,d6);
       h.setDoctor(6,d7);
       h.setDoctor(7,d8);
      
       h.ingresarPaciente(p1);
       h.mostrarEstadoHospi();
       h.verCargaDoc();
   }
} */