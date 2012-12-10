package minecraft2d;

import static minecraft2d.World.*;

public class Block {
	
	private BlockType type = BlockType.AIR;
	private float x, y;	
	
	public Block(BlockType type, float x, float y) {
		super();
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		
	}

	public BlockType getType() {
		return type;
	}

	public void setType(BlockType type) {
		this.type = type;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}	
}
