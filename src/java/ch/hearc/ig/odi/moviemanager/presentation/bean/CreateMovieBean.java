package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Ce Backing Bean est lié à la page "createMovie.xhtml".
 * Il permet la création d'un nouveau film.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "createMovieBean")
// Cycle de vie du Backing Bean.
// Ce Backing Bean ne manipule pas d'objet necessitant d'être mémorisé plus d'une requête.
@RequestScoped
public class CreateMovieBean implements Serializable {
    
    /** L'identifiant unique du nouveau film. */
    @NotNull
    @Min(0)
    private Long id;
    /** Le nom du nouveau film. */
    @NotNull
    private String name;
    /** Le producteur du nouveau film. */
    @NotNull
    private String producer;
    
    /** Services mise à disposition des programmeurs. */
    // L'injection permet la gestion automatique de l'instanciation des services.
    @Inject
    private Services service;
    
    /**
     * Mémorise le nouveau film.
     * 
     * @return "success" si le film a pu être mémorisé, sinon "failure".
     */
    public String submit() {
        try {
            service.saveMovie(id, name, producer);
            return "success";
        } catch(UniqueException ex) {
            return "failure";
        }
    }

    /**
     * Permet d'obtenir l'identifiant unique du nouveau film.
     * 
     * @return L'identifiant unique du nouveau film.
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifie l'identifiant unique du nouveau film par celui passé en paramètre.
     * 
     * @param id Le nouvel identifiant du film.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Permet d'obtenir le nom du nouveau film.
     * 
     * @return Le nom du nouveau film.
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom du nouveau film par celui passé en paramètre.
     * 
     * @param name Le nouveau nom du film.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Permet d'obtenir le producteur du nouveau film.
     * 
     * @return Le producteur du nouveau film.
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Modifie le producteur du nouveau film par celui passé en paramètre.
     * 
     * @param producer Le nouveau producteur du film.
     */
    public void setProducer(final String producer) {
        this.producer = producer;
    }
}
