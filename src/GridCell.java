import java.awt.*;

public class GridCell {
	public static enum Type{
		HEAD, BODY, APPLE, NONE
	}
	
	private static final int CELL_LENGTH = 20;
	private static final int CELL_HEIGHT = 20;
	private int posX;
	private int posY;
	private Type cellType;
	private Color cellColor;
	private BodyDir direction;
	
	public GridCell(int i, int j) {
		cellType = Type.NONE;
		cellColor = Color.black;
		posX = i;
		posY = j;
		direction = BodyDir.NONE;
	}
	
	public void setHead() {
		cellType = Type.HEAD;
	}
	
	public boolean isHead() {
		return (cellType == Type.HEAD);
	}
	public void setApple() {
		cellType = Type.APPLE;
	}
	public boolean isApple() {
		return (cellType == Type.APPLE);
	}
	public void removeHead() {
		cellType = Type.BODY;
	}
	public void setBody() {
		cellType = Type.BODY;
	}
	public void setBodyDirection(BodyDir d) {
		direction = d;
	}
	public BodyDir getBodyDirection() {
		return direction;
	}
	public boolean isBody() {
		return (cellType == Type.BODY);
	}
	public void removeBody() {
		cellType = Type.NONE;
	}
	public boolean isSnake() {
		if((cellType == Type.HEAD) || (cellType == Type.BODY)) return true;
		return false;
	}
	public void getColor() {
		System.out.println("Color: " + cellColor);
	}
	
	public void draw(Graphics g) {
		switch(this.cellType) {
		default:
			g.setColor(Color.black);
			cellColor = Color.black;
			//System.out.println("DEFAULT");
		case NONE:
			g.setColor(Color.black);
			cellColor = Color.black;
			//System.out.println("NONE");
			break;
		case HEAD:
			g.setColor(Color.white);
			cellColor = Color.white;
			//System.out.println("HEAD");
			break;
		case BODY:
			g.setColor(Color.white);
			cellColor = Color.white;
			//System.out.println("BODY");
			break;
		case APPLE:
			g.setColor(Color.red);
			cellColor = Color.red;
			//System.out.println("APPLE");
			break;
		}
		//getColor();
		g.fillRect(posX, posY, CELL_LENGTH, CELL_HEIGHT);
	}
	
}
