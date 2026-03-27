import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        try(FileWriter fileWriter = new FileWriter(fileName)) {


        } catch (IOException e) {
            System.out.println("There is an issue writing to " + fileName);
        }

    }

    public ArrayList<DisplayableRecord> loadRecords()
    {
        /*Loads and returns an ArrayList from a file with the file name specified by fileName
        using ObjectInputStream. Any exceptions thrown by the loading code should be caught
        and handled in this method.
         In the case of exceptions, an error message should be displayed and null returned.
        * */
        ArrayList<DisplayableRecord> records = new ArrayList<>();
        Charset charset = StandardCharsets.US_ASCII;
        Path path = Paths.get(fileName);

        try(BufferedReader reader = Files.newBufferedReader(path, charset))
        {
            String response = reader.readLine();

        } catch (Exception e) {
            System.out.println("Error reading " + fileName);
            return null;
        }


        return records;
    }

    public void exportReadableRecords( ArrayList<DisplayableRecord> records,
                                       String readableFileName)
    {
        /* Writes the details of each record
        to the specified file name in human-readable text format. */
    }
}
