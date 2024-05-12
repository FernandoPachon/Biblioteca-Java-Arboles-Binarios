import javax.swing.JOptionPane;

public class Arbol {

    Nodos Raiz;

    public Arbol () { 

        Raiz = null;

    }

    public boolean estaVacio(){

        return Raiz == null;

    }

    public void InsertarDatos(int dato,String nom){

        Nodos nuevo = new Nodos(dato,nom);

        if (estaVacio())

            Raiz = nuevo;

        else {

            Nodos aux = Raiz, Padre;

            while (true) {

                Padre = aux;

                if (dato < aux.Dato){

                    aux = aux.HijoIzq;

                    if (aux == null){

                        Padre.HijoIzq = nuevo;

                        return;

                    }

                } else {

                    aux = aux.HijoDer;

                    if (aux == null){

                        Padre.HijoDer = nuevo;

                        return;

                    }

                }

            }

        }

    }


    public void inOrder (Nodos Nodo) {

        if (Nodo != null){

            inOrder(Nodo.HijoIzq);

            /*System.out.println(Nodo.Dato);*/

            JOptionPane.showMessageDialog(null, Nodo.Dato +" "+Nodo.Nombre );

            inOrder(Nodo.HijoDer);

        }

    }


    public void preOrder (Nodos Nodo) {

        if (Nodo != null){

            /* System.out.println(Nodo.Dato); */

            JOptionPane.showMessageDialog(null, Nodo.Dato +" "+Nodo.Nombre );

            preOrder(Nodo.HijoIzq);

            preOrder(Nodo.HijoDer);

        }

    }


    public void postOrder (Nodos Nodo) {

        if (Nodo != null){

            postOrder(Nodo.HijoIzq);

            postOrder(Nodo.HijoDer);

           // System.out.println(Nodo.Dato);

        JOptionPane.showMessageDialog(null, Nodo.Dato +" "+Nodo.Nombre );

        }

    }
    
    public boolean buscar(Nodos nodo, int dato) {
        if (nodo == null) {
            return false;
        }

        if (nodo.Dato == dato) {
            JOptionPane.showMessageDialog(null, "Nodo encontrado: Dato: " + nodo.Dato + ", Nombre: " + nodo.Nombre);
            return true;
        }

        if (dato < nodo.Dato) {
            return buscar(nodo.HijoIzq, dato);
        } else {
            return buscar(nodo.HijoDer, dato);
        }
    }
    public boolean borrarNodo(int dato) {
        if (estaVacio()) {
            return false;
        } else {
            Raiz = borrar(Raiz, dato);
            return true;
        }
    }
    public Nodos borrar(Nodos nodo, int dato) {
        if (nodo == null) {
            return null;
        }

        if (dato < nodo.Dato) {
            nodo.HijoIzq = borrar(nodo.HijoIzq, dato);
        } else if (dato > nodo.Dato) {
            nodo.HijoDer = borrar(nodo.HijoDer, dato);
        } else {
            if (nodo.HijoIzq == null) {
                return nodo.HijoDer;
            } else if (nodo.HijoDer == null) {
                return nodo.HijoIzq;
            }

            nodo.Dato = encontrarMinimo(nodo.HijoDer);
            nodo.HijoDer = borrar(nodo.HijoDer, nodo.Dato);
        }

        return nodo;
    }

    private int encontrarMinimo(Nodos nodo) {
        int min = nodo.Dato;
        while (nodo.HijoIzq != null) {
            min = nodo.HijoIzq.Dato;
            nodo = nodo.HijoIzq;
        }
        return min;
    }
}


