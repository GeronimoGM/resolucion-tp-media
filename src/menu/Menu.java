package menu;

import data.Repositorio;
import models.Expansion;
import models.Videojuego;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private boolean iniciado = false;

    private final Repositorio<Videojuego> videojuegos = new Repositorio<>();
    private final Repositorio<Expansion> expansiones = new Repositorio<>();

    public Menu() {}

    public void iniciar() {
        this.sc = new Scanner(System.in);
        this.iniciado = true;

        while (iniciado) {
            System.out.println("1. Añadir videojuego");
            System.out.println("2. Añadir expansion");
            System.out.println("3. Mostrar todos los videojuegos ordenados por título");
            System.out.println("4. Mostrar todas las expansiones ordenadas por título");
            System.out.println("5. Mostrar videojuegos filtrados por género");
            System.out.println("6. Mostrar expansiones filtradas por género");
            System.out.println("7. Eliminar videojuego");
            System.out.println("8. Eliminar expansión");
            System.out.println("9. Modificar videojuego");
            System.out.println("10. Modificar expansión");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 0:
                    this.parar();
                    break;
                case 1:
                    agregarVideojuego();
                    break;
                case 2:
                    agregarExpansion();
                    break;
                case 3:
                    mostrarVideojuegos();
                    break;
                case 4:
                    mostrarExpansiones();
                    break;
                case 5:
                    filtrarVideojuegosPorGenero();
                    break;
                case 6:
                    filtrarExpansionesPorGenero();
                    break;
                case 7:
                    eliminarVideojuego();
                    break;
                case 8:
                    eliminarExpansion();
                    break;
                case 9:
                    modificarVideojuego();
                    break;
                case 10:
                    modificarExpansion();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public void parar() {
        this.iniciado = false;
        this.sc.close();
    }

    private void agregarVideojuego() {
        System.out.print("Ingrese el título del videojuego: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el creador del videojuego: ");
        String creador = sc.nextLine();
        System.out.print("Ingrese el género del videojuego: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese la versión del videojuego: ");
        int version = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        Videojuego videojuego = new Videojuego(titulo, creador, genero, version);
        try {
            videojuegos.agregar(videojuego);
            System.out.println("Videojuego añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al añadir el videojuego: " + e.getMessage());
        }
    }

    private void agregarExpansion() {
        System.out.print("Ingrese el título de la expansión: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el creador de la expansión: ");
        String creador = sc.nextLine();
        System.out.print("Ingrese el género de la expansión: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese la fecha de lanzamiento de la expansión (yyyy-MM-dd): ");
        String fechaStr = sc.nextLine();

        try {
            LocalDate lanzamiento = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
            Expansion expansion = new Expansion(titulo, creador, genero, lanzamiento);
            expansiones.agregar(expansion);
            System.out.println("Expansión añadida correctamente.");
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Error al añadir la expansión: " + e.getMessage());
        }
    }

    private void mostrarVideojuegos() {
        System.out.println("Listado de videojuegos:");
        videojuegos.mostrar();
    }

    private void mostrarExpansiones() {
        System.out.println("Listado de expansiones:");
        expansiones.mostrar();
    }

    private void filtrarVideojuegosPorGenero() {
        System.out.print("Ingrese el género para filtrar los videojuegos: ");
        String genero = sc.nextLine();
        System.out.println("Videojuegos del género " + genero + ":");
        videojuegos.filtrar(genero);
    }

    private void filtrarExpansionesPorGenero() {
        System.out.print("Ingrese el género para filtrar las expansiones: ");
        String genero = sc.nextLine();
        System.out.println("Expansiones del género " + genero + ":");
        expansiones.filtrar(genero);
    }

    private void eliminarVideojuego() {
        System.out.print("Ingrese el ID del videojuego a eliminar: ");
        String id = sc.nextLine();
        try {
            videojuegos.eliminar(id);
            System.out.println("Videojuego eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el videojuego: " + e.getMessage());
        }
    }

    private void eliminarExpansion() {
        System.out.print("Ingrese el ID de la expansión a eliminar: ");
        String id = sc.nextLine();
        try {
            expansiones.eliminar(id);
            System.out.println("Expansión eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar la expansión: " + e.getMessage());
        }
    }

    private void modificarVideojuego() {
        System.out.print("Ingrese el ID del videojuego a modificar: ");
        String id = sc.nextLine();
        System.out.print("Ingrese el nuevo título del videojuego: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el nuevo creador del videojuego: ");
        String creador = sc.nextLine();
        System.out.print("Ingrese el nuevo género del videojuego: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese la nueva versión del videojuego: ");
        int version = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        Videojuego videojuego = new Videojuego(titulo, creador, genero, version);
        try {
            videojuegos.modificar(id, videojuego);
            System.out.println("Videojuego modificado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al modificar el videojuego: " + e.getMessage());
        }
    }

    private void modificarExpansion() {
        System.out.print("Ingrese el ID de la expansión a modificar: ");
        String id = sc.nextLine();
        System.out.print("Ingrese el nuevo título de la expansión: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el nuevo creador de la expansión: ");
        String creador = sc.nextLine();
        System.out.print("Ingrese el nuevo género de la expansión: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese la nueva fecha de lanzamiento de la expansión (yyyy-MM-dd): ");
        String fechaStr = sc.nextLine();

        try {
            LocalDate lanzamiento = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
            Expansion expansion = new Expansion(titulo, creador, genero, lanzamiento);
            expansiones.modificar(id, expansion);
            System.out.println("Expansión modificada correctamente.");
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Error al modificar la expansión: " + e.getMessage());
        }
    }
}