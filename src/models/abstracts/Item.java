package models.abstracts;

import java.util.UUID;

public abstract class Item implements Comparable<Item> {
    private final String id = UUID.randomUUID().toString();
    private String titulo;
    private String creador;
    private String genero;

    public Item(String titulo, String creador, String genero) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int compareTo(Item o) {
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'';
    }
}
