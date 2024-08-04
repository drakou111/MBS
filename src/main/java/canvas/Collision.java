package canvas;


public class Collision {
    public int x;
    public int y;
    public int width;
    public int height;
    public int upExtended;
    public int downExtended;
    public int rightExtended;
    public int leftExtended;
    public boolean topLimited;

    public Collision(int x, int y, int width, int height, boolean topLimited) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.topLimited = topLimited;
        this.upExtended = 0;
        this.downExtended = 0;
        this.rightExtended = 0;
        this.leftExtended = 0;
    }

    public Collision(int x, int y, int width, int height, int upExtended, int downExtended, int rightExtended, int leftExtended, boolean topLimited) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.topLimited = topLimited;
        this.upExtended = upExtended;
        this.downExtended = downExtended;
        this.rightExtended = rightExtended;
        this.leftExtended = leftExtended;
    }

    @Override
    public String toString() {
        return "Collision: {x: " + this.x + ", y: " + this.y + ", width: " + this.width + ", height: " + this.height + ", up: " + upExtended + ", down: " + downExtended + ", right: " + rightExtended + ", left: " + leftExtended + "}";
    }
}
