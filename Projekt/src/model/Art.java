package model;

public class Art {
	private String art_id;
	private String name;
	
	public Art(String name, String art_id){
		this.name = name;
		this.art_id = art_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArt_id() {
		return art_id;
	}
	public void setArt_id(String art_id) {
		this.art_id = art_id;
	}
	
	
}
