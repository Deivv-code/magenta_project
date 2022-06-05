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

    public ArrayList<Double> getAverage(String _sensorName) {
        ArrayList<String> sensorNames = fetch(3);
        ArrayList<String> values = fetch(4);

        // process date
        ArrayList<String> dateTimes = fetch(0);
        ArrayList<String> date = new ArrayList<>();
        for (String data : dateTimes) { date.add(data.split(" ")[0]); }

        ArrayList<Double> averages = new ArrayList<>();

        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i=1; i<date.size(); i++) {
            indexes.add(i);
            if (i+1<date.size()) {
                if (!(date.get(i).equals( date.get(i+1) )) ) {
                    double average = 0;
                    for (int j=0; j<indexes.size(); j++) {
                        if (sensorNames.get(j).equals(_sensorName)) {
                            average += Double.parseDouble( values.get(j) );
                        }
                    }
                    average = average/indexes.size();
                    averages.add(average);

                    indexes.clear();
                }
            } else {
                double average = 0;
                for (int j=0; j<indexes.size(); j++) {
                    if (sensorNames.get(j).equals(_sensorName)) {
                        average += Double.parseDouble( values.get(j) );
                    }
                }
                average = average/indexes.size();
                averages.add(average);

                indexes.clear();
            }
        }

        return averages;
    }

    public  Double AnnualAverage(String _sensorName)
    {
        ArrayList<String> sensorNames = fetch(3);
        ArrayList<String> values = fetch(4);

        int counter = 0;
        double average = 0;

        for (int i=0;i<sensorNames.size();i++)
        {
            if (sensorNames.get(i).equals(_sensorName))
            {
                for (int j = 0; j<values.size();i++)
                {
                    average += Double.parseDouble(values.get(j));
                    counter++;
                }
                average = average /counter;

            }

        }
        return average;
    }

    public String getDateTime(int i)
    {
        ArrayList<String> dateTimes = fetch(0);
        return dateTimes.get(i);
    }
    public ArrayList <String> LimitExceeded(String _sensorName)
    {
        ArrayList<String> sensorNames = fetch(3);
        ArrayList<String> values = fetch(4);
        ArrayList<Double> average = new ArrayList<>();
        ArrayList<String> exceed = new ArrayList<>();
        ArrayList<String> dateTimes = fetch(0);
        for (int i =0 ; i< sensorNames.size();i++)
        {
            if (_sensorName.equals("PM10"))
            {
                average = getAverage("PM10");
                for (int j =0 ; j<average.size() ;j++)
                {
                    if (average.get(j)>50)
                    {
                        exceed.add(dateTimes.get(j));
                    }
                }
            }
            else if (_sensorName.equals("PM2.5"))
            {

                average = getAverage("PM2.5");

                for (int j =0 ; j<average.size() ;j++)
                {
                    if (average.get(j)>25)
                    {
                        exceed.add(dateTimes.get(j));
                    }
                }
            }
            else if (_sensorName.equals("T"))
            {

                throw new NullPointerException("The limit about this sensor type doesn't exist");
            }
            else if (_sensorName.equals("RH"))
            {

                throw new NullPointerException("The limit about this sensor type doesn't exist");
            }
        }


        return exceed;
    }
}


