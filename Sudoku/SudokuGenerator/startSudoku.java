package SudokuGenerator;

public class startSudoku {
    static void initialize(int matriz[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                matriz[i][j]=0;
            }
        }
    }
    static void print(int matriz[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print("|"+matriz[i][j]+"|");
            }
            System.out.print("\n");
        }
    }
}//end of class
