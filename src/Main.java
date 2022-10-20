import Parser.ParserTable;

public class Main {
    public static void main(String[] args) {
        ParserTable.getRow("data/basicprogramming_2.csv");
        String names = ParserTable.getRow("data/basicprogramming_2.csv", 2);
        String values = ParserTable.getRow("data/basicprogramming_2.csv", 3);
    }
}