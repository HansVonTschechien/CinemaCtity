/**
 * Třída reprezentující film v kinokomplexu.
 */
public class Film {
    private final String title;     // Název filmu
    private final String rating;    // Hodnocení filmu (např. PG-13)
    private final String director;  // Jméno režiséra
    private final boolean is3D;     // Zda film podporuje 3D

    /**
     * Konstruktor pro vytvoření instance filmu.
     *
     * @param title    Název filmu.
     * @param rating   Hodnocení filmu.
     * @param director Jméno režiséra.
     * @param is3D     Zda film podporuje 3D.
     */
    public Film(String title, String rating, String director, boolean is3D) {
        this.title = title;
        this.rating = rating;
        this.director = director;
        this.is3D = is3D;
    }

    /**
     * Získá název filmu.
     *
     * @return Název filmu.
     */
    public String getTitle() {
        return title;
    }
}



