import java.util.ArrayList;
import java.util.List;

/**
 * Třída reprezentující kinokomplex obsahující filmy a sály.
 */
public class KinoComplex {
    private final String name;                // Název kinokomplexu
    private final List<Film> films = new ArrayList<>(); // Seznam filmů
    private final List<Hall> halls = new ArrayList<>(); // Seznam sálů

    /**
     * Konstruktor pro vytvoření instance kinokomplexu.
     *
     * @param name Název kinokomplexu.
     */
    public KinoComplex(String name) {
        this.name = name;
    }

    /**
     * Získá název kinokomplexu.
     *
     * @return Název kinokomplexu.
     */
    public String getName() {
        return name;
    }

    /**
     * Získá seznam filmů v kinokomplexu.
     *
     * @return Seznam filmů.
     */
    public List<Film> getFilms() {
        return films;
    }

    /**
     * Získá seznam sálů v kinokomplexu.
     *
     * @return Seznam sálů.
     */
    public List<Hall> getHalls() {
        return halls;
    }

    /**
     * Přidá film do kinokomplexu.
     *
     * @param film Film k přidání.
     */
    public void addFilm(Film film) {
        films.add(film);
    }

    /**
     * Přidá sál do kinokomplexu.
     *
     * @param hall Sál k přidání.
     */
    public void addHall(Hall hall) {
        halls.add(hall);
    }

    /**
     * Získá film podle názvu.
     *
     * @param title Název filmu.
     * @return Film s odpovídajícím názvem nebo null, pokud film není nalezen.
     */
    public Film getFilm(String title) {
        for (Film film : films) {
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        return null;
    }

    /**
     * Získá sál podle čísla.
     *
     * @param number Číslo sálu.
     * @return Sál s odpovídajícím číslem nebo null, pokud sál není nalezen.
     */
    public Hall getHall(int number) {
        for (Hall hall : halls) {
            if (hall.getNumber() == number) {
                return hall;
            }
        }
        return null;
    }

    /**
     * Získá seznam sálů, ve kterých se promítá zadaný film.
     *
     * @param film Film pro který hledáme sály.
     * @return Seznam sálů, ve kterých se promítá zadaný film.
     */
    public List<Hall> getHallsForFilm(Film film) {
        List<Hall> availableHalls = new ArrayList<>();
        for (Hall hall : halls) {
            if (hall.getFilms().contains(film)) {
                availableHalls.add(hall);
            }
        }
        return availableHalls;
    }
}
