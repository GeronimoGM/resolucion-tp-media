package models;

import models.abstracts.Item;

import java.time.LocalDate;

public class Expansion extends Item {
    private LocalDate lanzamiento;

    public Expansion(String titulo, String autor, String genero, LocalDate lanzamiento) {
        super(titulo, autor, genero);
        this.lanzamiento = lanzamiento;
    }

    public LocalDate getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(LocalDate lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    @Override
    public String toString() {
        return super.toString() + ", lanzamiento=" + lanzamiento + '}';
    }
}
