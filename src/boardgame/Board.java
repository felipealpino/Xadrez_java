package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1 ) {
			throw new BoardException ("Error criando tabuleiro: é necessario no minimo 1 linha e ");
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
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) { 
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece (Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peca nessa posicao " +(position));
		}
		
		//vai na matriz e pieces[][] e atribui a peça
		//a matriz está declarada no inicio e instanciada no construtor
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // a posicao da peça é acessivel diretamente pois está como protectec	
	}
	
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		if(piece(position) == null) {
			return null; //nao existe nenhuma peça na posição, somente retorna null
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
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return piece(position)!=null;
	}
	
	
	
	
	
	
}
