package maze;

public class MazeReadingException extends Exception{
	private final String fileName;
	private final int lineIndex;
	private final String message;
	
	/**
	 * Shows error with file name, number of line and message depends on error happened when reading a text file of labyrinth
	 * @param fileName
	 * @param lineIndex
	 * @param message
	 */
	public MazeReadingException(String fileName, int lineIndex, String message) {
		super("Error exists in file " + fileName + "at line " + lineIndex + ": " + message);
		this.fileName = fileName;
		this.lineIndex = lineIndex;
		this.message = message;	
	}
	
}
