package Controller;

import Entity.ProgrammeAssembleur;

import java.util.LinkedList;
import java.util.Scanner;

public class ControllerEntrerProgramme {
    private ProgrammeAssembleur programmeAssembleur;
    public ControllerEntrerProgramme() {
        programmeAssembleur = new ProgrammeAssembleur(new LinkedList<>());
    }

    public void entrerProgramme() {
        LinkedList<String> lignesCode = new LinkedList<>();
        boolean estEntreEOF = false;
        Scanner sc = new Scanner(System.in);
        do{
            String ligneCode = sc.nextLine();
            if (ligneCode.equals("EOF") || ligneCode.equals("eof")){
                estEntreEOF = true;
            } else {
                lignesCode.add(ligneCode);
            }
        }  while (! estEntreEOF);
        programmeAssembleur.setLignesCode(lignesCode);
    }

    public ProgrammeAssembleur getProgrammeAssembleur() {
        return programmeAssembleur;
    }
}
