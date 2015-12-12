package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.util.*;

/**
 * Classe permettant la gestion de personnes.
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
public class Person {

    /** La liste des films vus par cette personne. */
    private Map<Long, Movie> movies;
    /** L'identifiant unique de la personne. */
    private Long id;
    /** Le prénom de la personne. */
    private String firstName;
    /** Le nom de la personne. */
    private String lastName;

    /**
     * Constructeur paramétré pour les personnes.
     * 
     * @param id L'identifiant unique de la personne.
     * @param firstName Le prénom de la personne.
     * @param lastName Le nom de la personne.
     */
    public Person(final Long id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = new LinkedHashMap<>();
    }
    
    /**
     * Ajoute le film passé en paramètre à la liste des films vu par cette personne.
     * Ajoute aussi cette personne à la liste des personnes ayant vues le film passé en paramètre.
     * 
     * @param movie Le film à ajouter à la liste des films déjà vus.
     * @throws UniqueException si le film a déjà été vu et est donc déjà présent dans la liste.
     */
    public void addMovie(final Movie movie) throws UniqueException {
        if(movies.containsKey(movie.getId())) {
            throw new UniqueException("Ce film a déjà été vu par cette personne.");
        }
        
        movies.put(movie.getId(), movie);
        
        try {
            movie.addPerson(this);
        }catch(UniqueException ex) {
            // Si cette exception se produit, cela signifie que c'est addPerson() qui a fait appelle à addMovie().
            // Il est donc normal que cette exception se produise. Aucune conséquence pour l'application.
        }
    }
    
    /**
     * Permet d'obtenir l'identifiant de cette personne.
     * 
     * @return L'identifiant de cette personne.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Modifie l'identifiant de cette personne par celui passé en paramètre.
     * 
     * @param id Le nouvel identifiant de cette personne.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Permet d'obtenir le prénom de cette personne.
     * 
     * @return Le prénom de cette persone.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Modifie le prénom de cette personne par celui passé en paramètre.
     * 
     * @param firstName Le nouveau prénom de cette personne.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Permet d'obtenir le nom de cette personne.
     * 
     * @return Le nom de cette personne.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Modifie le nom de cette personne par celui passé en paramètre.
     * 
     * @param lastName Le nouveau nom de cette personne.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}
