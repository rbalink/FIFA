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
	 * menü auswahl für den User
	 */
	public static int operator() {
		while (true) {
			System.out.println("");
			System.out.println("+ + + + + Auswahl + + + + +");
			System.out.println("[1]: Spieler hinzufügen");
			System.out.println("[2]: Alle Spieler anzeigen");
			System.out.println("[3]: Spieler suchen");
			System.out.println("[4]: Verlassen und Speichern");
			Scanner tmpo = new Scanner(System.in);
			int menu = tmpo.nextInt();

			switch (menu) {
			case 1:
				erstellen();
				break;
			case 2:
				zeigen();
				break;
			case 4:
				return 0;
			case 3:
				suchen();
				break;
			default:
				System.out.println("+ + + Falsche Eingabe + + +");
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
		System.out.println("Alter:");
		Scanner tmp2 = new Scanner(System.in);
		int alter = tmp2.nextInt();
		Fussballspieler neu = new Fussballspieler(name, alter);
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
	public static void suchen() {
		System.out.println("Wie heißt der Spieler?:");
		Scanner tmpor = new Scanner(System.in);
		String search = tmpor.nextLine();
		int count = 0;
		for (Fussballspieler i : liste) {
			count++;
			if (i.getNachname().equals(search)) {
				System.out.println(i.anzeigeString());
				return;
			}
		}
		if (count == liste.length) {
			System.out.println("Kein Spieler gefunden");
		}

	}

	/**
	 * 
	 * @throws FileNotFoundException
	 *             liest von fifahistory.txt die Strings ein splittet die
	 *             Strings bei dem Schlüsselwort ende neue Fussballspieler wird
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
					Fussballspieler spieler = new Fussballspieler(felder[0], Integer.parseInt(felder[1]));
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

}
