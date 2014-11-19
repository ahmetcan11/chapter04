import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * return true if song with x is in collection
     */
    public boolean contains(String searchString)
    {
        for(String filename : files) {
            if (filename.contains(searchString)){
                System.out.println(filename);
                return true;
            }
        }
        return false;
    }

    /**
     * return true if song with x is in collection
     * v2: with only one return statement
     */
    public boolean containsV2(String searchString)
    {
        int counter = 0;
        for(String filename : files) {
            if (filename.contains(searchString)){
                counter = counter +1;
            }
        }
        System.out.println("String "+searchString+ " "+counter+" mal gefunden.");
        return counter > 0;
    }

    /**
     * return true if song with x is in collection
     * v3: with only one return statement
     */
    public boolean containsV3(String searchString)
    {
        boolean found = false;
        for(String filename : files) {
            if (filename.contains(searchString)){
                found = true;
            }
        }
        return found;
    }

    /**
     * return true if song with x is in collection
     * v4: with only one return statement and
     * stopping to iterate when first occurence is found
     */
    public boolean containsV4(String searchString)
    {
        boolean found = false;
        int index = 0;
        while((index < files.size()) && (!found)){
            //for(String filename : files) {
            String filename = files.get(index);
            if (filename.contains(searchString)){
                found = true;
            }
            index = index + 1;
        }
        return found;
    }

    /**
     * return count of song if song with x is in collection
     */
    public int count(String searchString)
    {
        int counter = 0;
        for(String filename : files) {
            if (filename.contains(searchString)){
                counter = counter +1;
            }
        }
        System.out.println("String "+searchString+ " "+counter+" mal gefunden.");
        return counter;
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
}
