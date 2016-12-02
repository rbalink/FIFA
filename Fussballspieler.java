
public class Fussballspieler {

	private static int nextid = 1;
	private int id;
	private String nachname;
	private int alter;
	private int durchschnitt;
	private final int anfangsdurch;
	
	
	//Konstruktor
	public Fussballspieler(String nachname, int alter){
		this(nachname, alter, 0, 0);
		
	}
	public Fussballspieler(String nachname, int alter, int durchschnitt){
		this(nachname,alter,durchschnitt,durchschnitt);
	}
	
	
	public Fussballspieler(String nachname, int alter, int durchschnitt, int anfangsdurch){
		this.id = nextid++;
		this.nachname = nachname;
		this.alter = alter;
		this.durchschnitt = durchschnitt;
		this.anfangsdurch = anfangsdurch;
	}

	public void updateAlter(){
		this.alter = alter+1;
	}
	
	//Getter
	public String getNachname(){
		return this.nachname;
	}
	public int getAlter(){
		return this.alter;
	}
	
	public int getDurchschnitt() {
		return this.durchschnitt;
	}
	public int getAnfangsdurch() {
		return this.anfangsdurch;
	}
	//Setter
	public void setAlter(int alter){
		this.alter = alter;
	}
	public void setNachname(String nachname){
		this.nachname = nachname;
	}
	public void setDurchschnitt(int durchschnitt){
		this.durchschnitt = durchschnitt;
	}
	
	/**
	 * toString Methode die am Ende fuer die txt file gedacht ist
	 */
	public String toString(){
		return nachname+" "+alter+" "+durchschnitt+" "+anfangsdurch+" ende";
	}
	/**
	 * zeigt die Klasse Fussballspieler angemessen auf der Konsole an
	 * @return
	 */
	public String anzeigeString(){
		if(nachname.length()<=7){
			return "| Name: "+nachname+"\t        | Alter:"+alter+" | Staerke: "+durchschnitt;
		}else{
			return "| Name: "+nachname+"\t| Alter:"+alter+" | Staerke: "+durchschnitt;
		}

	}
	
}
