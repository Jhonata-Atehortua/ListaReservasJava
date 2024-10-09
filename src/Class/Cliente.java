package Class;

public class Cliente {

    private Integer Document;
    private String Name;
    private String LastName;

    //Constructor
    public Cliente(Integer Document, String Name, String LastName){
        this.Document = Document;
        this.Name = Name;
        this.LastName = LastName;
    }

    //aceder al documento
    public Integer GetDocumnetU(){
        return this.Document;
    }

    public void SetDocumentU(Integer Document){
        this.Document = Document;
    }

    //aceder al nombre
    public String GetNameU(){
        return this.Name;
    }

    public void SetNameU(String Name){
        this.Name = Name;
    }

    //aceder al apellido
    public String GetLastNameU(){
        return this.LastName;
    }

    public void SetLastNameU(String LastName){
        this.LastName = LastName;
    }
    
}
