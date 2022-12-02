public class UMLDiagramAndSkeletonGenerator {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        CanvasPanel canvas = new CanvasPanel(400, 30);
        DisplayPanel display = new DisplayPanel(20, 30);
        GUI plotPanel = new GUI(canvas, display);

        CanvasPanelController controller = new CanvasPanelController(canvas);
        DataSource.getInstance().addObserver(canvas);
    }

}
