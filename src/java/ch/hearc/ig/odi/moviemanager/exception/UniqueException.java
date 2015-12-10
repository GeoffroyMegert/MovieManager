package ch.hearc.ig.odi.moviemanager.exception;

/**
 * Cette classe permet la gestion des exceptions levées lorsqu'une
 * contrainte d'unicité n'est pas respectée.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
public class UniqueException extends Exception {

    /**
     * Lève une exception de violation d'une contrainte d'unicité.
     */
    public UniqueException() {
        super();
    }

    /**
     * Lève une exception de violation d'une contrainte d'unicité.
     * 
     * @param message Le message retourné par l'exception.
     */
    public UniqueException(final String message) {
        super(message);
    }

    /**
     * Lève une exception de violation d'une contrainte d'unicité.
     * 
     * @param cause La cause de l'exception.
     */
    public UniqueException(final Throwable cause) {
        super(cause);
    }

    /**
     * Lève une exception de violation d'une contrainte d'unicité.
     * 
     * @param message Le message retourné par l'exception.
     * @param cause La cause de l'exception.
     */
    public UniqueException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
}
