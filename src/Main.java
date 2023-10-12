import java.util.List;
import java.util.Scanner;


/**
 * Hlavní třída programu pro rezervaci kinovstupenek.
 */

public class Main {
    public static void main(String[] args) {
        // Vytvoření kinového komplexu
        KinoComplex kino = new KinoComplex("Můj Kino");

        // Přidání filmů
        kino.addFilm(new Film("Matrix", "PG-13", "Wachowski", true));
        kino.addFilm(new Film("Jurassic Park", "PG-13", "Spielberg", false));
        kino.addFilm(new Film("Star Wars: Episode IV", "PG", "Lucas", true));
        kino.addFilm(new Film("Inception", "PG-13", "Nolan", true));
        kino.addFilm(new Film("The Shawshank Redemption", "R", "Darabont", false));
        kino.addFilm(new Film("Pulp Fiction", "R", "Tarantino", false));
        kino.addFilm(new Film("The Dark Knight", "PG-13", "Nolan", true));
        kino.addFilm(new Film("Forrest Gump", "PG-13", "Zemeckis", false));
        kino.addFilm(new Film("The Lord of the Rings: The Fellowship of the Ring", "PG-13", "Jackson", true));
        kino.addFilm(new Film("Gladiator", "R", "Scott", false));

        // Vytvoření sálů
        kino.addHall(new Hall(1, 5, 10, kino.getFilms()));
        kino.addHall(new Hall(2, 6, 12, kino.getFilms()));

        // Uživatelské rozhraní
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vítejte v kině " + kino.getName());

        while (true) { // Hlavní smyčka pro opakované volby
            // Výpis dostupných filmy s čísly
            System.out.println("Dostupné filmy:");
            List<Film> films = kino.getFilms();
            for (int i = 0; i < films.size(); i++) {
                System.out.println((i + 1) + ". " + films.get(i).getTitle());
            }

            // Uživatel vybere film číselně
            int selectedFilmIndex;
            while (true) {
                System.out.print("Zadejte číslo filmu (nebo '0' pro ukončení): ");
                selectedFilmIndex = scanner.nextInt();
                scanner.nextLine(); // Zpracování zbytku řádku

                if (selectedFilmIndex == 0) {
                    System.out.println("Děkujeme za návštěvu kina " + kino.getName());
                    return; // Ukončení programu
                }

                if (selectedFilmIndex < 1 || selectedFilmIndex > films.size()) {
                    System.out.println("Neplatný výběr. Zadejte číslo filmu.");
                } else {
                    break; // Správný výběr filmu
                }
            }

            Film chosenFilm = films.get(selectedFilmIndex - 1);

            // Výpis dostupných sálů pro vybraný film
            List<Hall> availableHalls = kino.getHallsForFilm(chosenFilm);
            System.out.println("Dostupné sály pro film '" + chosenFilm.getTitle() + "':");
            for (Hall hall : availableHalls) {
                System.out.println("Sál č. " + hall.getNumber());
            }

            // Uživatel vybere sál
            System.out.print("Zadejte číslo sálu: ");
            int selectedHallNumber = scanner.nextInt();
            scanner.nextLine(); // Zpracování zbytku řádku

            Hall chosenHall = kino.getHall(selectedHallNumber);

            if (chosenHall == null) {
                System.out.println("Sál nenalezen.");
                continue; // Vrátí se na začátek smyčky
            }

            // Výpis rozložení křesel v sále
            System.out.println("Rozložení křesel v sále č. " + chosenHall.getNumber() + ":");
            chosenHall.printSeatLayout();

            // Uživatel vybere křeslo
            System.out.print("Zadejte řádek (A-Z): ");
            char selectedRow = scanner.next().toUpperCase().charAt(0);
            System.out.print("Zadejte sloupec (1-99): ");
            int selectedColumn = scanner.nextInt();

            try {
                chosenHall.reserveSeat(selectedRow, selectedColumn);
                System.out.println("Rezervace úspěšná. Děkujeme za návštěvu kina " + kino.getName());
            } catch (InvalidSeatException e) {
                System.out.println("Chyba: " + e.getMessage());
            }

            scanner.nextLine(); // Zpracování zbytku řádku
        }
    }
}
