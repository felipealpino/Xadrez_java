package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece [rows][columns];
	}


	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	
	public Piece piece (int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) { 
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece (Piece piece, Position position) {
		//vai na matriz e pieces[][] e atribui a pe�a
		//a matriz est� declarada no inicio e instanciada no construtor
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // a posicao da pe�a � acessivel diretamente pois est� como protectec
		
	}
	
	
	
}
