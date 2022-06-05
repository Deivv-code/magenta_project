import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];

        ParserCSV parser = new ParserCSV(fileName);

        ArrayList<Double> values = parser.getAverage("PM2.5");
        // process dateTimes
        ArrayList<String> dateTimes = parser.fetch(0);
        ArrayList<String> Alldates = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();

        for (String data : dateTimes) { Alldates.add(data.split(" ")[0]); } //remove hours
        for (int i=1; i<Alldates.size(); i++) { // delete the same dates
            if ( i+1<Alldates.size() && !(Alldates.get(i).equals( Alldates.get(i+1) )) ) {
                date.add( Alldates.get(i) );
            }
        }
        date.add(Alldates.get(Alldates.size()-1));

        print(date, values);
    }

    public static void print(ArrayList<String> date, ArrayList<Double> valori) {
        String string = "";
        for (int i=0; i<date.size(); i++) {
            string = "[" +
                    "\"" + date.get(i) + "\"" + "," +
                    valori.get(i) +
                    "], ";
            System.out.println(string);
        }
    }
}