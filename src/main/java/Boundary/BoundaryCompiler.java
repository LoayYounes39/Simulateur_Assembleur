package Boundary;

import Boundary.Compiler.BoundaryMov;
import Controller.Compiler.ControllerCommande;
import Controller.Compiler.ControllerMov;
import Controller.ControllerEntrerProgramme;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BoundaryCompiler {
    BoundaryMov boundaryMov;
    ControllerEntrerProgramme controllerEntrerProgramme;
    Commande derniereCommandeAppelee = Commande.fromString("mov");

    public BoundaryCompiler(ControllerEntrerProgramme controllerEntrerProgramme) {
        this.controllerEntrerProgramme = controllerEntrerProgramme;
        boundaryMov = new BoundaryMov(new String[] {});
    }

    private void checkNomCommande(String premierMot, int numLigne) throws CommandePasValideException {
        try {
            Commande.fromString(premierMot);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new CommandePasValideException(
                    "La commande " + premierMot + " à la ligne " + numLigne + " n'existe pas"
            );
        }
    }

    public void compiler(){
        LinkedList<String> lignesCode = controllerEntrerProgramme.getLignesCode();

        for (int i = 0; i < lignesCode.size(); i++){
            String[] listeMots = lignesCode.get(i).trim().split("\\s+|,\\s*");

            try {
                checkNomCommande(listeMots[0], i + 1);
            } catch (CommandePasValideException e){
                System.out.println(e.getMessage());
                return;
            }
            try {
                switch (listeMots[0].toLowerCase()) {
                    case "mov":
                        boundaryMov.setLigneCourant(Arrays.copyOfRange(listeMots, 1, listeMots.length));
                        boundaryMov.deplacer();
                        break;
                }
               derniereCommandeAppelee = Commande.fromString(listeMots[0].toLowerCase());
            } catch (CommandePasValideException e) {
                e.printStackTrace();
                System.out.println("à la ligne " + (i + 1));
                return;
            }
        }
    }

    public ControllerCommande getDernierControllerAppele() {
        switch (derniereCommandeAppelee) {
            case MOV:
                return boundaryMov.getControllerMov();
        }
        return boundaryMov.getControllerMov();
    }
}






