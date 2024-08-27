package minecraft;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Block {
    public String name;
    public BlockHitBox hitBox;
    public Facing[] availableFacings;
    public boolean topLimited;
    public String imagePath;

    public Block(String name, BlockHitBox hitBox, boolean topLimited, String imagePath) {
        this.name = name;
        this.hitBox = hitBox;
        this.availableFacings = new Facing[] {Facing.NORTH, Facing.SOUTH, Facing.WEST, Facing.EAST };
        this.topLimited = topLimited;
        this.imagePath = imagePath;
    }

    public Block(String name, BlockHitBox hitBox, Facing[] availableFacings, boolean isOnlyTop, String imagePath) {
        this.name = name;
        this.hitBox = hitBox;
        this.availableFacings = availableFacings;
        this.topLimited = isOnlyTop;
        this.imagePath = imagePath;
    }

    public List<BlockHitBox> getAllHitBoxesFacings() {
        List<BlockHitBox> allRotations = new ArrayList<>();
        for (Facing availableFacing : this.availableFacings) {
            allRotations.add(getHitBoxesWithFacing(availableFacing));
        }
        return allRotations;
    }

    public BlockHitBox getHitBoxesWithFacing(Facing facing) {
        return this.hitBox.getRotated(facing);
    }

    public Image getImage() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(imagePath)) {
            if (is == null) {
                throw new IllegalArgumentException("Image not found: " + imagePath);
            }
            return new ImageIcon(is.readAllBytes()).getImage();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "{name: " + name + ", topLimited: " + topLimited + "}";
    }
}
