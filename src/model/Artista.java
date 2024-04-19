package model;

public abstract class Artista {
    private String nombre;

    
    public Artista(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Artista [nombre=" + nombre + "]";
    }
}