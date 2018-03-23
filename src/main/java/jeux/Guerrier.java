package jeux;

public class Guerrier extends Personnage {
    protected String nomArmeGuerrier;
    protected int niveaudAttaqueArmeGuerrier;


    public String getNomArmeGuerrier() {
        return nomArmeGuerrier;
    }
    public void setNomArmeGuerrier(String nomArmeGuerrier) {
        this.nomArmeGuerrier = nomArmeGuerrier;
    }

    public int getNiveaudAttaqueArmeGuerrier() {
        return niveaudAttaqueArmeGuerrier;
    }

    public void setNiveaudAttaqueArmeGuerrier(int niveaudAttaqueArmeGuerrier) {
        this.niveaudAttaqueArmeGuerrier = niveaudAttaqueArmeGuerrier;
    }

    public String toString() {
        return super.toString() + "\nArme : " + nomArmeGuerrier + "\nNiveau d'attaque de l'arme : " + niveaudAttaqueArmeGuerrier;
    }
}


