import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FIFAManaging {

	static Fussballspieler[] liste = new Fussballspieler[0];

	public static void main(String[] args) {
		einlesen();
		while (operator() != 0) {
		}
		speichern();
	}

	/**
	 * menu auswahl fuer den User
	 */
	public static int operator() {
		while (true) {
			System.out.println("");
			System.out.println("+ + + + + Auswahl + + + + +");
			System.out.println("[1]: Alle Spieler anzeigen");
			System.out.println("[2]: Anzeige Optionen");
			System.out.println("[3]: Bearbeitungs Optionen");
			System.out.println("[4]: Speichern und Beenden");
			Scanner temp4 = new Scanner(System.in);
			int hmenu = temp4.nextInt();
			switch (hmenu) {
			case 1:
				zeigen();
				break;
			case 2:
				System.out.println("[1]: Alle Spieler anzeigen");
				System.out.println("[2]: Spieler suchen");
				System.out.println("[3]: Staerken Statistik");
				Scanner temp5 = new Scanner(System.in);
				int umenu = temp5.nextInt();
				switch (umenu) {
				case 1:
					zeigen();
					break;
				case 2:
					suchen();
					break;
				case 3:
					System.out.println("[1]: Staerken Veraenderung von einem Spieler sehen");
					System.out.println("[2]: Spieler im Kader mit groesster Staerken Veraenderung");
					Scanner temp6 = new Scanner(System.in);
					int umenu3 = temp6.nextInt();
					switch (umenu3) {
					case 1:
						staerkeSpieler();
						break;
					case 2:
						staerkeTeam();
						break;
					default:
						System.out.println("+ + + + + Ungueltige Eingabe + + + + + ");

					}
					break;
				default:
					System.out.println("+ + + + + Ungueltige Eingabe + + + + + ");
				}
				break;
			case 3:
				System.out.println("[1]: Spieler hinzufuegen");
				System.out.println("[2]: Staerke bearbeiten");
				System.out.println("[3]: Alter updaten");
				Scanner temp6 = new Scanner(System.in);
				int umenu2 = temp6.nextInt();
				switch (umenu2) {
				case 1:
					erstellen();
					break;
				case 2:
					bearbeiten();
					break;
				case 3:
					update();
					break;
				default:
					System.out.println("+ + + + + Ungueltige Eingabe + + + + + ");
				}
				break;
			case 4:
				return 0;
			default:
				System.out.println("+ + + + + Ungueltige Eingabe + + + + + ");
			}

		}
	}

	/**
	 * erstellt eine neue Fussballspieler Klasse
	 */
	public static void erstellen() {
		System.out.println("Nachname:");
		Scanner tmp = new Scanner(System.in);
		String name = tmp.nextLine();
		for (Fussballspieler i : liste) {
			if (i.getNachname().equals(name)) {
				System.out.println("Name existiert bereits");
				return;
			}
		}
		System.out.println("Alter:");
		Scanner tmp2 = new Scanner(System.in);
		int alter = tmp2.nextInt();
		System.out.println("Staerke:");
		Scanner tmp3 = new Scanner(System.in);
		int durchschnitt = tmp3.nextInt();
		Fussballspieler neu = new Fussballspieler(name, alter, durchschnitt);
		Fussballspieler[] hinzu = new Fussballspieler[liste.length + 1];
		System.arraycopy(liste, 0, hinzu, 0, liste.length);
		hinzu[liste.length] = neu;
		liste = hinzu;

	}

	public static void zeigen() {
		for (Fussballspieler i : liste) {
			System.out.println(i.anzeigeString());
		}
	}

	/**
	 * sucht die Fussballerliste nach eingegebenem Namen vom Usernamen durch
	 */
	public static Fussballspieler suchen() {
		System.out.println("Wie heisst der Spieler?:");
		Scanner tmpor = new Scanner(System.in);
		String search = tmpor.nextLine();
		int count = 0;
		for (Fussballspieler i : liste) {
			count++;
			if (i.getNachname().equals(search)) {
				System.out.println(i.anzeigeString());
				return i;
			}
		}
		if (count == liste.length) {
			System.out.println("Spieler nicht vorhanden");
		}
		return null;

	}

	/**
	 * 
	 * @throws FileNotFoundException
	 *             liest von fifahistory.txt die Strings ein splittet die
	 *             Strings bei dem Schluesselwort ende neue Fussballspieler wird
	 *             erstellt und in die liste gespeichert
	 */
	public static void einlesen() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("fifahistory.txt"));
		} catch (FileNotFoundException e1) {
			return;
		}
		String line;
		try {
			while ((line = file.readLine()) != null) {
				if (line.endsWith("ende")) {

					String[] felder = line.split(" ");
					Fussballspieler spieler = new Fussballspieler(felder[0], Integer.parseInt(felder[1]),
							Integer.parseInt(felder[2]), Integer.parseInt(felder[3]));
					Fussballspieler[] tempo = new Fussballspieler[liste.length + 1];
					System.arraycopy(liste, 0, tempo, 0, liste.length);
					tempo[liste.length] = spieler;
					liste = tempo;

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		zeigen();
	}

	/**
	 * 
	 * @throws IOException
	 *             speichert die Fussballspieler Array "liste" in
	 *             fifahistory.txt
	 */
	public static void speichern() {
		BufferedWriter br = null;

		try {
			br = new BufferedWriter(new FileWriter("fifahistory.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		for (Fussballspieler line : liste) {
			sb.append(line);
			sb.append(System.lineSeparator());
		}

		try {
			br.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// NAMEN aeNDERN ! ZU VERWIRREND
	/**
	 * Veraendert die Staerke des Spielers
	 */
	public static void bearbeiten() {
		Fussballspieler i = suchen();
		if (i == null) {
			return;
		}
		System.out.println("Neue Staerke:");
		Scanner tempo2 = new Scanner(System.in);
		int neu = tempo2.nextInt();
		if (neu <= 0 || neu >= 100) {
			System.out.println("Ungueltiger Wert");
			return;
		}
		i.setDurchschnitt(neu);
		System.out.println(i.anzeigeString());
	}

	// VERWIRRENDER NAME ! MEHR HINZU
	/**
	 * updated das alter von jedem Spieler um ein Jahr
	 */
	public static void update() {
		for (Fussballspieler i : liste) {
			i.updateAlter();
		}
	}

	/**
	 * zeigt den Spieler mit der groessten (postiven) Veraenderung an
	 */
	private static void staerkeTeam() {
		int diff = 0;
		int vergl = 0;
		String o = null;
		for (Fussballspieler c : liste) {
			vergl = c.getDurchschnitt() - c.getAnfangsdurch();
			if (vergl >= diff) {
				diff = vergl;
				o = c.getNachname();
			}
		}
		System.out.println(
				"Der Spieler mit der groessten Verbesserung ist " + o + " mit einer Verbesserung von " + diff + ".");

	}

	/**
	 * Sucht einen von dir genannten Spieler und vergleicht Anfangsstaerke mit
	 * aktueller
	 */
	private static void staerkeSpieler() {
		Fussballspieler b = suchen();
		if (b == null) {
			return;
		}
		int differenz = b.getDurchschnitt() - b.getAnfangsdurch();
		System.out.print("Staerke von " + b.getNachname());
		String plural;
		if (differenz == 1 || differenz == -1) {
			plural = "Punkt";
		} else {
			plural = "Punkte";
		}
		if (differenz > 0) {
			System.out.println(" hat sich verbessert um " + differenz + " " + plural + ". [Anfang "
					+ b.getAnfangsdurch() + "|Heute " + b.getDurchschnitt() + "]");
		} else if (differenz == 0) {
			System.out.println(" hat sich nicht veraendert. [Anfang/Heute " + b.getDurchschnitt() + "]");
		} else {
			System.out.println(" hat sich verschlechtert um " + differenz + " " + plural + ". [Anfang "
					+ b.getAnfangsdurch() + "|Heute " + b.getDurchschnitt() + "]");
		}

	}

}
