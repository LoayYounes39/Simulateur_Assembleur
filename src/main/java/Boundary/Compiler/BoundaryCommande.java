package Boundary.Compiler;

import Boundary.CommandePasValideException;

public class BoundaryCommande {
    protected String nom;
    int nbParametres;
    protected String[] strings;

    public BoundaryCommande(String nom, int nbParametres, String[] strings) {
        this.nom = nom;
        this.nbParametres = nbParametres;
        this.strings = strings;
    }

    public boolean isRegister(String string) {
        return string.toLowerCase().matches("r(1[0-5]|[0-9])");
    }

    private boolean isBinary(String s) {
        return s.matches("#0b[01]+");
    }

    private boolean isHexadecimal(String s) {
        return s.matches("#0x[0-9a-fA-F]+");
    }

    private boolean isDecimal(String s) {
        return s.matches("#\\d+");
    }

    public short parseConstant(String s) {

        s = s.toLowerCase();

        if (isBinary(s)) {
            return Short.parseShort(s.substring(3), 2);
        }

        if (isHexadecimal(s)) {
            return Short.parseShort(s.substring(3), 16);
        }

        return Short.parseShort(s.substring(1), 10);
    }

    public short toNumRegistre(String reg){
        return Short.parseShort(reg.substring(1));
    }

    public boolean isConstant(String s) {
        return isBinary(s) || isHexadecimal(s) || isDecimal(s);
    }

    public void veriferValPar() throws CommandePasValideException {
        if (strings.length != nbParametres) {
            throw new CommandePasValideException("la commande " + nom + " a " + strings.length + " tandis que le nombre de paramètres est " + nbParametres);
        }
        if (!isRegister(strings[0])) {
            throw new CommandePasValideException("la commande " + nom + " a " + strings[0] + " qui n'est pas un registre ");
        }
    }

    protected void verificationDernierParametre() throws CommandePasValideException {
        if (strings.length == 2) {
            if (!isConstant(strings[1]) && !isRegister(strings[1])) {
                throw new CommandePasValideException("Deuxième Paramètre dans la commande " + nom + " pas valide");
            }
        }
    }

    public void setLigneCourant(String[] strings) {
        this.strings = strings;
    }
}
