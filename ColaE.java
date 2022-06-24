import java.util.Scanner; // Importamos la libreria para la entrada de datos
import javax.swing.JOptionPane; //Importaos la libreria para los mensajes de JOption

class ColaE {  // Creamos la clase ColaE donde iran las funciones
    Nodo Primero, Final; //declaramos los punteros de primero y final
    int pos; // Declaramos la variable pos par ala posicion
    Scanner t = new Scanner(System.in); // Declaramos la variable para la recoleccion de datos

    public ColaE(){ // creamos de manera publica la variabel ColaE
        Primero = null; //apuntamos el primero a null= nada
        Final = null; //apuntamos el final a null= nada
        pos = 0; // Iniciamos la posicion en 0
    }
    private Boolean ColaesVacia() { // Creamos la funcion para saber cuando la cola se encuentre vacia
        return this.Primero == null; // retornamos el primero a nada cuando esta se encuentre vacia
    }
    private void mensaje(String cad) { // Declaramos de manera privada un string para la variable mensaje, que sera para imprimir los mensajes
        System.out.println(cad);
    }
    private int LeerDato() { // cremaos la funcion para leer los datos ingresados por el usuario
        mensaje(" INGRESE EL DATO : "); // mostramos un mensaje pidiendole al usuario que ingrese los datos correspondientes
        return t.nextInt(); // guardamos el dato ingresado en la variable t del Scannes, lo cual lo retornara
    }
    private void InsertaPrimero(int dato) { // creamos la funcion para ingresar los datos en primer lugar
        Nodo nuevo = new Nodo(dato); // creamos un nodo nuevo con el dato ingresado
        Primero = nuevo; // el priemer dato ingreado sera el nuevo nodo
        Final = nuevo; // el dato final sera uno nuevo
        pos++; // aunmentamos la posicion
    }
    private void InsertarInicio() { // Creamos la funcion para ingresar los datos al inicio de la cola
        int v; //declaramos la varible v para la validacion
        int dato; // declaramos la variable dato para la informacion
        do{
            try{ // En esta parte va la validacion, en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
                v=0;
                dato = LeerDato(); // dato sera igual a la funcion de LeerDato
                if (ColaesVacia()) // hacemos la comparacion, si  la cola es vacia
                    InsertaPrimero(dato); // entonces insertamos el nuevo dato en primer lugar de le cola
                else { // si la cola no esta vacia
                    Nodo nuevo = new Nodo (dato); // entonces creamos un nuevo nodo para el nuevo dato
                    nuevo.setSiguiente(Primero); // enlazamos el nuevo dato al primero
                    Primero = nuevo; // insertamos el nuevo dato al primer lugar
                    pos++; // Y aumentamos el tamaño de la cola
                }
                JOptionPane.showMessageDialog (null," DATO INSERTADO EN LA COLA "); // Mandamos un mensaje de confirmacion cunado el dato se haya insertado correctamente
            }catch(Exception e){ // declaramos la variable e para la execpion de la validacion
                JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
                v=1; 
                t.nextLine();
            }
        }while(v != 0); // Final de la validación. //
    }
    private void EliminarFinal() { // cremaos el constructor para eliminar el dato del final de la cola
        if (ColaesVacia()) // Hacemos la comparacion, si la cola esta vacia
        JOptionPane.showMessageDialog(null," COLA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); //mandamos un mensaje al usuario de que la cola esta vacia y por lo tanto no se puede eliminar ningun dato
        else{ // si la cola no esta vacia
            Nodo n; // creamos un nuevo nodo con la variable n
            n=Primero; // el nodo creado con la varible n sera el primero
            while (n!=null){ // si el nodo es es diferente de nada
                if (n.getSiguiente()==Final){ // si el nodo n  es igual al final
                    Final = n; // entonces el Final sera el nodo n
                    n.setSiguiente(null); // apuntamos el nodo n a nada
                    JOptionPane.showMessageDialog(null," DATO ELIMINADO ");  // madnamos un mensaje de confirmacion cuando el dato se haya eliminado
                }
                n = n.getSiguiente();
            }
            Listar(); // Listamos los datos disponibles en la lista
        }
    }
    private void Listar() { // Creamos el constructor para la funcipn de Listar
        if(ColaesVacia()) // hacemos la comparacion, si la cola esta vacia
        JOptionPane.showMessageDialog(null," COLA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); //mandamos un mensaje al usuario de que la cola esta vacia y por lo tanto no se puede eliminar ningun dato
        else{  // si la cola no esta vacia
            Nodo r = Primero; // apuntamos un nuevo nodo r al primero
            int c=1; // declaramos la varible c para mostrar el lugar de cada dato
            while(r!=null){ //mientras r sea diferente de nada
                mensaje("POSICION NUMERO [" + c + "], VALOR INSERTADO = " + r.getInfo() + ", DIRECCION -->"+ r.getSiguiente()); //Imprimimos la posicion, el valor y la direccion de los valores insertados
                r=r.getSiguiente();
                c++; // cada que se inserte un nuevo dato el lugar aumentara 1 lugar más
            }
        }
    }
    private void Vaciar() { //Creamos el constructor para la funcion de vaciar toda la cola
        if (ColaesVacia()) // Hacemos la comparación, si la cola esta vaci
        JOptionPane.showMessageDialog(null," COLA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); //mandamos un mensaje al usuario de que la cola esta vacia y por lo tanto no se puede eliminar ningun dato
        else{ // si la cola no esta vacia
            Primero = Final = null; //entonces apuntamos el primer nodo y el final a nada
            pos = 0; // y la posicion la pasamos a 0
            JOptionPane.showMessageDialog(null, " LA COLA SE HA VACIADO COMPLETAMENTE "); // mandamos un mensaje de confimacion cuando la cola se haya vaciado completamente
            JOptionPane.showMessageDialog(null," LA COLA YA ESTA VACIA "); // y mandamos un mensaje de que la cola ya se encuantra vacia
        }
    }
    private void TamanioDeLaCola(){ // Creamos la funcion para el tamanio de la pila //
        if (ColaesVacia()) // Hacemos la comparacion de si es vacia
        JOptionPane.showMessageDialog(null, " COLA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // si si es vacia, mostramos el mensaje de que la pila esta vacia
        else{ // si no
        JOptionPane.showMessageDialog(null, " LA LONGITUD DE LA COLA ES DE : "+ pos); // mostramos la longitud de la pila.
        return;
        }
    }
    public void menu() { //Creamos el constructor para el menu
        int v;
        int op;
        do{
            try{ // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
                v=0;
                do {   // Menu //
                    mensaje(" _________________________________ ");
                    mensaje("|        MENU DE OPCIONES         |");
                    mensaje("|                                 |");
                    mensaje("|  1. INSERTAR AL INICIO          |");
                    mensaje("|  2. ELIMINAR FINAL              |");
                    mensaje("|  3. LISTAR ELEMENTOS            |");
                    mensaje("|  4. ELIMINAR TODA LA COLA       |");
                    mensaje("|  5. TAMANIO DE LA COLA          |");
                    mensaje("|  6. SALIR                       |");
                    mensaje("|                                 |");
                    mensaje("|---------------------------------|");
                    mensaje("|         ELIJA SU OPCION         |");
                    mensaje(" --------------------------------- ");
                    op = t.nextInt();
                        switch (op) {
                        case 1:InsertarInicio();
                            break;
                        case 2:EliminarFinal();
                            break;
                        case 3:Listar();
                            break;
                        case 4:Vaciar();
                            break;
                        case 5:TamanioDeLaCola();
                            break;
                        case 6:
                            break;
                        default:
                        JOptionPane.showMessageDialog(null, " NO EXISTE ESA OPCION ", " ERROR ", JOptionPane.ERROR_MESSAGE); //mandamos un mensaje cuando el usuario ingrese una opcion que no se encuentre en el menu
                    }
                } while (op != 6);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario no haya ingresado caracteres validos //
                v=1;
                t.nextLine();
            }
        }while(v != 0); // Final de la validacion. //
    }
    public static void main(String[] args) {
        ColaE c = new ColaE();
        c.menu();
    }
}