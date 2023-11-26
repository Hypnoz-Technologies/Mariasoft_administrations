package net.mariasoft.administrations.enumeration;

public enum FormeJuridiqueEnum {
    EURL("Entreprise Unipersonnelle A Responsabilités Limitées"),
    CHU("Centre Hospitalier Universitaire"),
    SARL("Société A Responsabilités Limitées (LLC)"),
    SA("Société Anonyme"),
    SA_PUBLIQUE("Société Anonyme Publique"),
    GIE("Groupement d`Intérêt Economique"),
    ASSOCIATION("Association"),
    SP("Société Publique"),
    SCS("Société en Commandite Simple"),
    EI("Entreprise Individuelle"),
    SCI("Société Civile Immobilière"),
    ONG("Organisation Non Gouvernementale"),
    SNC("Société en Nom Collectif"),
    SASU("Société par Action Simplifiée Unipersonnelle"),
    SAS("Société par Action Simplifiée"),
    LTD("Private Limited Company"),
    LLP("Limited Liability Company"),
    PLC("Public Limited Company");

    private final String description;

    FormeJuridiqueEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
