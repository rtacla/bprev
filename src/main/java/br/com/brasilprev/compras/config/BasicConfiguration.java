package br.com.brasilprev.compras.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/api/**").authenticated().and().httpBasic().and()
                .authorizeRequests().antMatchers("/h2-console").hasRole("ADMIN")
                		.antMatchers("/h2-console/**").hasRole("ADMIN")
                		.antMatchers("/swagger-ui.html").hasRole("USER")
                		.antMatchers("/swagger-ui.html/**").hasRole("USER");
        
        httpSecurity.headers().frameOptions().disable();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user").password("{noop}123456").roles("USER")
		.and()
		.withUser("admin").password("{noop}admin123").roles("USER", "ADMIN");
	}
}
