package net.mariasoft.administrations.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.*;
import net.mariasoft.administrations.enumeration.FormeJuridiqueEnum;
import net.mariasoft.administrations.enumeration.TypeSocieteEnum;
import net.mariasoft.administrations.enumeration.ZoneCommercialEnum;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commun_structures")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@EqualsAndHashCode
public class Structures extends AbstractAuditingEntity<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "str_ecommerce_val")
    private Integer strEcommerceVal;
    @Column(name = "str_etat")
    private Integer strEtat;
    @Column(name = "str_mode")
    private Integer strMode;
    @Column(name = "str_maitre_cabinet")
    private Integer strMaitreCabinet;
    @NotNull(message = "La Rasison Social ne peut pas être null")
    @Size(max = 100)
    @Column(name = "str_raison_sociale",unique = true)
    private String strRaisonSociale;
    @Column(name = "str_Descriptif")
    private String strDescriptif;
    @NotNull(message = "Le Sigle ne peut pas être null")
    @Size(message = "Le sigle doit être compris entre 2 et 50 caractères", min = 2, max = 50)
    @Column(name = "str_Sigle",unique = true)
    private String strSigle;
    @Column(name = "str_nom_pays")
    private String strNomPays;
    @Column(name = "str_code_pays")
    private String strCodePays;
    @Column(name = "str_iso_pays")
    private String strIsoPays;
    @Column(name = "str_devise")
    private String strDevise;
    @Column(name = "str_site_devise")
    private Integer strSiteDevise;
    @Column(name = "str_Langue")
    private String strLangue;
    @Column(name = "str_zone_fiscale")
    private String strZoneFiscale;
    @Column(name = "str_zone_commerciale")
    private String strZoneCommerciale= ZoneCommercialEnum.UEMOA.getCode();
    @Column(name = "str_bilansocial")
    private String strBilanSocial;
    @Column(name = "str_formejuridique")
    private String strFormeJuridique= FormeJuridiqueEnum.EI.name();
    @Column(name = "str_type_entreprise")
    private String strtypEentreprise= TypeSocieteEnum.PRESTATION.name();
    @Column(name = "str_adresse")
    private String strAdresse;
    @Column(name = "str_rue")
    private String strRue;
    @Column(name = "str_lot")
    private String strLot;
    @Column(name = "str_porte")
    private String strPorte;
    @Column(name = "str_quartier")
    private String strQuartier;
    @Column(name = "str_ville")
    private String strVille;
    @Column(name = "str_commune")
    private String strCommune;
    @Column(name = "str_departement")
    private String strDepartement;
    @Column(name="str_code_postal")
    private String strCodePostal;
    @Column(name = "str_cedex")
    private String strCedex;
    @Column(name = "str_telephone")
    private String strTelephone;
    @Column(name = "str_fax")
    private String strFax;
    @Column(name = "str_activite_commerciale")
    private String strActiviteCommerciale;
    @Column(name = "str_logo")
    private String strLogo;
    @Column(name = "str_type_contact")
    private Integer strTypeContact;
    @Column(name = "str_responsable")
    private String strResponsable;
    @Column(name = "str_qualite_responsable")
    private String strQualiteResponsable;
    @Column(name = "str_capital")
    private String strCapital;

    private Boolean strStructure;
    private Boolean strChantier;
    private Boolean strMission;
    private Boolean strSite;
    private Boolean strRegion;
    private Boolean strUsine;
    private Boolean strActivite;
    private Integer strActiviteModeSasie;
    private Boolean strParc;
    private Integer strDossier;
    private Integer strNbCarDossier;
    private Integer strChainageAxes;
    private Boolean strAgent;
    private Boolean strCles;
    private Boolean strProjet;
    private String strQuart1DebutHeure;
    private String strQuart1DebutMinute;
    private String strQuart1FinHeure;
    private String strQuart1FinMinute;
    private String strQuart2FinHeure;
    private String strQuart2FinMinute;
    private String strQuart3FinHeure;
    private String strQuart3FinMinute;
    private String strBanqueDefaut;
    private LocalDate strDteDebMandat;
    private LocalDate strDteFinMandat;
    private Integer strEtatMandat;
    private String strSignature;

}
