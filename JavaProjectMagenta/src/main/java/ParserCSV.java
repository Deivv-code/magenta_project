import org.json.JSONArray;

import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import javax.xml.transform.stream.StreamResult;
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
import java.util.Date;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ParserCSV {
    private final File file;
    private ArrayList <DataReader> listDto = new ArrayList<>();


    public ParserCSV(String _fileName) {
        String currentDirectory = System.getProperty("user.dir");
        file = new File(currentDirectory + "\\files\\" + _fileName);
    }

    public File getFile()
    {
        return file;
    }


    public  ArrayList<OptionalDouble> getAverage(Type _sensorName)
    {
        OptionalDouble av;
        int counter= 0;

        ArrayList<OptionalDouble> average = new ArrayList<>();

              for(int i =0; i<listDto.size();i++)
              {
                if(_sensorName ==listDto.get(i).getSensortype())
                {
                    DoubleStream stream = DoubleStream.of(listDto.get(i).getValue());
                    av = stream.average();
                    average.add(av);
                }

              }


    return average;
    }

    public ArrayList<Double> getAverage(String _sensorName) {
        //ArrayList<String> sensorNames = fetch(3);
       // ArrayList<String> values = fetch(4);

        //ArrayList <String> datetimes = fetch(0);
        ReaderCSV a = new ReaderCSV(this);

        //change all ArrayList that use fetch with a.get

        // process date

        ArrayList<String> date = new ArrayList<>();
        for (String data : a.getDateTime()/*dateTimes*/) { date.add(data.split(" ")[0]); }

        ArrayList<Double> averages = new ArrayList<>();
        int counter = 0;
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i=1; i<date.size(); i++) {
            indexes.add(i);
            if (i+1<date.size()) {
                if (!(date.get(i).equals( date.get(i+1) )) ) {
                    double average = 0;
                    for (int j=0; j<indexes.size(); j++) {
                        if (a.getSensorNames().get(j).equals(_sensorName)){ //sensorNames.get(j).equals(_sensorName)) {
                            average += Double.parseDouble( a.getValues().get(j));//values.get(j) );
                            counter ++;
                        }
                    }
                    average = average/counter;
                    averages.add(average);

                    indexes.clear();
                    counter = 0;
                }
            } else {

                double average = 0;
                for (int j=0; j<indexes.size(); j++) {
                    if (a.getSensorNames().get(j).equals(_sensorName)){ //sensorNames.get(j).equals(_sensorName)) {
                        average += Double.parseDouble( a.getValues().get(j));//values.get(j) );
                        counter++;
                    }
                }
                average = average/counter;
                averages.add(average);
                counter = 0;

                indexes.clear();
            }
        }

        return averages;
    }

   /* public  Double AnnualAverage(Type _sensorName)
    {
        ReaderCSV a = new ReaderCSV(this);


        int counter = 0;
        double average = 0;

        for (int i=0;i<listDto.size();i++)
        {
            if (listDto.get(i).getSensortype() == _sensorName)//(sensorNames.get(i).equals(_sensorName))
            {
                for (int j = 0; j<listDto.size();i++)
                {
                    average += listDto.get(i).getValue();
                    counter++;
                }
                average = average /counter;

            }

        }
        return average;
    }
*/

    public Double AnnualAverage(String _sensorName)
    {
        ReaderCSV a = new ReaderCSV(this);
        int counter = 0;
        double average = 0;
        double temp = 0;
        for (int i = 0;i<a.getSensorNames().size();i++)
        {
            if (a.getSensorNames().get(i).equals(_sensorName))
            {
                for(int j = 0; j<a.getValues().size();j++)
                {
                 temp = Double.valueOf(a.getValues().get(j));
                 average += temp;
                 counter++;

                }
        }

        }
        return average/counter;
    }

    public Double OneAverage(String s)
    {
        double average = 0;
        ArrayList <Double> listAV = this.getAverage(s);
        for (int i = 0; i<listAV.size();i++)
        {
            average += listAV.get(i);
        }

        return average/listAV.size();
    }
    public String getDateTime(int i)
    {
        ReaderCSV a = new ReaderCSV(this);
        ArrayList<String> dateTimes = a.getDateTime();
        return dateTimes.get(i);
    }
    public int LimitExceeded(String _sensorName)
    {
       // ArrayList<String> sensorNames = fetch(3);
        ReaderCSV a = new ReaderCSV(this);
        ArrayList<Double> average = getAverage(_sensorName);
        System.out.println(average.size());
        double limit = 0;
        int counter = 0;
        //ArrayList<String> dateTimes = fetch(0);


            if (_sensorName.equals("PM10")) {
                limit = 14.450451940035277;


                for (int j = 0; j < average.size(); j++) {
                    if (average.get(j) > limit) {
                        counter++;
                    }
                }
            }
            else if (_sensorName.equals("PM2.5"))
            {
                limit = 12.016062409812399;


                for (int j =0 ; j<average.size() ;j++)
                {
                    if (average.get(j)>limit)
                    {
                        counter++;
                    }
                }
            }
            else if (_sensorName.equals("T"))
            {
                limit = 11.096315057263205;

                for (int j = 0; j<average.size();j++)
                {
                    if (average.get(j)>limit)
                    {
                        counter++;
                    }
                }
            }
            else if (_sensorName.equals("RH"))
            {
                limit = 99.88732793615938;

                for (int j = 0; j<average.size();j++)
                {
                    if (average.get(j)>limit)
                    {
                        counter++;
                    }
                }
            }



        return counter;
    }
    public JSONArray ArrayToJSONArray(ArrayList <DataReader> a)
    {
        JSONArray list = new JSONArray(a);
        return list;
    }
    public JSONArray ArrayToJSONArray()
    {
        JSONArray list = new JSONArray(listDto);
        return list;
    }
}


