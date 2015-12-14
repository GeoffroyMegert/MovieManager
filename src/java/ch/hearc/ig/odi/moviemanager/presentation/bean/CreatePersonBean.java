package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.services.Services;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Ce Backing Bean est lié à la page "createPerson.xhtml".
 * Il permet la création d'une nouvelle personne.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "createPersonBean")
// Cycle de vie du Backing Bean.
// Ce Backing Bean ne manipule pas d'objet necessitant d'être mémorisé plus d'une requête.
@RequestScoped
public class CreatePersonBean {
    
    /** L'identifiant unique de la nouvelle personne. */
    private Long id;
    /** Le prénom de la nouvelle personne. */
    private String firstName;
    /** Le nom de la nouvelle personne. */
    private String lastName;
    
    /** Services mise à disposition des programmeurs. */
    // L'injection permet la gestion automatique de l'instanciation des services.
    @Inject
    private Services service;
    
    /**
     * Mémorise la nouvelle personne.
     * 
     * @return "success" si la personne a pu être mémorisée, sinon "failure".
     */
    public String submit() {
        try {
            service.savePerson(id, firstName, lastName);
            return "success";
        } catch(UniqueException ex) {
            return "failure";
        }
    }

    /**
     * Permet d'obtenir l'identifiant unique de la nouvelle personne.
     * 
     * @return L'identifiant unique de la nouvelle personne.
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifie l'identifiant unique de la nouvelle personne par celui passé en paramètre.
     * 
     * @param id Le nouvel identifiant de la personne.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Permet d'obtenir le prénom de la nouvelle personne.
     * 
     * @return Le prénom de la nouvelle personne.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modifie le prénom de la nouvelle personne par celui passé en paramètre.
     * 
     * @param firstName  Le nouveau prénom de la personne.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Permet d'obtenir le nom de la nouvelle personne.
     * 
     * @return Le nom de la nouvelle personne.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Modifie le nom de la nouvelle personne par celui passé en paramètre.
     * 
     * @param lastName  Le nouveau nom de la personne.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
}
