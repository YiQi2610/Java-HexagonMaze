package maze;

public class MazeReadingException extends Exception{
	private final String fileName;
	private final int lineIndex;
	private final String message;
	
	public MazeReadingException(String fileName, int lineIndex, String message) {
		super("Error exists in file " + fileName + "at line " + lineIndex + ": " + message);
		this.fileName = fileName;
		this.lineIndex = lineIndex;
		this.message = message;	
	}
	
}
