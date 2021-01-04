package boardgame;

public class Piece {
	
	protected Position position;
	
	private Board board;

	public Piece(Board board) {
		this.board = board;
		this.position = null; // A pe�a nao foi adicionada ao tabuleiro ainda
	}

	protected Board getBoard() { //alterado para protected porque somente classes do mesmo pagote e subclasses podem acessar o tabuleiro de uma pe�a
		return board;
	}
	//setBoard apagado pois nao � permitido que o tabuleiro seja alterado
	
	
}

