package org.generation.imei.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired // injeção de dependencia
	private UserDetailsService userDetailsService;

	@Override // sobreescrita de metodo
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/usuario/logar").permitAll()
		.antMatchers("/usuario/cadastrar").permitAll()
		.antMatchers("/usuario/{id}").permitAll()
		.antMatchers("/usuario/atualizar").permitAll()
		.antMatchers("/usuario/postagem/**").permitAll()
		.anyRequest().authenticated().and().httpBasic().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors().and().csrf().disable();
		// para liberar endpoints dentro do controller para o cliente ter acesso a ele
		// sem precisar de token

	}
}
