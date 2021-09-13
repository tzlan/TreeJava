public class Feuille<V extends Valeur<V>> {
    final V valeur;

    public Feuille(V valeur) {
        this.valeur = valeur;
    }

    public V getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return ""+ valeur ;
    }
}
