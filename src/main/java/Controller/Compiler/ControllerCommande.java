package Controller.Compiler;

import Entity.BancRegistres;

public abstract class ControllerCommande {
    protected BancRegistres bc;

    public ControllerCommande() {
        this.bc = new BancRegistres();
    }

    public void store(Short numReg, Short valCons){
        if (valCons < Short.MIN_VALUE || valCons > Short.MAX_VALUE) {
            throw new IllegalArgumentException("hors short");
        }
        bc.mettreAJour(numReg, valCons);
    }
    public Short load(Short numReg){
        return bc.getCase(numReg);
    }

    public BancRegistres getBc() {
        return bc;
    }
}
