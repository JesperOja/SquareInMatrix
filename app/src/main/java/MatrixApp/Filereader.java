package MatrixApp;
/**
 *
 * @author Jesper Oja
 * 22.1.2022
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Filereader {
	private String orginalData = "";
    private String[] splitted;
    private String metaData;
    private String filename;
    
    //Reading file, getting metadata and matrixboard from file
    public void readFile(String filename){
        try(FileReader reader = new FileReader("src\\main\\java\\files\\"+filename);
                BufferedReader data = new BufferedReader(reader);){
			this.metaData = data.readLine();
			this.filename = filename;
			this.orginalData = new String (Files.readAllBytes(Paths.get("src\\main\\java\\files\\"+filename)));
            this.splitted =  orginalData.split("\n"); //Splitting data to get one row of board

        }catch(Exception e){
            System.out.println("Something went wrong!");
        }
    }
    public String getMetaData(){
        return metaData;
    }
    public String[] getSplitted(){
        return splitted;
    }
    public String getFilename() {
    	return filename;
    }
}
