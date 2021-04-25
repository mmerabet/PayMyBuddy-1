package com.steve.paymybuddy.config;

import com.steve.paymybuddy.dao.UserDao;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Override
    protected void configure(HttpSecurity httpSecurity ) throws Exception{
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests().antMatchers("/actuactor*").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/actuactor/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/h2-console/**/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET,"/*").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST, "/*").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.PUT, "/*").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE, "/*").permitAll();
        httpSecurity.formLogin().loginPage("/connect/formConnexion").permitAll();
        httpSecurity.logout().invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logout?logout");
    }
   @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   }
   @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
   }
   @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider());
   }
}
