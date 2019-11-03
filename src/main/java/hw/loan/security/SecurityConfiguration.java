package hw.loan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
                .authorities("admin")

                .and()

                .withUser("manager")
                .password(passwordEncoder().encode("manager"))
                .authorities("manager", "upload", "search", "whatever")

                .and()

                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .authorities("user-common");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/inside").permitAll()
                .antMatchers("/inside/admin").hasAnyAuthority("admin")
                .antMatchers("/inside/manager").hasAnyAuthority("admin", "manager")
                .antMatchers("/inside/user").hasAnyAuthority("admin", "manager", "user-common")

                .and()

                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")

                .and()

                .httpBasic();
    }

//    @Bean
//    DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        //daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
//
//        return daoAuthenticationProvider;
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
