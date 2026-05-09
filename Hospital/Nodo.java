

// ============================================================
// CLASE NODO
// Representa cada elemento de la lista enlazada (lista de espera).
// Cada nodo guarda un paciente y una referencia al siguiente nodo.
// ============================================================
public class Nodo {
    private Paciente paciente; // El paciente almacenado en este nodo
    private Nodo next;         // Referencia al siguiente nodo en la lista
 
    // Constructor: crea un nodo con un paciente, sin sucesor aún
    public Nodo(Paciente p) {
        this.paciente = p;
        this.next = null;
    }
 
    // Asigna un nuevo paciente a este nodo
    public void setPaciente(Paciente p) {
        this.paciente = p;
    }
 
    // Enlaza este nodo con el siguiente
    public void setNext(Nodo n) {
        this.next = n;
    }
 
    // Devuelve el paciente almacenado en este nodo
    public Paciente getPaciente() {
        return this.paciente;
    }
 
    // Devuelve el siguiente nodo en la lista
    public Nodo getNext() {
        return this.next;
    }
}

    