public class Nodos {

    int Dato;

    String Nombre;

    Nodos HijoIzq, HijoDer;

    public Nodos (int Dato,String nom) {

        this.Dato = Dato;

        this.Nombre=nom;

        this.HijoDer = null;

        this.HijoIzq = null;

    }

    public String tostring()

    {

      return Nombre +"Su datos es "+ Dato;

    }

}