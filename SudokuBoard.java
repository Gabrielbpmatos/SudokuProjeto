class SudokuBoard {


	private int[][] board;
	private int[][] initialGame;
	ColorImage boardImagem ;



	// 1.
	public SudokuBoard(int[][] initialBoard, int dificuldade) {
		if (SudokuAux.SudokuValido(initialBoard) == false) {
			throw new IllegalArgumentException("Matriz de Sudoku inválida");
		}
		this.board = SudokuAux.gerarMatriz(initialBoard, dificuldade);

		if (dificuldade < 0 || dificuldade > 100) {
			throw new IllegalArgumentException("A dificuldade deve estar entre 1 e 100");
		}

		 boardImagem = SudokuAux.desenharSudoku(this.board);
	}
	// 2.	
	public int getNumberAtCoordinate(int linha, int coluna) {
		if (linha < 0 || linha >= board.length || coluna < 0 || coluna >= board[0].length) {
			throw new IllegalArgumentException("Coordenadas inválidas");
		}
		return board[linha-1][coluna-1];   
	}
	// 3.
	public void Jogada(int x, int y, int numero, ColorImage img){
		if(board[x][y] != 0){
			throw new IllegalArgumentException("Posição Inválida");
		}
		int [][] tempboard = board;
		tempboard[x][y] = numero;
		if(SudokuAux.SudokuValido(board) == false){
			throw new IllegalArgumentException("Posição Inválida");
		}
		SudokuAux.alterarPosiçao(x, y, numero, boardImagem);
	}

	//4.
	public void jogadaRandom() {
	    int posicaoRandom = 1;

	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (board[i][j] == 0) {
	                if (posicaoRandom != 0) {
	                    if (Math.random() <= 0.3) {
	                        int numeroRandom = (int) (Math.random() * 9) + 1;
	                        board[i][j] = numeroRandom;
	                        posicaoRandom--;
	                        if (SudokuAux.SudokuValido(board)) {
	                            SudokuAux.alterarPosiçao(i, j, numeroRandom, boardImagem);
	                        } else {
	                            // Se a jogada não for válida, vai desfazer o que foi mudado.
	                            board[i][j] = 0;
	                        }
	                    }
	                }
	            }
	        }
	    }
	}
	
	 // Reiniciar o tabuleiro para a configuração inicial
    public void reiniciarTabuleiro() {
        for (int i = 0; i < initialGame.length; i++) {
            for (int j = 0; j < initialGame[0].length; j++) {
                board[i][j] = initialGame[i][j];
            }
        }
        // Atualiza a imagem do tabuleiro
        boardImagem = SudokuAux.desenharSudoku(board);
    }



	public static void testJogadaRandom() {
		int[][] initialBoard = {
				{5, 3, 4, 6, 7, 8, 9, 1, 2},
				{6, 7, 2, 1, 9, 5, 3, 4, 8},
				{1, 9, 8, 3, 4, 2, 5, 6, 7},
				{8, 5, 9, 7, 6, 1, 4, 2, 3},
				{4, 2, 6, 8, 5, 3, 7, 9, 1},
				{7, 1, 3, 9, 2, 4, 8, 5, 6},
				{9, 6, 1, 5, 3, 7, 2, 8, 4},
				{2, 8, 7, 4, 1, 9, 6, 3, 5},
				{3, 4, 5, 2, 8, 6, 1, 7, 9},

		};


		SudokuBoard sudokuBoard = new SudokuBoard(initialBoard, 5);
		
		System.out.println(sudokuBoard.getNumberAtCoordinate(1, 1));
		/*print(sudokuBoard);
		sudokuBoard.jogadaRandom();

		System.out.println("\nBoard after jogadaRandom:");
		printBoard(sudokuBoard);
	}
		 */
	}
}


