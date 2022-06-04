package org.serratec.backend.projetofinalecommerce.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserServiceImpl userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userService)
		.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers()
		.permitAll()
		.anyRequest()
		.authenticated()
		.and().sessionManagement();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

/*
 	nosso próprio sistema de encodificação
 	
	@Bean
	public PasswordEncoder passwordEncoder () {
		PasswordEncoder pEncoder = new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword + "123";
			}
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				
				return (rawPassword + "123").equals(encodedPassword);
			}
		}
	} 
	
*/

}
