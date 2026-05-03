package Boundary;

import Boundary.Compiler.BoundaryMov;
import Controller.ControllerEntrerProgramme;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BoundaryCompiler {
    BoundaryMov boundaryMov;
    ControllerEntrerProgramme controllerEntrerProgramme;

    public BoundaryCompiler(ControllerEntrerProgramme controllerEntrerProgramme) {
        boundaryMov = new BoundaryMov();
        this.controllerEntrerProgramme = controllerEntrerProgramme;
    }

    private void checkNomCommande(String premierMot, int numLigne) throws CommandePasValideException {
        try {
            Commande.fromString(premierMot);
        } catch (IllegalArgumentException e){
            throw new CommandePasValideException(
                    "La commande " + premierMot + " à la ligne " + numLigne + " n'existe pas"
            );
        }
    }

    public void compiler(){
        LinkedList<String> lignesCode = controllerEntrerProgramme.getLignesCode();

        for (int i = 0; i < lignesCode.size(); i++){
            String[] listeMots = lignesCode.get(i).trim().split("\\s+");

            try {
                checkNomCommande(listeMots[0], i + 1);
            } catch (CommandePasValideException e){
                System.out.println(e.getMessage());
                return;
            }
            try {
                switch (listeMots[0].toLowerCase()) {
                    case "mov":
                        boundaryMov.veriferValPar(Arrays.copyOfRange(listeMots, 1, listeMots.length));
                        break;
                }
            } catch (CommandePasValideException e) {
                e.printStackTrace();
                System.out.println("à la ligne " + (i + 1));
                return;
            }
        }
    }
}






