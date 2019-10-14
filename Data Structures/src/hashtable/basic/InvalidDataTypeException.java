package hashtable.basic;

public class InvalidDataTypeException extends Exception {
  private static final long serialVersionUID = 5962640475940555117L;
  
  public InvalidDataTypeException(String message) {
      super(message);
    }
}
