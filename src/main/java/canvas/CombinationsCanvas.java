package canvas;

import logic.BlockFinder;
import minecraft.BlockResult;
import minecraft.Constants;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class CombinationsCanvas extends JFrame {
    private int currentIndex = 0;
    private ArrayList<ArrayList<BlockResult>> allCombinations;
    private JLabel combinationLabel;
    private Timer timer;
    private int frameRate = 1000; // 1 second per frame

    public CombinationsCanvas(ArrayList<Collision> collisions) {
        setTitle("Momentum Combinations");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Prepare all combinations
        allCombinations = new ArrayList<>();
        for (int x = 0; x < Constants.BLOCK_WIDTH; x++) {
            for (int y = 0; y < Constants.BLOCK_WIDTH; y++) {
                ArrayList<Collision> updatedCollisions = BlockFinder.findBlocks(new ArrayList<>(collisions), x, y);
                ArrayList<BlockResult> results = BlockFinder.getBlockGrid(updatedCollisions, x, y);
                if (results != null && !results.isEmpty())
                    allCombinations.add(results);
            }
        }

        // Create a label to display the current combination
        combinationLabel = new JLabel();
        combinationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateCombinationLabel();
        add(combinationLabel, BorderLayout.CENTER);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0)
                    currentIndex--;
                else
                    currentIndex = allCombinations.size() - 1;
                updateCombinationLabel();
            }
        });
        buttonPanel.add(prevButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < allCombinations.size() - 1)
                    currentIndex++;
                else
                    currentIndex = 0;
                updateCombinationLabel();
            }
        });
        buttonPanel.add(nextButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer != null) {
                    timer.stop();
                }
                dispose();
            }
        });
        buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize the timer
        timer = new Timer(frameRate, new ActionListener() {
            private int frame = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                updateCombinationLabel(frame);
                frame++;
            }
        });
        timer.start();
    }

    private void updateCombinationLabel() {
        combinationLabel.setText("Combination " + (currentIndex + 1) + " of " + allCombinations.size());
        updateCombinationLabel(0); // Start with the first frame
    }

    private void updateCombinationLabel(int frame) {
        int gridSize = 50;
        int gridDimensions = 8;
        BufferedImage image = new BufferedImage(gridDimensions * gridSize, gridDimensions * gridSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= gridDimensions * gridSize; i += gridSize) {
            g2d.drawLine(i, 0, i, gridDimensions * gridSize);
            g2d.drawLine(0, i, gridDimensions * gridSize, i);
        }

        if (!allCombinations.isEmpty()) {
            AffineTransform backup = g2d.getTransform(); // Save the original transform
            ArrayList<BlockResult> currentCombination = allCombinations.get(currentIndex);
            Map<Point, List<BlockResult>> blocksMap = new HashMap<>();

            for (BlockResult block : currentCombination) {
                int x = block.gridX * gridSize;
                int y = block.gridY * gridSize;
                Point point = new Point(x, y);

                blocksMap.computeIfAbsent(point, k -> new ArrayList<>()).add(block);
            }

            for (Map.Entry<Point, List<BlockResult>> entry : blocksMap.entrySet()) {
                Point point = entry.getKey();
                List<BlockResult> blocks = entry.getValue();

                int index = frame % blocks.size();
                BlockResult block = blocks.get(index);

                int x = point.x;
                int y = point.y;

                AffineTransform transform = new AffineTransform();
                switch (block.facing) {
                    case NORTH -> {
                    }
                    case SOUTH -> transform.rotate(Math.PI, x + gridSize / 2, y + gridSize / 2);
                    case WEST -> transform.rotate(Math.PI + Math.PI / 2, x + gridSize / 2, y + gridSize / 2);
                    case EAST -> transform.rotate(Math.PI / 2, x + gridSize / 2, y + gridSize / 2);
                }
                g2d.setTransform(transform);
                g2d.drawImage(block.block.getImage(), x, y, gridSize, gridSize, null);
                g2d.setTransform(backup);
            }
        }

        g2d.dispose();

        combinationLabel.setIcon(new ImageIcon(image));
    }
}