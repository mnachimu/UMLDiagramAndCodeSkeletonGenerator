/**
 * This class
 * This class implements singleton pattern.
 * This class is a part of MODEL in MVC.
 * @version 1.0
 */
public class RecordStatus implements IStatus{

    private static volatile RecordStatus instance;
    private RecordStatus(){
    }

    /**
     * if two thread tries to get access to the instance,
     * this will prevent both of them from accessing at the same time,
     * preventing the generation of two different unique instance objects.
     * but this will make the thread to wait to get the access, delaying the process,
     * to prevent this we are using double-checked locking idiom
     * @return
     */
    public static RecordStatus getInstance(){
        RecordStatus result = instance;
        if (result == null){
            synchronized (RecordStatus.class){
                result = instance;
                if (result  == null){
                    instance = result = new RecordStatus();
                }
            }
        }
        return result;
    }

    /**
     * This method passes the message to the statusbar.
     * @param msg
     */
    @Override
    public void Record(String msg) {
        System.out.println("-------------- Class "+msg+" created -------------");
        StatusBar statusBar = new StatusBar();
        statusBar.setStatus(msg);
    }
}
