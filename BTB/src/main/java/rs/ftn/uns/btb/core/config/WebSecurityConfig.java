package rs.ftn.uns.btb.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import rs.ftn.uns.btb.core.security.CustomUserDetailsServiceImpl;
import rs.ftn.uns.btb.core.security.auth.RestAuthenticationEntryPoint;
import rs.ftn.uns.btb.core.security.auth.TokenAuthenticationFilter;
import rs.ftn.uns.btb.core.util.TokenUtils;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {
    
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private TokenUtils tokenUtils;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsServiceImpl();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        
        return authProvider;
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    private static final String[] AUTH_WHITELIST = {
        // swagger ui v3 (openapi)
        "v3/api-docs/**",
        "/swagger-ui/**",
        // swagget ui v2
        "/v2/api-docs",
        "/configuration/ui",
        "/swagger-resources/**",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
            .authorizeRequests().antMatchers("/auth/**").permitAll()
                                // .antMatchers("/api/user/**").permitAll()
                                .antMatchers("/api/center").permitAll()
                                .antMatchers(AUTH_WHITELIST).permitAll()
            .anyRequest().authenticated().and()
            .cors().and()
            .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, userDetailsService()), BasicAuthenticationFilter.class);
        
        http.csrf().disable();

        http.authenticationProvider(authenticationProvider());

        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(HttpMethod.POST, "/auth/login")
                                      .antMatchers(HttpMethod.GET, "/", "/webjars/*", "/*.html", "favicon.ico", "/**/*.html",
                                                                   "/**/*.css", "/**/*/js")
                                      .antMatchers(AUTH_WHITELIST);
                                    //   .antMatchers("/v2/api-docs",
                                    //                "/configuration/ui",
                                    //                "/swagger-resources/**",
                                    //                "/configuration/security",
                                    //                "/swagger-ui.html",
                                    //                "/webjars/**");
    }

    
    // @Autowired
    // private CustomUserDetailsServiceImpl _customUserDetailsService;


    // @Bean
    // @Override
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    //     return super.authenticationManagerBean();
    // }
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    //     return authConfig.getAuthenticationManager();
    // }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //         .userDetailsService(_customUserDetailsService)
    //         .passwordEncoder(passwordEncoder());
    // }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
    //         .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
    //         .authorizeRequests().antMatchers("/auth/**").permitAll()
    //                             .antMatchers("/api/center").permitAll()
    //         .anyRequest().authenticated().and()
    //         .cors().and()
    //         .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, _customUserDetailsService), BasicAuthenticationFilter.class);
        
    //     http.csrf().disable();
    // }

    // @Override
    // public void configure(WebSecurity web) throws Exception {
    //     web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");
    //     web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/*", "/*.html", "favicon.ico", "/**/*.html",
    //                     "/**/*.css", "/**/*/js");           
    // }

}
