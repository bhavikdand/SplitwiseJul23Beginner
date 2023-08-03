package com.example.splitwiseJul23Beginner;

import com.example.splitwiseJul23Beginner.commands.Command;
import com.example.splitwiseJul23Beginner.commands.CommandRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseJul23BeginnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseJul23BeginnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Awaiting input");
			String input = scanner.nextLine();
			Command command = CommandRegistry.getInstance().getCommand(input);
			command.execute(input);
		}
	}
}
