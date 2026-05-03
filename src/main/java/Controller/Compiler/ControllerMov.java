package Controller.Compiler;

import Entity.BancRegistres;

public class ControllerMov extends ControllerCommande{
    public ControllerMov() {
        super();
    }


    public void deplacerConstant(Short numReg1, Short cons) {
        store(numReg1, cons);
    }

    public void deplacerRegistre(Short numReg1, Short numReg2) {
       store(numReg1,  load(numReg2));
    }
}
