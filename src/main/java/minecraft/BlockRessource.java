package minecraft;

import java.util.ArrayList;
import java.util.List;

public class BlockRessource {
    public static List<Block> allBlocks() {
        List<Block> allBlocks = new ArrayList<>();

        allBlocks.add(new Block("Block", "b", new BlockHitBox(0, 0, 16, 16), new Facing[]{ Facing.NORTH }, false, "block.png"));
        allBlocks.add(new Block("Dragon Egg", "e", new BlockHitBox(1, 1, 14, 14), new Facing[]{ Facing.NORTH }, false, "dragon_egg.png"));
        allBlocks.add(new Block("Anvil", "a", new BlockHitBox(2, 0, 12, 16), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "anvil.png"));
        allBlocks.add(new Block("Ladder", "ld", new BlockHitBox(0, 0, 16, 2), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "ladder.png"));
        allBlocks.add(new Block("Trapdoor", "td", new BlockHitBox(0, 0, 16, 3), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "trapdoor.png"));
        allBlocks.add(new Block("Piston Base", "pb", new BlockHitBox(0, 0, 16, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "piston_base.png"));
        allBlocks.add(new Block("Piston Head", "ph", new BlockHitBox(0, 0, 16, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "piston_head.png"));
        allBlocks.add(new Block("CobbleWall", "cw", new BlockHitBox(4, 4, 8, 8), new Facing[]{ Facing.NORTH }, false, "cobblewall.png"));
        allBlocks.add(new Block("CobbleWall (North)", "cw(n)", new BlockHitBox(4, 0, 8, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cobblewall_north.png"));
        allBlocks.add(new Block("CobbleWall (North-East)", "cw(ne)", new BlockHitBox(4, 0, 12, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cobblewall_north_east.png"));
        allBlocks.add(new Block("Thin CobbleWall", "tcw", new BlockHitBox(5, 0, 6, 16), new Facing[]{ Facing.NORTH, Facing.WEST}, false, "thin_cobblewall.png"));
        allBlocks.add(new Block("Head", "h", new BlockHitBox(4, 0, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "head.png"));
        allBlocks.add(new Block("Flower Pot", "pot", new BlockHitBox(5, 5, 6, 6), new Facing[]{ Facing.NORTH}, false, "flower_pot.png"));
        allBlocks.add(new Block("Fence", "f", new BlockHitBox(6, 6, 4, 4), new Facing[]{ Facing.NORTH }, false, "fence.png"));
        allBlocks.add(new Block("Fence (North)", "f(n)", new BlockHitBox(6, 0, 4, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "fence_north.png"));
        allBlocks.add(new Block("Fence Gate", "fg", new BlockHitBox(6, 0, 4, 16), new Facing[]{ Facing.NORTH, Facing.WEST}, false, "fence_gate.png"));
        allBlocks.add(new Block("Pane", "p", new BlockHitBox(7, 0, 2, 16), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "pane.png"));
        allBlocks.add(new Block("Short Pane", "sp", new BlockHitBox(7, 0, 2, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "short_pane.png"));
        allBlocks.add(new Block("Brewing Stand", "bs", new BlockHitBox(7, 7, 2, 2), new Facing[]{ Facing.NORTH}, false, "brewing_stand.png"));
        allBlocks.add(new Block("Stair", "st", new BlockHitBox(8, 0, 8, 16), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "side_stair.png"));
        allBlocks.add(new Block("Corner Stair", "cst", new BlockHitBox(8, 0, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "corner_stair.png"));
        allBlocks.add(new Block("Cocoa Age 1", "cb0", new BlockHitBox(6, 1, 4, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_0.png"));
        allBlocks.add(new Block("Cocoa Age 2", "cb1", new BlockHitBox(5, 1, 6, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_1.png"));
        allBlocks.add(new Block("Cocoa Age 3", "cb2", new BlockHitBox(4, 1, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_2.png"));
        allBlocks.add(new Block("Double Chest", "dc", new BlockHitBox(1, 0, 14, 15), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "double_chest.png"));
        allBlocks.add(new Block("Cake 1 Bite", "ck1b", new BlockHitBox(1, 1, 14, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_1.png"));
        allBlocks.add(new Block("Cake 2 Bite", "ck2b", new BlockHitBox(1, 1, 14, 10), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_2.png"));
        allBlocks.add(new Block("Cake 3 Bite", "ck3b", new BlockHitBox(1, 1, 14, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_3.png"));
        allBlocks.add(new Block("Cake 4 Bite", "ck4b", new BlockHitBox(1, 1, 14, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_4.png"));
        allBlocks.add(new Block("Cake 5 Bite", "ck5b", new BlockHitBox(1, 1, 14, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_5.png"));
        allBlocks.add(new Block("Cake 6 Bite", "ck6b", new BlockHitBox(1, 1, 14, 2), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_6.png"));


        return allBlocks;
    }


}
