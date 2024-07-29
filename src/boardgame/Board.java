package boardgame;

public class Board {
	
	private int rows;
	private int colums;
	private Piece[][] pieces;
	
	public Board(int rows, int colums) {
		if (rows < 1 || colums < 1) {
			throw new BoardException("Eroor creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.colums = colums;
		pieces = new Piece[rows][colums];
	}

	public int getRows() {
		return rows;
	}

	public int getColums() {
		return colums;
	}
	
	public Piece piece(int row, int colum) {
		if (!positionExists(row, colum)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][colum];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColum()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColum()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int colum) {
		return row >= 0 && row < rows && colum >= 0 && colum < colums;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColum());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
}