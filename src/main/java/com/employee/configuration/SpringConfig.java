package com.employee.configuration;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean
    public ServletWebServerFactory containerFactory() {
        return new TomcatServletWebServerFactory() {

            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/jndiDataSource");
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", "com.mysql.jdbc.Driver");
                resource.setProperty("url", "jdbc:mysql://localhost:3306/raja");
                resource.setProperty("username", "raja");
                resource.setProperty("password", "admin");
                context.getNamingResources().addResource(resource);
            }
        };
    }

    @Bean
    public DataSource jndiDataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:/comp/env/jndiDataSource");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }


}
