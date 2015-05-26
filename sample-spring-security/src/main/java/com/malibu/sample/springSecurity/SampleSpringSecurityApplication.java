package com.malibu.sample.springSecurity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.malibu.sample.springSecurity.service.InitService;

@SpringBootApplication
public class SampleSpringSecurityApplication extends WebSecurityConfigurerAdapter {
	
	@Autowired
	InitService initService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@PostConstruct
	public void postConstruct() {
		initService.initData();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin().permitAll() //로그인 화면을 사용함을 알림
		.and().logout().logoutSuccessUrl("/") //로그아웃한후 메인화면(/)으로 간다
		.and().authorizeRequests().antMatchers("/").permitAll() //첫 페이지는 아무나 접근 가능
		.and().authorizeRequests().antMatchers("/users").hasAuthority("ADMIN") //사용자 목록 페이지는 ADMIN 역할을 가진 계정으로 로그인해야 접근가능
		.and().exceptionHandling().accessDeniedPage("/accessDenied") //접근권한 없을때 보여줄 페이지
		.and().authorizeRequests().anyRequest().authenticated(); //그외 페이지들은 모두 인증을 받아야 함
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SampleSpringSecurityApplication.class, args);
	}
}
