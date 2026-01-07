package ru.lanolin.quote;

import org.springframework.boot.SpringApplication;

public class TestQuoteStorageApplication {

	public static void main(String[] args) {
		SpringApplication.from(QuoteStorageApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
