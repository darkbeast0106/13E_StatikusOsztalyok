package hu.petrik.statikusosztalyok;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Veletlen.velTeljesNev(true));
            System.out.println(Veletlen.velTeljesNev(false));
        }
    }
}