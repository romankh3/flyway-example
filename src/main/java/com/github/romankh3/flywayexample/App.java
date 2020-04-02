package com.github.romankh3.flywayexample;

import org.flywaydb.core.Flyway;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/foobar", "sa", null).load();

        // Start the migration
        flyway.migrate();
    }
}
