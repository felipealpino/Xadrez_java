package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	private int turn;
	private Color currentPlayer;

	public ChessMatch(Board board) {
		this.board = new Board(8, 8);
		this.turn = 1;
		this.currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public Color getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	
	
	
	public ChessPiece [][] getPieces() { //retorna uma matriz de pe�as de xadrex correspondentes a essa partida
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		// convertendo as duas posi��es para posi��es da matriz
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		// validando posi��o de origem
		validateSourcePosition(source);
		
		//validando posi��o de destino
		validateTargetPosition(source,target);
		
		Piece capturedPiece = makeMove(source, target);
		
		nextTurn();
		return (ChessPiece) capturedPiece;
	}
	
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("Nao existe pe�a na posicao de origem");
		}
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			//caso o jogador tente mover uma pe�a advers�ria
			throw new ChessException("A peca escolhida nao pertence a voce");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existem movimentos possiveis para a peca escolhida");
		}
		
	}
	
	
	private void validateTargetPosition(Position source, Position target) {
		// se para pe�a de origem a posi��o de destino nao � um movimento possivel, significa que nao pode-se mexer para la, ou seja, ChessException
		if (!board.piece(source).possibleMoves(target)) {
			throw new ChessException("A peca escolhida nao pode se mover para a posicao de destino");
		}
	}
	
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		//inicia a partida de xadrez colocando as pe�as no tabuleiro
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	
}
