
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;


public class ParserCSV {
    private final File file;
    private ArrayList<DataReader> listDto = new ArrayList<>();


    public ParserCSV(String _fileName) {
        String currentDirectory = System.getProperty("user.dir");
        file = new File(currentDirectory + "\\files\\" + _fileName);

    }

    public File getFile() {
        return file;
    }



    public ArrayList<Double> getAverage(Type T, ArrayList<DataReader> listD) {
        ReaderCSV a = new ReaderCSV(this);

        ArrayList<String> date = new ArrayList<>();
        for (String data : a.getDateTime()) {
            date.add(data.split(" ")[0]);
        }

        ArrayList<Double> averages = new ArrayList<>();
        int counter = 0;
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 1; i < date.size()-1; i++) {
            indexes.add(i);
            if (i + 1 < date.size()) {
                if (!(date.get(i).equals(date.get(i + 1)))) {
                    double average = 0;
                    for (int j = 0; j < indexes.size(); j++) {
                        if (listD.get(j).getSensortype().equals(T)) {
                            average += listD.get(j).getValue();
                            counter++;
                        }
                    }


                    average = average / counter;
                    averages.add(average);


                    indexes.clear();
                    counter = 0;
                }
            } else {

                double average = 0;
                for (int j = 0; j < indexes.size(); j++) {
                    if (listD.get(j).getDatetime().equals(T)) {
                        average += listD.get(j).getValue();
                        counter++;
                    }
                }
                average = average / counter;
                averages.add(average);
                counter = 0;

                indexes.clear();
            }

        }
        return averages;
    }

    public ArrayList<Double> getAverage(String _sensorName) {


        ReaderCSV a = new ReaderCSV(this);

        //change all ArrayList that use fetch with a.get

        // process date

        ArrayList<String> date = new ArrayList<>();
        for (String data : a.getDateTime()) {
            date.add(data.split(" ")[0]);
        }

        ArrayList<Double> averages = new ArrayList<>();
        int counter = 0;
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 1; i < date.size(); i++) {
            indexes.add(i);
            if (i + 1 < date.size()) {
                if (!(date.get(i).equals(date.get(i + 1)))) {
                    double average = 0;
                    for (int j = 0; j < indexes.size(); j++) {
                        if (a.getSensorNames().get(j).equals(_sensorName)) {
                            average += Double.parseDouble(a.getValues().get(j));
                            counter++;
                        }
                    }
                    average = average / counter;
                    averages.add(average);

                    indexes.clear();
                    counter = 0;
                }
            } else {

                double average = 0;
                for (int j = 0; j < indexes.size(); j++) {
                    if (a.getSensorNames().get(j).equals(_sensorName)) {
                        average += Double.parseDouble(a.getValues().get(j));
                        counter++;
                    }
                }
                average = average / counter;
                averages.add(average);
                counter = 0;

                indexes.clear();
            }
        }

        return averages;
    }


    public Double OneAverage(String a) {
        double average = 0;
        ArrayList<Double> listAV = this.getAverage(a);
        for (int i = 0; i < listAV.size(); i++) {
            average += listAV.get(i);
        }

        return average / listAV.size();
    }


    public Double OneAverage(Type n,ReaderCSV reader)
    {
     listDto = reader.fetch();
     double average = 0;
        ArrayList <Double> listAV = this.getAverage(n,listDto);
        for (int i = 0; i<listAV.size();i++)
        {
            average += listAV.get(i);
        }

        return average/listAV.size();
    }




    public int LimitExceeded(Type t, ReaderCSV reader)
    {
        listDto = reader.fetch();
        ReaderCSV a = new ReaderCSV(this);
        ArrayList <Double> average = getAverage(t,listDto);
        double limit = 0;
        int counter=0;
        String s = t.toString();
        if(t == Type.PM10)
        {
            limit = OneAverage(Type.PM10,reader);
            for (int i = 0; i<average.size();i++)
            {
                if(average.get(i)>limit)
                {
                   counter++;
                }
            }
        }
           if(t == Type.PM2_5)
        {
            limit = OneAverage(Type.PM2_5,reader);
            for (int i = 0; i<average.size();i++)
            {
                if(average.get(i)>limit)
                {
                   counter++;
                }
            }
        }
           if(t == Type.T)
        {
            limit = OneAverage(Type.T,reader);
            for (int i = 0; i<average.size();i++)
            {
                if(average.get(i)>limit)
                {
                   counter++;
                }
            }
        }
           if(t == Type.RH)
        {
            limit = OneAverage(Type.RH,reader);
            for (int i = 0; i<average.size();i++)
            {
                if(average.get(i)>limit)
                {
                   counter++;
                }
            }
        }
        return counter;
    }


    public int LimitExceeded(String _sensorName) {

        ReaderCSV a = new ReaderCSV(this);
        ArrayList<Double> average = getAverage(_sensorName);
        System.out.println(average.size());
        double limit = 0;
        int counter = 0;


        if (_sensorName.equals("PM10")) {
            limit = this.OneAverage(_sensorName);


            for (int j = 0; j < average.size(); j++) {
                if (average.get(j) > limit) {
                    counter++;
                }
            }
        } else if (_sensorName.equals("PM2.5")) {
            limit = this.OneAverage(_sensorName);


            for (int j = 0; j < average.size(); j++) {
                if (average.get(j) > limit) {
                    counter++;
                }
            }
        } else if (_sensorName.equals("T")) {
            limit = this.OneAverage(_sensorName);

            for (int j = 0; j < average.size(); j++) {
                if (average.get(j) > limit) {
                    counter++;
                }
            }
        } else if (_sensorName.equals("RH")) {
            limit = this.OneAverage(_sensorName);

            for (int j = 0; j < average.size(); j++) {
                if (average.get(j) > limit) {
                    counter++;
                }
            }
        }


        return counter;
    }

    public static ArrayList<DataReader> JSONSensor(ArrayList<DataReader> listD, Type T) {
        ArrayList<DataReader> listForSensor = new ArrayList<>();
        for (int i = 0; i < listD.size(); i++) {
            if (listD.get(i).getSensortype().equals(T)) {
                listForSensor.add(listD.get(i));
            }
        }
        return listForSensor;
    }

    public static Date divideDate(ArrayList<DataReader> listD)
    {


        ArrayList<String> date = new ArrayList<>();
        for (String data : this.getDateTime()) {
            date.add(data.split(" ")[0]);
        }
    }

}





