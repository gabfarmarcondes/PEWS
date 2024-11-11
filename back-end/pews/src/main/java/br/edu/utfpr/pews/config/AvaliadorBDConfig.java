package br.edu.utfpr.pews.config;


import br.edu.utfpr.pews.repository.avaliador.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = AvaliadorRepository.class,
        entityManagerFactoryRef = "avaliadorEntityManager")
public class AvaliadorBDConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "avaliador.datasource")
    public DataSource avalaidorDataSource() { return DataSourceBuilder.create().build(); }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean avaliadorEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier(value = "avalaidorDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("br.edu.utfpr.pews.model.avaliador")
                .build();
    }
}
