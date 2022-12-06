package com.nomina.nomina1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl usuarioDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioDetailsService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
         * http.authorizeRequests().antMatchers("/","/css/**","/font/**","/img/**",
         * "/js/**","/json/**","/sass/**","/empleado/**","/cargo/**").permitAll().
         * anyRequest().authenticated()
         * 
         * .and()
         * .formLogin().loginPage("/login").defaultSuccessUrl("/home",
         * true).failureUrl("/login?error=true")
         * .loginProcessingUrl("/loginpost").permitAll()
         * .and()
         * .logout().logoutUrl("/logout").logoutSuccessUrl("/");*/
         

        http.authorizeRequests().antMatchers(
                "/index/**", "/public/**", "/css/**", "/js/**", "/img/**","/resources/****","/nomina/**","/comision/**","/Convenio/**","/Incapacidad/**","/Pago/**",
                "/app-assets/**", "/fonts/**", "/error/**", "/empleado/**","/cargo/**","/login/**","/he/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home")
                .permitAll();
                
    }

}