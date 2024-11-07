package minecraft;

import java.util.ArrayList;
import java.util.List;

public class BlockRessource {

    public static List<Block> allBlocks1_8_9() {
        List<Block> allBlocks = new ArrayList<>();

        allBlocks.add(new Block("Block", new BlockHitBox(0, 0, 16, 16), new Facing[]{ Facing.NORTH }, false, "block.png"));
        allBlocks.add(new Block("Dragon Egg", new BlockHitBox(1, 1, 14, 14), new Facing[]{ Facing.NORTH }, false, "dragon_egg.png"));
        allBlocks.add(new Block("Anvil", new BlockHitBox(2, 0, 12, 16), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "anvil.png"));
        allBlocks.add(new Block("Ladder", new BlockHitBox(0, 0, 16, 2), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "ladder.png"));
        allBlocks.add(new Block("Trapdoor", new BlockHitBox(0, 0, 16, 3), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "trapdoor.png"));
        allBlocks.add(new Block("Piston Base", new BlockHitBox(0, 0, 16, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "piston_base.png"));
        allBlocks.add(new Block("Piston Head", new BlockHitBox(0, 0, 16, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "piston_head.png"));
        allBlocks.add(new Block("CobbleWall", new BlockHitBox(4, 4, 8, 8), new Facing[]{ Facing.NORTH }, false, "cobblewall.png"));
        allBlocks.add(new Block("CobbleWall (North)", new BlockHitBox(4, 0, 8, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cobblewall_north.png"));
        allBlocks.add(new Block("CobbleWall (North-East)", new BlockHitBox(4, 0, 12, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cobblewall_north_east.png"));
        allBlocks.add(new Block("Thin CobbleWall", new BlockHitBox(5, 0, 6, 16), new Facing[]{ Facing.NORTH, Facing.WEST}, false, "thin_cobblewall.png"));
        allBlocks.add(new Block("Head", new BlockHitBox(4, 0, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "head.png"));
        allBlocks.add(new Block("Flower Pot", new BlockHitBox(5, 5, 6, 6), new Facing[]{ Facing.NORTH}, false, "flower_pot.png"));
        allBlocks.add(new Block("Fence", new BlockHitBox(6, 6, 4, 4), new Facing[]{ Facing.NORTH }, false, "fence.png"));
        allBlocks.add(new Block("Fence (North)", new BlockHitBox(6, 0, 4, 10), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "fence_north.png"));
        allBlocks.add(new Block("Fence Gate", new BlockHitBox(6, 0, 4, 16), new Facing[]{ Facing.NORTH, Facing.WEST}, false, "fence_gate.png"));
        allBlocks.add(new Block("Pane", new BlockHitBox(7, 0, 2, 16), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "pane.png"));
        allBlocks.add(new Block("Short Pane", new BlockHitBox(7, 0, 2, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "short_pane.png"));
        allBlocks.add(new Block("Brewing Stand", new BlockHitBox(7, 7, 2, 2), new Facing[]{ Facing.NORTH}, true, "brewing_stand.png"));
        allBlocks.add(new Block("Stair", new BlockHitBox(8, 0, 8, 16), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "side_stair.png"));
        allBlocks.add(new Block("Corner Stair", new BlockHitBox(8, 0, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "corner_stair.png"));
        allBlocks.add(new Block("Cocoa Age 1", new BlockHitBox(6, 1, 4, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_0.png"));
        allBlocks.add(new Block("Cocoa Age 2", new BlockHitBox(5, 1, 6, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_1.png"));
        allBlocks.add(new Block("Cocoa Age 3", new BlockHitBox(4, 1, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_2.png"));
        allBlocks.add(new Block("Double Chest", new BlockHitBox(1, 0, 14, 15), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "double_chest.png"));
        allBlocks.add(new Block("Cake 1 Bite", new BlockHitBox(1, 1, 14, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_1.png"));
        allBlocks.add(new Block("Cake 2 Bite", new BlockHitBox(1, 1, 14, 10), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_2.png"));
        allBlocks.add(new Block("Cake 3 Bite", new BlockHitBox(1, 1, 14, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_3.png"));
        allBlocks.add(new Block("Cake 4 Bite", new BlockHitBox(1, 1, 14, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_4.png"));
        allBlocks.add(new Block("Cake 5 Bite", new BlockHitBox(1, 1, 14, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_5.png"));
        allBlocks.add(new Block("Cake 6 Bite", new BlockHitBox(1, 1, 14, 2), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_6.png"));

        return allBlocks;
    }

    public static List<Block> allBlocks1_20_4() {
        List<Block> allBlocks = new ArrayList<>();

        allBlocks.add(new Block("Block", new BlockHitBox(0, 0, 16, 16), new Facing[]{ Facing.NORTH }, false, "block.png"));
        allBlocks.add(new Block("Dragon Egg", new BlockHitBox(1, 1, 14, 14), new Facing[]{ Facing.NORTH }, false, "dragon_egg.png"));
        allBlocks.add(new Block("Stair", new BlockHitBox(8, 0, 8, 16), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "side_stair.png"));
        allBlocks.add(new Block("Corner Stair", new BlockHitBox(8, 0, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "corner_stair.png"));
        allBlocks.add(new Block("Fence", new BlockHitBox(6, 6, 4, 4), new Facing[]{ Facing.NORTH }, false, "fence.png"));
        allBlocks.add(new Block("Fence (North)", new BlockHitBox(6, 0, 4, 10), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "fence_north.png"));
        allBlocks.add(new Block("Fence Gate", new BlockHitBox(6, 0, 4, 16), new Facing[]{ Facing.NORTH, Facing.WEST}, false, "fence_gate.png"));
        allBlocks.add(new Block("Trapdoor", new BlockHitBox(0, 0, 16, 3), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "trapdoor.png"));
        allBlocks.add(new Block("CobbleWall", new BlockHitBox(4, 4, 8, 8), new Facing[]{ Facing.NORTH }, false, "cobblewall.png"));
        allBlocks.add(new Block("Thin CobbleWall", new BlockHitBox(5, 0, 6, 16), new Facing[]{ Facing.NORTH, Facing.WEST}, false, "thin_cobblewall.png"));
        allBlocks.add(new Block("Single Pane", new BlockHitBox(7, 7, 2, 2), new Facing[]{ Facing.NORTH }, false, "single_pane.png"));
        allBlocks.add(new Block("Pane", new BlockHitBox(7, 0, 2, 16), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "pane.png"));
        allBlocks.add(new Block("Short Pane", new BlockHitBox(7, 0, 2, 9), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "short_pane_new.png"));
        allBlocks.add(new Block("2 Candles", new BlockHitBox(6, 5, 3, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "candles_2.png"));
        allBlocks.add(new Block("3 Candles", new BlockHitBox(6, 6, 5, 5), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "candles_3.png"));
        allBlocks.add(new Block("4 Candles", new BlockHitBox(5, 5, 5, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "candles_4.png"));
        allBlocks.add(new Block("Amethyst Cluster (Floor / Ceiling)", new BlockHitBox(3, 3, 10, 10), new Facing[]{ Facing.NORTH }, false, "amethyst_cluster.png"));
        allBlocks.add(new Block("Small Amethyst (Wall)", new BlockHitBox(4, 0, 8, 3), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "small_amethyst_wall.png"));
        allBlocks.add(new Block("Medium Amethyst (Wall)", new BlockHitBox(3, 0, 10, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "medium_amethyst_wall.png"));
        allBlocks.add(new Block("Large Amethyst (Wall)", new BlockHitBox(3, 0, 10, 5), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "large_amethyst_wall.png"));
        allBlocks.add(new Block("Amethyst Cluster (Wall)", new BlockHitBox(3, 0, 10, 7), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "amethyst_cluster_wall.png"));
        allBlocks.add(new Block("Chorus Plant (North)", new BlockHitBox(3, 0, 10, 13), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "chorus_plant_north.png"));
        allBlocks.add(new Block("Chorus Plant (North-South)", new BlockHitBox(3, 0, 10, 16), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "chorus_plant_north_south.png"));
        allBlocks.add(new Block("Turtle Egg", new BlockHitBox(3, 4, 9, 9), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "turtle_egg.png"));
        allBlocks.add(new Block("Sniffer Egg", new BlockHitBox(2, 1, 12, 14), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "sniffer_egg.png"));
        allBlocks.add(new Block("Piston Base", new BlockHitBox(0, 0, 16, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "piston_base.png"));
        allBlocks.add(new Block("Piston Head", new BlockHitBox(0, 0, 16, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "piston_head.png"));
        allBlocks.add(new Block("Cake 1 Bite", new BlockHitBox(1, 1, 14, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_1.png"));
        allBlocks.add(new Block("Cake 2 Bite", new BlockHitBox(1, 1, 14, 10), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_2.png"));
        allBlocks.add(new Block("Cake 3 Bite", new BlockHitBox(1, 1, 14, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_3.png"));
        allBlocks.add(new Block("Cake 4 Bite", new BlockHitBox(1, 1, 14, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_4.png"));
        allBlocks.add(new Block("Cake 5 Bite", new BlockHitBox(1, 1, 14, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_5.png"));
        allBlocks.add(new Block("Cake 6 Bite", new BlockHitBox(1, 1, 14, 2), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cake_bite_6.png"));
        allBlocks.add(new Block("Double Chest", new BlockHitBox(1, 0, 14, 15), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "double_chest.png"));
        allBlocks.add(new Block("Head", new BlockHitBox(4, 0, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "head.png"));
        allBlocks.add(new Block("Flower Pot", new BlockHitBox(5, 5, 6, 6), new Facing[]{ Facing.NORTH}, false, "flower_pot.png"));
        allBlocks.add(new Block("Cocoa Age 1", new BlockHitBox(6, 1, 4, 4), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_0.png"));
        allBlocks.add(new Block("Cocoa Age 2", new BlockHitBox(5, 1, 6, 6), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_1.png"));
        allBlocks.add(new Block("Cocoa Age 3", new BlockHitBox(4, 1, 8, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "cocoa_2.png"));
        allBlocks.add(new Block("Bell (Floor)", new BlockHitBox(4, 0, 8, 16), new Facing[]{ Facing.NORTH, Facing.WEST }, false, "bell.png"));
        allBlocks.add(new Block("Bell (Wall)", new BlockHitBox(7, 0, 2, 13), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "bell_wall.png"));
        allBlocks.add(new Block("Piglin Head (Floor)", new BlockHitBox(3, 3, 10, 10), new Facing[]{ Facing.NORTH }, false, "piglin_head.png"));
        allBlocks.add(new Block("Piglin Head (Wall)", new BlockHitBox(3, 0, 10, 8), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, false, "piglin_head_wall.png"));
        allBlocks.add(new Block("Anvil", new BlockHitBox(3, 0, 12, 14), new Facing[]{ Facing.NORTH, Facing.WEST }, true, "anvil_new.png"));
        allBlocks.add(new Block("4 Pickles", new BlockHitBox(2, 2, 12, 12), new Facing[]{ Facing.NORTH }, false, "pickles_4.png"));
        allBlocks.add(new Block("Grindstone (Floor)", new BlockHitBox(4, 2, 8, 12), new Facing[]{ Facing.NORTH, Facing.WEST }, true, "grindstone.png"));
        allBlocks.add(new Block("Grindstone (Wall)", new BlockHitBox(4, 4, 8, 12), new Facing[]{ Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST }, true, "grindstone_wall.png"));
        allBlocks.add(new Block("Grindstone (Ceiling)", new BlockHitBox(6, 2, 4, 12), new Facing[]{ Facing.NORTH, Facing.WEST }, true, "grindstone_ceiling.png"));

        return allBlocks;
    }

}
