import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Noeud<T extends Valeur<T>> {
    final List<Feuille<T>> feuilles = new ArrayList<>();
    final List<Noeud<T>> noeuds = new ArrayList<>();

    public Noeud<T> addFeuilles(T... feuillesToAdd){
        for (T cur:feuillesToAdd)
            feuilles.add(new Feuille<>(cur));
        return this;
    }

    public Noeud<T> addNoeuds(Noeud<T>... noeudsToAdd){
        for (Noeud<T> cur:noeudsToAdd)
            noeuds.add(cur);
        return this;
    }



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
        return Stream.concat(noeuds.stream().flatMap(Noeud::fluxAllValeurs),feuilles().map(Feuille::getValeur));
    }

    @Override
    public String toString() {
        Optional<String>  feuillesStr= feuilles.stream().map(Objects::toString).reduce((s, s2) -> s+", "+s2);
        String feuillesf = (!noeuds.isEmpty()&&feuillesStr.isPresent()?", " : "") + feuillesStr.orElse("");
        return  "["+ (noeuds.isEmpty()?"": noeuds) + feuillesf +']';
    }

}
