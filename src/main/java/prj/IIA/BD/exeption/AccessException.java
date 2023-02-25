package prj.IIA.BD.exeption;

public class AccessException extends Exception{
    
    private AcccessError acccessError = AcccessError.OK ;

    public AccessException() {
    }

    public AccessException(String message) {
        super(message);
    }

    public AccessException(AcccessError AcccessError) {
        this.acccessError = AcccessError;
    }

    public AcccessError getAcccessError() {
        return acccessError;
    }

    public void setAcccessError(AcccessError AcccessError) {
        this.acccessError = AcccessError;
    }

    public String AcccessErrorMessage() {
        return acccessError.getAcccessErrorMessage();
    }

    public enum AcccessError {
        OK( ""),
        NOT_ALLOWED_TO_BE_HERE( "Not allowed to be here"),
        NOT_ALLOWED_TO_DO_THIS( "Not allowed to do this"),
        BLOCKED_FROM_THIS( "Blocked from this"),
        NOT_FOUND( "Field not found"),
        ALREADY_EXISTS( "Already exists"),
        ELSE( "Something went wrong");

        private String errorMessage;

        private AcccessError( String errorMessage){
            this.errorMessage = errorMessage ;
        }

        public String getAcccessErrorMessage() {
            return errorMessage;
        }

    }

}
