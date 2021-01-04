package boardgame;

public class Piece {
	
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
	
	
}

