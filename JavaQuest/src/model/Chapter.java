package model;
/**
 * Chapter
 * Shows/uses the chapter information
 */
public class Chapter {
	private String chapterName;
	private int chapterNumber;

	/**
	 * Chapter constructor
	 */
	public Chapter() {
		this.chapterName = "";
		this.chapterNumber = 0;		
	}
	
	/**
	 * Chapter constructor
	 */
	public Chapter(String chapterName, int chapterNumber) {
		this.chapterName = chapterName;
		this.chapterNumber = chapterNumber;
	}

	/**
	 * String getChapterName() 
	 * Gets chapter name
	 * Returns chapter name
	 */
	public String getChapterName() {
		return chapterName;
	}
	
	/**
	 * String getChapterNumber() 
	 * Gets chapter number
	 * Returns chapter number
	 */
	public int getChapterNumber() {
		return chapterNumber;
	}
}
