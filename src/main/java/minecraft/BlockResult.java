package minecraft;

public class BlockResult {
    public Block block;
    public int gridX;
    public int gridY;
    public Facing facing;

    public BlockResult(Block block, int gridX, int gridY, Facing facing) {
        this.block = block;
        this.gridX = gridX;
        this.gridY = gridY;
        this.facing = facing;
    }

    @Override
    public String toString() {
        return "{block: " + block + ", gridX: " + gridX + ", gridY: " + gridY + ", facing: " + facing + "}";
    }
}
