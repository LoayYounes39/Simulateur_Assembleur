package Controller;

import Controller.Compiler.ControllerCommande;
import Entity.BancRegistres;

public class ControllerVoirRegistres {
    ControllerCommande dernierController;
    BancRegistres bc;
    public ControllerVoirRegistres(ControllerCommande dernierController) {
        this.dernierController = dernierController;
        this.bc = dernierController.getBc();
    }


    public void afficherRegistres() {
        System.out.println(bc.toString());
    }
}
