package com.example.mentoriautec;

import org.springframework.boot.SpringApplication;

public class TestMentoriaUtecApplication {

    public static void main(String[] args) {
        SpringApplication.from(MentoriaUtecApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
