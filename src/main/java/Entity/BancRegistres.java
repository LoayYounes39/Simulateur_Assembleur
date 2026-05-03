package Entity;

public class BancRegistres {
    Short[] tableau;

    public BancRegistres() {
        tableau = new Short[16];
    }

    public void mettreAJour(Short numReg, Short val) {
        tableau[numReg] = val;
    }

    public Short getCase (Short indice){
        return tableau[indice];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++){
            sb.append("r"+i+ " : "+ tableau[i] + "\n");
        }
        return sb.toString();
    }
}
