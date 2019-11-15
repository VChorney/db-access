package com.db_access.connection;

import com.db_access.config.DBProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ConnectionToDB {

    DBProperties dbProperties;

    public Connection getConnection() {
        try {
            Class.forName(dbProperties.getDriver());
            return DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getUser(), dbProperties.getPassword());
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException("Class not found", exception.getCause());
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e.getCause());
        }
    }
}
