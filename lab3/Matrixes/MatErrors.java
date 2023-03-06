package Matrixes;

public class MatErrors extends RuntimeException{
    public MatErrors(String message){
        super(message);
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
