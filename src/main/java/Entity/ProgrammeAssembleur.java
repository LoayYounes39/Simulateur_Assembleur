package Entity;

import java.util.LinkedList;

public class ProgrammeAssembleur {
    LinkedList<String> lignesCode;

    public ProgrammeAssembleur(LinkedList<String> lignesCode) {
        this.lignesCode = lignesCode;
    }

    public void setLignesCode(LinkedList<String> lignesCode) {
        this.lignesCode = lignesCode;
    }

    public void afficherLignes() {
        lignesCode.stream().forEach(ligne -> System.out.print(ligne + "\n"));
    }

    public LinkedList<String> getLignesCode() {
        return lignesCode;
    }
}
