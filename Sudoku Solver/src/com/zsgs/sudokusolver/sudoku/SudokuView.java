package com.zsgs.sudokusolver.sudoku;

import java.util.Scanner;

public class SudokuView {

	SudokuModel sudokuModel;
	Scanner sc = new Scanner(System.in);

	public SudokuView() {
		sudokuModel = new SudokuModel(this);
	}

	public void onInit() {
		System.out.println("\n\n\n\nHello! Welcome to the sudoku solver!");
		System.out.println(
				"Please choose an option from the following: \n1. Solve a sudoku\n2. Terminate\nEnter your choice: ");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			getSudoku();
			break;
		case 2:
			System.out.println("Thank you for using this application!");
			break;
		default:
			System.out.println("Invalid choice. Please enter a valid choice, punk.");
			onInit();
			break;
		}
	}

	public void getSudoku() {

		System.out.println("Enter a grid number for the board: ");
		int n = sc.nextInt();
		sc.nextLine();
		int[][] board = new int[n][n];
		System.out.println("Enter the grid to be solved. In the empty spaces, please fill in a zero.");

		for (int i = 0; i < n; i++) {
			System.out.println("Row: " + (int) (i + 1));
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		System.out.println("Before solving: ");
		view(board, n);
		sudokuModel.solve(board, n);
		System.out.println("\n\nAfter solving: ");
		view(board, n);
		onInit();
	}

	public void view(int[][] board, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
		}
	}

}
