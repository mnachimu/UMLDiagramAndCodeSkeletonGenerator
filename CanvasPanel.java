import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Class for the Canvas panel where classes are added and relationships are established.
 * This class is part of the VIEW.
 * @version 1.0
 */
public class CanvasPanel extends JPanel implements Observer {
	// view
	private static final int width = 625;
	private static final int height = 600;

	public BufferedImage canvas;

	/**
	 * Class Constructor which creats a BufferedImage object
	 * @param x X coordinate from where the canvas panel should start
	 * @param y Y coordinate from where the canvas panel should start.
	 */
	public CanvasPanel(int x, int y) {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		this.setBackground(Color.white);
		this.setBounds(x, y, width, height);
    	this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));

	}

	/**
	 * Draws a relation between two classes
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);

		 g.setColor(new Color(242, 213, 145));

		DataSource dataSource = DataSource.getInstance();

		Relationship[][] rels = dataSource.relationships;
		int maxLen = dataSource.classObjectsLists.size();
		for (int i=0 ; i< maxLen; i++) {
			for (int j=0 ; j<maxLen; j++) {
				if (!( rels[i][j] == null || rels[i][j] == Relationship.NO_RELATION)) {
					System.out.println(rels[i][j].name());
					g.drawLine(dataSource.classObjectsLists.get(i).getX(),
							dataSource.classObjectsLists.get(i).getY(),
							dataSource.classObjectsLists.get(j).getX(),
							dataSource.classObjectsLists.get(j).getY());
					switch (rels[i][j]) { // change it to arrows, use chain of responsibilities for drawing the line
						case AGGREGATION -> System.out.println("Aggregation between " + i + " and " + j);
						case ASSOCIATION -> System.out.println("Association between " + i + " and " + j);
						case INHERITANCE -> System.out.println("Inheritance between " + i + " and " + j);
					}
				}
			}
		}
		for (int i = 0; i < maxLen; i++) {
			dataSource.classObjectsLists.get(i).draw(g);
		}
		if (dataSource.getSelectedObject() != -1) {
			dataSource.classObjectsLists.get(dataSource.getSelectedObject()).selectedState(g);
		}

//		g.drawImage(canvas, 0, 0, this);
	}

	/**
	 * This method is a part of Observer pattern.
	 * @param o
	 * @param arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("CanvasPanel update() called!");
		repaint();
	}
}
