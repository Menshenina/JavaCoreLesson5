package main.java.lesson5;

public class AppData {
    private String[] header;
    private int [][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void readFromFile(){

    }

    public  void writeToFile(){

    }
}
