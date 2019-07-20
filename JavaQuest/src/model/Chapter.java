package model;

public class Chapter {
	private String chapterName;
	private int chapterNumber;

	public Chapter() {
		this.chapterName = "";
		this.chapterNumber = 0;		
	}
	
	public Chapter(String chapterName, int chapterNumber) {
		this.chapterName = chapterName;
		this.chapterNumber = chapterNumber;
	}

	public String getChapterName() {
		return chapterName;
	}
	
	public int getChapterNumber() {
		return chapterNumber;
	}
}
