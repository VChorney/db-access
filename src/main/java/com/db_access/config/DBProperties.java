package com.db_access.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@ConfigurationProperties(prefix = "db")
@Setter
@Getter
public class DBProperties {

    String url;

    String driver;

    String user;

    String password;
}
