package minecraft;

public class BlockHitBox {
    // x and y is the top left corner of the block
    public int x;
    public int y;

    // width and height is the width and height of the block
    public int width;
    public int height;

    public BlockHitBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Rotates the block to a certain direction (NORTH is default)
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
