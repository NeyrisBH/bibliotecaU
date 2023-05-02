package com.ucompensar.biblioteca;

import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Neyris
 */
public class Biblioteca {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Libro[][] libros = new Libro[3][5];
        int fila = 0;
        int columna = 0;

        // Creamos algunos libros
        libros[fila][columna] = new Libro(001, 96, "El principito", "Antoine de Saint-Exupéry", "Fábula");
        columna++;
        libros[fila][columna] = new Libro(002, 432, "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico");
        columna++;
        libros[fila][columna] = new Libro(003, 863, "El Quijote", "Miguel de Cervantes", "Novela");
        columna = 0;
        fila++;

        //Añadir Libro
        System.out.println("Ingrese los datos del nuevo libro:");
        System.out.println("------------------------");
        libros[fila][columna] = lecturaDatos(input);

        //Añadir espacios si no hay
        columna++;
        if (columna >= libros[0].length) {
            columna = 0;
            fila++;
            if (fila >= libros.length) {
                Libro[][] temporal = new Libro[libros.length + 1][libros[0].length];
                for (int i = 0; i < libros.length; i++) {
                    for (int j = 0; j < libros[i].length; j++) {
                        temporal[i][j] = libros[i][j];
                    }
                }
                libros = temporal;
            }
        }
        imprimirDatos(libros);

        // Actualizar un libro
        System.out.print("Ingrese el código del libro a actualizar: ");
        int codigo = input.nextInt();
        input.nextLine(); // Consumir el salto de línea después del número
        Libro libroEncontrado = buscarLibroPorCodigo(libros, codigo);
        if (libroEncontrado != null) {
            System.out.println("Ingrese los nuevos datos del libro:");
            Libro libroActualizado = lecturaDatos(input);
            libroEncontrado.setCodigoLibro(libroActualizado.getCodigoLibro());
            libroEncontrado.setNombreLibro(libroActualizado.getNombreLibro());
            libroEncontrado.setAutorLibro(libroActualizado.getAutorLibro());
            libroEncontrado.setMateriaLibro(libroActualizado.getMateriaLibro());
            libroEncontrado.setNumeroPaginas(libroActualizado.getNumeroPaginas());
        } else {
            System.out.println("El libro no existe");
        }
        imprimirDatos(libros);

        eliminarLibroPorCodigo(libros, codigo);
        imprimirDatos(libros);

        buscarLibroPorNombre(libros, "nombreDelLibro");
    }

    public static Libro lecturaDatos(Scanner input) {
        System.out.println("Ingrese el código del libro:");
        int codigo = input.nextInt();
        input.nextLine(); // Consumir el salto de línea después del número
        System.out.println("Ingrese el nombre del libro:");
        String nombre = input.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = input.nextLine();
        System.out.println("Ingrese la materia del libro:");
        String materia = input.nextLine();
        System.out.println("Ingrese el número de páginas del libro:");
        int numPaginas = input.nextInt();
        input.nextLine(); // Consumir el salto de línea después del número
        return new Libro(codigo, numPaginas, nombre, autor, materia);
    }

    public static void imprimirDatos(Libro[][] libros) {
        // Imprimimos la información de los libros
        System.out.println("Libros registrados:");
        System.out.println("------------------------");
        System.out.println("------------------------");
        for (int i = 0; i < libros.length; i++) {
            for (int j = 0; j < libros[i].length; j++) {
                if (libros[i][j] != null) {
                    System.out.println("Código: " + libros[i][j].getCodigoLibro());
                    System.out.println("Nombre: " + libros[i][j].getNombreLibro());
                    System.out.println("Autor: " + libros[i][j].getAutorLibro());
                    System.out.println("Materia: " + libros[i][j].getMateriaLibro());
                    System.out.println("Número de páginas: " + libros[i][j].getNumeroPaginas());
                    System.out.println("------------------------");
                }
            }
        }
    }

    public static Libro buscarLibroPorCodigo(Libro[][] libros, int codigo) {
        for (int i = 0; i < libros.length; i++) {
            for (int j = 0; j < libros[i].length; j++) {
                if (libros[i][j] != null && Integer.valueOf(libros[i][j].getCodigoLibro()).equals(codigo)) {
                    return libros[i][j];
                }
            }
        }
        return null; // Si no se encontró el libro con el código dado
    }

    public static void eliminarLibroPorCodigo(Libro[][] libros, int codigo) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el código del libro a eliminar: ");
        int codigoEliminar = input.nextInt();
        input.nextLine(); // Consumir el salto de línea después del número
        Libro libroEncontrado = buscarLibroPorCodigo(libros, codigoEliminar);

        if (libroEncontrado != null) {
            for (int i = 0; i < libros.length; i++) {
                for (int j = 0; j < libros[i].length; j++) {
                    if (libros[i][j] == libroEncontrado) {
                        libros[i][j] = null;
                    }
                }
            }
            System.out.println("El libro ha sido eliminado.");
        } else {
            System.out.println("El libro no ha sido encontrado.");
        }
    }

    public static void buscarLibroPorNombre(Libro[][] libros, String nombre) {
        boolean encontrado = false;
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el nombre del libro a buscar: ");
        String nombreBuscar = input.nextLine();
        for (int i = 0; i < libros.length; i++) {
            for (int j = 0; j < libros[i].length; j++) {
                if (libros[i][j] != null && libros[i][j].getNombreLibro().toLowerCase().contains(nombreBuscar.toLowerCase())) {
                    System.out.println("Código: " + libros[i][j].getCodigoLibro());
                    System.out.println("Nombre: " + libros[i][j].getNombreLibro());
                    System.out.println("Autor: " + libros[i][j].getAutorLibro());
                    System.out.println("Materia: " + libros[i][j].getMateriaLibro());
                    System.out.println("Número de páginas: " + libros[i][j].getNumeroPaginas());
                    System.out.println("----------------------");
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros con ese nombre.");
        }
    }

    public static void ordenarLibros(Libro[][] libros, String campo, String metodo) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese ");
        // Se define la variable de comparación dependiendo del campo elegido
        Comparator<Libro> comparador = null;
        switch (campo) {
            case "código":
                comparador = Comparator.comparing(Libro::getCodigoLibro);
                break;
            case "nombre":
                comparador = Comparator.comparing(Libro::getNombreLibro);
                break;
            case "autor":
                comparador = Comparator.comparing(Libro::getAutorLibro);
                break;
            case "materia":
                comparador = Comparator.comparing(Libro::getMateriaLibro);
                break;
            case "páginas":
                comparador = Comparator.comparingInt(Libro::getNumeroPaginas);
                break;
            default:
                System.out.println("Campo de ordenamiento inválido");
                return;
        }

        // Se define el método de ordenamiento a utilizar
        switch (metodo) {
            case "burbuja":
                for (int i = 0; i < libros.length; i++) {
                    for (int j = 0; j < libros[i].length - 1; j++) {
                        for (int k = j + 1; k < libros[i].length; k++) {
                            if (libros[i][k] != null && (libros[i][j] == null || comparador.compare(libros[i][k], libros[i][j]) < 0)) {
                                Libro temp = libros[i][k];
                                libros[i][k] = libros[i][j];
                                libros[i][j] = temp;
                            }
                        }
                    }
                }
                break;
            case "selección":
                for (int i = 0; i < libros.length; i++) {
                    for (int j = 0; j < libros[i].length - 1; j++) {
                        int minIndex = j;
                        for (int k = j + 1; k < libros[i].length; k++) {
                            if (libros[i][k] != null && (libros[i][minIndex] == null || comparador.compare(libros[i][k], libros[i][minIndex]) < 0)) {
                                minIndex = k;
                            }
                        }
                        if (minIndex != j) {
                            Libro temp = libros[i][minIndex];
                            libros[i][minIndex] = libros[i][j];
                            libros[i][j] = temp;
                        }
                    }
                }
                break;
            case "inserción":
                for (int i = 0; i < libros.length; i++) {
                    for (int j = 1; j < libros[i].length; j++) {
                        if (libros[i][j] == null) {
                            break;
                        }
                        Libro temp = libros[i][j];
                        int k = j - 1;
                        while (k >= 0 && comparador.compare(libros[i][k], temp) > 0) {
                            libros[i][k + 1] = libros[i][k];
                            k--;
                        }
                        libros[i][k + 1] = temp;
                    }
                }
                break;
            default:
                System.out.println("Método de ordenamiento inválido");
                return;
        }

        // Se imprime la lista de libros ordenada
        imprimirDatos(libros);
    }

}
