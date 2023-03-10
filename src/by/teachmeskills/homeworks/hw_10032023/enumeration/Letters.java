package by.teachmeskills.homeworks.hw_10032023.enumeration;

public class Letters {
    public static void main(String[] args) {
        System.out.println(Alphabet.B.getLettersPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLettersPosition() {
            return this.ordinal() + 1;
        }
    }
}