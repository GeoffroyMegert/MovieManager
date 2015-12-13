package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Person;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Cette classe est liée à la page "personDetail.xhtml".
 * Elle permet la gestion de l'affichage du détail d'un client.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom employé sur les pages xhtml pour faire appel à ce Backing Bean.
@Named(value = "personDetailBean")
// Cycle de vie du Backing Bean.
// Ce Backing Bean doit mémoriser un objet plus d'une requête, il a donc une durée d'une session.
@SessionScoped
public class PersonDetailBean implements Serializable {
    
    /** La personne à détailler. */
    private Person person;

    public String getPersonToDetail(final Person person) {
        if(person == null) {
            this.person = person;
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * Permet d'obtenir la personne à détailler.
     * 
     * @return La personne à détailler.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Modifie la personne à détailler par celle passée en paramètre.
     * 
     * @param person La nouvelle personne à détailler.
     */
    public void setPerson(final Person person) {
        this.person = person;
    }
    
}
