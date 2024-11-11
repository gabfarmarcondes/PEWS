package br.edu.utfpr.pews.config;


import br.edu.utfpr.pews.repository.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = PacienteRepository.class,
        entityManagerFactoryRef = "pacienteEntityManager")
public class PacienteBDConfig {

    @Bean
    @ConfigurationProperties(prefix="paciente.datasource")
    public DataSource pacienteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean pacienteEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier(value = "pacienteDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("br.edu.utfpr.pews.model.paciente")
                .build();

    }
}
