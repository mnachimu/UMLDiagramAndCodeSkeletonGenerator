import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class CanvasPanel extends JPanel implements Observer {
	// view
	private static final int width = 625;
	private static final int height = 600;

	public BufferedImage canvas;

	int mouseX, mouseY;

	public CanvasPanel(int x, int y) {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		this.setBackground(Color.white);
		this.setBounds(x, y, width, height);
    	this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));

	}

	@Override
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);

		 g.setColor(new Color(242, 213, 145));

		 DataSource dataSource = DataSource.getInstance();

		Relationship[][] rels = dataSource.relationships;
		for (int i=0 ; i< rels.length; i++) {
			for (int j=0 ; j<rels[0].length ; j++) {
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
		for (int i = 0; i < dataSource.classObjectsLists.size(); i++) {
			dataSource.classObjectsLists.get(i).draw(g);
		}
		if (dataSource.getSelectedObject() != -1) {
			dataSource.classObjectsLists.get(dataSource.getSelectedObject()).selectedState(g);
		}

//		g.drawImage(canvas, 0, 0, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
