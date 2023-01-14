package hitzseb.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.httpBasic().and().cors().and().csrf().disable()
			.authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/", "/posts", "/register", "/login").permitAll()
			.anyRequest().authenticated()
			)
			.formLogin()
      		.loginPage("/login");
		
		return http.build();
		
	}
	
}
