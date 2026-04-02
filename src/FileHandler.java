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
        /*Saves the ArrayList passed in to a file
         with the file name specified by fileName using ObjectOutputStream*/

    }

    public ArrayList<DisplayableRecord> loadRecords()
    {
        /*Loads and returns an ArrayList from a file with the file name specified by fileName
        using ObjectInputStream. Any exceptions thrown by the loading code should be caught
        and handled in this method.
         In the case of exceptions, an error message should be displayed and null returned.
        * */

        ArrayList<DisplayableRecord> records = new ArrayList<>();

        return records;
    }

    public void exportReadableRecords( ArrayList<DisplayableRecord> records,
                                       String readableFileName)
    {
        /* Writes the details of each record
        to the specified file name in human-readable text format. */
    }
}
