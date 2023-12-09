import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {




	private SudokuBoard sudokuBoard;
	public ColorImage boardImage; 



	public Sudoku(String file, double dificuldadePercentagem) {
		try {
			carregarJogo(file, (int)dificuldadePercentagem);
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao carregar o jogo");
		}
	}

	private void carregarJogo(String filename, int percentagemDificuldade) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		int[][] initialGame = new int[9][9];


		// Verificações do carregamento do jogo
		if (SudokuAux.SudokuValido(initialGame) == false) {
			System.out.println("Jogo inválido.");
			return;
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				initialGame[i][j] = scanner.nextInt();
			}
		}

		this.board = new SudokuBoard(initialGame, percentagemDificuldade);
		this.boardImagem = SudokuAux.desenharSudoku(this.board);

		scanner.close();
	}


}
