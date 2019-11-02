package hw.loan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()

                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("admin").authorities("master")

                .and()

                .withUser("manager")
                .password(passwordEncoder().encode("manager"))
                .roles("manager").authorities("manager-common", "upload", "search", "whatever")

                .and()

                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .roles("user").authorities("user-commmon");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/inside").permitAll()
                .antMatchers("/inside/admin").hasAnyAuthority("master")
                .antMatchers("/inside/manager").hasAnyAuthority("master", "manager-common")
                .antMatchers("/inside/user").hasAnyAuthority("master", "manager-common", "user-common")

                .and()

                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")

                .and()

                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
