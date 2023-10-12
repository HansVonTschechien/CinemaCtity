import java.util.List;

/**
 * Třída reprezentující sál v kinokomplexu.
 */
public class Hall {
    private final int number;          // Číslo sálu
    private final int numRows;         // Počet řad
    private final int seatsPerRow;     // Počet křesel v řadě
    private final List<Film> films;    // Seznam filmů, které jsou promítány v tomto sále
    private final char[][] seatLayout; // Rozložení křesel v sálu

    /**
     * Konstruktor pro vytvoření instance sálu.
     *
     * @param number      Číslo sálu.
     * @param numRows     Počet řad.
     * @param seatsPerRow Počet křesel v řadě.
     * @param films       Seznam filmů, které jsou promítány v tomto sále.
     */
    public Hall(int number, int numRows, int seatsPerRow, List<Film> films) {
        this.number = number;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        this.films = films;
        this.seatLayout = new char[numRows][seatsPerRow];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seatLayout[i][j] = 'O'; // 'O' označuje volné křeslo
            }
        }
    }

    /**
     * Získá číslo sálu.
     *
     * @return Číslo sálu.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Získá seznam filmů promítaných v tomto sále.
     *
     * @return Seznam filmů.
     */
    public List<Film> getFilms() {
        return films;
    }

    /**
     * Vytiskne rozložení křesel v sále do konzole.
     */
    public void printSeatLayout() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.print(seatLayout[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Rezervuje křeslo v sálu na základě zadaného řádku a sloupce.
     *
     * @param row    Řádek (A-Z).
     * @param column Sloupec (1-99).
     * @throws InvalidSeatException Pokud je zvolené křeslo neplatné nebo již rezervované.
     */
    public void reserveSeat(char row, int column) throws InvalidSeatException {
        int rowIndex = row - 'A';
        int columnIndex = column - 1;

        if (row < 'A' || row > 'Z' || column < 1 || column > seatsPerRow) {
            throw new InvalidSeatException("Neplatné řádek nebo sloupec.");
        }

        if (seatLayout[rowIndex][column - 1] == 'X') {
            throw new InvalidSeatException("Křeslo je již rezervováno.");
        }

        seatLayout[rowIndex][column - 1] = 'X'; // 'X' označuje rezervované křeslo
    }
}

/**
 * Vlastní výjimka pro neplatné křeslo.
 */
class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) {
        super(message);
    }
}
