package com.zsgs.sudokusolver;

import com.zsgs.sudokusolver.sudoku.SudokuView;

public class SudokuSolverMain {
	
	private static void onInit() {
		SudokuView sudokuView = new SudokuView();
		sudokuView.onInit();
	}

	public static void main(String[] args) {
		onInit();
	}

}
