package canvas;

import logic.BlockFinder;
import minecraft.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CollisionCanvas extends JFrame {
    private ArrayList<Collision> collisions;
    private final int GRID_SIZE = 12;

    public CollisionCanvas() {
        setTitle("Collision Canvas");
        setSize(GRID_SIZE * 64, GRID_SIZE * 64);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        collisions = new ArrayList<>();
        DrawPanel drawPanel = new DrawPanel();

        add(drawPanel);

        // Add key listener to the draw panel
        drawPanel.setFocusable(true);
        drawPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    BlockFinder.showAllCombinations(collisions);
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    drawPanel.cancelCurrentRectangle();
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && !collisions.isEmpty()) {
                    collisions.remove(collisions.size() - 1);
                    repaint();
                }
            }
        });
    }

    private class DrawPanel extends JPanel {
        private Point startPoint;
        private Collision currentCollision;
        private boolean currenTopLimited;

        public DrawPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startPoint = snapToGrid(e.getPoint());
                    startPoint.x /= GRID_SIZE;
                    startPoint.y /= GRID_SIZE;

                    if (e.getButton() == MouseEvent.BUTTON1) {
                        currenTopLimited = false; // Left click
                    } else if (e.getButton() == MouseEvent.BUTTON3) {
                        currenTopLimited = true; // Right click
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (currentCollision != null) {
                        if (currentCollision.width == 0 || currentCollision.height == 0) return;

                        collisions.add(currentCollision);
                        currentCollision = null;
                        repaint();
                    }
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Point endPoint = snapToGrid(e.getPoint());
                    endPoint.x /= GRID_SIZE;
                    endPoint.y /= GRID_SIZE;

                    int x = Math.min(startPoint.x, endPoint.x);
                    int y = Math.min(startPoint.y, endPoint.y);
                    int width = Math.abs(startPoint.x - endPoint.x);
                    int height = Math.abs(startPoint.y - endPoint.y);
                    currentCollision = new Collision(x, y, width + 1, height + 1, currenTopLimited);
                    repaint();
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point point = e.getPoint();
                    float pointX = (float) point.x / GRID_SIZE;
                    float pointY = (float) point.y / GRID_SIZE;

                    for (Collision collision : collisions) {
                        int widthPixels = collision.width;
                        int heightPixels = collision.height;

                        float tolerance = 1f; // Adjust this value as needed
                        if (pointX >= (float)collision.x && pointX < (float)collision.x + widthPixels &&
                                pointY >= (float)collision.y && pointY < (float)collision.y + heightPixels) {

                            // Calculate distances to each side
                            float distLeft = Math.abs(pointX - (float) collision.x);
                            float distRight = Math.abs(pointX - (float) (collision.x + widthPixels));
                            float distUp = Math.abs(pointY - (float) collision.y);
                            float distDown = Math.abs(pointY - (float) (collision.y + heightPixels));

                            // Determine the closest side
                            float minDist = Math.min(Math.min(distLeft, distRight), Math.min(distUp, distDown));

                            //TODO: right click would do --

                            if (minDist <= tolerance) {
                                if (e.getButton() == MouseEvent.BUTTON1) { // Left click
                                    if (minDist == distLeft) {
                                        collision.leftExtended++;
                                        if (collision.leftExtended >= 16)
                                            collision.leftExtended = 0;
                                    } else if (minDist == distRight) {
                                        collision.rightExtended++;
                                        if (collision.rightExtended >= 16)
                                            collision.rightExtended = 0;
                                    } else if (minDist == distUp) {
                                        collision.upExtended++;
                                        if (collision.upExtended >= 16)
                                            collision.upExtended = 0;
                                    } else if (minDist == distDown) {
                                        collision.downExtended++;
                                        if (collision.downExtended >= 16)
                                            collision.downExtended = 0;
                                    }
                                } else if (e.getButton() == MouseEvent.BUTTON3) { // Right click
                                    if (minDist == distLeft) {
                                        collision.leftExtended--;
                                        if (collision.leftExtended < 0)
                                            collision.leftExtended = 15;
                                    } else if (minDist == distRight) {
                                        collision.rightExtended--;
                                        if (collision.rightExtended < 0)
                                            collision.rightExtended = 15;
                                    } else if (minDist == distUp) {
                                        collision.upExtended--;
                                        if (collision.upExtended < 0)
                                            collision.upExtended = 15;
                                    } else if (minDist == distDown) {
                                        collision.downExtended--;
                                        if (collision.downExtended < 0)
                                            collision.downExtended = 15;
                                    }
                                }
                                repaint();
                                break;
                            }
                        }
                    }
                }
            });
        }

        public void cancelCurrentRectangle() {
            currentCollision = null;
            repaint();
        }

        private Point snapToGrid(Point point) {
            int x = (point.x / GRID_SIZE) * GRID_SIZE;
            int y = (point.y / GRID_SIZE) * GRID_SIZE;
            return new Point(x, y);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw 1xgrid
            g.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i < getWidth(); i += GRID_SIZE)
                g.drawLine(i, 0, i, getHeight());
            for (int i = 0; i < getHeight(); i += GRID_SIZE)
                g.drawLine(0, i, getWidth(), i);

            // Draw 4xgrid
            g.setColor(Color.GRAY);
            for (int i = 0; i < getWidth(); i += GRID_SIZE * Constants.BLOCK_WIDTH / 4)
                g.drawLine(i, 0, i, getHeight());
            for (int i = 0; i < getHeight(); i += GRID_SIZE * Constants.BLOCK_WIDTH / 4)
                g.drawLine(0, i, getWidth(), i);

            // Draw 16xgrid
            g.setColor(Color.BLACK);
            for (int i = 0; i < getWidth(); i += GRID_SIZE * Constants.BLOCK_WIDTH)
                g.drawLine(i, 0, i, getHeight());
            for (int i = 0; i < getHeight(); i += GRID_SIZE * Constants.BLOCK_WIDTH)
                g.drawLine(0, i, getWidth(), i);

            // Draw existing rectangles
            for (Collision collision : collisions) {
                g.setColor(collision.topLimited ? new Color(255, 0, 0, 128) : new Color(0, 0, 255, 128));
                g.fillRect(collision.x * GRID_SIZE, collision.y * GRID_SIZE, collision.width * GRID_SIZE, collision.height * GRID_SIZE);

                // Draw extendable sides
                Graphics2D g2 = (Graphics2D) g;
                Stroke originalStroke = g2.getStroke();
                g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{5}, 0));

                int x = collision.x * GRID_SIZE;
                int y = collision.y * GRID_SIZE;
                int width = collision.width * GRID_SIZE;
                int height = collision.height * GRID_SIZE;

                if (collision.upExtended > 0) {
                    g.drawLine(x, y, x + width, y);
                    g.drawString(String.valueOf(collision.upExtended), x + width / 2, y - 2);
                }
                if (collision.downExtended > 0) {
                    g.drawLine(x, y + height, x + width, y + height);
                    g.drawString(String.valueOf(collision.downExtended), x + width / 2, y + height + 12);
                }
                if (collision.leftExtended > 0) {
                    g.drawLine(x, y, x, y + height);
                    g.drawString(String.valueOf(collision.leftExtended), x - 12, y + height / 2);
                }
                if (collision.rightExtended > 0) {
                    g.drawLine(x + width, y, x + width, y + height);
                    g.drawString(String.valueOf(collision.rightExtended), x + width + 2, y + height / 2);
                }

                g2.setStroke(originalStroke);
            }

            // Draw current rectangle
            if (currentCollision != null) {
                g.setColor(currentCollision.topLimited ? new Color(255, 0, 0, 128) : new Color(0, 0, 255, 128));
                g.fillRect(currentCollision.x * GRID_SIZE, currentCollision.y * GRID_SIZE, currentCollision.width * GRID_SIZE, currentCollision.height * GRID_SIZE);
            }
        }
    }
}