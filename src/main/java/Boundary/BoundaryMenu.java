package Boundary;

import Controller.*;
import Controller.Compiler.ControllerCommande;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoundaryMenu {
    ControllerEntrerProgramme controllerEntrerProgramme;
    ControllerAfficherProgramme controllerAfficherProgramme;
    BoundaryCompiler boundaryCompiler;
    ControllerCommande controllerCommande;
    ControllerVoirALU controllerVoirALU;
    ControllerVoirMemoire controllerVoirMemoire;
    ControllerVoirRegistres controllerVoirRegistres;

    public BoundaryMenu() {
        controllerEntrerProgramme = new ControllerEntrerProgramme();
        controllerAfficherProgramme = new ControllerAfficherProgramme(controllerEntrerProgramme);
        boundaryCompiler = new BoundaryCompiler(controllerEntrerProgramme);

        controllerVoirRegistres = new ControllerVoirRegistres(boundaryCompiler.getDernierControllerAppele());

    }

    private void afficherListeChoix(){
        System.out.println("1.Afficher Programme");
        System.out.println("2.Entrer Programme");
        System.out.println("3.Compiler");
        System.out.println("4.Voir ALU");
        System.out.println("5.Voir Mémoire");
        System.out.println("6.Voir Registres");
    }

    private void choisirAction(int choix){
        switch (choix){
            case 1:
                controllerAfficherProgramme.afficherProgramme();
                break;
            case 2:
                controllerEntrerProgramme.entrerProgramme();
                break;
            case 3:
                boundaryCompiler.compiler();
                break;
            case 6:
                controllerVoirRegistres.afficherRegistres();
                break;
        }
    }

    public void afficherMenu() {
        boolean estMenuContinu;
        int choix = 0;
        Scanner sc = new Scanner(System.in);

        do {
            boolean numeroValide = false; // reset ici

            afficherListeChoix();

            do {
                try {
                    System.out.println("Veuillez taper un nombre de 1 à 6");
                    choix = sc.nextInt();

                    if (1 <= choix && choix <= 6) {
                        numeroValide = true;
                    } else {
                        System.out.println("Veuillez entrer une valeur entre 1 et 6");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un entier");
                    sc.nextLine(); // vider le buffer
                }
            } while (!numeroValide);

            choisirAction(choix);

            System.out.println("Pour afficher menu taper M");
            String rep = sc.next();
            estMenuContinu = rep.equalsIgnoreCase("m");

        } while (estMenuContinu);
    }
}
