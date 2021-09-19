public class Main {
    public static void main(String[] args){
        Arbre<Entier> testEntier = new ArbreImpl<>();
        testEntier.getRoot().addFeuilles(
                new Entier(1 ),
                new Entier(2 ))
                .addNoeuds(
                        new Noeud<Entier>().addFeuilles(new Entier(3),new Entier(4))
                        .addNoeuds(
                             new Noeud<Entier>().addFeuilles(new Entier(5)).addNoeuds(
                                new Noeud().addFeuilles(new Entier(6)))));
        System.out.println("Tree : "+ testEntier.toString());
        System.out.println("Is ordered : "+testEntier.estTrie());
        System.out.println("sum : "+testEntier.somme());
        System.out.println("max : "+testEntier.max());
        System.out.println("min : "+testEntier.min());
        System.out.println("min : "+testEntier.valeurs());

    }
}
