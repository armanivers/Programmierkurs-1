package mainprogrammJavaFxApp.fachlogik;

public class EmptyFilenameException extends Exception{
	EmptyFilenameException(){
		super();
	}
	EmptyFilenameException(String message){
		super(message);
	}
}
