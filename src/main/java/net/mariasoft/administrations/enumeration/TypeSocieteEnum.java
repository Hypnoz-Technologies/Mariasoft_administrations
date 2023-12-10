package net.mariasoft.administrations.enumeration;

public enum TypeSocieteEnum {
    COMMERCE( "Commerce"),
    PRESTATION("Prestation"),
    USINE_PRODUCTION( "Usine/Production"),
    ETAT( "Etat"),
    CASINO( "Casino");


    private final String libelle;

    TypeSocieteEnum( String libelle) {

        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
