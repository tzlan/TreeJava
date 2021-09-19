import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class ArbreImpl<V extends Valeur<V>> implements Arbre<V>{
    final Noeud<V> racine = new Noeud<>();


    @Override
    public Noeud<V> getRoot() {
        return racine;
    }

    @Override
    public int taille() {
        return racine.taille();
    }

    @Override
    public boolean contient(V val) {
        return racine.contient(val);
    }

    @Override
    public Set<V> valeurs() {
        return racine.valeurs();
    }

    @Override
    public V somme() {
        return racine.fluxAllValeurs().reduce((v, v2) -> v.sum(v2)).orElse(null);
    }

    @Override
    public V min() {
        return racine.fluxAllValeurs().min(Comparator.naturalOrder()).orElse(null);
    }

    @Override
    public V max() {
        return racine.fluxAllValeurs().max(Comparator.naturalOrder()).orElse(null);
    }

    @Override
    public boolean estTrie() {
        return isInOrder(racine.fluxAllValeurs());
    }

    private boolean isInOrder(Stream<V> fluxAllValeurs) {
        V prev = null;
        for (Iterator<V> it = fluxAllValeurs.iterator(); it.hasNext(); ) {
            V v = it.next();
            if(prev!=null&&prev.compareTo(v)>=0){
                return false;
            }
            prev=v;
        }
        return true;
    }

    @Override
    public String toString() {
        return  racine.toString();
    }
}
