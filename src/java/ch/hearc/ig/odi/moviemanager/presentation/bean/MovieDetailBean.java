package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Cette classe est liée à la page "personDetail.xhtml".
 * Elle permet la gestion de l'affichage du détail d'un client.
 * 
 * @author Geoffroy Megert
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "movieDetailBean")
// Cycle de vie du Backing Bean.
// Ce Backing Bean doit mémoriser un objet plus d'une requête, il a donc une durée d'une session.
@SessionScoped
public class MovieDetailBean implements Serializable {
    
    /** Le film à détailler. */
    private Movie movie;

    /**
     * Reçoit le film à détailler.
     * 
     * @param movie Le film à détailler.
     * @return "success" si le film a bien été reçu, sinon "failure".
     */
    public String getMovieToDetail(final Movie movie) {
        if(movie != null) {
            this.movie = movie;
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * Permet d'obtenir le film à détailler.
     * 
     * @return Le film à détailler.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Modifie le film à détailler par celui passé en paramètre.
     * 
     * @param movie  Le nouveau film à détailler.
     */
    public void setMovie(final Movie movie) {
        this.movie = movie;
    }
}
