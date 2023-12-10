package net.mariasoft.administrations.enumeration;

public enum PostesEnum {
    PDG("PDG", "Président Directeur Général"),
    DG("DG", "Directeur Général"),
    DGA("DGA", "Directeur Général Adjoint"),
    PCA("PCA", "Président du Conseil d`Administration"),
    AS("AS", "Assistant de Direction"),
    DF("DF", "Directeur Financier"),
    DFC("DFC", "Directeur Financier et Comptable"),
    AF("AF", "Agent Financier"),
    DAF("DAF", "Directeur Administratif et Financier"),
    DAC("DAC", "Directeur Administratif et Comptable"),
    RAF("RAF", "Ressource humaine"),
    CC("CC", "Chef Comptable"),
    AC("AC", "Agent Comptable"),
    ASSC("ASSC", "Assistant comptable"),
    DRH("DRH", "Directeur des Ressources Humaines"),
    SG("SG", "Secétaire Général"),
    TRE("TRE", "Trésorier"),
    CAIS("CAIS", "Caissier"),
    FAC("FAC", "Agent de facturation"),
    STAN("STAN", "Standardiste"),
    ARH("ARH", "Agent des Ressources Humaines"),
    ASSRH("ASSRH", "Assistant des Ressources Humaines"),
    SEC("SEC", "Secrétaire"),
    CG("CG", "Contrôleur de Gestion"),
    AUD("AUD", "Auditeur"),
    CSX("CSX", "Consultant"),
    DSI("DSI", "Directeur du Système d`Information"),
    AM("AM", "Agent de Maintenance"),
    DTEC("DTEC", "Directeur Technique"),
    AT("AT", "Agent Technique"),
    ASST("ASST", "Assistant Technique"),
    DACH("DACH", "Directeur des achats"),
    RACH("RACH", "Responsable des achats"),
    AACH("AACH", "Agent des achats"),
    ASSACH("ASSACH", "Assistant des achats"),
    DPROD("DPROD", "Directeur de Production"),
    APROD("APROD", "Agent de Production"),
    ASSPROD("ASSPROD", "Assistant de Production"),
    DENTR("DENTR", "Directeur de l`Entretien"),
    AENTR("AENTR", "Agent Technicien de Surface"),
    CAT("CAT", "Chef Atelier"),
    REC("REC", "Réceptionnaire"),
    QUA("QUA", "Service Qualité"),
    DLOG("DLOG", "Directeur Logistique"),
    ALOG("ALOG", "Agent Logistique"),
    CTRAS("CTRAS", "Chef Transit"),
    DTRAN("DTRAN", "Directeur des Transports"),
    ACH("ACH", "Agent Chauffeur"),
    LIV("LIV", "Livreur"),
    DDEV("DDEV", "Directeur de Développement"),
    ADEV("ADEV", "Agent de Développement"),
    ASSDEV("ASSDEV", "Assistant de Développement"),
    DCOM("DCOM", "Directeur Commercial"),
    DCOC("DCOC", "Directeur de Clientèle"),
    ACMM("ACMM", "Agent Commercial"),
    ASSCMM("ASSCMM", "Assistant Commercial"),
    CHCMM("CHCMM", "Chargé de Clientèle"),
    FORM("FORM", "Formateur"),
    DMAR("DMAR", "Directeur Marketing"),
    AMAR("AMAR", "Agent Marketing"),
    ASSMAR("ASSMAR", "Assistant Marketing"),
    DCMU("DCMU", "Directeur de la Communication"),
    ACMU("ACMU", "Agent de Communication"),
    DPUB("DPUB", "Directeur de Publicité"),
    APUB("APUB", "Agent de Publicité"),
    ASSPUB("ASSPUB", "Assistant de Publicité"),
    GRAPF("GRAPF", "Graphiste"),
    MAQ("MAQ", "Maquetiste"),
    MONT("MONT", "Monteur"),
    WEBM("WEBM", "WEB MASTER"),
    DSEC("DSEC", "Directeur de la Sécurité"),
    ASEC("ASEC", "Agent de Sécurité"),
    AACC("AACC", "Agent d`Accueil"),
    SECMED("SECMED", "Secrétaire médical"),
    BIO("BIO", "Biologiste"),
    DPROF("DPROF", "Professeur"),
    MEDC("MEDC", "Médecin Chef"),
    MED("MED", "Médecin"),
    INFC("INFC", "Infirmier Chef"),
    INF("INF", "Infirmier"),
    DPROFC("DPROFC", "Professeur Vacataire"),
    MEDCV("MEDCV", "Médecin Chef Vacataire"),
    MEDV("MEDV", "Médecin Vacataire"),
    INFCV("INFCV", "Infirmier Chef Vacataire"),
    INFV("INFV", "Infirmier Vacataire");

    private final String code;
    private final String libelle;

    PostesEnum(String code, String libelle) {
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