import java.util.ArrayList;

public abstract class Repository<T> {
    protected FileManage fileManage;
    protected String delimiter;


    public Repository(String nameFile, String delimiter){
        this.fileManage = new FileManage(nameFile);
        this.delimiter = delimiter;
    }

    //Create Data
    public abstract void insertDataEntity(T entity);

    //Read Data
    public abstract ArrayList<T> getDataList();

    //Update Data
    public abstract void updateDataEntity(T oldEntity, T newEntity);

    //Delete Data
    public abstract void deleteDataEntity(T entity);

    //Get Data String Line of Entity
    protected abstract String getDataLine(T entity);
}




