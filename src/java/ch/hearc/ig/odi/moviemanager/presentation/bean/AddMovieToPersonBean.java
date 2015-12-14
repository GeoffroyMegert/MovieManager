package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.services.Services;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Ce Backing Bean est lié à la page "addMovieToPerson.xhtml".
 * Il permet la gestion de l'affectation d'un film à une personne.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "addMovieToPersonBean")
// Cycle de vie du Backing Bean.
// Ce Backing Bean doit mémoriser un objet plus d'une requête, il a donc une durée d'une session.
@SessionScoped
public class AddMovieToPersonBean implements Serializable {
    
    /** La personne a qui on veut affecter un film. */
    private Person person;
    /** Le film à affecter à la personne. */
    private Movie movie;
    /** La liste de films que la personne n'a pas encore vu. */
    // Les DataModel sont des composants adaptés aux JavaServer Faces.
    private DataModel<Movie> movies;
    
    /** Services mise à disposition des programmeurs. */
    // L'injection permet la gestion automatique de l'instanciation des services.
    @Inject
    private Services service;
    
    /**
     * Permet d'obtenir la liste des films que la personne n'a pas encore vu.
     * 
     * @return La liste des films que la personne n'a pas encore vu.
     */
    public DataModel<Movie> getMovies() {
        List<Movie> unseenMovies = new LinkedList<>(service.getMoviesList());
        
        for(Movie seenMovie : person.getMovies()) {
            if(unseenMovies.contains(seenMovie)) {
                unseenMovies.remove(seenMovie);
            }
        }
        
        movies = new ListDataModel<>();
        movies.setWrappedData(unseenMovies);
        
        return movies;
    }

    /**
     * Affecte le film à la personne.
     * 
     * @return "success" si le film a bien été affecté, sinon "failure".
     */
    public String addMovie() {
        try {
            person.addMovie(movie);
            return "success";
        }catch(UniqueException ex) {
            return "failure";
        }
    }
    
    /**
     * Permet d'obtenir la personne a qui on veut affecter un film.
     * 
     * @return La personne a qui on veut affecter un film.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Modifie la personne a qui on veut affecter un film par celui passé en paramètre.
     * 
     * @param person La nouvelle personne a qui on veut affecter un film.
     */
    public void setPerson(final Person person) {
        this.person = person;
    }

    /**
     * Permet d'obtenir le film à attribuer à la personne.
     * 
     * @return Le film à attribuer à la personne.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Modifie le film à attribuer à la personne par celui passé en paramètre.
     * 
     * @param movie Le nouveau film à attribuer à la personne.
     */
    public void setMovie(final Movie movie) {
        this.movie = movie;
    }
    
}
