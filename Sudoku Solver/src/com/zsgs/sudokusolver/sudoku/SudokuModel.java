package com.zsgs.sudokusolver.sudoku;

public class SudokuModel {

	SudokuView sudokuView;

	SudokuModel(SudokuView sudokuView) {
		this.sudokuView = sudokuView;
	}
	
	public void solve(int[][] board, int n) {
        solve(board, 0, 0, n);
    }

    public boolean solve(int[][] board, int r, int c, int n) {
        if (r == n-1 && c == board[0].length)
            return true;
        if (c == board[0].length) {
            c = 0;
            r++;
        }
        if (board[r][c] != 0)
            return solve(board, r, c + 1, n);
        for (int i = 1; i <= n; i++) {
            if (check(board, r, c, i)) {
                board[r][c] = i;
                if (solve(board, r, c + 1, n))
                    return true;
            }
            board[r][c] = 0;
        }
        return false;
    }

    public boolean check(int[][] board, int r, int c, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == num)
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num)
                return false;
        }
        int temp = (int)Math.sqrt(board.length);
        int row = r - r % temp;
        int col = c - c % temp;
        if(board.length>=9)
        for (int i = row; i < row + temp; i++) {
            for (int j = col; j < col + temp; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
