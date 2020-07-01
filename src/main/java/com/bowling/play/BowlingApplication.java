package com.bowling.play;

import com.bowling.play.Importer.FileReaderService;
import com.bowling.play.Importer.Impl.FileReaderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);
		FileReaderService fileReaderService = new FileReaderServiceImpl();

		if(args.length==0){
			System.err.println("ERROR!! Please run the command with filename, ie:\nmvn compile && mvn exec:java -Dexec.args=\"filename\"");
			return;
		}

		Stream<String> lines = fileReaderService.readFile(args[0]);


	}

}
