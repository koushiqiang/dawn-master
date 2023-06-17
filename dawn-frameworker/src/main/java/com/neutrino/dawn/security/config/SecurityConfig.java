package com.neutrino.dawn.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @author kousq
 * @Date 2023/05/01 17:22
 * @Version 1.0.0
 * @Description:
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 1.设置自定义登录页面,loginProcessingUrl设置过后才会执行 UserDetailsService 中我们自定义的登录逻辑,以及请求成功后跳转的页面
        // 注意登录成功和登录失败都是POST请求,所以要自定义Controller来处理,请求地址与入参一致
        // 注意成功失败跳转的页面都需要放行
        // usernameParameter和passwordParameter设置登录页面的用户名和密码的name属性
        http.formLogin()
                .usernameParameter("username123")
                .passwordParameter("password123")
                .loginPage("/login.html").loginProcessingUrl("/login").permitAll()
                .successForwardUrl("/index")
                .failureForwardUrl("/ToLoginFailure");
        // 2.授权:设置所有的请求都必须认证才能访问,放行login.html
        http.authorizeRequests().antMatchers("error.html").permitAll()
                .antMatchers("login.html").permitAll().anyRequest().authenticated();
        // 3.异常处理:没有权限访问时的操作/页面等
        http.exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);

        // 4.rememberMe功能
        http.rememberMe()
                // 设置数据源
//                .tokenRepository(persistentTokenRepository)
                .rememberMeParameter("")
                // 超时时间,默认两周
                .tokenValiditySeconds(60)
                // 自定义登录逻辑
                .userDetailsService(userDetailsService);
        // .关闭csrf防护
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/authenticate").permitAll()
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    /***
     * @Description:定义了认证Authentication的方法，是认证相关的核心接口，也是发起认证的出发点,所以说AuthenticationManager一般不直接认证，
     * AuthenticationManager接口的常用实现类ProviderManager 内部会维护一个List列表，存放多种认证方式，实际上这是委托者模式的应用（Delegate）
     * 也就是说，核心的认证入口始终只有一个：AuthenticationManager
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl tokenRepository = new
//                JdbcTokenRepositoryImpl();
//        // 1.设置数据源
//        tokenRepository.setDataSource(dataSource);
//        // 2.自动建表，第一次启动时需要，第二次启动时注释掉
//        tokenRepository.setCreateTableOnStartup(true);
//
//        return tokenRepository;
//    }

    /***
     * @Description:官方推荐的加密器。length默认为10，可以自行设置
     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}