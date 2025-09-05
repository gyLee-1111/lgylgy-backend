package com.bmm.api.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.bmm.api.logIn.security.JwtAuthenticationFilter;
import com.bmm.api.logIn.security.JwtUtil;

@Configuration
public class SecurityConfig {

	private final JwtUtil jwtUtil;

	public SecurityConfig(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtil);

		return http
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.csrf(csrf -> csrf.disable())
				.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						auth -> auth
						.requestMatchers(
								"/test/getTest",
								"/images/**",
							    "/public/**", 
				                "/login/logInApi",
				                "/login/refreshToken",
				                "/login/logOut",
				                "/login/changeRole",
				                "/login/getUserMenu",
				                "/user/keyword/getListKeyword",
				                "/login/kakao/logIn",
				                "/join/**"
				           //     "/reviewPop/**",
				               /* "/user/keyword/getListKeyword",*/
			//	                "/login/**"
						//권한에 맞춰서 /admin/user/public url 주소 맞추기
								)
						.permitAll()
						.anyRequest()
						.authenticated())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
		
		//permitAll 걍 넘어감
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
	//	config.setAllowedOrigins(List.of("http://localhost:5174"));  // 🔧 프론트 주소
		config.setAllowedOriginPatterns(List.of("https://calm-stone-09e440100.1.azurestaticapps.net","http://calm-stone-09e440100.1.azurestaticapps.net"));
		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowedHeaders(List.of("*"));
		config.setExposedHeaders(List.of("Content-Disposition"));
		config.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}	
		
		
		
		
		
	
/*
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(AbstractHttpConfigurer::disable)
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/admin/**").hasRole("ADMIN")       // <- 핵심!
	            .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
	            .anyRequest().authenticated()
	        )
	        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	*/

