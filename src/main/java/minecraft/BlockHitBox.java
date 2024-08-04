package minecraft;

public class BlockHitBox {
    public int x;
    public int y;
    public int width;
    public int height;

    public BlockHitBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int[] getTopLeft() {
        return new int[]{ this.x, this.y};
    }

    public int[] getTopRight() {
        return new int[]{ this.x + this.width - 1, this.y};
    }

    public int[] getBottomLeft() {
        return new int[]{ this.x, this.y + this.height - 1};
    }

    public int[] getBottomRight() {
        return new int[]{ this.x + this.width - 1, this.y + this.height - 1};
    }

    public BlockHitBox getRotated(Facing facing) {
        switch (facing) {
            case NORTH -> { return new BlockHitBox(this.x, this.y, this.width, this.height); }
            case SOUTH -> { return new BlockHitBox(Constants.BLOCK_WIDTH - this.x - this.width, Constants.BLOCK_WIDTH - this.y - this.height, this.width, this.height); }
            case EAST -> { return new BlockHitBox(Constants.BLOCK_WIDTH - this.y - this.height, this.x, this.height, this.width ); }
            case WEST -> { return new BlockHitBox(this.y, Constants.BLOCK_WIDTH - this.x - this.width, this.height, this.width ); }
        }
        return null;
    }
}
