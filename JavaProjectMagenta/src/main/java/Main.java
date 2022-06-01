import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

       ParserCSV p1 = new ParserCSV(args[0],args[1]);

        System.out.println(p1.Parse());


    }
}