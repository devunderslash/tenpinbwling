package com.bowling.play;

import com.bowling.play.Exporter.OutputService;
import com.bowling.play.Exporter.OutputServiceImpl;
import com.bowling.play.Importer.FileReaderService;
import com.bowling.play.Importer.Impl.FileReaderServiceImpl;
import com.bowling.play.Model.Frame;
import com.bowling.play.Service.BowlingService;
import com.bowling.play.Service.Impl.BowlingServiceImpl;
import com.bowling.play.Validation.BowlingValidation;
import com.bowling.play.Validation.Impl.BowlingValidationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {

		FileReaderService fileReaderService = new FileReaderServiceImpl();
		BowlingService bowlingService = new BowlingServiceImpl();
		BowlingValidation bowlingValidation = new BowlingValidationImpl();
		OutputService outputService = new OutputServiceImpl();

		if(args.length==0){
			System.err.println("ERROR!! Please run the command with filename, ie:\nmvn compile && mvn exec:java -Dexec.args=\"RealGame\"");
			return;
		}

		Stream<String> lines = fileReaderService.readFile(args[0]);

		Map<String, List<Frame>> playsMap =
				bowlingService.calcPlayScoresFromMap(
						bowlingService.buildPlayListFromStream(lines));

		playsMap.forEach((name,plays)->{
			String error = bowlingValidation.validate(plays);
			if(!error.isEmpty()){
				throw new IllegalArgumentException(name+": "+error);
			}
		});

		outputService.printBoard(playsMap);


		SpringApplication.run(BowlingApplication.class, args);
	}

}
