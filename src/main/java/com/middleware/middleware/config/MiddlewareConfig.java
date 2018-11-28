package com.middleware.middleware.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.middleware.middleware.model.Connector;
import com.middleware.middleware.model.Middleware;
import com.middleware.middleware.repository.EDIMessageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
public class MiddlewareConfig {

}
