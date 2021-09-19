public class Entier implements Valeur<Entier>{

    final Integer value;

    public Entier(Integer value) {
        this.value = value;
    }

    @Override
    public Entier sum(Entier val) {
        return new Entier(value+val.value);
    }

    @Override
    public int compareTo(Entier o) {
        return value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
