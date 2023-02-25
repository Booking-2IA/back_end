package prj.IIA.BD.exeption;

public class clientNotFoundExeption extends RuntimeException{

	public clientNotFoundExeption( String message){
        super( message);
    }
}
