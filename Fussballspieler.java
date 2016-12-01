
public class Fussballspieler {

	private String nachname;
	private int alter;
	
	
	//Konstruktor
	public Fussballspieler(String nachname, int alter){
		this.nachname = nachname;
		this.alter = alter;
	}
	
	
	//Getter
	public String getNachname(){
		return this.nachname;
	}
	public int getAlter(){
		return this.alter;
	}
	
	//Setter
	public void setAlter(int alter){
		this.alter = alter;
	}
	public void setNachname(String nachname){
		this.nachname = nachname;
	}
	
	
	public String toString(){
		return nachname+" "+alter+" ende";
	}
	public String anzeigeString(){
		return "| Name: "+nachname+" 		| Alter:"+alter+" | ";

	}
	
}
