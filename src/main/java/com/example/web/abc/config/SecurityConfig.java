package com.example.web.abc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@WebGüvenligiAktifEtme
@EnableWebMvcSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter { 
	
    @Autowired
    private UserDetailsService userDetailsService;
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    
    	.antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
    	   .antMatchers("/register").permitAll()
           .anyRequest()
           .authenticated()
           .and()
    		.formLogin().loginPage("/login") .permitAll()
    		.successHandler(myAuthenticationSuccessHandler())
    	    		.failureUrl("/loginPage?error")
    		.usernameParameter("username")
    		    		.and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll();
    }
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
       
		.withUser("admin").password("123456").authorities("ROLE_ADMIN");
		
				auth    .userDetailsService(userDetailsService);
        			
    }
}
