package second;

import first.Queue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by nicasandra on 11/14/2016.
 */
public class Adjacency {
    private Integer edges;
    private Integer size;
    private Queue<Integer>[] list;

    public String readFromFile(String source) {
        RandomAccessFile raf;
        StringBuilder buffer = new StringBuilder();
        String line = "";
        try {
            raf = new RandomAccessFile(source, "rw");
            while ((line = raf.readLine()) != null) {
                buffer.append(line).append(System.getProperty("line.separator"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public void processingMethod() {
        String str = readFromFile("source.in");
        String[] lines = str.split(System.getProperty("line.separator"));

        String[] firstLine = lines[0].split(" ");
        this.size = Integer.parseInt(firstLine[0]);
        this.edges = Integer.parseInt(firstLine[1]);

        list = new Queue[size];

        initializeArray(list);

        addElements(lines);

        String data = getElements();
        writeInFile("destination.in", data);

        System.out.println("Successfully added!");

    }

    public void initializeArray(Queue<Integer>[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Queue<Integer>();
        }
    }

    public void addElements(String[] lines) {
        for (int i = 1; i < lines.length; i++) {
            String[] aLine = lines[i].split(" ");
            Integer first = Integer.parseInt(aLine[0]);
            Integer second = Integer.parseInt(aLine[1]);

            if (!list[first - 1].containsElement(second)) {
                list[first - 1].add(second);
            }
            if (!list[second - 1].containsElement(first)) {
                list[second - 1].add(first);
            }
        }
    }

    public String getElements() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            sb.append((i + 1) + ": ");
            for (int j = 0; j < list[i].size(); j++) {
                sb.append(list[i].getFromIndex(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void writeInFile(String destination, String data) {
        try {
            RandomAccessFile raf = new RandomAccessFile(destination, "rw");
            raf.write(data.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Adjacency a = new Adjacency();
        a.processingMethod();
    }
}
