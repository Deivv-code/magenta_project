import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserCSV {
    private final File file;

    public ParserCSV(String _fileName) {
        String currentDirectory = System.getProperty("user.dir");
        file = new File(currentDirectory + "\\files\\" + _fileName);
    }

    public ArrayList<String> fetch(int _index) {
        ArrayList<String> values = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String item = data[_index];
                values.add(item);
            }
        } catch (IOException e) { e.printStackTrace(); }
        return values;
    }

    public ArrayList<Double> getMedia(String _sensorName) {
        ArrayList<String> sensorNames = fetch(3);
        ArrayList<String> values = fetch(4);

        // process date
        ArrayList<String> dateTimes = fetch(0);
        ArrayList<String> date = new ArrayList<>();
        for (String data : dateTimes) { date.add(data.split(" ")[0]); }

        ArrayList<Double> medie = new ArrayList<>();

        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i=1; i<date.size(); i++) {
            indexes.add(i);
            if (i+1<date.size()) { // se ci sono altri dati:
                if (!(date.get(i).equals( date.get(i+1) )) ) { // se la data successiva è diversa dall' i-esima
                    double media = 0;
                    for (int j=0; j<indexes.size(); j++) {
                        if (sensorNames.get(j).equals(_sensorName)) {
                            media += Double.parseDouble( values.get(j) );
                        }
                    }
                    media = media/indexes.size();
                    medie.add(media);

                    indexes.clear();
                }
            } else { // quando ha finito, aggiungi pure l'ultima media
                double media = 0;
                for (int j=0; j<indexes.size(); j++) {
                    if (sensorNames.get(j).equals(_sensorName)) {
                        media += Double.parseDouble( values.get(j) );
                    }
                }
                media = media/indexes.size();
                medie.add(media);

                indexes.clear();
            }
        }

        return medie;
    }

}


