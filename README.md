# Sudoku-Generator

Just a classic Sudoku generator that creates random sudoku's combinations

# How does it works?
By implementing some checking functions (rows, columns and regions), the programm generates the sudoku by regions. After some tests, I find out that the most efficient way of generating it was starting with region 5 (middle), then R2 and R8, etc. (the order is written in the code). 

While it is generating the regions, the programm checks if the random number combination is valid. If it is not, then it generates another one until is valid. To avoid infinite loops, I pinned up a limit of operations. If the limit is exceeded, it restarts the sudoku from the beggining.

# Example

...
