package net.mariasoft.administrations.enumeration;

public enum ZoneCommercialEnum {
    CEMAC("CEMAC", "CEMAC"),
    COMESA("COMESA", "COMESA"),
    UEMOA("UEMOA", "UEMOA");

    private final String code;
    private final String libelle;


    ZoneCommercialEnum(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

}
