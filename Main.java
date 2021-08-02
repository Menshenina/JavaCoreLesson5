package main.java.lesson5;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static String splitter = ";";
    public static void main(String[] args){
        String fileName = "data.csv";
        String[] header = new String[3];
        header[0] = "val 1";
        header[1] = "val 2";
        header[2] = "val 3";

        int[][] vals = new int[2][];
        int[] col1 = new int[3];
        col1[0] = 123;
        col1[1] = 234;
        col1[2] = 345;
        vals[0] = col1;

        int[] col2 = new int[3];
        col2[0] = 890;
        col2[1] = 891;
        col2[2] = 982;
        vals[1] = col2;


        AppData newData = new AppData(header, vals);

        try(PrintWriter outputStream = new PrintWriter(fileName)){
            boolean first = true;
            for(String hed : newData.getHeader()){
                if(!first){
                    outputStream.print(splitter);
                }
                first = false;
                outputStream.print(hed);
            }


            for(int i = 0; i < 2; i++){
                outputStream.println("");
                first = true;
                for(int j = 0; j < 3; j++){
                    if(!first){
                        outputStream.print(splitter);
                    }
                    first = false;
                    outputStream.print(newData.getData()[i][j]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String tempString;
            boolean first = true;
            String[] newHeaders ;
            ArrayList<int[]> newValsTemp = new ArrayList<int[]>();
            while((tempString = bufferedReader.readLine())!= null){
                String[] tempVals = tempString.split(splitter);

                if(first){
                    newHeaders = new String[tempVals.length];
                    for(int i = 0; i < tempVals.length; i++){
                        newHeaders[i] = tempVals[i];
                    }
                }
                else {
                    int[] valsItem = new int[tempVals.length];
                    for(int i = 0; i < tempVals.length; i++){
                        valsItem[i] = Integer.parseInt(tempVals[i]);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
