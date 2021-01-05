package boardgame;

public abstract class Piece {
	
	protected Position position;
	
	private Board board;

	public Piece(Board board) {
		this.board = board;
		this.position = null; // A peça nao foi adicionada ao tabuleiro ainda
	}

	protected Board getBoard() { //alterado para protected porque somente classes do mesmo pagote e subclasses podem acessar o tabuleiro de uma peça
		return board;
	}
	//setBoard apagado pois nao é permitido que o tabuleiro seja alterado
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		/* Chama o metodo abstrato possibleMovies que irá retornar uma matriz de booleano
		 * iremos varrer a matriz para verificar se existe pelo menos uma posição que seja true
		 */
		boolean[][] mat = possibleMoves();
		for (int i = 0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				} 
			}
		}
		return false;
	}

	
	
	
	
}

