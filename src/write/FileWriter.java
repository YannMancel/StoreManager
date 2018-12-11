package write;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter implements Writer {

	/**
	 * FileWriter constructor with the a arguments of String type
	 * @param fileName The file name
	 */
	public FileWriter(String fileName) {		
		this.fileName = fileName;
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void start() {	
		this.summary = "";
	}

	@Override
	public void writeLine(String line) {
		this.summary += line + "%n";
	}

	@Override
	public void stop() {
		
		Path path = Paths.get(this.fileName);
		
		try {
			Files.write(path, String.format(this.summary).getBytes());
		} catch (IOException e) {
			System.out.println("Impossible de rédiger la facture");
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private String fileName;
	private String summary;
}
