
public class MazeReadingException extends Exception{
	private final String fileName;
	private final int lineIndex;
	
	public MazeReadingException(String fileName, int lineIndex) {
		super("Error exists in file " + fileName + "at line " + lineIndex);
		this.fileName = fileName;
		this.lineIndex = lineIndex;	
	}
	
}
