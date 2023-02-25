package prj.IIA.BD.exeption;

public class AuthException extends Exception {

    private ErrorCode errorCode = ErrorCode.OK ;

    public AuthException() {
    }

    public AuthException(String message) {
        super(message);
    }

    public AuthException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String errorMessage() {
        return errorCode.getErrorMessage();
    }

    public String frErrorMessage() {
        return errorCode.getFrErrorMessage();
    }

    public enum ErrorCode {
        OK( "", ""),
        WRONG_LOGIN( "Email/password not valid", "Email/mot de passe non valide"),
        EMAIL_ALREADY_REGISTERED( "Email already gesitered for another account", "E-mail déjà enregistré pour un autre compte"),
        EMAIL_NOT_REGISTERED( "Email not registered", "E-mail non enregistré"),
        EMAIL_NOT_VALID( "Email format not valid", "Format d'e-mail non valide"),
        PASSWORDS_DO_NOT_MATCH( "Passwords do not match", "Les mots de passe ne correspondent pas"),
        WEAK_PASSWORD( "Weak password", "Mot de passe faible"),
        WRONG_PASSWORD( "Wrong password", "Mauvais mot de passe"),
        WRONG_OLD_PASSWORD( "Wrong old password", "Ancien mot de passe erroné"),
        ELSE( "Something went wrong", "Quelque chose s'est mal passé");

        private String errorMessage;
        private String frErrorMessage;

        private ErrorCode( String erroeMessage, String frErrorMessage){
            this.errorMessage = erroeMessage ;
            this.frErrorMessage = frErrorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public String getFrErrorMessage(){
            return frErrorMessage;
        }

    }

}
            

