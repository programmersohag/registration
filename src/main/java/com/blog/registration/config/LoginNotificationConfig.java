package com.blog.registration.config;

import com.maxmind.geoip2.DatabaseReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import ua_parser.Parser;

import java.io.File;
import java.io.IOException;

@Configuration
public class LoginNotificationConfig {

    @Bean
    public Parser uaParser() throws IOException {
        return new Parser();
    }

    @Bean(name = "GeoIPCity")
    public DatabaseReader cityDatabaseReader() throws IOException {
        final File resource = new File(this.getClass().getClassLoader().getResource("maxmind/GeoLite2-City.mmdb").getFile());
        return new DatabaseReader.Builder(resource).build();
    }

    @Bean(name = "GeoIPCountry")
    public DatabaseReader countryDatabaseReader() throws IOException {
        final File resource = new File(this.getClass().getClassLoader().getResource("maxmind/GeoLite2-Country.mmdb").getFile());
        return new DatabaseReader.Builder(resource).build();
    }
}
