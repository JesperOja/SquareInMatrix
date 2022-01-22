package MatrixApp;

/**
 *
 * @author Jesper Oja
 */

public class NewMatrix {
    private int[][] valueMatrix;
    private String[][] finalMatrix;
    private Filereader reader;
    private MakeMatrix originalMatrix;
    private String block;
    private String replace;
    private String empty;
    
    public NewMatrix(Filereader reader, MakeMatrix originalMatrix){
        this.reader = reader;
        this.originalMatrix = originalMatrix; 
    }
    
    //Creating valueMatrix and finalMatrix
    public void createFinalBoard(){
    	this.valueMatrix = new int[originalMatrix.getHeight()][originalMatrix.getRow()];
        this.finalMatrix = new String[originalMatrix.getHeight()][originalMatrix.getRow()];   
    	this.empty = reader.getMetaData().substring(reader.getMetaData().length()-3, reader.getMetaData().length()-2);
    	this.block = reader.getMetaData().substring(reader.getMetaData().length()-2, reader.getMetaData().length()-1);
        this.replace = reader.getMetaData().substring(reader.getMetaData().length()-1, reader.getMetaData().length());
        
        int maxCount = 0;
        int maxI = 0;
        int maxJ = 0;
        
        //Checking first collum and assigning values for valueMatrix and character to finalMatrix
        for(int i = 0; i<originalMatrix.getHeight(); i++){
            if(originalMatrix.getMatrix()[i][0].equals(block)){
                valueMatrix[i][0] = 0;
                finalMatrix[i][0] = block;
            }else{
                valueMatrix[i][0] = 1;
                finalMatrix[i][0] = empty;
            }
        }
        //Checking first row and assigning values for valueMatrix and character to finalMatrix
        for(int i = 0; i<originalMatrix.getRow(); i++){
            if(originalMatrix.getMatrix()[0][i].equals(block)){
                valueMatrix[0][i] = 0;
                finalMatrix[0][i] = block;
            }else{
                valueMatrix[0][i] = 1;
                finalMatrix[0][i] = empty;
            }
        }
        
        //Going through rest of original matrix board
        for(int i = 1; i<originalMatrix.getHeight(); i++){
            for(int j = 1; j<originalMatrix.getRow(); j++){
                if(originalMatrix.getMatrix()[i][j].equals(block)){
                valueMatrix[i][j] = 0;
                finalMatrix[i][j] = block;
                }else{
                	//Assigning values to valueMatrix depending what values are in previous spots next to this one
                	//and taking minimum value of those and increasing that by 1
                    valueMatrix[i][j] = min(valueMatrix[i][j-1],valueMatrix[i-1][j],valueMatrix[i-1][j-1])+1;
                    finalMatrix[i][j] = empty;
                    //Assigning maxCount value to be first highest found in valueMatrix and taking that points i and j values
                    if (maxCount <valueMatrix[i][j]){
                        maxCount = valueMatrix[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        
        //Going from maxI and maxJ backwards to create largest possible square
        for(int i = maxI; i > maxI-maxCount; i--){
            for(int j = maxJ; j > maxJ-maxCount; j--){
            finalMatrix[i][j] = replace;
        }
        }
        
    }
    //function to check lowest value
    private int min(int a, int b, int c){
        if(a<b && a < c)
            return a;
        else if(b < a && b < c)
            return b;
        else if(c<a && c<b)
            return c;
        else if(a==b)
            return a;
        else
            return c;
    }
    
    //Printing finalBoard, you can check here your valueMatrix as well
    public void printFinalMatrix(){
        for(int i = 0; i<originalMatrix.getHeight(); i++){
            for(int j = 0; j<originalMatrix.getRow(); j++){
                if(j == originalMatrix.getRow()-1){
                    System.out.println(finalMatrix[i][j]); 	//By changing finalMatrix[i][j] to valueMatrix[i][j]
                }else{
                    System.out.print(finalMatrix[i][j]);	//By changing finalMatrix[i][j] to valueMatrix[i][j]
                }
            }
        }
    }
    
}