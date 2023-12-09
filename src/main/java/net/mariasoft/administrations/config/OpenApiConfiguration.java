package net.mariasoft.administrations.config;

import net.mariasoft.administrations.utils.MariasoftOpenApiCustomizer;
import net.mariasoft.administrations.utils.MariasoftProperies;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    public static final String API_FIRST_PACKAGE = "net.mariasoft.administrations.web.api";

    /**
     * Configure et renvoie un bean GroupedOpenApi pour le groupe "openapi".
     *
     * @param mariasoftOpenApiCustomizer Une instance de MariasoftOpenApiCustomizer utilisée pour personnaliser les métadonnées OpenAPI.
     * @param mariasoftProperies Une instance de MariasoftProperies contenant les propriétés de documentation de l'API.
     * @return Le bean GroupedOpenApi pour le groupe "openapi".
     */
    @Bean
    @ConditionalOnMissingBean(name = "apiFirstGroupedOpenAPI")
    public GroupedOpenApi apiFirstGroupedOpenAPI(
        MariasoftOpenApiCustomizer mariasoftOpenApiCustomizer,
        MariasoftProperies mariasoftProperies
    ) {
        MariasoftProperies.ApiDocs properties = mariasoftProperies.getApiDocs();
        return GroupedOpenApi
            .builder()
            .group("openapi")
            .addOpenApiCustomizer(mariasoftOpenApiCustomizer)
            .packagesToScan(API_FIRST_PACKAGE)
            .pathsToMatch(properties.getDefaultIncludePattern())
            .build();
    }

    /**
     * Renvoie un bean GroupedOpenApi pour la documentation de l'API publique.
     *
     * @return Le bean GroupedOpenApi pour l'API publique.
     */
    @Bean
    public GroupedOpenApi publicAPI() {
        return GroupedOpenApi.builder().group("public")
                .pathsToMatch("/public/**")
                .build();
    }

    /**
     * Renvoie un bean GroupedOpenApi pour la documentation de l'API privée.
     *
     * @return Le bean GroupedOpenApi pour l'API privée.
     */
    @Bean
    public GroupedOpenApi privateAPI() {
        return GroupedOpenApi.builder().group("private")
                .pathsToMatch("/private/**")
                .build();
    }

}