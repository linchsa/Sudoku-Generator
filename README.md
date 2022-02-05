# Sudoku-Generator

Just a classic Sudoku generator that creates random sudoku's combinations

# How does it works?
By implementing some checking functions (rows, columns and regions), the programm generates the sudoku by regions. After some tests, I find out that the most efficient way of generating it was starting with region 5 (middle), then R2 and R8, etc. (the order is written in the code). 

While it is generating the regions, the programm checks if the random number combination is valid. If it is not, then it generates another one until is valid. To avoid infinite loops, I pinned up a limit of operations. If the limit is exceeded, it restarts the sudoku from the beggining.

# Example

                                                                                                                                                      |4||7||3||6||2||8||5||9||1|
                                                                                                                                                      |8||2||5||1||9||7||3||6||4|
                                                                                                                                                      |6||1||9||3||5||4||7||8||2|
|2||5||4||8||3||9||1||7||6|
|1||6||8||4||7||5||2||3||9|
|9||3||7||2||6||1||8||4||5|
|5||4||2||7||8||6||9||1||3|
|3||8||6||9||1||2||4||5||7|
|7||9||1||5||4||3||6||2||8|
