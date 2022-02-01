package com.sha.springboot_microservice1_product.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
    WebSecurityConfigurerAdapter web güvenliği
    özelleştirmeye yarayan bir güvenlik sınıfı.
    Dosyada "Güvenlik Yapılandırması" kısmı
 */
@EnableWebSecurity // web tabanlı güvenlik sağlamak için birlikte çalışıyorlar WebSecurityConfigurerAdapter ile
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    // ***3
    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    //CTRL + o kullanılarak getirildi.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        // istediğimiz herhangi bir kodlama algoritmasını kullanabiliriz.
        // BCryptPasswordEncoder, password'e hashing sağlar.
        PasswordEncoder encoder = new BCryptPasswordEncoder();  // *** 2


        //  Bellekte bazı kullanıcılar var ve Spring security yetkilendirme(authorization) için bekliyor.  ***1
        //  Burada, kullanıcı ad, şifre ve rol verilmesi gerekecek.
        //  Birden çok role sahip birden çok kullanıcı oluşturulabilir.
        // Sonra onlara farklı operasyonalr için izin verebiliriz.
        // Bilgiler hashing ile saklanabilir.
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser(SECURE_KEY_USERNAME)
                .password(encoder.encode(SECURE_KEY_PASSWORD))
                .roles("USER");
    }


    /*
    Tanımlı olmayan roller dışında, kimse o rollere erişmesin
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        super.configure(http);

        // Buradan, dosyaya git:
        http.csrf().disable();
    }
}
