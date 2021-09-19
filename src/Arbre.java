import java.util.Set;

public interface Arbre<V extends Valeur<V>> {
    Noeud<V> getRoot();
    int taille(); // nombre de valeurs
    boolean contient(final V val); // vrai si val est contenue dans l'arbre, faux sinon
    Set<V> valeurs(); // ensemble des valeurs différentes dans l'arbre
    V somme(); // somme des valeurs
    V min(); // valeur minimale
    V max(); // valeur maximale
    boolean estTrie(); // vrai si l'arbre est trié, faux sinon
}
