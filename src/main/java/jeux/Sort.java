package jeux;

public class Sort{
    protected String nomSort;
    protected int forceSort;

    public String getNomSort() {
        return nomSort;
    }

    public void setNomSort(String nomSort) {
        this.nomSort = nomSort;
    }

    public int getForceSort() {
        return forceSort;
    }

    public void setForceSort(int forceSort) {
        this.forceSort = forceSort;
    }

    public String toString() {
        return nomSort + " \nForce du sort : " + forceSort;
    }
}
