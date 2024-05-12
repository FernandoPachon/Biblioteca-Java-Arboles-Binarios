import javax.swing.JOptionPane;

public class Arboles {

    public static void main(String[] args) {

        Arbol arbol = new Arbol();

        short opcion = 0;

        do {
            try {
                opcion = Short.parseShort(JOptionPane.showInputDialog(null, "Elige una opción:\n"
                        + "1. Ir a Libros.\n"
                        + "2. Ir a Usuarios.\n"
                        + "3. Ir a Prestamos.\n"
                        + "4. Salir", "Menú Principal: Biblioteca Fernando Pachón", JOptionPane.PLAIN_MESSAGE));

                switch (opcion) {
                    case 1:
                        menuLibros(arbol);
                        break;
                    case 2:
                        menuUsuarios(arbol);
                        break;
                    case 3:
                        menuPrestamos(arbol);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Gracias por usar nuestra biblioteca. ¡Hasta la próxima");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al digitar el número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 4);
    }

    public static void menuLibros(Arbol arbol) {
        short opcionLibros = 0;
        do {
            try {
                opcionLibros = Short.parseShort(JOptionPane.showInputDialog(null, "Menú de Libros:\n"
                        + "1. Agregar Libro.\n"
                        + "2. Mostrar Libros.\n"
                        + "3. Borrar Libros.\n"
                        + "4. Regresar al Menú Principal.", "Menú de Libros", JOptionPane.PLAIN_MESSAGE));
                switch (opcionLibros) {
                    case 1:
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del libro:"));
                        String nombreLibro = JOptionPane.showInputDialog("Ingrese el nombre del libro:");
                        arbol.InsertarDatos(codigo, nombreLibro);
                        JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");
                        break;
                    case 2:
                    if (!arbol.estaVacio()) {
                        /* JOptionPane.showMessageDialog(null, "Mostrando libros:");
                        mostrarLibros(arbol); */
                        submenuMostrarLibros(arbol);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay libros en el árbol.");
                    }
                    break;
                    case 3:
                        borrarDatos(arbol);
                        break;
                    case 4:
                        break; 
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al digitar el número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcionLibros != 4);
    }
    public static void submenuMostrarLibros(Arbol arbol) {
        short opcionMostrar = 0;
        do {
            try {
                opcionMostrar = Short.parseShort(JOptionPane.showInputDialog(null, "Submenú de Mostrar Libros:\n"
                        + "1. In-Order.\n"
                        + "2. Pre-Order.\n"
                        + "3. Post-Order.\n"
                        + "4. Regresar al Menú de Libros.", "Submenú de Mostrar Libros", JOptionPane.PLAIN_MESSAGE));
                switch (opcionMostrar) {
                    case 1:
                        if (!arbol.estaVacio()) {
                            JOptionPane.showMessageDialog(null, "Mostrando libros en In-Order:");
                            arbol.inOrder(arbol.Raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay libros en el árbol.");
                        }
                        break;
                    case 2:
                        if (!arbol.estaVacio()) {
                            arbol.preOrder( arbol.Raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay libros en el árbol.");
                        }
                        break;
                    case 3:
                        if (!arbol.estaVacio()) {
                            JOptionPane.showMessageDialog(null, "Mostrando libros en Post-Order:");
                            arbol.postOrder(arbol.Raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay libros en el árbol.");
                        }
                        break;
                    case 4:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al digitar el número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcionMostrar != 4);
    }
    public static void menuUsuarios(Arbol arbol) {
        short opcionUsuarios = 1;
        do {
            try {
                opcionUsuarios = Short.parseShort(JOptionPane.showInputDialog(null, "Menú de Libros:\n"
                        + "1. Agregar Usuarios.\n"
                        + "2. Mostrar Usuarios.\n"
                        + "3. Borrar Usuarios.\n"
                        + "4. Regresar al Menú Principal.", "Menú de Libros", JOptionPane.PLAIN_MESSAGE));
                switch (opcionUsuarios) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Agrega un Id que contenga al menos 3 dígitos.");
                        agregarUsuario(arbol);
                        //JOptionPane.showMessageDialog(null, "Opción no implementada aún.");
                        break;
                    case 2:
                        if (!arbol.estaVacio()) {
                            //JOptionPane.showMessageDialog(null, "Mostrando usuarios:");
                            //mostrarUsuarios(arbol);
                            submenuMostrarUsuarios(arbol);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay usuarios registrados en el árbol.");
                        }
                        break;
                    case 3:
                        if (!arbol.estaVacio()) {
                            borrarDatos(arbol);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay usuarios registrados en el árbol.");
                        }
                        break;
                    case 4:
                        break; 
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al digitar el número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcionUsuarios != 4);
    }
    public static void submenuMostrarUsuarios(Arbol arbol) {
        short opcionMostrar = 0;
        do {
            try {
                opcionMostrar = Short.parseShort(JOptionPane.showInputDialog(null, "Submenú de Mostrar Libros:\n"
                        + "1. In-Order.\n"
                        + "2. Pre-Order.\n"
                        + "3. Post-Order.\n"
                        + "4. Regresar al Menú de Libros.", "Submenú de Mostrar Libros", JOptionPane.PLAIN_MESSAGE));
                switch (opcionMostrar) {
                    case 1:
                        if (!arbol.estaVacio()) {
                            JOptionPane.showMessageDialog(null, "Mostrando libros en In-Order:");
                            arbol.inOrder(arbol.Raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay libros en el árbol.");
                        }
                        break;
                    case 2:
                        if (!arbol.estaVacio()) {
                            arbol.preOrder( arbol.Raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay libros en el árbol.");
                        }
                        break;
                    case 3:
                        if (!arbol.estaVacio()) {
                            JOptionPane.showMessageDialog(null, "Mostrando libros en Post-Order:");
                            arbol.postOrder(arbol.Raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay libros en el árbol.");
                        }
                        break;
                    case 4:
                        break; 
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al digitar el número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcionMostrar != 3);
    }
    public static void menuPrestamos(Arbol arbol) {
        short opcionPrestamos = 2;
        do {
            try {
                opcionPrestamos = Short.parseShort(JOptionPane.showInputDialog(null, "Menú de Libros:\n"
                        + "1. Agregar Un Prestamo.\n"
                        + "2. Mostrar Prestamos.\n"
                        + "3. Borrar Prestamos.\n"
                        + "4. Regresar al Menú Principal.", "Menú de Libros", JOptionPane.PLAIN_MESSAGE));
                switch (opcionPrestamos) {
                    case 1:
                        agregarPrestamo(arbol);
                        break;
                    case 2:
                        mostrarPrestamos(arbol);
                        break;
                    case 3:
                        borrarDatos(arbol);
                        break;
                    case 4:
                        break; 
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al digitar el número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcionPrestamos != 4);
    }
    public static void mostrarLibros(Arbol arbol) {
        arbol.inOrder(arbol.Raiz);
    }
    public static void agregarUsuario(Arbol arbol) {
        try {
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario:"));
            String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
            arbol.InsertarDatos(idUsuario, nombreUsuario);
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el ID del usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void mostrarUsuarios(Arbol arbol) {
        if (!arbol.estaVacio()) {
            JOptionPane.showMessageDialog(null, "Mostrando usuarios:");
            arbol.inOrder(arbol.Raiz);
        } else {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados en el árbol.");
        }
    }
    public static void borrarDatos(Arbol arbol) {
        try {
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a borrar:"));
            boolean borrado = arbol.borrarNodo(idUsuario);
            if (borrado) {
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el ID del usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void agregarPrestamo(Arbol arbol) {
        try {
            JOptionPane.showMessageDialog(null, "Préstamo registrado correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos del préstamo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void mostrarPrestamos(Arbol arbol) {
        if (!arbol.estaVacio()) {
            JOptionPane.showMessageDialog(null, "Mostrando prestamos:");
            mostrarPrestamosRecursivo(arbol);
        } else {
            JOptionPane.showMessageDialog(null, "No hay prestamos registrados en el árbol.");
        }
    }
    private static void mostrarPrestamosRecursivo(Arbol arbol) {
        if (arbol != null) {
           // mostrarPrestamosRecursivo(arbol.Raiz);
    
            // Mostrar información del préstamo (libro y usuario)
            JOptionPane.showMessageDialog(null, "Libro prestado: " + arbol.Raiz.Dato + ", Nombre: " + arbol.Raiz.Nombre + ", Al usuario: " + arbol.Raiz.HijoDer.Nombre);
        }
    }
    
}

