

public class Main
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
}