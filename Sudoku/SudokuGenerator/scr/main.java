package SudokuGenerator.scr;

class Sudoku {
   public static void main(String[] args){
       int sudoku[][] = new int [9][9];
       startSudoku.initialize(sudoku);
       int sudokufinal[][]= check.generate(sudoku);
       startSudoku.print(sudokufinal);
   }//end of main
}// end of class