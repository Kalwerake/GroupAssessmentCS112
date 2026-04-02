import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileHandler {

    private String fileName;


    public FileHandler(String fileName){
        this.fileName = fileName;

    }

    public void setFileName(String fileName){ this.fileName = fileName; }

    public String getFileName(){ return fileName;}

    public void saveRecords(ArrayList<DisplayableRecord> records)
    {
        /*
        Saves the ArrayList passed in to a file
        with the file name specified by fileName using ObjectOutputStream*/

        Path filePath = Path.of(fileName);
        try(ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(filePath))) {
            os.writeObject(records);
            System.err.println("Records written to " + fileName);

        } catch (IOException e) {
            System.err.println("There is an issue writing to " + fileName);
        }

    }

    public ArrayList<DisplayableRecord> loadRecords()
    {
        /*
        Loads and returns an ArrayList from a file with the file name specified by fileName
        using ObjectInputStream. Any exceptions thrown by the loading code should be caught
        and handled in this method.
        In the case of exceptions, an error message should be displayed and null returned.
        */
        Path filePath = Path.of(fileName);

        try(ObjectInputStream os = new ObjectInputStream(Files.newInputStream(filePath)))
        {
            return (ArrayList<DisplayableRecord>) os.readObject();

        } catch (IOException e) {
            System.err.println("Error reading " + fileName);
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Type error");
            return null;
        }

    }

    public void exportReadableRecords( ArrayList<DisplayableRecord> records,
                                       String readableFileName)
    {
        /* Writes the details of each record
        to the specified file name in human-readable text format. */

        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(readableFileName), StandardCharsets.UTF_8)) {
            for (DisplayableRecord record : records) {
                writer.write(record.toString());
                writer.newLine();
            }
            System.out.println("Records saved to " + readableFileName);
        } catch (IOException e) {
            System.err.println(("Error exporting records"));
        }
    }
}
