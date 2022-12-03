import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class DisplayPanel extends JScrollPane implements Observer {

    
    private JTextArea outputArea;

	private static final int width = 350;
	private static final int height = 600;

    private String code;
    DataSource dataSource;
    List<String> codeList;

    public DisplayPanel(int x, int y) {
        this.dataSource = DataSource.getInstance();

        outputArea = new JTextArea();

        outputArea.setEnabled(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Courier", Font.PLAIN, 14));

        this.setViewportView(outputArea);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setBounds(x, y, width,height);
		this.setForeground(Color.BLACK);
    	this.setBackground(Color.WHITE);
    	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }


    public JTextArea getOutputArea() {
        return outputArea;
    }

    public void setCode() {
        String input;
        String oldSnip;
        String newSnip;

        Relationship[][] rels =  dataSource.relationships;
        int maxLen = dataSource.classObjectsLists.size();
        codeList = new ArrayList<String>();

        System.out.println("Classes created: " + maxLen);

        if (maxLen > 0) {
            for (int i = 0; i < maxLen; i++ ) {     // Object branch
                System.out.println("Object " + i);
                input = "";
                input += dataSource.classObjectsLists.get(i).getClassName();
                for (int j = 0; j < maxLen; j++) {  // Relationship branch
                    if (!((rels[i][j] == null) || (rels[i][j] == Relationship.NO_RELATION))) {
                        System.out.print("Relation between " + i + " and " + j + ": ");
                        switch (rels[i][j]) {
                            case NO_RELATION:
                                break;
                            case COMPOSITION:
                                input += "\t" + dataSource.classObjectsLists.get(j).getClassName() + "\n";
                                break;
                            case ASSOCIATION:
                                if (input.contains("\tmethod() {")) {
                                    oldSnip = "\t}\n";
                                    newSnip = "\t\t" + dataSource.classObjectsLists.get(j).getClassName() + "\n"
                                                + "\t}\n";
                                    input = input.replace(oldSnip, newSnip);
                                }
                                else {
                                    input += "\tmethod() {\n";
                                    input += "\t\t" + dataSource.classObjectsLists.get(j).getClassName()+ "\n";
                                    input += "\t}\n";
                                }

                                break;
                            case INHERITANCE:
                                oldSnip = dataSource.classObjectsLists.get(i).getClassName() + " {\n";
                                newSnip = dataSource.classObjectsLists.get(i).getClassName()
                                    + " extends " + dataSource.classObjectsLists.get(j).getClassName() + " {\n";
                                input = input.replace(oldSnip, newSnip);
                                break;
                        }
                    }
                    else {
                        if (j < 1) {
                            input += " {\n";
                        }
                    }
                }
                input += "}\n\n";
                codeList.add(i, input);
            }
        }
    }

    public void formatCode() {
        code = "";
        for (int i = 0; i < codeList.size(); i++) {
            code += codeList.get(i);
        }
    }

    public String getCode() {
        return code;
    }

    @Override
	public void update(Observable o, Object arg) {
        System.out.println("DisplayPanel update() called!");

        setCode();
        formatCode();
        outputArea.setText(getCode());
	}
}
