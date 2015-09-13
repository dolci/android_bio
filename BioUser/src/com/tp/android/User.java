package com.tp.android;

public class User {
	
	
	private int id;
	private String name;
	private String surname;
	private String profession;
	private String datebirth;
	private String description;
	private String urlpic;
	public User(){}
	public User( String name, String surname,String prof,String date)
	{
		super();
		this.name=name;
		this.surname=surname;
		this.profession=prof;
		this.datebirth=date;
		description="fffff";
		urlpic="rihanna";
	}
	@Override
	public String toString() {
	return "User [id=" + id + ", name=" + name + ", surname=" + surname+" datebirth"+datebirth+"urlpic"+urlpic
	+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDatebirth() {
		return datebirth;
	}
	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlpic() {
		return urlpic;
	}
	public void setUrlpic(String urlpic) {
		this.urlpic = urlpic;
	}
	
}
