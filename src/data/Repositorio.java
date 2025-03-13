package data;

import exceptions.FechaLanzamientoNulaException;
import exceptions.IdDuplicadaException;
import exceptions.ItemNoEncontradoException;
import exceptions.VersionNoPositivaException;
import models.Expansion;
import models.Videojuego;
import models.abstracts.Item;

import java.util.Map;
import java.util.TreeMap;

public class Repositorio<T extends Item> { //
    private Map<String, T> map = new TreeMap<>();

    public Repositorio() {}

    public void agregar(T item) throws IdDuplicadaException, VersionNoPositivaException, FechaLanzamientoNulaException {
        if (map.containsKey(item.getId())) {
            throw new IdDuplicadaException("This ID");
        }
        if (item instanceof Videojuego videojuego) {
            if (!(videojuego.getVersion() > 0)) {
                throw new VersionNoPositivaException("La versión debe ser positiva");
            }
        }
        if (item instanceof Expansion expansion) {
            if (expansion.getLanzamiento() == null) {
                throw new FechaLanzamientoNulaException("La fecha de lanzamiento no puede ser nula");
            }
        }
        map.put(item.getId(), item);
    }

    public void eliminar(String id) throws ItemNoEncontradoException {
        if (map.remove(id) == null) {
            throw new ItemNoEncontradoException("El item con la id: " + id + " no existe");
        }
    }

    public void mostrar() {
        map.values().forEach(System.out::println);
    }

    public void filtrar(String genero) {
        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getGenero().equals(genero))
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    public void modificar(String id, T item) throws ItemNoEncontradoException {
        if (!map.containsKey(id)) {
            throw new ItemNoEncontradoException("El item con la id: " + id + " no existe");
        }
        map.put(id, item);
    }
}
