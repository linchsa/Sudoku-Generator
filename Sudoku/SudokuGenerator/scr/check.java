package SudokuGenerator.scr;

public class check{
    //Checks if there's elements repeated in rows
    static boolean checkColumns(int sudoku[][],int i,int j){
       int i2;
       int value=sudoku[i][j];
       int cont=0;
       for(i2=0;i2<9 && cont!=2;i2++){
           if(sudoku[i2][j]==value) cont++;
       }
       return cont>=2?false:true;
   }
   //Checks if there's elements repeated in columns
   static boolean checkRows(int sudoku[][],int i,int j){
       int j2;
       int value=sudoku[i][j];
       int cont=0;
       for(j2=0;j2<9 && cont!=2;j2++){
           if(sudoku[i][j2]==value) cont++;
       }
       return cont>=2?false:true;
   }
   //Checks if there's elements repeated in eack region

   static boolean checkRegion(int sudoku[][],int i,int j, int i2, int j2, int i3, int j3){
        int value=sudoku[i][j];
        int cont=0;
        for(;i2<i3;i2++){
            for(;j2<j3 && cont!=2;j2++){
                if(sudoku[i2][j2]==value) cont++;
            }
        }
        return cont>=2?false:true;
    }

    static boolean checkRegionExtended(int sudoku[][],int i,int j){
        boolean answer=true;
        if(i<3 && j<3){//R1
            answer= checkRegion(sudoku,i,j,0,0,3,3);

        }
        else if(i<3 && (j>2 && j<6)){//R2
            answer= checkRegion(sudoku,i,j,0,3,3,6);

        }
        else if(i<3 && j>5){//R3
            answer= checkRegion(sudoku,i,j,0,6,3,9);

        }
        else if((i>2 && i<6) && j<3){//R4
            answer= checkRegion(sudoku, i,j,3,0,6,3);

        }
        else if((i>2 && i<6) && (j>2 && j<6)){//R5
            answer= checkRegion(sudoku, i,j,3,3,6,6);

        }
        else if((i>2 && i<6) && j>5){//R6
            answer= checkRegion(sudoku, i,j,3,6,6,9);

        }
        else if(i>5 && j<2){//R7
            answer= checkRegion(sudoku, i,j,6,0,9,3);
        }

        else if(i>5 && (j>2 && j<6)){//R8
            answer= checkRegion(sudoku, i,j,6,3,9,6);

        }
        else if(i>5 && j>5){//R9
            answer= checkRegion(sudoku, i,j,6,6,9,9);

        }
        return answer;
    }

   
   static int[][] generateaux (int sudoku[][], int i2, int j2, int i3, int j3){
        int contador=0;
        for(int i=i2;i<i3;i++){
            for(int j=j2;j<j3;j++){
                //Last number correction
            if(i==8 && j==8){
                sudoku[i][j]=(int)(Math.random()*9+1);
                while(checkRegionExtended(sudoku, i, j)!=true){
                    sudoku[i][j]=(int)(Math.random()*9+1);
                }
            }
                boolean proof=checkRegionExtended(sudoku, i, j) && (checkColumns(sudoku, i, j) && checkRows(sudoku, i, j));
                if(proof==false){
                    contador=0;
                    while(proof!=true){
                    sudoku[i][j]=(int)(Math.random()*9+1);
                    proof= checkRegionExtended(sudoku, i, j) && checkColumns(sudoku, i, j) && checkRows(sudoku, i, j);
                    if(proof==false) contador++;
                    if(contador==100) return generate(sudoku);
                    }
                }
            }
        }
    return sudoku;
}
    static int[][] generate(int sudoku[][]){
        startSudoku.initialize(sudoku);
        sudoku = generateaux(sudoku, 3, 3,6,6); //R5
        sudoku = generateaux(sudoku, 3, 0,6,9); //R4 and R6
        sudoku = generateaux(sudoku, 0, 3,9,6); //R2 and R8
        sudoku = generateaux(sudoku, 0, 0,9,3); // R1 and R7
        sudoku = generateaux(sudoku, 0, 6,9,9); // R3 and R9
        return sudoku;
    }
}//end of class