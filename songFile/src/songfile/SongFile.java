/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package songfile;
import java.io.*;
/**
 * @date 10-Mar-2017
 * @author Trevor
 */
public class SongFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File songLyrics= new File("song.txt");//this is a comment.
        FileReader in;//this creates a new filereader
        BufferedReader readFile;
        String line;
        try{
            in = new FileReader(songLyrics);//this opens the stream
            readFile = new BufferedReader(in);//this opens the stream
            while((line=readFile.readLine())!=null){//prints lines line by lines until it reaches an empty line.;
                System.out.println(line);
            }
            readFile.close();//this closes the stream
            in.close();//this closes the stream
        }
        catch(FileNotFoundException e){
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: "+e.getMessage());
        }
        catch(IOException e){
            System.out.println("Problem Reading File");
            System.err.println("IOException: "+e.getMessage());
        }
    }

}
