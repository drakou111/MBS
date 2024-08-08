package canvas;

import logic.BlockFinder;
import minecraft.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CollisionCanvas extends JFrame {
    private ArrayList<Collision> collisions;
    private final int INITIAL_GRID_SIZE = 12;
    private int gridSize = INITIAL_GRID_SIZE;
    private float zoomFactor = 1.0f;
    private Point panOffset = new Point(0, 0);
    private Point dragStartPoint;

    private final int BLOCK_COUNT = 8;
    public static float MAX_ZOOM = 4.0f;
    public static float MIN_ZOOM = 0.5f;
    public static float ZOOM_STEP = 0.1f;

    public CollisionCanvas() {
        setTitle("Collision Canvas");
        setSize(INITIAL_GRID_SIZE * 64, INITIAL_GRID_SIZE * 64);
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
        private boolean currentTopLimited;

        public DrawPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON2) {
                        dragStartPoint = e.getPoint();
                    } else {
                        startPoint = snapToGrid(e.getPoint());
                        startPoint.x /= gridSize;
                        startPoint.y /= gridSize;

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            currentTopLimited = false; // Left click
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            currentTopLimited = true; // Right click
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON2) {
                        dragStartPoint = null;
                    } else if (currentCollision != null) {
                        if (currentCollision.width == 0 || currentCollision.height == 0) return;

                        collisions.add(currentCollision);
                        currentCollision = null;
                        repaint();
                    }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    Point point = e.getPoint();
                    float pointX = (float) (point.x - panOffset.x) / gridSize / zoomFactor;
                    float pointY = (float) (point.y - panOffset.y) / gridSize / zoomFactor;

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

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragStartPoint != null) {
                        Point dragEndPoint = e.getPoint();
                        panOffset.translate(dragEndPoint.x - dragStartPoint.x, dragEndPoint.y - dragStartPoint.y);
                        dragStartPoint = dragEndPoint;
                        repaint();
                    } else {
                        Point endPoint = snapToGrid(e.getPoint());
                        endPoint.x /= gridSize;
                        endPoint.y /= gridSize;

                        int x = Math.min(startPoint.x, endPoint.x);
                        int y = Math.min(startPoint.y, endPoint.y);
                        int width = Math.abs(startPoint.x - endPoint.x);
                        int height = Math.abs(startPoint.y - endPoint.y);
                        currentCollision = new Collision(x, y, width + 1, height + 1, currentTopLimited);
                        repaint();
                    }
                }
            });

            addMouseWheelListener(e -> {
                //Point mousePos = e.getPoint();
                float delta = e.getWheelRotation() < 0 ? ZOOM_STEP : -ZOOM_STEP;
                float newZoomFactor = Math.max(MIN_ZOOM, Math.min(MAX_ZOOM, zoomFactor + delta));

                if (newZoomFactor != zoomFactor) {
                    //TODO fix this shit
                    //TODO-2 prevent creating stuff outside of borders

                    // Update zoomFactor and gridSize
                    zoomFactor = newZoomFactor;
                    gridSize = Math.round(INITIAL_GRID_SIZE * zoomFactor);

                    // Repaint the component
                    repaint();
                }
            });
        }

        public void cancelCurrentRectangle() {
            currentCollision = null;
            repaint();
        }

        private Point snapToGrid(Point point) {
            int x = (int) (((point.x - panOffset.x) / zoomFactor) / gridSize) * gridSize;
            int y = (int) (((point.y - panOffset.y) / zoomFactor) / gridSize) * gridSize;
            return new Point(x, y);
        }

        private void drawGrid(Graphics2D g, Color color, int gap) {
            g.setColor(color);
            for (int i = 0; i <= gridSize * BLOCK_COUNT * Constants.BLOCK_WIDTH; i += gap)
                g.drawLine(i, 0, i, gridSize * BLOCK_COUNT * Constants.BLOCK_WIDTH);
            for (int i = 0; i <= gridSize * BLOCK_COUNT * Constants.BLOCK_WIDTH; i += gap)
                g.drawLine(0, i, gridSize * BLOCK_COUNT * Constants.BLOCK_WIDTH, i);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.translate(panOffset.x, panOffset.y);
            g2.scale(zoomFactor, zoomFactor);

            // Draw 1xgrid
            drawGrid(g2, Color.LIGHT_GRAY, gridSize);

            // Draw 4xgrid
            drawGrid(g2, Color.GRAY, gridSize * Constants.BLOCK_WIDTH / 4);

            // Draw 16xgrid
            drawGrid(g2, Color.BLACK, gridSize * Constants.BLOCK_WIDTH);


            // Draw existing rectangles
            for (Collision collision : collisions) {
                g2.setColor(collision.topLimited ? new Color(255, 0, 0, 128) : new Color(0, 0, 255, 128));
                g2.fillRect(collision.x * gridSize, collision.y * gridSize, collision.width * gridSize, collision.height * gridSize);

                // Draw extendable sides
                Stroke originalStroke = g2.getStroke();
                g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{5}, 0));

                int x = collision.x * gridSize;
                int y = collision.y * gridSize;
                int width = collision.width * gridSize;
                int height = collision.height * gridSize;

                if (collision.upExtended > 0) {
                    g2.drawLine(x, y, x + width, y);
                    g2.drawString(String.valueOf(collision.upExtended), x + width / 2, y - 2);
                }
                if (collision.downExtended > 0) {
                    g2.drawLine(x, y + height, x + width, y + height);
                    g2.drawString(String.valueOf(collision.downExtended), x + width / 2, y + height + 12);
                }
                if (collision.leftExtended > 0) {
                    g2.drawLine(x, y, x, y + height);
                    g2.drawString(String.valueOf(collision.leftExtended), x - 12, y + height / 2);
                }
                if (collision.rightExtended > 0) {
                    g2.drawLine(x + width, y, x + width, y + height);
                    g2.drawString(String.valueOf(collision.rightExtended), x + width + 2, y + height / 2);
                }

                g2.setStroke(originalStroke);
            }

            // Draw current rectangle
            if (currentCollision != null) {
                g2.setColor(currentCollision.topLimited ? new Color(255, 0, 0, 128) : new Color(0, 0, 255, 128));
                g2.fillRect(currentCollision.x * gridSize, currentCollision.y * gridSize, currentCollision.width * gridSize, currentCollision.height * gridSize);
            }
        }
    }
}