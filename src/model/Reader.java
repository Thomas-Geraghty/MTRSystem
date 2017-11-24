package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {

    private File file;
    private FileReader fr;
    private BufferedReader br;

    public Reader() {
        try{
            file = new File("resources/MTRsystem_partial.csv");
            fr = new FileReader(file);
            br = new BufferedReader(fr);

        }catch(Exception e){
            System.out.println("File not found");
        }
    }


    public ArrayList<ArrayList<String>> readFile() {

        ArrayList<ArrayList<String>> arrayOfLines = new ArrayList<>();

        try {
            String line = null;
            String[] lineList = null;
            String[] stationList = null;

            while ((line = br.readLine()) != null) {
                lineList = line.split("\\n");

                for (int i = 0; i < lineList.length; i++) {
                    ArrayList<String> arrayOfStations = new ArrayList<>();
                    arrayOfLines.add(arrayOfStations);
                    stationList = lineList[i].split(",");

                    for(int x = 0; x < stationList.length; x++) {
                        arrayOfStations.add(stationList[x]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayOfLines;
    }
}
