package net.mariasoft.administrations.config.declaration;

import io.swagger.v3.oas.models.info.Info;
import net.mariasoft.administrations.utils.MariasoftOpenApiCustomizer;
import net.mariasoft.administrations.utils.MariasoftProperies;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.customizers.ActuatorOpenApiCustomizer;
import org.springdoc.core.customizers.ActuatorOperationCustomizer;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;

import static org.springdoc.core.utils.Constants.DEFAULT_GROUP_NAME;
import static org.springdoc.core.utils.Constants.SPRINGDOC_SHOW_ACTUATOR;
import static org.springdoc.core.utils.SpringDocUtils.getConfig;

@Configuration
public class MariasoftSpringDocGroupsConfiguration {
    public static final String MANAGEMENT_GROUP_NAME = "management";

    static {
        getConfig().replaceWithClass(ByteBuffer.class, String.class);
    }

    static final String MANAGEMENT_TITLE_SUFFIX = "Management API";
    static final String MANAGEMENT_DESCRIPTION = "Management endpoints documentation";

    private final Logger log = LoggerFactory.getLogger(MariasoftSpringDocGroupsConfiguration.class);

    private final MariasoftProperies.ApiDocs properties;

    /**
     * <p>Constructor for OpenApiAutoConfiguration.</p>
     *
     * @param jHipsterProperties a {@link MariasoftProperies} object.
     */
    public MariasoftSpringDocGroupsConfiguration(MariasoftProperies jHipsterProperties) {
        properties = jHipsterProperties.getApiDocs();
    }

    /**
     * JHipster OpenApi Customiser
     *
     * @return the Customizer of JHipster
     */
    @Bean
    public MariasoftOpenApiCustomizer jhipsterOpenApiCustomizer() {
        log.debug("Initializing JHipster OpenApi customizer");
        return new MariasoftOpenApiCustomizer(properties);
    }

    /**
     * OpenApi default group configuration.
     *
     * @return the GroupedOpenApi configuration
     */
    @Bean
    @ConditionalOnMissingBean(name = "openAPIDefaultGroupedOpenAPI")
    public GroupedOpenApi openAPIDefaultGroupedOpenAPI(
            List<OpenApiCustomizer> openApiCustomizers,
            List<OperationCustomizer> operationCustomizers,
            @Qualifier("apiFirstGroupedOpenAPI") Optional<GroupedOpenApi> apiFirstGroupedOpenAPI) {
        log.debug("Initializing JHipster OpenApi default group");
        GroupedOpenApi.Builder builder = GroupedOpenApi.builder()
                .group(DEFAULT_GROUP_NAME)
                .pathsToMatch(properties.getDefaultIncludePattern());
        openApiCustomizers.stream()
                .filter(customizer -> !(customizer instanceof ActuatorOpenApiCustomizer))
                .forEach(builder::addOpenApiCustomizer);
        operationCustomizers.stream()
                .filter(customizer -> !(customizer instanceof ActuatorOperationCustomizer))
                .forEach(builder::addOperationCustomizer);
        apiFirstGroupedOpenAPI.map(GroupedOpenApi::getPackagesToScan)
                .ifPresent(packagesToScan -> packagesToScan.forEach(builder::packagesToExclude));
        return builder.build();
    }

    /**
     * OpenApi management group configuration for the management endpoints (actuator) OpenAPI docs.
     *
     * @return the GroupedOpenApi configuration
     */
    @Bean
    @ConditionalOnClass(name = "org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties")
    @ConditionalOnMissingBean(name = "openAPIManagementGroupedOpenAPI")
    @ConditionalOnProperty(SPRINGDOC_SHOW_ACTUATOR)
    public GroupedOpenApi openAPIManagementGroupedOpenAPI(
            @Value("${spring.application.name:application}") String appName
    ) {
        log.debug("Initializing JHipster OpenApi management group");
        return GroupedOpenApi.builder()
                .group(MANAGEMENT_GROUP_NAME)
                .addOpenApiCustomizer(openApi -> openApi.info(new Info()
                        .title(StringUtils.capitalize(appName) + " " + MANAGEMENT_TITLE_SUFFIX)
                        .description(MANAGEMENT_DESCRIPTION)
                        .version(properties.getVersion())
                ))
                .pathsToMatch(properties.getManagementIncludePattern())
                .build();
    }
}

