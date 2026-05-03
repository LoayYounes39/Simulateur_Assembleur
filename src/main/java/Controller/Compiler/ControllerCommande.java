package Controller.Compiler;

import Entity.BancRegistres;

public class ControllerCommande {
    BancRegistres bc;

    public ControllerCommande(BancRegistres bc) {
        this.bc = bc;
    }

    public void sauver(Short numReg, Short valCons){
        if (valCons < Short.MIN_VALUE || valCons > Short.MAX_VALUE){
            throw new IllegalArgumentException("hors short");
        }
    }
}
