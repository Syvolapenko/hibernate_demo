package com.goit11.Flyway;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new FlywayApplication()
                .setup()
                .migrate();
    }
}
