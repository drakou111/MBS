package logic;

import canvas.Collision;
import canvas.CombinationsCanvas;
import minecraft.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BlockFinder {

    public static void showAllCombinations(ArrayList<Collision> collisions) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CombinationsCanvas window = new CombinationsCanvas(collisions);
                window.setVisible(true);
            }
        });
    }

    public static ArrayList<BlockResult> getBlockGrid(ArrayList<Collision> collisions, int offsetX, int offsetY) {
        List<Block> allBlocks = BlockRessource.allBlocks();
        ArrayList<BlockResult> results = new ArrayList<>();

        for (Collision collision : collisions) {
            int possibleBlockCount = 0;
            int newPosX = collision.x - offsetX + Constants.BLOCK_WIDTH;
            int newPosY = collision.y - offsetY + Constants.BLOCK_WIDTH;
            int gridX = newPosX / Constants.BLOCK_WIDTH;
            int gridY = newPosY / Constants.BLOCK_WIDTH;
            newPosX = newPosX % Constants.BLOCK_WIDTH;
            newPosY = newPosY % Constants.BLOCK_WIDTH;

            List<BlockResult> possibleBlocks = new ArrayList<>();
            List<BlockResult> toRemove = new ArrayList<>();
            for (BlockResult result : results) {
                if (result.gridX == gridX && result.gridY == gridY) {
                    possibleBlocks.add(result);
                    toRemove.add(result);
                }
            }

            results.removeAll(toRemove);

            if (possibleBlocks.isEmpty()) {
                for (Block block : allBlocks) {
                    for (Facing facing : block.availableFacings) {
                        possibleBlocks.add(new BlockResult(block, 0, 0, facing));
                    }
                }
            }


            for (BlockResult blockResult : possibleBlocks) {

                if (!collision.topLimited && blockResult.block.topLimited)
                    continue;

                Facing facing = blockResult.facing;
                BlockHitBox hitBox = blockResult.block.getHitBoxesWithFacing(facing);

                //left
                if (!(hitBox.x <= newPosX && hitBox.x >= newPosX - collision.leftExtended))
                    continue;
                //up
                if (!(hitBox.y <= newPosY && hitBox.y >= newPosY - collision.upExtended))
                    continue;
                //right
                if (!(hitBox.x + hitBox.width >= newPosX + collision.width && hitBox.x + hitBox.width <= newPosX + collision.width + collision.rightExtended))
                    continue;
                //down
                if (!(hitBox.y + hitBox.height >= newPosY + collision.height && hitBox.y + hitBox.height <= newPosY + collision.height + collision.downExtended))
                    continue;

                possibleBlockCount++;
                results.add(new BlockResult(blockResult.block, gridX, gridY, facing));
            }

            if (possibleBlockCount <= 0) {
                return null; // Un-buildable
            }
        }

        return results;
    }

    public static ArrayList<Collision> findBlocks(ArrayList<Collision> collisions, int offsetX, int offsetY) {
        ArrayList<Collision> newCollisions = new ArrayList<>();

        for (Collision collision : collisions) {
            ArrayList<Collision> horizontalCuts = cutHorizontally(collision, offsetY);
            for (Collision hCut : horizontalCuts) {
                ArrayList<Collision> verticalCuts = cutVertically(hCut, offsetX);
                newCollisions.addAll(verticalCuts);
            }
        }

        return newCollisions;
    }

    private static ArrayList<Collision> cutHorizontally(Collision collision, int offset) {
        ArrayList<Collision> result = new ArrayList<>();

        int top = collision.y;
        int bottom = collision.y + collision.height;

        int cutLine = (top / Constants.BLOCK_WIDTH) * Constants.BLOCK_WIDTH + offset;
        if (cutLine <= top)
            cutLine += Constants.BLOCK_WIDTH;

        Collision bottomCollision = null;
        int count = 0;

        while (cutLine < bottom) {
            Collision topCollision = new Collision(collision.x, top, collision.width, cutLine - top, collision.topLimited);
            topCollision.upExtended = count == 0 ? collision.upExtended : 0;
            topCollision.downExtended = 0;
            topCollision.leftExtended = collision.leftExtended;
            topCollision.rightExtended = collision.rightExtended;

            bottomCollision = new Collision(collision.x, cutLine, collision.width, bottom - cutLine, collision.topLimited);

            result.add(topCollision);

            top = cutLine;
            cutLine += Constants.BLOCK_WIDTH;
            count++;
        }

        if (bottomCollision != null) {
            bottomCollision.upExtended = 0;
            bottomCollision.downExtended = collision.downExtended;
            bottomCollision.leftExtended = collision.leftExtended;
            bottomCollision.rightExtended = collision.rightExtended;
            result.add(bottomCollision);
        }

        if (result.isEmpty())
            result.add(collision);

        return result;
    }

    private static ArrayList<Collision> cutVertically(Collision collision, int offset) {
        ArrayList<Collision> result = new ArrayList<>();

        int left = collision.x;
        int right = collision.x + collision.width;

        int cutLine = (left / Constants.BLOCK_WIDTH) * Constants.BLOCK_WIDTH + offset;
        if (cutLine <= left)
            cutLine += Constants.BLOCK_WIDTH;

        Collision rightCollision = null;
        int count = 0;

        while (cutLine < right) {
            Collision leftCollision = new Collision(left, collision.y, cutLine - left, collision.height, collision.topLimited);
            leftCollision.upExtended = collision.upExtended;
            leftCollision.downExtended = collision.downExtended;
            leftCollision.leftExtended = count == 0 ? collision.leftExtended : 0;
            leftCollision.rightExtended = 0;

            rightCollision = new Collision(cutLine, collision.y, right - cutLine, collision.height, collision.topLimited);

            result.add(leftCollision);

            left = cutLine;
            cutLine += Constants.BLOCK_WIDTH;
            count++;
        }

        if (rightCollision != null) {
            rightCollision.upExtended = collision.upExtended;
            rightCollision.downExtended = collision.downExtended;
            rightCollision.leftExtended = 0;
            rightCollision.rightExtended = collision.rightExtended;
            result.add(rightCollision);
        }

        if (result.isEmpty())
            result.add(collision);

        return result;
    }
}