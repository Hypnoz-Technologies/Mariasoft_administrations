package net.mariasoft.administrations.enumeration;

public enum CiviliteEnum {
    MME("Mme", "Madame"),
    MLLE("Mlle", "Mademoiselle"),
    BEBE("Bébé", "Bébé"),
    ENFANT("Enfant", "Enfant"),
    M("M.", "Monsieur"),
    MME_ET_M("Mme et M.", "Madame et Monsieur"),
    CONSORTS("Consorts", "Consorts"),
    DR("Dr.", "Docteur"),
    PR("Pr.", "Professeur"),
    ME("Me", "Maître"),
    MSG("Msg", "Monseigneur"),
    COLONEL("Colonel", "Colonel"),
    CAPITAINE("Capitaine", "Capitaine"),
    COMMANDANT("Commandant", "Commandant"),
    LIEUTENANT("Lieutenant", "Lieutenant"),
    SERGENT("Sergent", "Sergent"),
    AUTRE("Autre", "Autre"),
    SE("Se.", "Son Excellence");

    private final String code;
    private final String libelle;

    CiviliteEnum(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }
}
