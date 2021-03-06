package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Ce Backing Bean est lié à la page "index.xhtml".
 * Il permet la gestion des listes de films.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "moviesBean")
// Cycle de vie du Backing Bean.
// Ce Backing Bean ne manipule pas d'objet necessitant d'être mémorisé plus d'une requête.
@RequestScoped
public class MoviesBean implements Serializable {
    
    /** La liste de films. */
    // Les DataModel sont des composants adaptés aux JavaServer Faces.
    private DataModel<Movie> movies;
    
    /** Services mise à disposition des programmeurs. */
    // L'injection permet la gestion automatique de l'instanciation des services.
    @Inject
    private Services service;
    
    /**
     * Permet d'obtenir la liste des films.
     * 
     * @return La liste des films.
     */
    public DataModel<Movie> getMovies() {
        movies = new ListDataModel<>();
        movies.setWrappedData(service.getMoviesList());
        
        return movies;
    }
}
