package Boundary;

public enum Commande {
    MOV,
    ADD,
    SUB;

    public static Commande fromString(String value) {
        for (Commande c : Commande.values()) {
            if (c.name().equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Commande inconnue : " + value);
    }
}
