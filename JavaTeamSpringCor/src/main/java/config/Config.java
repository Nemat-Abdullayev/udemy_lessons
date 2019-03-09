package config;

import Model.Member;
import data.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;


@Configuration
@PropertySource("classpath:datasource.properties")
public class Config {

    @Autowired
    private Environment environment;


    @Bean(name = "member")
    public Member member() {

        Member member = new Member();
        member.setId(1);
        member.setName("Nemet");
        member.setSurname("Abdullayev");
        return member;

    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("db.drive"));
        dataSource.setUrl(environment.getRequiredProperty("db.url"));
        dataSource.setUsername(environment.getRequiredProperty("db.username"));
        dataSource.setPassword(environment.getRequiredProperty("db.password"));
        return dataSource;
    }

    @Bean(name = "dataManager")
    public DataManager dataManager() {
        DataManager dataManager = new DataManager();
        //dataManager.setDataSource(dataSource());
        return dataManager;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
}
