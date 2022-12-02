/**
 * @author Darshan Navadiya
 */
public class RecordStatus implements IStatus{

    private static volatile RecordStatus instance;
    private RecordStatus(){
    }
    public static RecordStatus getInstance(){
        // if two thread tries to get access to the instance,
        // this will prevent both of them from acessing at the same time,
        // preventing the generation of two different unique instace objects.
        // but this will make the thread to wait to get the access, delaying the process,
        // to prevent this we are using double-checked locking idiom
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

    @Override
    public void Record(String msg) {
        System.out.println("-------------- Class "+msg+" created -------------");
        StatusBar statusBar = new StatusBar();
        statusBar.setStatus(msg);
    }
}
