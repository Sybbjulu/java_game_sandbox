package minecraft2d;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Boot {
	
	// window attributes
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final String TITLE = "MINECRAFT-2D";
	
	// timing 
	private static final int FPS = 60;
	private long lastFrame;
		
	private boolean isRunning = true;
	
	// block sandbox
	BlockGrid grid = null;
	
	public static void main(String[] args) {
		Boot boot = new Boot();
		boot.run();
	}
	
	public Boot() {
		initDisplay();
		initOpenGL();
		initEntities();
		initTimer();		
	}
	
	private void run() {
		while (isRunning) {
			render();
			logic(getDelta());
			input();
			Display.update();
			Display.sync(FPS);
			
			if (Display.isCloseRequested()) { isRunning = false; }
		}
		
		Display.destroy();		
	}
	
	private void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}
	
	private void initEntities() {		
		grid = new BlockGrid();		
	}
		
	private void initTimer() {
		lastFrame = getTime();
	}
		
	private void render() {		
		grid.draw();
	}
		
	private void logic(int delta) {		
			
	}
	
	private void input() {		
		
		int mousex = Mouse.getX();
		int mousey = HEIGHT - Mouse.getY() - 1;
		boolean mouseClicked = Mouse.isButtonDown(0);
		
		// get block clicked on
		if (mouseClicked) {
			int grid_x = Math.round(mousex / World.BLOCK_SIZE);
			int grid_y = Math.round(mousey / World.BLOCK_SIZE);
			
			// debug
			System.out.println("[LEFT_CLICK] " + grid_x + ", " + grid_y);
			grid.setAt(grid_x, grid_y, BlockType.STONE);
		}
		
	}
	
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	private int getDelta() {
		long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
	}
	
	private void initOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}	

}
