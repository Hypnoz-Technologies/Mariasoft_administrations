package net.mariasoft.administrations.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link net.mariasoft.administrations.domain.Structures}
 */
@Data
public class StructuresDto implements Serializable {
    Long id;
    int strEcommerceVal;
    Integer strEtat;
    Integer strMode;
    int strMaitreCabinet;
    @NotNull(message = "La Rasison Social ne peut pas être null")
    @Size(max = 100)
    String strRaisonSociale;
    String strDescriptif;
    @NotNull(message = "Le Sigle ne peut pas être null")
    @Size(message = "Le sigle doit être compris entre 2 et 50 caractères", min = 2, max = 50)
    String strSigle;
    String strNomPays;
    String strCodePays;
    String strIsoPays;
    String strDevise;
    int strSiteDevise;
    String strLangue;
    String strZoneFiscale;
    String strZoneCommerciale;
    String strBilanSocial;
    String strFormeJuridique;
    String strtypEentreprise;
    String strAdresse;
    String strRue;
    String strLot;
    String strPorte;
    String strQuartier;
    String strVille;
    String strCommune;
    String strDepartement;
    String strCodePostal;
    String strCedex;
    String strTel1;
    String strTel2;
    String strTel3;
    String strFax;
    String strTelex;
    String strSiteWzb;
    String strActiviteCommerciale;
    String strLogo1;
    int strTypeContact;
    String strResponsable;
    String strQualiteResponsable;
    String strCapital;
    boolean strStructure;
    boolean strChantier;
    boolean strMission;
    boolean strSite;
    boolean strRegion;
    boolean strUsine;
    boolean strActivite;
    int strActiviteModeSasie;
    boolean strParc;
    int strDossier;
    int strNbCarDossier;
    int strChainageAxes;
    boolean strAgent;
    boolean strCles;
    boolean strProjet;
    String strQuart1DebutHeure;
    String strQuart1DebutMinute;
    String strQuart1FinHeure;
    String strQuart1FinMinute;
    String strQuart2FinHeure;
    String strQuart2FinMinute;
    String strQuart3FinHeure;
    String strQuart3FinMinute;
    String strBanqueDefaut;
    LocalDate strDteDebMandat;
    LocalDate strDteFinMandat;
    int strEtatMandat;
    String strSignature;
}