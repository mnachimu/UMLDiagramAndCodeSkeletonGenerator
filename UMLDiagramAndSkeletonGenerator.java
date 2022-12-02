public class UMLDiagramAndSkeletonGenerator {

    public static void main(String[] args) {
        MenuBar menuBar = new MenuBar();
        System.out.println("Hello, World!");
        CanvasPanel canvas = new CanvasPanel(400, 30);
        DisplayPanel display = new DisplayPanel(20, 30);
        StatusBar statusBar = new StatusBar(20, 650, 1005, 30);
        GUI plotPanel = new GUI(canvas, display, menuBar, statusBar);

        CanvasPanelController controller = new CanvasPanelController(canvas);
        DataSource.getInstance().addObserver(canvas);
        DataSource.getInstance().addObserver(display);
    }

}
