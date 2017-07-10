package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/7/10.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication().withUser("zyliu").password("123456").roles("admin")
                .and().withUser("admin").password("147258").roles("admin");*/
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("")
            .authoritiesByUsernameQuery("")
            .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("")
                .and().httpBasic()
                .and().rememberMe().key("connKey")
                .and().logout().logoutUrl("doLogout").logoutSuccessUrl("/")
                .and().authorizeRequests()
                    .antMatchers("/search/***").authenticated()
                    .anyRequest().permitAll();
    }
}
