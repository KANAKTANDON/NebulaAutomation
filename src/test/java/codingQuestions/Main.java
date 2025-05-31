package codingQuestions;

public class Main {
    public static void main(String[] args) {
        printHelloWord(5);
    }

    public static void printHelloWord(int n) {
        System.out.println("Hello");

        if (n == 1) {
            return;
        }
        printHelloWord(n - 1);
    }
}
