package jeux;

public class Personnage {
    protected String nomPersonnage;
    protected String imagePersonnage;
    protected String typePersonnage;
    protected int niveauDeViePersonnage;
    protected int forcedAttaquePersonnage;


    public void setNomPersonnage(String pNom) {
        nomPersonnage = pNom;
    }
    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNiveauDeViePersonnage(int pNiveauDeVue) {
        niveauDeViePersonnage = pNiveauDeVue;
    }
    public int getNiveauDeViePersonnage() {
        return niveauDeViePersonnage;
    }

    public void setForcedAttaquePersonnage(int pforcedAttaque) {
        forcedAttaquePersonnage = pforcedAttaque;
    }
    public int getForcedAttaquePersonnage() {
        return forcedAttaquePersonnage;
    }

    public String getTypePersonnage() {
        return typePersonnage;
    }
    public void setTypePersonnage(String ptypePersonnage) {
        this.typePersonnage = ptypePersonnage;
    }

    public String toString() {
        return "\nNom : " + nomPersonnage + " \nType : " + typePersonnage + "\nImage : " + imagePersonnage + "\nNiveau de vie : " + niveauDeViePersonnage + "\nForce d'attaque : " + forcedAttaquePersonnage ;
    }
}


