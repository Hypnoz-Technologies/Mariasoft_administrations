package net.mariasoft.administrations.service.structres;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Optional;

import net.mariasoft.administrations.domain.Structures;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.mappers.StructuresMapper;
import net.mariasoft.administrations.repository.StructuresRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StructureService.class})
@ExtendWith(SpringExtension.class)
class StructureServiceTU {
    @Autowired
    private StructureService structureService;

    @MockBean
    private StructuresMapper structuresMapper;

    @MockBean
    private StructuresRepository structuresRepository;

    /**
     * Method under test: {@link StructureService#creationStructure(StructuresDto)}
     */
    @Test
    void testCreationStructure() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        when(structuresRepository.saveAndFlush(Mockito.<Structures>any())).thenReturn(structures);

        Structures structures2 = new Structures();
        structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures2.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures2.setId(1L);
        structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures2.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures2.setStrActivite(true);
        structures2.setStrActiviteCommerciale("Str Activite Commerciale");
        structures2.setStrActiviteModeSasie(1);
        structures2.setStrAdresse("Str Adresse");
        structures2.setStrAgent(true);
        structures2.setStrBanqueDefaut("Str Banque Defaut");
        structures2.setStrBilanSocial("Str Bilan Social");
        structures2.setStrCapital("Str Capital");
        structures2.setStrCedex("Str Cedex");
        structures2.setStrChainageAxes(1);
        structures2.setStrChantier(true);
        structures2.setStrCles(true);
        structures2.setStrCodePays("Str Code Pays");
        structures2.setStrCodePostal("Str Code Postal");
        structures2.setStrCommune("Str Commune");
        structures2.setStrDepartement("Str Departement");
        structures2.setStrDescriptif("Str Descriptif");
        structures2.setStrDevise("Str Devise");
        structures2.setStrDossier(1);
        structures2.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures2.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures2.setStrEcommerceVal(42);
        structures2.setStrEtat(1);
        structures2.setStrEtatMandat(1);
        structures2.setStrFax("Str Fax");
        structures2.setStrFormeJuridique("Str Forme Juridique");
        structures2.setStrIsoPays("Str Iso Pays");
        structures2.setStrLangue("Str Langue");
        structures2.setStrLogo("Str Logo");
        structures2.setStrLot("Str Lot");
        structures2.setStrMaitreCabinet(1);
        structures2.setStrMission(true);
        structures2.setStrMode(1);
        structures2.setStrNbCarDossier(1);
        structures2.setStrNomPays("Str Nom Pays");
        structures2.setStrParc(true);
        structures2.setStrPorte("Str Porte");
        structures2.setStrProjet(true);
        structures2.setStrQualiteResponsable("Str Qualite Responsable");
        structures2.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures2.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures2.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures2.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures2.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures2.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures2.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures2.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures2.setStrQuartier("Str Quartier");
        structures2.setStrRaisonSociale("Str Raison Sociale");
        structures2.setStrRegion(true);
        structures2.setStrResponsable("Str Responsable");
        structures2.setStrRue("Str Rue");
        structures2.setStrSigle("Str Sigle");
        structures2.setStrSignature("Str Signature");
        structures2.setStrSite(true);
        structures2.setStrSiteDevise(1);
        structures2.setStrStructure(true);
        structures2.setStrTelephone("6625550144");
        structures2.setStrTypeContact(1);
        structures2.setStrUsine(true);
        structures2.setStrVille("Str Ville");
        structures2.setStrZoneCommerciale("Str Zone Commerciale");
        structures2.setStrZoneFiscale("Str Zone Fiscale");
        structures2.setStrtypEentreprise("Strtyp Eentreprise");
        when(structuresMapper.toEntity(Mockito.<StructuresDto>any())).thenReturn(structures2);
        StructuresDto.StructuresDtoBuilder strDossierResult = StructuresDto.builder()
                .id(1L)
                .strActivite(true)
                .strActiviteCommerciale("Str Activite Commerciale")
                .strActiviteModeSasie(1)
                .strAdresse("Str Adresse")
                .strAgent(true)
                .strBanqueDefaut("Str Banque Defaut")
                .strBilanSocial("Str Bilan Social")
                .strCapital("Str Capital")
                .strCedex("Str Cedex")
                .strChainageAxes(1)
                .strChantier(true)
                .strCles(true)
                .strCodePays("Str Code Pays")
                .strCodePostal("Str Code Postal")
                .strCommune("Str Commune")
                .strDepartement("Str Departement")
                .strDescriptif("Str Descriptif")
                .strDevise("Str Devise")
                .strDossier(1);
        StructuresDto.StructuresDtoBuilder strDteDebMandatResult = strDossierResult
                .strDteDebMandat(LocalDate.of(1970, 1, 1));
        StructuresDto buildResult = strDteDebMandatResult.strDteFinMandat(LocalDate.of(1970, 1, 1))
                .strEcommerceVal(42)
                .strEtat(1)
                .strEtatMandat(1)
                .strFax("Str Fax")
                .strFormeJuridique("Str Forme Juridique")
                .strIsoPays("Str Iso Pays")
                .strLangue("Str Langue")
                .strLogo("Str Logo")
                .strLot("Str Lot")
                .strMaitreCabinet(1)
                .strMission(true)
                .strMode(1)
                .strNbCarDossier(1)
                .strNomPays("Str Nom Pays")
                .strParc(true)
                .strPorte("Str Porte")
                .strProjet(true)
                .strQualiteResponsable("Str Qualite Responsable")
                .strQuart1DebutHeure("Str Quart1 Debut Heure")
                .strQuart1DebutMinute("Str Quart1 Debut Minute")
                .strQuart1FinHeure("Str Quart1 Fin Heure")
                .strQuart1FinMinute("Str Quart1 Fin Minute")
                .strQuart2FinHeure("Str Quart2 Fin Heure")
                .strQuart2FinMinute("Str Quart2 Fin Minute")
                .strQuart3FinHeure("Str Quart3 Fin Heure")
                .strQuart3FinMinute("Str Quart3 Fin Minute")
                .strQuartier("Str Quartier")
                .strRaisonSociale("Str Raison Sociale")
                .strRegion(true)
                .strResponsable("Str Responsable")
                .strRue("Str Rue")
                .strSigle("Str Sigle")
                .strSignature("Str Signature")
                .strSite(true)
                .strSiteDevise(1)
                .strStructure(true)
                .strTelephone("6625550144")
                .strTypeContact(1)
                .strUsine(true)
                .strVille("Str Ville")
                .strZoneCommerciale("Str Zone Commerciale")
                .strZoneFiscale("Str Zone Fiscale")
                .strtypEentreprise("Strtyp Eentreprise")
                .build();
        when(structuresMapper.toDto(Mockito.<Structures>any())).thenReturn(buildResult);
        structureService.creationStructure(new StructuresDto());
        verify(structuresMapper).toDto(Mockito.<Structures>any());
        verify(structuresMapper).toEntity(Mockito.<StructuresDto>any());
        verify(structuresRepository).saveAndFlush(Mockito.<Structures>any());
    }

    /**
     * Method under test: {@link StructureService#creationStructure(StructuresDto)}
     */
    @Test
    void testCreationStructure2() {
        when(structuresMapper.toEntity(Mockito.<StructuresDto>any()))
                .thenThrow(new IllegalArgumentException("Attempting to create Structure with info: {}"));
        assertThrows(IllegalArgumentException.class, () -> structureService.creationStructure(new StructuresDto()));
        verify(structuresMapper).toEntity(Mockito.<StructuresDto>any());
    }

    /**
     * Method under test: {@link StructureService#updateStructure(StructuresDto)}
     */
    @Test
    void testUpdateStructure() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        Optional<Structures> ofResult = Optional.of(structures);

        Structures structures2 = new Structures();
        structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures2.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures2.setId(1L);
        structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures2.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures2.setStrActivite(true);
        structures2.setStrActiviteCommerciale("Str Activite Commerciale");
        structures2.setStrActiviteModeSasie(1);
        structures2.setStrAdresse("Str Adresse");
        structures2.setStrAgent(true);
        structures2.setStrBanqueDefaut("Str Banque Defaut");
        structures2.setStrBilanSocial("Str Bilan Social");
        structures2.setStrCapital("Str Capital");
        structures2.setStrCedex("Str Cedex");
        structures2.setStrChainageAxes(1);
        structures2.setStrChantier(true);
        structures2.setStrCles(true);
        structures2.setStrCodePays("Str Code Pays");
        structures2.setStrCodePostal("Str Code Postal");
        structures2.setStrCommune("Str Commune");
        structures2.setStrDepartement("Str Departement");
        structures2.setStrDescriptif("Str Descriptif");
        structures2.setStrDevise("Str Devise");
        structures2.setStrDossier(1);
        structures2.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures2.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures2.setStrEcommerceVal(42);
        structures2.setStrEtat(1);
        structures2.setStrEtatMandat(1);
        structures2.setStrFax("Str Fax");
        structures2.setStrFormeJuridique("Str Forme Juridique");
        structures2.setStrIsoPays("Str Iso Pays");
        structures2.setStrLangue("Str Langue");
        structures2.setStrLogo("Str Logo");
        structures2.setStrLot("Str Lot");
        structures2.setStrMaitreCabinet(1);
        structures2.setStrMission(true);
        structures2.setStrMode(1);
        structures2.setStrNbCarDossier(1);
        structures2.setStrNomPays("Str Nom Pays");
        structures2.setStrParc(true);
        structures2.setStrPorte("Str Porte");
        structures2.setStrProjet(true);
        structures2.setStrQualiteResponsable("Str Qualite Responsable");
        structures2.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures2.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures2.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures2.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures2.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures2.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures2.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures2.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures2.setStrQuartier("Str Quartier");
        structures2.setStrRaisonSociale("Str Raison Sociale");
        structures2.setStrRegion(true);
        structures2.setStrResponsable("Str Responsable");
        structures2.setStrRue("Str Rue");
        structures2.setStrSigle("Str Sigle");
        structures2.setStrSignature("Str Signature");
        structures2.setStrSite(true);
        structures2.setStrSiteDevise(1);
        structures2.setStrStructure(true);
        structures2.setStrTelephone("6625550144");
        structures2.setStrTypeContact(1);
        structures2.setStrUsine(true);
        structures2.setStrVille("Str Ville");
        structures2.setStrZoneCommerciale("Str Zone Commerciale");
        structures2.setStrZoneFiscale("Str Zone Fiscale");
        structures2.setStrtypEentreprise("Strtyp Eentreprise");
        when(structuresRepository.saveAndFlush(Mockito.<Structures>any())).thenReturn(structures2);
        when(structuresRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Structures structures3 = new Structures();
        structures3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures3.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures3.setId(1L);
        structures3.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures3.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures3.setStrActivite(true);
        structures3.setStrActiviteCommerciale("Str Activite Commerciale");
        structures3.setStrActiviteModeSasie(1);
        structures3.setStrAdresse("Str Adresse");
        structures3.setStrAgent(true);
        structures3.setStrBanqueDefaut("Str Banque Defaut");
        structures3.setStrBilanSocial("Str Bilan Social");
        structures3.setStrCapital("Str Capital");
        structures3.setStrCedex("Str Cedex");
        structures3.setStrChainageAxes(1);
        structures3.setStrChantier(true);
        structures3.setStrCles(true);
        structures3.setStrCodePays("Str Code Pays");
        structures3.setStrCodePostal("Str Code Postal");
        structures3.setStrCommune("Str Commune");
        structures3.setStrDepartement("Str Departement");
        structures3.setStrDescriptif("Str Descriptif");
        structures3.setStrDevise("Str Devise");
        structures3.setStrDossier(1);
        structures3.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures3.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures3.setStrEcommerceVal(42);
        structures3.setStrEtat(1);
        structures3.setStrEtatMandat(1);
        structures3.setStrFax("Str Fax");
        structures3.setStrFormeJuridique("Str Forme Juridique");
        structures3.setStrIsoPays("Str Iso Pays");
        structures3.setStrLangue("Str Langue");
        structures3.setStrLogo("Str Logo");
        structures3.setStrLot("Str Lot");
        structures3.setStrMaitreCabinet(1);
        structures3.setStrMission(true);
        structures3.setStrMode(1);
        structures3.setStrNbCarDossier(1);
        structures3.setStrNomPays("Str Nom Pays");
        structures3.setStrParc(true);
        structures3.setStrPorte("Str Porte");
        structures3.setStrProjet(true);
        structures3.setStrQualiteResponsable("Str Qualite Responsable");
        structures3.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures3.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures3.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures3.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures3.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures3.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures3.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures3.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures3.setStrQuartier("Str Quartier");
        structures3.setStrRaisonSociale("Str Raison Sociale");
        structures3.setStrRegion(true);
        structures3.setStrResponsable("Str Responsable");
        structures3.setStrRue("Str Rue");
        structures3.setStrSigle("Str Sigle");
        structures3.setStrSignature("Str Signature");
        structures3.setStrSite(true);
        structures3.setStrSiteDevise(1);
        structures3.setStrStructure(true);
        structures3.setStrTelephone("6625550144");
        structures3.setStrTypeContact(1);
        structures3.setStrUsine(true);
        structures3.setStrVille("Str Ville");
        structures3.setStrZoneCommerciale("Str Zone Commerciale");
        structures3.setStrZoneFiscale("Str Zone Fiscale");
        structures3.setStrtypEentreprise("Strtyp Eentreprise");
        when(structuresMapper.partialUpdate(Mockito.<StructuresDto>any(), Mockito.<Structures>any()))
                .thenReturn(structures3);
        StructuresDto.StructuresDtoBuilder strDossierResult = StructuresDto.builder()
                .id(1L)
                .strActivite(true)
                .strActiviteCommerciale("Str Activite Commerciale")
                .strActiviteModeSasie(1)
                .strAdresse("Str Adresse")
                .strAgent(true)
                .strBanqueDefaut("Str Banque Defaut")
                .strBilanSocial("Str Bilan Social")
                .strCapital("Str Capital")
                .strCedex("Str Cedex")
                .strChainageAxes(1)
                .strChantier(true)
                .strCles(true)
                .strCodePays("Str Code Pays")
                .strCodePostal("Str Code Postal")
                .strCommune("Str Commune")
                .strDepartement("Str Departement")
                .strDescriptif("Str Descriptif")
                .strDevise("Str Devise")
                .strDossier(1);
        StructuresDto.StructuresDtoBuilder strDteDebMandatResult = strDossierResult
                .strDteDebMandat(LocalDate.of(1970, 1, 1));
        StructuresDto buildResult = strDteDebMandatResult.strDteFinMandat(LocalDate.of(1970, 1, 1))
                .strEcommerceVal(42)
                .strEtat(1)
                .strEtatMandat(1)
                .strFax("Str Fax")
                .strFormeJuridique("Str Forme Juridique")
                .strIsoPays("Str Iso Pays")
                .strLangue("Str Langue")
                .strLogo("Str Logo")
                .strLot("Str Lot")
                .strMaitreCabinet(1)
                .strMission(true)
                .strMode(1)
                .strNbCarDossier(1)
                .strNomPays("Str Nom Pays")
                .strParc(true)
                .strPorte("Str Porte")
                .strProjet(true)
                .strQualiteResponsable("Str Qualite Responsable")
                .strQuart1DebutHeure("Str Quart1 Debut Heure")
                .strQuart1DebutMinute("Str Quart1 Debut Minute")
                .strQuart1FinHeure("Str Quart1 Fin Heure")
                .strQuart1FinMinute("Str Quart1 Fin Minute")
                .strQuart2FinHeure("Str Quart2 Fin Heure")
                .strQuart2FinMinute("Str Quart2 Fin Minute")
                .strQuart3FinHeure("Str Quart3 Fin Heure")
                .strQuart3FinMinute("Str Quart3 Fin Minute")
                .strQuartier("Str Quartier")
                .strRaisonSociale("Str Raison Sociale")
                .strRegion(true)
                .strResponsable("Str Responsable")
                .strRue("Str Rue")
                .strSigle("Str Sigle")
                .strSignature("Str Signature")
                .strSite(true)
                .strSiteDevise(1)
                .strStructure(true)
                .strTelephone("6625550144")
                .strTypeContact(1)
                .strUsine(true)
                .strVille("Str Ville")
                .strZoneCommerciale("Str Zone Commerciale")
                .strZoneFiscale("Str Zone Fiscale")
                .strtypEentreprise("Strtyp Eentreprise")
                .build();
        when(structuresMapper.toDto(Mockito.<Structures>any())).thenReturn(buildResult);
        structureService.updateStructure(new StructuresDto());
        verify(structuresMapper).partialUpdate(Mockito.<StructuresDto>any(), Mockito.<Structures>any());
        verify(structuresMapper).toDto(Mockito.<Structures>any());
        verify(structuresRepository).saveAndFlush(Mockito.<Structures>any());
        verify(structuresRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StructureService#updateStructure(StructuresDto)}
     */
    @Test
    void testUpdateStructure2() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        Optional<Structures> ofResult = Optional.of(structures);
        when(structuresRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(structuresMapper.partialUpdate(Mockito.<StructuresDto>any(), Mockito.<Structures>any()))
                .thenThrow(new IllegalArgumentException("Attempting to update Structure with info: {}"));
        assertThrows(IllegalArgumentException.class, () -> structureService.updateStructure(new StructuresDto()));
        verify(structuresMapper).partialUpdate(Mockito.<StructuresDto>any(), Mockito.<Structures>any());
        verify(structuresRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StructureService#updateStructure(StructuresDto)}
     */
    @Test
    void testUpdateStructure3() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        Optional<Structures> ofResult = Optional.of(structures);
        when(structuresRepository.saveAndFlush(Mockito.<Structures>any())).thenThrow(new RuntimeException("foo"));
        when(structuresRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Structures structures2 = new Structures();
        structures2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures2.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures2.setId(1L);
        structures2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures2.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures2.setStrActivite(true);
        structures2.setStrActiviteCommerciale("Str Activite Commerciale");
        structures2.setStrActiviteModeSasie(1);
        structures2.setStrAdresse("Str Adresse");
        structures2.setStrAgent(true);
        structures2.setStrBanqueDefaut("Str Banque Defaut");
        structures2.setStrBilanSocial("Str Bilan Social");
        structures2.setStrCapital("Str Capital");
        structures2.setStrCedex("Str Cedex");
        structures2.setStrChainageAxes(1);
        structures2.setStrChantier(true);
        structures2.setStrCles(true);
        structures2.setStrCodePays("Str Code Pays");
        structures2.setStrCodePostal("Str Code Postal");
        structures2.setStrCommune("Str Commune");
        structures2.setStrDepartement("Str Departement");
        structures2.setStrDescriptif("Str Descriptif");
        structures2.setStrDevise("Str Devise");
        structures2.setStrDossier(1);
        structures2.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures2.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures2.setStrEcommerceVal(42);
        structures2.setStrEtat(1);
        structures2.setStrEtatMandat(1);
        structures2.setStrFax("Str Fax");
        structures2.setStrFormeJuridique("Str Forme Juridique");
        structures2.setStrIsoPays("Str Iso Pays");
        structures2.setStrLangue("Str Langue");
        structures2.setStrLogo("Str Logo");
        structures2.setStrLot("Str Lot");
        structures2.setStrMaitreCabinet(1);
        structures2.setStrMission(true);
        structures2.setStrMode(1);
        structures2.setStrNbCarDossier(1);
        structures2.setStrNomPays("Str Nom Pays");
        structures2.setStrParc(true);
        structures2.setStrPorte("Str Porte");
        structures2.setStrProjet(true);
        structures2.setStrQualiteResponsable("Str Qualite Responsable");
        structures2.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures2.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures2.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures2.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures2.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures2.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures2.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures2.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures2.setStrQuartier("Str Quartier");
        structures2.setStrRaisonSociale("Str Raison Sociale");
        structures2.setStrRegion(true);
        structures2.setStrResponsable("Str Responsable");
        structures2.setStrRue("Str Rue");
        structures2.setStrSigle("Str Sigle");
        structures2.setStrSignature("Str Signature");
        structures2.setStrSite(true);
        structures2.setStrSiteDevise(1);
        structures2.setStrStructure(true);
        structures2.setStrTelephone("6625550144");
        structures2.setStrTypeContact(1);
        structures2.setStrUsine(true);
        structures2.setStrVille("Str Ville");
        structures2.setStrZoneCommerciale("Str Zone Commerciale");
        structures2.setStrZoneFiscale("Str Zone Fiscale");
        structures2.setStrtypEentreprise("Strtyp Eentreprise");
        when(structuresMapper.partialUpdate(Mockito.<StructuresDto>any(), Mockito.<Structures>any()))
                .thenReturn(structures2);
        StructuresDto.StructuresDtoBuilder strDossierResult = StructuresDto.builder()
                .id(1L)
                .strActivite(true)
                .strActiviteCommerciale("Str Activite Commerciale")
                .strActiviteModeSasie(1)
                .strAdresse("Str Adresse")
                .strAgent(true)
                .strBanqueDefaut("Str Banque Defaut")
                .strBilanSocial("Str Bilan Social")
                .strCapital("Str Capital")
                .strCedex("Str Cedex")
                .strChainageAxes(1)
                .strChantier(true)
                .strCles(true)
                .strCodePays("Str Code Pays")
                .strCodePostal("Str Code Postal")
                .strCommune("Str Commune")
                .strDepartement("Str Departement")
                .strDescriptif("Str Descriptif")
                .strDevise("Str Devise")
                .strDossier(1);
        StructuresDto.StructuresDtoBuilder strDteDebMandatResult = strDossierResult
                .strDteDebMandat(LocalDate.of(1970, 1, 1));
        StructuresDto structuresDto = strDteDebMandatResult.strDteFinMandat(LocalDate.of(1970, 1, 1))
                .strEcommerceVal(42)
                .strEtat(1)
                .strEtatMandat(1)
                .strFax("Str Fax")
                .strFormeJuridique("Str Forme Juridique")
                .strIsoPays("Str Iso Pays")
                .strLangue("Str Langue")
                .strLogo("Str Logo")
                .strLot("Str Lot")
                .strMaitreCabinet(1)
                .strMission(true)
                .strMode(1)
                .strNbCarDossier(1)
                .strNomPays("Str Nom Pays")
                .strParc(true)
                .strPorte("Str Porte")
                .strProjet(true)
                .strQualiteResponsable("Str Qualite Responsable")
                .strQuart1DebutHeure("Str Quart1 Debut Heure")
                .strQuart1DebutMinute("Str Quart1 Debut Minute")
                .strQuart1FinHeure("Str Quart1 Fin Heure")
                .strQuart1FinMinute("Str Quart1 Fin Minute")
                .strQuart2FinHeure("Str Quart2 Fin Heure")
                .strQuart2FinMinute("Str Quart2 Fin Minute")
                .strQuart3FinHeure("Str Quart3 Fin Heure")
                .strQuart3FinMinute("Str Quart3 Fin Minute")
                .strQuartier("Str Quartier")
                .strRaisonSociale("Str Raison Sociale")
                .strRegion(true)
                .strResponsable("Str Responsable")
                .strRue("Str Rue")
                .strSigle("Str Sigle")
                .strSignature("Str Signature")
                .strSite(true)
                .strSiteDevise(1)
                .strStructure(true)
                .strTelephone("6625550144")
                .strTypeContact(1)
                .strUsine(true)
                .strVille("Str Ville")
                .strZoneCommerciale("Str Zone Commerciale")
                .strZoneFiscale("Str Zone Fiscale")
                .strtypEentreprise("Strtyp Eentreprise")
                .build();
        assertThrows(RuntimeException.class, () -> structureService.updateStructure(structuresDto));
        verify(structuresMapper).partialUpdate(Mockito.<StructuresDto>any(), Mockito.<Structures>any());
        verify(structuresRepository).saveAndFlush(Mockito.<Structures>any());
        verify(structuresRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StructureService#deleteStructure(Long)}
     */
    @Test
    void testDeleteStructure() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        Optional<Structures> ofResult = Optional.of(structures);
        doNothing().when(structuresRepository).delete(Mockito.<Structures>any());
        when(structuresRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        structureService.deleteStructure(1L);
        verify(structuresRepository).delete(Mockito.<Structures>any());
        verify(structuresRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StructureService#deleteStructure(Long)}
     */
    @Test
    void testDeleteStructure2() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        Optional<Structures> ofResult = Optional.of(structures);
        doThrow(new RuntimeException("Attempting to delete Structure with info: {}")).when(structuresRepository)
                .delete(Mockito.<Structures>any());
        when(structuresRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> structureService.deleteStructure(1L));
        verify(structuresRepository).delete(Mockito.<Structures>any());
        verify(structuresRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StructureService#getStructure(Long)}
     */
    @Test
    void testGetStructure() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        Optional<Structures> ofResult = Optional.of(structures);
        when(structuresRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        StructuresDto.StructuresDtoBuilder strDossierResult = StructuresDto.builder()
                .id(1L)
                .strActivite(true)
                .strActiviteCommerciale("Str Activite Commerciale")
                .strActiviteModeSasie(1)
                .strAdresse("Str Adresse")
                .strAgent(true)
                .strBanqueDefaut("Str Banque Defaut")
                .strBilanSocial("Str Bilan Social")
                .strCapital("Str Capital")
                .strCedex("Str Cedex")
                .strChainageAxes(1)
                .strChantier(true)
                .strCles(true)
                .strCodePays("Str Code Pays")
                .strCodePostal("Str Code Postal")
                .strCommune("Str Commune")
                .strDepartement("Str Departement")
                .strDescriptif("Str Descriptif")
                .strDevise("Str Devise")
                .strDossier(1);
        StructuresDto.StructuresDtoBuilder strDteDebMandatResult = strDossierResult
                .strDteDebMandat(LocalDate.of(1970, 1, 1));
        StructuresDto buildResult = strDteDebMandatResult.strDteFinMandat(LocalDate.of(1970, 1, 1))
                .strEcommerceVal(42)
                .strEtat(1)
                .strEtatMandat(1)
                .strFax("Str Fax")
                .strFormeJuridique("Str Forme Juridique")
                .strIsoPays("Str Iso Pays")
                .strLangue("Str Langue")
                .strLogo("Str Logo")
                .strLot("Str Lot")
                .strMaitreCabinet(1)
                .strMission(true)
                .strMode(1)
                .strNbCarDossier(1)
                .strNomPays("Str Nom Pays")
                .strParc(true)
                .strPorte("Str Porte")
                .strProjet(true)
                .strQualiteResponsable("Str Qualite Responsable")
                .strQuart1DebutHeure("Str Quart1 Debut Heure")
                .strQuart1DebutMinute("Str Quart1 Debut Minute")
                .strQuart1FinHeure("Str Quart1 Fin Heure")
                .strQuart1FinMinute("Str Quart1 Fin Minute")
                .strQuart2FinHeure("Str Quart2 Fin Heure")
                .strQuart2FinMinute("Str Quart2 Fin Minute")
                .strQuart3FinHeure("Str Quart3 Fin Heure")
                .strQuart3FinMinute("Str Quart3 Fin Minute")
                .strQuartier("Str Quartier")
                .strRaisonSociale("Str Raison Sociale")
                .strRegion(true)
                .strResponsable("Str Responsable")
                .strRue("Str Rue")
                .strSigle("Str Sigle")
                .strSignature("Str Signature")
                .strSite(true)
                .strSiteDevise(1)
                .strStructure(true)
                .strTelephone("6625550144")
                .strTypeContact(1)
                .strUsine(true)
                .strVille("Str Ville")
                .strZoneCommerciale("Str Zone Commerciale")
                .strZoneFiscale("Str Zone Fiscale")
                .strtypEentreprise("Strtyp Eentreprise")
                .build();
        when(structuresMapper.toDto(Mockito.<Structures>any())).thenReturn(buildResult);
        structureService.getStructure(1L);
        verify(structuresMapper).toDto(Mockito.<Structures>any());
        verify(structuresRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StructureService#getStructure(Long)}
     */
    @Test
    void testGetStructure2() {
        Structures structures = new Structures();
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        structures.setCreatedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setId(1L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        structures.setLastModifiedDate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        structures.setStrActivite(true);
        structures.setStrActiviteCommerciale("Str Activite Commerciale");
        structures.setStrActiviteModeSasie(1);
        structures.setStrAdresse("Str Adresse");
        structures.setStrAgent(true);
        structures.setStrBanqueDefaut("Str Banque Defaut");
        structures.setStrBilanSocial("Str Bilan Social");
        structures.setStrCapital("Str Capital");
        structures.setStrCedex("Str Cedex");
        structures.setStrChainageAxes(1);
        structures.setStrChantier(true);
        structures.setStrCles(true);
        structures.setStrCodePays("Str Code Pays");
        structures.setStrCodePostal("Str Code Postal");
        structures.setStrCommune("Str Commune");
        structures.setStrDepartement("Str Departement");
        structures.setStrDescriptif("Str Descriptif");
        structures.setStrDevise("Str Devise");
        structures.setStrDossier(1);
        structures.setStrDteDebMandat(LocalDate.of(1970, 1, 1));
        structures.setStrDteFinMandat(LocalDate.of(1970, 1, 1));
        structures.setStrEcommerceVal(42);
        structures.setStrEtat(1);
        structures.setStrEtatMandat(1);
        structures.setStrFax("Str Fax");
        structures.setStrFormeJuridique("Str Forme Juridique");
        structures.setStrIsoPays("Str Iso Pays");
        structures.setStrLangue("Str Langue");
        structures.setStrLogo("Str Logo");
        structures.setStrLot("Str Lot");
        structures.setStrMaitreCabinet(1);
        structures.setStrMission(true);
        structures.setStrMode(1);
        structures.setStrNbCarDossier(1);
        structures.setStrNomPays("Str Nom Pays");
        structures.setStrParc(true);
        structures.setStrPorte("Str Porte");
        structures.setStrProjet(true);
        structures.setStrQualiteResponsable("Str Qualite Responsable");
        structures.setStrQuart1DebutHeure("Str Quart1 Debut Heure");
        structures.setStrQuart1DebutMinute("Str Quart1 Debut Minute");
        structures.setStrQuart1FinHeure("Str Quart1 Fin Heure");
        structures.setStrQuart1FinMinute("Str Quart1 Fin Minute");
        structures.setStrQuart2FinHeure("Str Quart2 Fin Heure");
        structures.setStrQuart2FinMinute("Str Quart2 Fin Minute");
        structures.setStrQuart3FinHeure("Str Quart3 Fin Heure");
        structures.setStrQuart3FinMinute("Str Quart3 Fin Minute");
        structures.setStrQuartier("Str Quartier");
        structures.setStrRaisonSociale("Str Raison Sociale");
        structures.setStrRegion(true);
        structures.setStrResponsable("Str Responsable");
        structures.setStrRue("Str Rue");
        structures.setStrSigle("Str Sigle");
        structures.setStrSignature("Str Signature");
        structures.setStrSite(true);
        structures.setStrSiteDevise(1);
        structures.setStrStructure(true);
        structures.setStrTelephone("6625550144");
        structures.setStrTypeContact(1);
        structures.setStrUsine(true);
        structures.setStrVille("Str Ville");
        structures.setStrZoneCommerciale("Str Zone Commerciale");
        structures.setStrZoneFiscale("Str Zone Fiscale");
        structures.setStrtypEentreprise("Strtyp Eentreprise");
        Optional<Structures> ofResult = Optional.of(structures);
        when(structuresRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(structuresMapper.toDto(Mockito.<Structures>any()))
                .thenThrow(new RuntimeException("Attempting to get Structure by id: {}"));
        assertThrows(RuntimeException.class, () -> structureService.getStructure(1L));
        verify(structuresMapper).toDto(Mockito.<Structures>any());
        verify(structuresRepository).findById(Mockito.<Long>any());
    }
}
