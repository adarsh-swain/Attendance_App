package com.ams.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests(
						(auth) -> auth.requestMatchers("/employees/**").authenticated().anyRequest().permitAll())
				.formLogin(formLogin -> formLogin.loginPage("/login").defaultSuccessUrl("/employees/getAllEmployee", true).permitAll())
				.exceptionHandling(exceptionHandling -> exceptionHandling
			            .accessDeniedPage("/error/403"));
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("cmgi").password(encoder.encode("1234")) .roles("ADMIN").build();
		UserDetails superadmin = User.withUsername("cmgi1").password(encoder.encode("1234")).roles("SUPERADMIN").build();
		return new InMemoryUserDetailsManager(admin, superadmin);
	}

}
