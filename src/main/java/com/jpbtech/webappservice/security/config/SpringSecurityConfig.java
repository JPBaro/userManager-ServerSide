
package com.jpbtech.webappservice.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jpbtech.webappservice.security.filter.JWTAuthenticationFilter;
import com.jpbtech.webappservice.security.filter.JWTLoginFilter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests()
	                // No need authentication.
	                .antMatchers("/").permitAll() //
	                .antMatchers(HttpMethod.POST, "/login").permitAll() //
	                .antMatchers(HttpMethod.GET, "/login").permitAll() // For Test on Browser REMOVEEEEEEE!!! jp
	                // Need authentication.
	                .anyRequest().authenticated()
	                //
	                .and()
	                //
	                // Add Filter 1 - JWTLoginFilter
	                //
	                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
	                //
	                // Add Filter 2 - JWTAuthenticationFilter
	                //
	                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
	                .cors();
	    }
	 
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 
	        String password = "123";
	 
	        String encrytedPassword = this.passwordEncoder().encode(password);
	        System.out.println("Encoded password of 123=" + encrytedPassword); // testing purposes JP
	 
	        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> //
	        mngConfig = auth.inMemoryAuthentication();
	 
	        // Defines 2 users, stored in memory.
	        // ** Spring BOOT >= 2.x (Spring Security 5.x)
	        // Spring auto add ROLE_
	        UserDetails u1 = User.withUsername("jpb").password(encrytedPassword).roles("USER").build();
	        UserDetails u2 = User.withUsername("guest").password(encrytedPassword).roles("USER").build();
	 
	        mngConfig.withUser(u1);
	        mngConfig.withUser(u2);
	 
	        // If Spring BOOT < 2.x (Spring Security 4.x)):
	        // Spring auto add ROLE_
	        // mngConfig.withUser("tom").password("123").roles("USER");
	        // mngConfig.withUser("jerry").password("123").roles("USER");
	 
	    }
	     
	}