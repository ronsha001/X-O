import java.util.Scanner;

public class Functions_T10 {

	public static void printMat(char[][] arr) {

		for (char[] n : arr) {
			for (char k : n) {
				System.out.print(k);
			}
			System.out.println();
		}
	}
	public static void resetMat (char[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i %2 == 0) {
					if (j %2 == 0) {
						arr[i][j] = 0;
					} else {
						arr[i][j] = '|';
					}
				} else {
					arr[i][j] = '_';
				}
			}
		}
		
	}
	public static char checkRows (char[][] arr) {
		// *** CHECK ROWS *** //
		char flag = 'b';
		int countX;
		int countO;
		for (int i = 0; i <= 4; i += 2) {
			countX = 3;
			countO = 3;
			for (int j = 0; j <= 4; j += 2) {
				if (arr[i][j] != 'X') {
					countX--;
				}
				if (arr[i][j] != 'O') {
					countO--;
				}
			}
			if (countX == 3) {
				flag = 'X';
			}
			if (countO == 3) {
				flag = 'O';
			}
		}
		return flag;
	}
	public static char checkMainSlant (char[][] arr) {
		// *** CHECK MAIN SLANT *** //
		char flag = 0;
		int countX = 3;
		int countO = 3;
		for (int i = 0, j = 0; i <= 4; i += 2, j += 2) {
			if (arr[j][j] != 'X') {
				countX--;
			}
			if (arr[j][j] != 'O') {
				countO--;
			}
		}
		if (countX == 3) {
			flag = 'X';
		}
		if (countO == 3) {
			flag = 'O';
		}
		return flag;
	}
	public static char checkOtherSlant (char[][] arr) {
		// *** CHECK OTHER SLANT *** //
		char flag = 0;
		int countX = 3;
		int countO = 3;
		for (int i = 0, j = 4; i <= 4; i += 2, j -= 2) {
			if (arr[i][j] != 'X') {
				countX--;
			}
			if (arr[i][j] != 'O') {
				countO--;
			}
		}
		if (countX == 3) {
			flag = 'X';
		}
		if (countO == 3) {
			flag = 'O';
		}
		return flag;
	}	
	public static char checkColumns (char[][] arr) {
		char flag = 0;
		int countX;
		int countO;
		// *** CHECK COLUMNS *** //
		for (int i = 0; i <= 4; i += 2) {
			countX = 3;
			countO = 3;
			for (int j = 0; j <= 4; j += 2) {
				if (arr[j][i] != 'X') {
					countX--;
				}
				if (arr[j][i] != 'O') {
					countO--;
				}
			}
			if (countX == 3) {
				flag = 'X';
			}
			if (countO == 3) {
				flag = 'O';
			}
		}
		return flag;
	}
	public static int hardModeCheckRows (char[][] arr) {
		int countX;
		int countO;
		for (int i = 0; i <= 4; i += 2) {
			countX = 0;
			countO = 0;
			for (int j = 0; j <= 4; j += 2) {
				if (arr[i][j] == 'X' ) {
					countX++;
				}
				if (arr[i][j] == 'O') {
					countO++;
				}
			}
			if (countX == 2 && countO == 0) {
				return i;
			}
		}
		return 10;
	}
	public static int hardModeCheckMainSlant (char[][] arr) {
		
		int countX = 0;
		int countO = 0;
		for (int i = 0, j = 0; i <= 4; i += 2, j += 2) {
			if (arr[j][j] == 'X') {
				countX++;
			}
			if (arr[j][j] == 'O') {
				countO++;
			}
		}
		if (countX == 2 && countO == 0) {
			return 0;
		}
		return 10;
	}
	public static int hardModeCheckOtherSlant (char[][] arr) {
		
		int countX = 0;
		int countO = 0;
		
		for (int i = 4, j = 0; i >= 0; i-=2, j+=2) {
			if (arr[i][j] == 'X') {
				countX++;
			}
			if (arr[i][j] == 'O') {
				countO++;
			}
		}
		if (countX == 2 && countO == 0) {
			return 2;
		}
		
		return 10;
	}
	public static int hardModeCheckColumns (char[][] arr) {
		
		int countX = 0;
		int countO = 0;
		for (int i = 0; i <= 4; i+=2) {
			for (int j = 0; j <= 4; j+=2) {
				if (arr[j][i] == 'X') {
					countX++;
				}
				if (arr[j][i] == 'O') {
					countO++;
				}
			}
			if (countX == 2 & countO == 0) {
				return i;
			}
			countX = 0;
			countO = 0;
		}
		
		return 10;
	}
	public static void onePlayerModeHard(char[][] arr) {
		
		Scanner s = new Scanner(System.in);
		final int MAX_TURNS = 9;
		char player = 'X';

		int i = -1;
		int j = -1;
		for (int k = 0; k < MAX_TURNS; k++) {

			printMat(arr);
			
			if (player == 'X') {
				while (i < 0 || i > 3 || j < 0 || j > 3) {
					System.out.println("Enter Index: (<row> space <column>)");
					i = s.nextInt();
					j = s.nextInt();
					s.nextLine();
				}
				switch (i) {
				case 1: i = 0; break;
				case 2: i = 2; break;
				case 3: i = 4; break;
				}
				switch (j) {
				case 1: j = 0; break;
				case 2: j = 2; break;
				case 3: j = 4; break;
				}
				if (arr[i][j] == 'O' || arr[i][j] == 'X') {
					System.err.println("Index already taken !");
					k--;
					i = -1;
					j = -1;
					continue;
				}
				arr[i][j] = 'X';
				i = 0;
				j = 0;
				player = 'O';
			} else {
				int rowNum = hardModeCheckRows(arr);
				int columnNum = hardModeCheckColumns(arr);
				if (hardModeCheckRows(arr) != 10) {
					for (int v = 0; v < 5; v+=2) {
						if (arr[rowNum][v] == 0) {
							arr[rowNum][v] = 'O';
						}
					}
					System.out.println("PC Turn: ");
					player = 'X';
				} 
				else if (hardModeCheckMainSlant(arr) != 10) {
					for (int n = 0; n <= 4; n+=2) {
						if (arr[n][n] != 'X') {
							arr[n][n] = 'O';
						}
					}
					System.out.println("PC Turn: ");
					player = 'X';
				}
				else if (hardModeCheckOtherSlant(arr) != 10) {
					for (int n = 0, l = 4; n <= 4; n+=2, l-=2) {
						if (arr[n][l] == 0) {
							arr[n][l] = 'O';
						}
					}
					System.out.println("PC Turn: ");
					player = 'X';
				}
				else if (columnNum != 10) {
					for (int n = 4; n >= 0; n-=2) {
						if (arr[n][columnNum] == 0) {
							arr[n][columnNum] = 'O';
						}
					}
					System.out.println("PC Turn: ");
					player = 'X';
				}
				else if (hardModeCheckColumns(arr) != 10) {
					for (int n = 0; n <= 4; n+=2) {
						for (int l = 0; l <= 4; l+=2) {
							if (arr[l][n] == 0) {
								arr[l][n] = 'O';
							}
						}
					}
					System.out.println("PC Turn: ");
					player = 'X';
				}
				else {
					while (arr[i][j] == 'O' || arr[i][j] == 'X') {
						i = (int)(Math.random()*3+1);
						j = (int)(Math.random()*3+1);
						switch (i) {
						case 1: i = 0; break;
						case 2: i = 2; break;
						case 3: i = 4; break;
						}
						switch (j) {
						case 1: j = 0; break;
						case 2: j = 2; break;
						case 3: j = 4; break;
						}
					}
					System.out.println("PC Turn: ");
					arr[i][j] = 'O';
					player = 'X';
				}
				i = -1;
				j = -1;
			}
				

			
			char column = checkColumns(arr);
			char row = checkRows(arr);
			char mainSlant = checkMainSlant(arr);
			char otherSlant = checkOtherSlant(arr);
			
			if (column == 'X' || column == 'O') {
				printMat(arr);
				if (column == 'X') {
					System.out.println("You Won !");
				} else {
					System.out.println("Loser !");
				}
				return;
			}
			if (row == 'X' || row == 'O') {
				printMat(arr);
				if (row == 'X') {
					System.out.println("You Won !");
				} else {
					System.out.println("Loser !");
				}
				return;
			}
			if (mainSlant == 'X' || mainSlant == 'O') {
				printMat(arr);
				if (mainSlant == 'X') {
					System.out.println("You Won !");
				} else {
					System.out.println("Loser !");
				}
				return;
			}
			if (otherSlant == 'X' || otherSlant == 'O') {
				printMat(arr);
				if (otherSlant == 'X') {
					System.out.println("You Won !");
				} else {
					System.out.println("Loser !");
				}
				return;
			}
			if (k == MAX_TURNS-1) {
				System.out.println("Draw.");
				printMat(arr);
				return;
			}
		}

	}
	public static void onePlayerMode(char[][] arr) {
		
		Scanner s = new Scanner(System.in);
		final int MAX_TURNS = 9;
		char player = 'X';

		
		int i = -1;
		int j = -1;
		for (int k = 0; k < MAX_TURNS; k++) {

			printMat(arr);
			
			if (player == 'X') {
				while (i < 0 || i > 3 || j < 0 || j > 3) {
					System.out.println("Enter Index: (<row> space <column>)");
					i = s.nextInt();
					j = s.nextInt();
					s.nextLine();
				}
				switch (i) {
				case 1: i = 0; break;
				case 2: i = 2; break;
				case 3: i = 4; break;
				}
				switch (j) {
				case 1: j = 0; break;
				case 2: j = 2; break;
				case 3: j = 4; break;
				}
				if (arr[i][j] == 'O' || arr[i][j] == 'X') {
					System.err.println("Index already taken !");
					i = -1;
					j = -1;
					k--;
					continue;
				}
				arr[i][j] = 'X';
				player = 'O';
			} else {
				while (arr[i][j] == 'O' || arr[i][j] == 'X') {
					i = (int)(Math.random()*3+1);
					j = (int)(Math.random()*3+1);
					switch (i) {
					case 1: i = 0; break;
					case 2: i = 2; break;
					case 3: i = 4; break;
					}
					switch (j) {
					case 1: j = 0; break;
					case 2: j = 2; break;
					case 3: j = 4; break;
					}
				}
				if (arr[i][j] == 'X') {
					System.err.println("Index already taken !");
					i = -1;
					j = -1;
					k--;
					continue;
				}
				arr[i][j] = 'O';
				player = 'X';
				System.out.println("PC turn: ");
			}
			if (player == 'O') {
				i = 0;
				j = 0;
			} else {
				i = -1;
				j = -1;
			}
			if (k >= 4) {
				char column = checkColumns(arr);
				char row = checkRows(arr);
				char mainSlant = checkMainSlant(arr);
				char otherSlant = checkOtherSlant(arr);
				
				if (column == 'X' || column == 'O') {
					printMat(arr);
					if (column == 'X') {
						System.out.println("You Won !");
					} else {
						System.out.println("Loser !");
					}
					return;
				}
				if (row == 'X' || row == 'O') {
					printMat(arr);
					if (row == 'X') {
						System.out.println("You Won !");
					} else {
						System.out.println("Loser !");
					}
					return;
				}
				if (mainSlant == 'X' || mainSlant == 'O') {
					printMat(arr);
					if (mainSlant == 'X') {
						System.out.println("You Won !");
					} else {
						System.out.println("Loser !");
					}
					return;
				}
				if (otherSlant == 'X' || otherSlant == 'O') {
					printMat(arr);
					if (otherSlant == 'X') {
						System.out.println("You Won !");
					} else {
						System.out.println("Loser !");
					}
					return;
				}
				
				if (k == MAX_TURNS-1) {
					printMat(arr);
					System.out.println("Draw.");
					return;
				}
			}
		}
	}
	public static void twoPlayersMode(char[][] arr) {
		Scanner s = new Scanner(System.in);
		final int MAX_TURNS = 9;
		char player = 0;

		while (player != 'X' && player != 'O') {
			System.out.println("Which player would like to start ? (X/O)");
			player = s.next().charAt(0);

			if (player != 'X' && player != 'O') {
				System.err.println("Invalid Input !");
			}
		}
		int i = -1;
		int j = -1;
		for (int k = 0; k < MAX_TURNS; k++) {

			printMat(arr);
			
			if (player == 'X') {
				while (i < 0 || i > 3 || j < 0 || j > 3) {
					System.out.println("Enter Index: (<row> space <column>)");
					i = s.nextInt();
					j = s.nextInt();
					s.nextLine();
				}
				switch (i) {
				case 1: i = 0; break;
				case 2: i = 2; break;
				case 3: i = 4; break;
				}
				switch (j) {
				case 1: j = 0; break;
				case 2: j = 2; break;
				case 3: j = 4; break;
				}
				if (arr[i][j] == 'O') {
					System.err.println("Index already taken !");
					i = -1;
					j = -1;
					k--;
					continue;
				}
				arr[i][j] = 'X';
				player = 'O';
			} else {
				while (i < 0 || i > 3 || j < 0 || j > 3) {
					System.out.println("Enter Index: (<row> space <column>)");
					i = s.nextInt();
					j = s.nextInt();
					s.nextLine();
				}
				switch (i) {
				case 1: i = 0; break;
				case 2: i = 2; break;
				case 3: i = 4; break;
				}
				switch (j) {
				case 1: j = 0; break;
				case 2: j = 2; break;
				case 3: j = 4; break;
				}
				if (arr[i][j] == 'X') {
					System.err.println("Index already taken !");
					i = -1;
					j = -1;
					k--;
					continue;
				}
				arr[i][j] = 'O';
				player = 'X';
			}
			i = -1;
			j = -1;
			if (k >= 4) {
				char column = checkColumns(arr);
				char row = checkRows(arr);
				char mainSlant = checkMainSlant(arr);
				char otherSlant = checkOtherSlant(arr);
				
				if (column == 'X' || column == 'O') {
					printMat(arr);
					if (column == 'X') {
						System.out.println("Player '"+column+"' Won !");
					}
					return;
				}
				if (row == 'X' || row == 'O') {
					printMat(arr);
					System.out.println("Player '"+row+"' Won !");
					return;
				}
				if (mainSlant == 'X' || mainSlant == 'O') {
					printMat(arr);
					System.out.println("Player '"+mainSlant+"' Won !");
					return;
				}
				if (otherSlant == 'X' || otherSlant == 'O') {
					printMat(arr);
					System.out.println("Player '"+otherSlant+"' Won !");
					return;
				}
				
				if (k == MAX_TURNS-1) {
					printMat(arr);
					System.out.println("Draw.");
					return;
				}
			}
		}	
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		int mode = 0;
		int lvl = 0;
		char[][] board = {  { 0, '|', 0, '|', 0 },
							{ '_', '_', '_', '_', '_' },
							{ 0, '|', 0, '|', 0 },
							{ '_', '_', '_', '_', '_' },
							{ 0, '|', 0, '|', 0 },
							{ '_', '_', '_', '_', '_' } };


		/*char[][] board2 = {   { 'X', '|', 'O', '|', 'X' },
								{ '_', '_', '_', '_', '_' },
								{ 'O', '|', 'X', '|', 'O' },
								{ '_', '_', '_', '_', '_' },
								{ 'O', '|', 'X', '|', 'O' },
								{ '_', '_', '_', '_', '_' } };*/
		
		//onePlayerMode(board);
		
		char check = 'y';
		while (check == 'y' || check != 'n') {
			System.out.println("Do you want to play again?\nYes? y\nNo? n");
			check = s.next().charAt(0);
			if (check == 'y') {
				System.out.println("Which mode would you like to play?\nOne player mode -> 1\nTwo players mode -> 2");
				mode = s.nextInt();
				switch (mode) {
				case 1:
					System.out.println("Pick Level:\nEasy -> 1\nHard -> 2");
					lvl = s.nextInt();
					switch (lvl) {
					case 1:
						resetMat(board);
						onePlayerMode(board);
						break;
					case 2:
						resetMat(board);
						onePlayerModeHard(board);
						break;
					}
					break;
				case 2:
					resetMat(board);
					twoPlayersMode(board);
					break;
				}
			} else if (check == 'n') {
				System.out.println("Good Bye :)");
			}
		}
	}

}
