package Boundary.Compiler;

import Boundary.CommandePasValideException;

import java.util.List;

public class BoundaryCommande {
    String nom;
    int nbParamètres;
    public BoundaryCommande(String nom, int nbParamètres) {
        this.nom = nom;
        this.nbParamètres = nbParamètres;
    }
    public boolean isRegister(String string){
        return string.toLowerCase().matches("r(1[0-5]|[0-9])");
    }

    public boolean isConstant(String string){
        
    }

    public void veriferValPar(String[] strings) throws CommandePasValideException {
        if (strings.length != nbParamètres){
            throw new CommandePasValideException("la commande " + nom + " a " + strings.length + " tandis que le nombre de paramètres est " + nbParamètres );
        }
        if (! isRegister(strings[0])){
            throw new CommandePasValideException("la commande " + nom + " a " + strings[0] + " qui n'est pas un registre " );
        }
    }
}
