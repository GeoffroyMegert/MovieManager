package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est liée à la page "index.xhtml".
 * Elle permet la gestion des listes de personnes.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "peopleBean")
// Cycle de vie du Backing Bean.
// Ce Backing Bean ne manipule pas d'objet necessitant d'être mémorisé plus d'une requête.
@RequestScoped
public class PeopleBean implements Serializable {
    
    /** La liste de personnes. */
    // Les DataModel sont des composants adaptés aux JavaServer Faces.
    private DataModel<Person> people;
    
    /** Services mise à disposition des programmeurs. */
    // L'injection permet la gestion automatique de l'instanciation des services.
    @Inject
    private Services services;
    
    /**
     * Permet d'obtenir la liste des personnes.
     * 
     * @return La liste des personnes.
     */
    public DataModel<Person> getPeople() {
        people = new ListDataModel<>();
        people.setWrappedData(services.getPeopleList());
        
        return people;
    }
}
