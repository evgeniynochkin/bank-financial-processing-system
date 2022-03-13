//package ru.sbp.bankfinancialprocessingsystem.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Класс SecurityConfig содержит методы конфигурации Spring Security
// * @autor Sergey Proshchaev
// * @version 1.0
// *
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        if (true) {
//
//            http.csrf().ignoringAntMatchers("/bank/*")
//                    .ignoringAntMatchers("/pos/createtrans")
//                    .ignoringAntMatchers("/pos/createrefund")
//                    .ignoringAntMatchers("/pos/createstatement")
//                    //
//                    .ignoringAntMatchers("/account/info")
//                    .ignoringAntMatchers("/account/info/withdrawCash")
//                    .ignoringAntMatchers("/account/info/updateDeposit")
//                    .ignoringAntMatchers("/erorr")
//                    .ignoringAntMatchers("/account/info/createAnAccount")
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/pos/pay").hasAnyRole("MANAGER")
//                    .and()
//                    .authorizeRequests()
////                    .antMatchers("/account/info/createAnAccount").hasAnyRole("MANAGER","ADMIN")
//                    .antMatchers("/pos/admin").hasAnyRole("ADMIN")
//                    .and()
//                    .formLogin()
//                    .and()
//                    .exceptionHandling().accessDeniedPage("/view/pos_access_denied.jsp");
//        } else {
//
//            http.csrf().ignoringAntMatchers("/bank/*")
//                    .ignoringAntMatchers("/pos/createtrans")
//                    .ignoringAntMatchers("/pos/createrefund")
//                    .ignoringAntMatchers("/pos/createstatement")
//                    ;
//
//        }
//
//    }
//
//    /**
//     * Метод PasswordEncoder определяет правило сравнения паролей
//     * как простые текстовые строки
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//}
