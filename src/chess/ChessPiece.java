package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece{

	private Color color;
	
	public ChessPiece(Board board) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	// a cor de uma pe�a nao pode ser modificada -- set apagado
	
	
}
