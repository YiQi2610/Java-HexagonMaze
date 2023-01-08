package maze;

public class MazeReadingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MazeReadingException(String fileName, int lineIndex) {
		super("Error exists in file " + fileName + "at line " + lineIndex);
	}
	
}
