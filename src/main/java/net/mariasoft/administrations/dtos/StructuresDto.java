package net.mariasoft.administrations.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link net.mariasoft.administrations.domain.Structures}
 */
public record StructuresDto(Long id, Integer strEcommerceVal, Integer strEtat, Integer strMode,
                            Integer strMaitreCabinet,
                            @NotNull(message = "La Rasison Social ne peut pas être null") @Size(max = 100) String strRaisonSociale,

                            String strDescriptif,
                            @NotNull(message = "Le Sigle ne peut pas être null") @Size(message = "Le sigle doit être compris entre 2 et 50 caractères", min = 2, max = 50) String strSigle,
                            String strNomPays, String strCodePays, String strIsoPays, String strDevise,
                            Integer strSiteDevise, String strLangue, String strZoneFiscale, String strZoneCommerciale,
                            String strBilanSocial, String strFormeJuridique, String strtypEentreprise,
                            String strAdresse, String strRue, String strLot, String strPorte, String strQuartier,
                            String strVille, String strCommune, String strDepartement, String strCodePostal,
                            String strCedex, String strTel1, String strTel2, String strTel3, String strFax,
                            String strTelex, String strSiteWzb, String strActiviteCommerciale, String strLogo1,
                            Integer strTypeContact, String strResponsable, String strQualiteResponsable,
                            String strCapital, Boolean strStructure, Boolean strChantier, Boolean strMission,
                            Boolean strSite, Boolean strRegion, Boolean strUsine, Boolean strActivite,
                            Integer strActiviteModeSasie, Boolean strParc, Integer strDossier, Integer strNbCarDossier,
                            Integer strChainageAxes, Boolean strAgent, Boolean strCles, Boolean strProjet,
                            String strQuart1DebutHeure, String strQuart1DebutMinute, String strQuart1FinHeure,
                            String strQuart1FinMinute, String strQuart2FinHeure, String strQuart2FinMinute,
                            String strQuart3FinHeure, String strQuart3FinMinute, String strBanqueDefaut,
                            LocalDate strDteDebMandat, LocalDate strDteFinMandat, Integer strEtatMandat,
                            String strSignature) implements Serializable {
public StructuresDto{
    if(strRaisonSociale.length()>100){
        throw new IllegalArgumentException("La Rasison Social ne peut pas dépasser 100 caractères");
    }
    if(strSigle.length()<2 || strSigle.length()>50){
        throw new IllegalArgumentException("Le sigle doit être compris entre 2 et 50 caractères");
    }
}

}