package jeux;

public class Magicien extends Personnage {
    protected Sort sortMagicien;

    public Sort getSortMagicien() {
        return sortMagicien;
    }

    public void setSortMagicien(Sort sortMagicien) {
        this.sortMagicien = sortMagicien;
    }

    public String toString() {
        return super.toString() + "\nSort : " + sortMagicien.toString();
    }
}
