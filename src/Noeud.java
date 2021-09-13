import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Noeud<T extends Valeur<T>> {
    final List<Feuille<T>> feuilles = new ArrayList<>();
    final List<Noeud<T>> noeuds = new ArrayList<>();

    public int taille() {
        return feuilles.size()+
                noeuds.stream().mapToInt(Noeud::taille).sum();
    }

    public boolean contient(T val) {
        if(feuilles.contains(val)){
            return true;
        }
        Optional<Noeud<T>> noeud=noeuds.stream().filter(n->n.contient(val)).findFirst();
        return noeud.isPresent();
    }

    public Stream<Feuille<T>> feuilles(){
        return feuilles.stream();
    }

    public Set<T> valeurs() {
        return fluxAllValeurs()
                .collect(Collectors.toCollection(TreeSet::new));
    }


    public Stream<T> fluxAllValeurs() {
        return Stream.concat(feuilles(),noeuds.stream().flatMap(Noeud::feuilles))
                .map(Feuille::getValeur);
    }

    @Override
    public String toString() {
        return  "["+feuilles +
                "," + noeuds +
                ']';
    }

}
