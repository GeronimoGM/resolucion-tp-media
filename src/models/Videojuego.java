package models;

import models.abstracts.Item;

public class Videojuego extends Item {
    private int version;

    public Videojuego(String titulo, String autor, String genero, int version) {
        super(titulo, autor, genero);
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return super.toString() + ", version=" + version + '}';
    }
}
