import java.util.ArrayList;
import java.util.Iterator;

public class RecordManager {
    //this class will store and manage all book records in memory

    private ArrayList<DisplayableRecord> records;

    public RecordManager() {
        records = new ArrayList<>();
    }

    //adds a record and throws illegal argument exception if duplicate record exists
    public void addRecord(DisplayableRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("Record cannot be null");
        }
        Iterator<DisplayableRecord> it = records.iterator();

        while(it.hasNext()) {
            DisplayableRecord rec = it.next();

            if(rec.getId().equals(record.getId())) {
                throw new IllegalArgumentException("Duplicated record");
            }
        }

        records.add(record);
    }

    //removes the record with the matching ID from the collection
    //Returns true if the record was found and removed
    //Returns false if no record exists with ID
    public boolean removeRecord(String id) {
        Iterator<DisplayableRecord> it = records.iterator();

        while(it.hasNext()) {
            DisplayableRecord record = it.next();

            if(record.getId().equals(id)) {
                records.remove(record);
                return true;
            }
        }

        return false;
    }

    //returns all stored records
    public ArrayList<DisplayableRecord> getAllRecords() {
        return records;
    }

    //returns the record if found otherwise null
    public DisplayableRecord findRecordById(String id) {
        Iterator<DisplayableRecord> it = records.iterator();

        while(it.hasNext()) {
            DisplayableRecord record = it.next();

            if(record.getId().equals(id)) {
               return record;
            }
        }

        return null;
    }

    //Replaces the current list of records with the parameter passed in
    public void setRecords(ArrayList<DisplayableRecord>records) {
        this.records = records;
    }

    //prints out the details for every DisplayableRecord in records
    public void displayAllRecords() {
        for (DisplayableRecord record : records) {
            System.out.println(record);
        }
    }
}
