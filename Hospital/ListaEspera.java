

// ============================================================
// CLASE LISTAESPERA
// Lista enlazada simple que almacena pacientes que no pudieron
// ser internados de inmediato. Se atienden en orden de llegada,
// pero dando prioridad a pacientes CRITICOS al reasignar camas.
// ============================================================
public class ListaEspera {
    Nodo cabeza; // Primer nodo de la lista
 
    // Constructor: lista vacía
    public ListaEspera() {
        this.cabeza = null;
    }
 
    public Nodo getCabeza() {
        return this.cabeza;
    }

 
    // Agrega un paciente al final de la lista de espera
    public void agregarAlFinal(Paciente p) {
        Nodo nuevo = new Nodo(p);
        Nodo actual = cabeza;
 
        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo es la cabeza
            this.cabeza = nuevo;
        } else {
            // Recorre hasta el último nodo y enlaza el nuevo al final
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
        }
        }
    
    public void setCabeza(Nodo n){
        this.cabeza= n;
    }
    
 
    // Extrae y devuelve el paciente en una posición específica
    public Paciente extraerPosicion(int posicion) {
        int contador = 0;
        Paciente p = null;
        Nodo actual = cabeza;
 
        if (posicion == 0) {
            // Caso especial: extraer el primero de la lista
            p = cabeza.getPaciente();
            cabeza = cabeza.getNext();
        } else {
            // Avanza hasta el nodo anterior a la posición buscada
            while (actual != null && contador < posicion - 1) {
                actual = actual.getNext();
                contador++;
            }
            // Extrae el nodo y reencadena la lista
            Nodo extraer = actual.getNext();
            p = extraer.getPaciente();
            actual.setNext(extraer.getNext());
        }
 
        return p;
    }
 
    // Busca un paciente por nombre (sin distinguir mayúsculas/minúsculas)
    public Paciente buscarCandidato(String nombre) {
        Paciente p = null;
        Nodo actual = cabeza;
 
        while (actual != null) {
            if (actual.getPaciente().getNombre().equalsIgnoreCase(nombre)) {
                p = actual.getPaciente();
            }
            actual = actual.getNext();
        }
 
        return p;
    }
 
    // Muestra todos los pacientes en lista de espera con su posición
    public void mostrar() {
        Nodo actual = cabeza;
        int contador = 0;
 
        while (actual != null) {
            contador++;
            actual.getPaciente().imprimirDetalles();
            System.out.println("Posicion del paciente en LE: " + contador);
            actual = actual.getNext();
        }
    }
}