package ch.hearc.ig.odi.moviemanager.presentation.bean;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Ce Backing Bean est lié à la page "createMovie.xhtml".
 * Il permet la création d'un nouveau film.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "createMovieBean")
@RequestScoped
public class CreateMovieBean implements Serializable {
    
}
