//Clase nodo
class Nodo {
    private int info;
    private Nodo siguiente;

    public Nodo(int info) {
        this.info = info;
        this.siguiente = null;
    }

    public Nodo(int info, Nodo siguiente) {
        this.info = info;
        this.siguiente = siguiente;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return this.info;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }
}

