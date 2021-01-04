package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1 ) {
			throw new BoardException ("Error criando tabuleiro: � necess�rio no m�nimo 1 linha e ");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece [rows][columns];
	}


	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}
	
	
	public Piece piece (int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posi��o nao existe no tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) { 
		if(!positionExists(position)) {
			throw new BoardException("Posi��o nao existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece (Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("J� existe uma pe�a nessa posi��o " +(position));
		}
		
		//vai na matriz e pieces[][] e atribui a pe�a
		//a matriz est� declarada no inicio e instanciada no construtor
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // a posicao da pe�a � acessivel diretamente pois est� como protectec	
	}
	
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o nao existe no tabuleiro");
		}
		if(piece(position) == null) {
			return null; //nao existe nenhuma pe�a na posi��o, somente retorna null
		} 
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null; 
		return aux;
	}
	
	
	private boolean positionExists(int row, int column) {
		return row>=0 && row < this.rows && column >=0 && column < this.columns;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o nao existe no tabuleiro");
		}
		return piece(position)!=null;
	}
	
	
	
	
	
	
}
