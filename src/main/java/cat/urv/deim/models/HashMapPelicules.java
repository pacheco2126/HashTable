package cat.urv.deim.models;

import cat.urv.deim.exceptions.ElementNoTrobat;

public class HashMapPelicules implements IPelicules {


    private HashMapIndirecte<String, Pelicula> hashMap;

    public HashMapPelicules() {
        hashMap = new HashMapIndirecte<>(10);
    }

    @Override
    public void inserir(Pelicula p) {
        hashMap.inserir(p.getTitol(), p);
    }

    @Override
    public boolean buscar(Pelicula p) {
        return hashMap.buscar(p.getTitol());
    }

    @Override
    public int buscarAnyPelicula(String titol) throws ElementNoTrobat {
        Pelicula p = hashMap.element(titol);
        return p.getAny();
    }

    @Override
    public Pelicula buscarPeliculaTitol(String titol) throws ElementNoTrobat {
        return hashMap.element(titol);
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
    public boolean esBuida() {
        return hashMap.esBuida();
    }

    @Override
    public void esborrar(Pelicula p) throws ElementNoTrobat {
        if (!buscar(p)) {
            throw new ElementNoTrobat("La pel·lícula no existeix en l'estructura.");
        }
        hashMap.esborrar(p.getTitol());        
    }

    @Override
    public Pelicula[] llistaPelicules() {
        Object[] claus = hashMap.obtenirClaus();
        Pelicula[] pelicules = new Pelicula[hashMap.longitud()];
        int index = 0;
        for (Object c : claus) {
            try {
                pelicules[index] = hashMap.element((String) c);
            } catch (ElementNoTrobat e) {
                e.printStackTrace();
            }
            index++;
        }
        return pelicules;
    }

    @Override
    public int longitud() {
        return hashMap.longitud();
    }
}