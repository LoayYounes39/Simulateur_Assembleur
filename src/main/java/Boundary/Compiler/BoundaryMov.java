package Boundary.Compiler;

import Boundary.CommandePasValideException;

public class BoundaryMov extends BoundaryCommande {
    public BoundaryMov() {
        super("mov", 2);
    }

    public void veriferValPar(String[] strings) throws CommandePasValideException {
        super.veriferValPar(strings);
        if (strings[1] )
    }
}
