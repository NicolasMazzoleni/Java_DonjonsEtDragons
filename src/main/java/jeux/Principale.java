package jeux;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principale {

    private static Scanner sc = new Scanner(System.in);
    private static Sort sortTableau[] = new Sort[10];
    private static int nbSort = 0;

    public static void main(String[] args) {
        String Menu;
        int nb = 0;
        Personnage personnageTableau[] = new Personnage[10];


        do {
            System.out.println("\n**MENU - Que voulez vous faire?" + "\n(1) Ajouter un nouveau personnage" +
                    "\n(2) Voir la liste des personnages créés" + "\n(3) Modifier un personnage" +
                    "\n(4) Quitter le jeux");
            Menu = sc.nextLine();
            if (Menu.equals("1")) {
                creationPersonnage(personnageTableau, nb);
                nb++;
            } else if (Menu.equals("2")) {
                showPersonnages(personnageTableau, nb);
            } else if (Menu.equals("3")) {
                modifPersonnage(personnageTableau, nb);
            }
        } while (!Menu.equals("4"));
    }

    public static void creationPersonnage(Personnage personnageTableau[], Integer nb) {

        String personnage;
        Personnage personnage1 = null;
        int nb2 = 0;

        do {
            System.out.println("\nCréation du personnage : (1) Guerrier |(2) Magicien");
            personnage = sc.nextLine();

        } while (!(personnage.equals("1") || personnage.equals("2")));
        if (personnage.equals("1")) {
            personnage1 = new Guerrier();
            personnage1.setTypePersonnage("guerrier");
        } else if (personnage.equals("2")) {
            personnage1 = new Magicien();
            personnage1.setTypePersonnage("magicien");
        } else {
            System.out.println("Mauvais choix! Tapez 1 ou 2");
        }

        System.out.println("\nVous avez créé un " + personnage1.getTypePersonnage());

        //saisie du nom
        saisieNom(personnage1);
        //saisie niveau vie
        saisieVie(personnage1);
        //saisie force
        saisieForce(personnage1);

        if (personnage1 instanceof Guerrier) {
            //saisie arme du guerrier
            saisieArme((Guerrier) personnage1);
            //saisie niveau d'attaque de l'arme
            saisieNiveaudAttaque(((Guerrier) personnage1));
        } else {
            //saisie sort du magicien
            Sort s = creerSort();
            ((Magicien) personnage1).setSortMagicien(s);
            sortTableau[nbSort] = s;
            nbSort++;

        }
        personnageTableau[nb] = personnage1;
    }


    public static void saisieNom(Personnage p) {
        System.out.println("\nChoisissez le nom de votre personnage :");
        String nom = sc.nextLine();
        p.setNomPersonnage(nom);
        System.out.println("Le nom de votre " + p.getClass().getSimpleName() + " est : " + p.getNomPersonnage());
    }

    public static void saisieVie(Personnage p) {
        System.out.println("\nChoisissez son niveau de vie (0 à 100) :");
        int niveauDeVie;
        do {
            niveauDeVie = sc.nextInt();
            sc.nextLine();
            if (niveauDeVie >= 0 && niveauDeVie <= 100) {
                p.setNiveauDeViePersonnage(niveauDeVie);
                System.out.println("Le niveau de vie choisi est : " + p.getNiveauDeViePersonnage());
            } else {
                System.out.println("Choisissez un nombre entre 0 et 100 inclus");
            }
        } while (niveauDeVie < 0 || niveauDeVie > 100);
    }

    public static void saisieForce(Personnage p) {
        System.out.println("\nChoisissez sa force d'attaque (0 à 20) :");
        int forcedAttaque;
        do {
            forcedAttaque = sc.nextInt();
            sc.nextLine();
            if (forcedAttaque >= 0 && forcedAttaque <= 20) {
                p.setForcedAttaquePersonnage(forcedAttaque);
                System.out.println("Votre " + p.getClass().getSimpleName() + " à une force d'attaque de " + p.getForcedAttaquePersonnage() + ".");
            } else {
                System.out.println("Choisissez un nombre entre 0 et 20 inclus");
            }
        } while (forcedAttaque < 0 || forcedAttaque > 20);
    }

    public static void saisieArme(Guerrier g) {
        System.out.println("\nChoisissez une arme pour votre guerrier : (1) Epée |(2) Lance");
        int nomArme;
        do {
            nomArme = sc.nextInt();
            sc.nextLine();
            if (nomArme == 1) {
                g.setNomArmeGuerrier("Epée");
                System.out.println("Vous avez choisi " + g.nomArmeGuerrier + " comme arme.");
            } else if (nomArme == 2) {
                g.setNomArmeGuerrier("Lance");
                System.out.println("Vous avez choisi " + g.nomArmeGuerrier + " comme arme.");
            } else {
                System.out.println("Choisissez un nombre entre 1 et 2 inclus");
            }
        } while (nomArme < 1 || nomArme > 2);
    }

    public static void saisieNiveaudAttaque(Guerrier g) {
        System.out.println("\nChoisissez un niveau d'attaque (0 à 20)");
        int niveaudAttaque;
        do {
            niveaudAttaque = sc.nextInt();
            sc.nextLine();
            if (niveaudAttaque >= 0 && niveaudAttaque <= 20) {
                g.setNiveaudAttaqueArmeGuerrier(niveaudAttaque);
                System.out.println("Votre arme " + g.nomArmeGuerrier + " a un niveau d'attaque de " + g.niveaudAttaqueArmeGuerrier);
            } else {
                System.out.println("Choisissez un nombre entre 0 et 20 inclus");
            }
        } while (niveaudAttaque < 0 || niveaudAttaque > 20);
    }

    public static Sort creerSort() {
        Sort s = new Sort();
        saisieSort(s);
        saisieNiveaudAttaqueSort(s);
        return s;
    }

    public static void saisieSort(Sort s) {

        System.out.println("\nChoisissez un sort pour votre magicien: (1) transformation en crapeau |(2) baguette magique");
        int nomSort;
        do {
            nomSort = sc.nextInt();
            sc.nextLine();
            if (nomSort == 1) {
                s.setNomSort("transformation en crapeau");
                System.out.println("Vous avez choisi " + s.getNomSort() + " comme sort.");
            } else if (nomSort == 2) {
                s.setNomSort("baguette magique");
                System.out.println("Vous avez choisi " + s.getNomSort() + " comme sort.");
            } else {
                System.out.println("Choisissez un nombre entre 1 et 2 inclus");
            }
        } while (nomSort < 1 || nomSort > 2);
    }

    public static void saisieNiveaudAttaqueSort(Sort s) {
        System.out.println("\nChoisissez un niveau d'attaque (0 à 20)");
        int niveaudAttaque;
        do {
            niveaudAttaque = sc.nextInt();
            sc.nextLine();
            if (niveaudAttaque >= 0 && niveaudAttaque <= 20) {
                s.setForceSort(niveaudAttaque);
                System.out.println("Votre sort " + s.getNomSort() + " a un niveau d'attaque de " + s.getForceSort());
            } else {
                System.out.println("Choisissez un nombre entre 0 et 20 inclus");
            }
        } while (niveaudAttaque < 0 || niveaudAttaque > 20);
    }

    public static void showPersonnages(Personnage personnageTableau[], Integer nb) {
        System.out.println("\nDetails des personnes créées :");
        for (int i = 0; i < personnageTableau.length; i++) {
            if (personnageTableau[i] != null) {
                System.out.println(personnageTableau[i]);
            }
        }
        if (personnageTableau[0] != null) {
        } else {
            System.out.println("Aucun personnage n'a encore été ajouté.");
        }
    }


    public static void modifPersonnage(Personnage personnageTableau[], Integer nb) {

        if (personnageTableau[0] != null) {
            System.out.println("\nQuel personnage souhaitais vous modifier? (Choisir par Index)");
            for (int i = 0; i < personnageTableau.length; i++) {
                if (personnageTableau[i] != null) {
                    System.out.println(i + " Index | " + "Nom : " + personnageTableau[i].getNomPersonnage() + " | Type : " + personnageTableau[i].getTypePersonnage());
                }
            }
            int j = sc.nextInt();
            sc.nextLine();
            System.out.println("\nQue souhaitez-vous modifier? " + "\n(1) Modifier le nom" + "\n(2) Modifier le niveau de vie" + "\n(3) Modifier la force d'attaque" + "\n(4) Modifier l'arme/sort" + "\n(5) Modifier le niveau d'attaque de l'arme/sort");
            int k = sc.nextInt();
            sc.nextLine();
            switch (k) {
                case 1:
                    saisieNom(personnageTableau[j]);
                    break;
                case 2:
                    saisieVie(personnageTableau[j]);
                    break;
                case 3:
                    saisieForce(personnageTableau[j]);
                    break;
                case 4:
                    if (personnageTableau[j] instanceof Guerrier) {
                        saisieArme((Guerrier) personnageTableau[j]);
                    } else saisieSort(sortTableau[j]);
                    break;
                case 5:
                    if (personnageTableau[j] instanceof Guerrier) {
                        saisieNiveaudAttaque((Guerrier) personnageTableau[j]);
                    } else saisieNiveaudAttaqueSort(sortTableau[j]);
                    break;
            }

        } else
            System.out.println("Aucun personnage n'a encore été ajouté.");

    }
}


