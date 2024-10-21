package hu.petrik.statikusosztalyok;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Veletlen {
    private Veletlen() {}
    private static final Random RANDOM = new Random();
    private static final List<String> VEZETEK_NEVEK = feltolt("veznev.txt");
    private static final List<String> FERFI_KRERESZT_NEVEK = feltolt("ferfikernev.txt");
    private static final List<String> NOI_KRERESZT_NEVEK = feltolt("noikernev.txt");

    private static List<String> feltolt(String fajlnev) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("files/"+fajlnev));
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static int velEgesz(int min, int max) {
        return RANDOM.nextInt(min, max + 1);
    }

    public static char velKarater(char min, char max) {
        return (char) velEgesz(min, max);
    }

    public static String velVezetekNev() {
        return VEZETEK_NEVEK.get(RANDOM.nextInt(VEZETEK_NEVEK.size()));
    }

    private static String velFerfiKerestNev() {
        return FERFI_KRERESZT_NEVEK.get(RANDOM.nextInt(FERFI_KRERESZT_NEVEK.size()));
    }

    private static String velNoiKerestNev() {
        return NOI_KRERESZT_NEVEK.get(RANDOM.nextInt(NOI_KRERESZT_NEVEK.size()));
    }

    /**
     * Véletlen keresztnevet generál a beolvasott fájlok alapján
     * @param nem a keresztnév neme. Férfi - true, Nő - false
     * @return A generált véletlen keresztnév
     */
    public static String velKeresztNev(boolean nem) {
        if (nem) {
            return velFerfiKerestNev();
        }
        return velNoiKerestNev();
    }

    /**
     * Véletlen nevet generál a beolvasott fájlok alapján
     * @param nem a név neme. Férfi - true, Nő - false
     * @return A generált véletlen név
     */
    public static String velTeljesNev(boolean nem) {
        return velVezetekNev() + " " + velKeresztNev(nem);
    }
}

