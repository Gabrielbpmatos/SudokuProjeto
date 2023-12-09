import java.util.Random;
import java.util.Arrays;

class SudokuAux {
/*
	int[][] board = {
			{7, 0, 2, 0, 5, 0, 6, 0, 0},
			{0, 0, 0, 0, 0, 3, 0, 0, 0},
			{1, 0, 0, 0, 0, 9, 5, 0, 0},
			{8, 0, 0, 0, 0, 0, 0, 9, 0},
			{0, 4, 3, 0, 0, 0, 7, 5, 0},
			{0, 9, 0, 0, 0, 0, 0, 0, 8},
			{0, 0, 9, 7, 0, 0, 0, 0, 5},
			{0, 0, 0, 2, 0, 0, 0, 0, 0},
			{0, 0, 7, 0, 4, 0, 2, 0, 3} 
	};
	int[][] sudoku1 = {
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

	//PARTE 1
	/*public static void main(String[] args){ 

		int[][] sudoku1 = {
				{5, 3, 4, 6, 7, 8, 9, 1, 2},
				{6, 7, 2, 1, 9, 5, 3, 4, 8},
				{1, 9, 8, 3, 4, 2, 5, 6, 7},
				{8, 5, 9, 7, 6, 1, 4, 2, 3},
				{4, 2, 6, 8, 5, 3, 7, 9, 1},
				{7, 1, 3, 9, 2, 4, 8, 5, 6},
				{9, 6, 1, 5, 3, 7, 2, 8, 4},
				{2, 8, 7, 4, 1, 9, 6, 3, 5},
				{3, 4, 5, 2, 8, 6, 1, 7, 9}
		};
		SudokuValido(sudoku1);
		boolean x = SudokuValido(sudoku1);
		int[][] y = gerarMatriz(sudoku1, 10);	
	} 
	 */
	/* static void testar(){
		ColorImage img = desenharSudoku();
		alterarPosiçao(5, 3, 10, img);
		//pintarLinha(5, img);
		//pintarColuna(5, img);
		pintarSegmento(3, 2, img);
		return;
	}
	*/
	//1.
	static boolean SudokuValido(int[][] matriz) {
		// Inicia um loop que percorre as linhas da matriz.
		for (int i = 0; i < 9; i++) { 
			// Inicia um loop que percorre as colunas da matriz.
			for (int j = 0; j < 9; j++) {
				if (matriz[i][j] != 0) {
					// Inicia um loop que percorre as outras linhas da coluna atual para verificar se há valores duplicados.
					for (int n = 0; n < 9; n++) {
						// Verifica se o valor na posição atual da matriz é igual a outro valor na mesma coluna.
						if (n != i && matriz[n][j] == matriz[i][j]) {
							return false;
						}
						// Verifica se o valor na posição atual da matriz é igual a outro valor na mesma linha.
						if (n != j && matriz[i][n] == matriz[i][j]) {
							return false; // Vai devolver falso se houver valores duplicados
						}
					}
					// Calcula o índice da linha inicial da submatriz atual.
					int linha = i / 3 * 3;
					// Calcula o índice da coluna
					int coluna = j / 3 * 3;
					// Verifica uma matriz 3 por 3
					for (int n = linha; n < linha + 3; n++) {
						for (int l = coluna; l < coluna + 3; l++) {
							if (n != i && l != j && matriz[n][l] == matriz[i][j]) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	//2.

	public static int[][] gerarMatriz(int[][] sudoku1, int percentagem) {
		int[][] matriz = new int[sudoku1.length][sudoku1[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = sudoku1[i][j];
			}
		}
		int zeros = (int)(0.5 + ((matriz.length * matriz[0].length) * (double)(percentagem/100.0)));

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (zeros != 0){
					if (Math.random() <= percentagem/100.0 ){
						matriz[i][j] = 0;
						zeros--;
					}
				}
			}
		}
		return matriz;
	}

	//3.

	public static String MatrizInteiros(int[][] matrix){
		String result = "";

		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				result += matrix[i][j]+ "" ;
			}
			result += "\n";
		}

		return result;
	}



	/*	"/n" passa para a próxima linha / "" dar um espaço
	 */
	
	// no final do iterador string += "\n":
	//4.


	static ColorImage desenharSudoku(int[][] sudoku){
		ColorImage base = new ColorImage("teste.jpg"); 
		Color corPreto = new Color(0,0,0);
		Color corGrelha = new Color(228,235,242);


		//desenhar grelhas(horizontais internas)
		for(int j = 0 ; j != 400 ; j++){
			base.setColor(j,43,corGrelha);
			base.setColor(j,44,corGrelha);
			base.setColor(j,87,corGrelha);
			base.setColor(j,88,corGrelha);
			base.setColor(j,175,corGrelha);
			base.setColor(j,176,corGrelha);
			base.setColor(j,219,corGrelha);
			base.setColor(j,220,corGrelha);
			base.setColor(j,263,corGrelha);
			base.setColor(j,264,corGrelha);
			base.setColor(j,307,corGrelha);
			base.setColor(j,308,corGrelha);
			base.setColor(j,351,corGrelha);
			base.setColor(j,352,corGrelha);
		}
		//desenhar grelhas(verticais internas)
		for(int j = 0 ; j != 400 ; j++){
			base.setColor(43,j,corGrelha);
			base.setColor(44,j,corGrelha);
			base.setColor(87,j,corGrelha);
			base.setColor(88,j,corGrelha);
			base.setColor(175,j,corGrelha);
			base.setColor(176,j,corGrelha);
			base.setColor(219,j,corGrelha);
			base.setColor(220,j,corGrelha);
			base.setColor(263,j,corGrelha);
			base.setColor(264,j,corGrelha);
			base.setColor(307,j,corGrelha);
			base.setColor(308,j,corGrelha);
			base.setColor(351,j,corGrelha);
			base.setColor(352,j,corGrelha);

		}
		//Desenhar linha horizontal de cima e de baixo
		for(int i = 0 ; i != 400 ; i++){
			base.setColor(i,0,corPreto);
			base.setColor(i,1,corPreto);
			base.setColor(i,399,corPreto);
			base.setColor(i,398,corPreto);

		}

		//desenhar vertical linha da esquerda e da direita

		Color preto = new Color(0,0,0);
		for(int j = 0 ; j != 400 ; j++){
			base.setColor(0,j,corPreto);
			base.setColor(1,j,corPreto);
			base.setColor(399,j,corPreto);
			base.setColor(398,j,corPreto);
		}    


		//desenhar grelha vertical
		for(int j = 0 ; j != 400 ; j++){
			base.setColor(133,j,corPreto);
			base.setColor(134,j,corPreto);
			base.setColor(266,j,corPreto);
			base.setColor(267,j,corPreto);        	
		}

		//desenhar grelha horizontal
		for(int j = 0 ; j != 400 ; j++){
			base.setColor(j,133,corPreto);
			base.setColor(j,134,corPreto);
			base.setColor(j,266,corPreto);
			base.setColor(j,267,corPreto);        	
		}
/*
		int[][] sudoku1 = {
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
*/
		int posicaox = 22;
		int posicaoy = 22;
		Color numero = new Color(10, 10, 10);
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[0].length; j++) {
				if(sudoku[i][j] != 0){
					base.drawCenteredText(posicaox, posicaoy, String.valueOf(sudoku[i][j]), 40, numero);

					posicaox = posicaox+44;
				}
			}
			posicaoy = posicaoy+44;
			posicaox = 22;

		}
		return base;
	}




	//5.
	static void alterarPosiçao(int x, int y, int numero, ColorImage img){

		// pintar quadrado em branco
		x = 22 + (x - 1) * 44;
		y = 22 + (y - 1) * 44;

		Color numeroCor = new Color(10, 10, 10);
		Color branco = new Color (255,255,255);

		int a = x - 20;
		int b = y - 20;
		for (int i = a; i < x+20; i++) {
			for (int j = b; j < y+ 20; j++) {	
				img.setColor(i,j, branco);  		
			}
		}

		//Mudar de número
		img.drawCenteredText(x, y, Integer.toString(numero), 40, numeroCor);
	}

	//6.
	static void pintarLinha(int linhaIdx, ColorImage img){

		Color red = new Color(255, 0, 0);

		int start = 44 * (linhaIdx - 1) + 1;

		int end = 44 * linhaIdx;

		for(int i = 0; i < 400; i++)
		{
			// linha acima
			img.setColor(i, start, red);
			img.setColor(i, start+1, red);

			// linha abaixo
			img.setColor(i, end-1, red);
			img.setColor(i, end, red);
		}

		for(int i = start; i < end; i++)
		{
			// linha esquerda
			img.setColor(0, i, red);
			img.setColor(1, i, red);

			// linha direita
			img.setColor(398, i, red);
			img.setColor(399, i, red);
		}
	}

	//7.
	static void pintarColuna(int colunaIdx, ColorImage img){

		Color red = new Color(255, 0, 0);

		int start = 44 * (colunaIdx - 1);

		int end = 44 * colunaIdx;

		for(int i = 0; i < 400; i++)
		{
			// linha esquerda
			img.setColor(start, i, red);
			img.setColor(start+1, i, red);

			// linha direita
			img.setColor(end-1, i, red);
			img.setColor(end, i, red);
		}

		for(int i = start; i < end; i++)
		{
			// linha cima
			img.setColor(i, 0, red);
			img.setColor(i, 1, red);

			// linha abaixo
			img.setColor(i, 398, red);
			img.setColor(i, 399, red);
		}
	}

	//8.
	static void pintarSegmento(int linhaIdx, int colunaIdx, ColorImage img){

		Color red = new Color(255, 0, 0);

		linhaIdx = linhaIdx * 3;
		colunaIdx = colunaIdx * 3;

		int limiteSuperior = 44 * (linhaIdx - 3) + 3;

		int limiteInferior = 44 * linhaIdx + 1;

		int limiteEsquerdo = 44 * (colunaIdx - 3) + 3;

		int limiteDireito = 44 * colunaIdx + 1;

		for(int i = limiteEsquerdo; i < limiteDireito; i++)
		{
			// cima
			img.setColor(i, limiteSuperior, red);
			img.setColor(i, limiteSuperior + 1, red);

			// baixo
			img.setColor(i, limiteInferior - 1, red);
			img.setColor(i, limiteInferior, red);
		}

		for(int i = limiteSuperior; i < limiteInferior; i++)
		{
			// cima
			img.setColor(limiteEsquerdo, i, red);
			img.setColor(limiteEsquerdo + 1, i, red);

			// baixo
			img.setColor(limiteDireito - 1, i, red);
			img.setColor(limiteDireito, i, red);
		}
	}

}

