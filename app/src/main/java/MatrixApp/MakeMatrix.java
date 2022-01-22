package MatrixApp;

/**
 *
 * @author Jesper Oja
 */
public class MakeMatrix {
	private String[][] originalBoard;
    private Filereader reader;
    private int height;
    private int row;
    
    public MakeMatrix(Filereader reader){
        this.reader = reader;  
    }
    
    //Creating matrixboard from file
    public void createMatrix(){
    	//Checking how high the board is from metadata
        this.height = Integer.parseInt(reader.getMetaData().substring(0, reader.getMetaData().length()-3));
        
        //reading first board row to get how long it is
        if(reader.getFilename().contains(".txt")){
        	this.row = reader.getSplitted()[1].length()-1;
        }else	
        	this.row = reader.getSplitted()[1].length();
        
        //Creating matrix with height and row from above
        this.originalBoard = new String[height][row];
        for(int i = 0; i< height;i++){
            for(int j = 0; j < row;j++){
               originalBoard[i][j] = String.valueOf(reader.getSplitted()[i+1].charAt(j));
            }
        }
    }
    
    public String[][] getMatrix(){
        return originalBoard;
    }
    public int getHeight(){
        return height;
    }
    public int getRow(){
        return row;
    }
}

