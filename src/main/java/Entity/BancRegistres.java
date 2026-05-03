package Entity;

public class BancRegistres {
    Short[] tableau;

    public BancRegistres() {
        tableau = new Short[15];
    }

    public void mettreAJour(Short numReg, Short val) {
        tableau[numReg] = val;
    }
}
