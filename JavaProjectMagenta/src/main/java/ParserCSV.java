import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ParserCSV {
    private String file_name;
    static double [] [] ArrayCSV;

    public ParserCSV(String file_name) {
        file_name = "air_quality_data.csv";
        this.file_name = file_name;
    }


    String currentDirectory = System.getProperty("user.dir");
    String filePath = currentDirectory + "\\files\\" + file_name;

    BufferedReader in = null;
    String line = "";

    public void PrintCSV(String file_name) {

        try {
            in = new BufferedReader(new FileReader(filePath));

            while ((line = in.readLine()) != null) {
                String[] row = line.split(",");

                for (String index : row) {
                    System.out.printf("%10s", index);
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                // System.out.println(sum/count);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void SetupArray()
    {
      ArrayCSV = new double [4][5];

        Scanner scanIn= null;
        int row = 0;
        int col = 0;
        int rowC = 0;
        int colC = 0;

        String InputLine = "";
        double xnum = 0;
        String xfileLocation = filePath;

        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));

            while (scanIn.hasNextLine())
            {
                InputLine = scanIn.nextLine();

                String[] inArray = InputLine.split(",");

                for (int i =0; i<inArray.length; i++)
                {
                    ArrayCSV [rowC][i] = Double.parseDouble(inArray[i]);
                }
                rowC++;
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}


