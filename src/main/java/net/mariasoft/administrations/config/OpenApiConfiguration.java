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
}
