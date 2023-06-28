package cat.urv.deim.models;

import cat.urv.deim.exceptions.ElementNoTrobat;

public class LlistaPelicules implements IPelicules {
    private LlistaDoblementEncadenada<Pelicula> llista = new LlistaDoblementEncadenada<>();

    @Override
    public void inserir(Pelicula p) {
        llista.inserir(p);
    }

    @Override
    public void esborrar(Pelicula p) throws ElementNoTrobat {
        llista.esborrar(p);
    }

    @Override
    public boolean buscar(Pelicula p) {
        return llista.buscar(p);
    }

    @Override
    public boolean esBuida() {
        return llista.esBuida();
    }

    @Override
    public int longitud() {
        return llista.longitud();
    }

    @Override
    public int comptarPeliculesAny(int any) {
        Pelicula[] pelicules = llistaPelicules();
        int comptador = 0;
        for (Pelicula p : pelicules) {
            if (p.getAny() == any) {
                comptador++;
            }
        }
        return comptador;

    }

    @Override
    public int buscarAnyPelicula(String titol) throws ElementNoTrobat {
        Pelicula p = buscarPeliculaTitol(titol);
        if (p != null) {
            return p.getAny();
        } else {
            throw new ElementNoTrobat("No s'ha trobat la pelicula");
        }

    }

    @Override
    public Pelicula buscarPeliculaTitol(String titol) throws ElementNoTrobat {
        Pelicula[] pelicules = llistaPelicules();
        for (Pelicula p : pelicules) {
            if (p.getTitol().equals(titol)) {
                return p;
            }
        }
        throw new ElementNoTrobat("No s'ha trobat la pelicula");
    }

    @Override
    public Pelicula[] llistaPelicules() {
        Object[] elements = llista.elements();
        Pelicula[] pelicules = new Pelicula[elements.length];
        for (int i = 0; i < elements.length; i++) {
            pelicules[i] = (Pelicula) elements[i];
        }
        return pelicules;       
    }

}
