package org.example.demo.data;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseSeeder.seedDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
