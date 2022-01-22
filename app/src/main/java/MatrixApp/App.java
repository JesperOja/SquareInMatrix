/**
 * 
 * @author Jesper Oja
 * @version 1/21.1.2022
 */
package MatrixApp;

public class App {
    //Change this value to get different files
    final static String Filename = "Test.txt";
    
	public static void main(String[] args) {
            Filereader reader = new Filereader();
            MakeMatrix originalMatrix = new MakeMatrix(reader);
            NewMatrix finalMatrix = new NewMatrix(reader, originalMatrix);
        
            reader.readFile(Filename);
        
            originalMatrix.createMatrix();
            finalMatrix.createFinalBoard();
            finalMatrix.printFinalMatrix();
	}
}
