package Boundary.Compiler;

import Boundary.CommandePasValideException;
import Controller.Compiler.ControllerMov;

public class BoundaryMov extends BoundaryCommande {
    ControllerMov controllerMov;
    public BoundaryMov(String[] strings) {
        super("mov", 2, strings);
        controllerMov = new ControllerMov();
    }

    public void veriferValPar(String[] strings) throws CommandePasValideException {
        super.veriferValPar();
        super.verificationDernierParametre();
        if (isConstant(strings[1])){
            controllerMov.deplacerConstant(toNumRegistre(strings[0]), parseConstant(strings[1]));
        } else {
            controllerMov.deplacerRegistre(toNumRegistre(strings[0]) , toNumRegistre(strings[1]));
        }
    }
}
