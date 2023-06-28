package cat.urv.deim.models;

public class Pelicula implements Comparable<Pelicula> {
    private int idP;
    private String titol;
    private int any;

    public Pelicula(int idP, String titol, int any) {
        this.idP = idP;
        this.titol = titol;
        this.any = any;
    }

    public int getID() {
        return this.idP;
    }

    public String getTitol() {
        return this.titol;
    }

    public int getAny() {
        return this.any;
    }

    // Comparem amb tres criteris, primer el titol, despres l'any i per últim l'id
    @Override
    public int compareTo(Pelicula peliculaAComparar) {
        int resultat = this.titol.compareTo(peliculaAComparar.getTitol());
        if (resultat == 0) {
            resultat = this.any - peliculaAComparar.getAny();
            if (resultat == 0) {
                resultat = this.idP - peliculaAComparar.getID();
            }
        }
        return resultat;
    }

} 