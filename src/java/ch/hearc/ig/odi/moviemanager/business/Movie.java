package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.util.*;

/**
 * Classe permettant la gestion de films.
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
public class Movie {

    /** La liste des personnes ayant regardées ce film. */
    private Map<Long, Person> people;
    /** L'identifiant unique du film. */
    private Long id;
    /** Le nom du film. */
    private String name;
    /** Le producteur du film. */
    private String producer;

    /**
     * Constructeur paramétré pour les films.
     * 
     * @param id L'identifiant unique du film.
     * @param name Le nom du film.
     * @param producer Le producteur du film.
     */
    public Movie(final Long id, final String name, final String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.people = new LinkedHashMap<>();
    }
    
    /**
     * Ajoute la personne passé en paramètre à la liste des personnes ayant vues ce film.
     * Ajoute aussi ce film à la liste des films vu par la personne passée en paramètre.
     * 
     * @param person La personne à ajouter à la liste des personnes ayant vues ce film.
     * @throws UniqueException si cette personne à déjà vu ce film et est donc déjà présent dans la liste.
     */
    public void addPerson(final Person person) throws UniqueException {
        if(people.containsKey(person.getId())) {
            throw new UniqueException("Cette personne à déjà vu ce film.");
        }
        
        people.put(person.getId(), person);
        
        try {
            person.addMovie(this);
        }catch(UniqueException ex) {
            // Si cette exception se produit, cela signifie que c'est addMovie() qui a fait appelle à addPerson().
            // Il est donc normal que cette exception se produise. Aucune conséquence pour l'application.
        }
    }

    /**
     * Permet d'obtenir l'identifiant de ce film.
     * 
     * @return L'identifiant de ce film.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Modifie l'identifiant de ce film par celui passé en paramètre.
     * 
     * @param id Le nouvel identifiant de ce film.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Permet d'obtenir le nom de ce film.
     * 
     * @return Le nom de ce film.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Modifie le nom de ce film par celui passé en paramètre.
     * 
     * @param name Le nouveau nom de ce film.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Permet d'obtenir le producteur de ce film.
     * 
     * @return Le producteur de ce film.
     */
    public String getProducer() {
        return this.producer;
    }

    /**
     * Modifie le producteur de ce film par celui passé en paramètre.
     * 
     * @param producer Le nouveau producteur de ce film.
     */
    public void setProducer(final String producer) {
        this.producer = producer;
    }

    /**
     * Permet d'obtenir le nombre de personnes ayant vues ce film.
     * 
     * @return Le nombre de personnes ayant vues ce film.
     */
    public int getPeopleNumber() {
        return people.size();
    }
    
    /**
     * Permet d'obtenir la liste des personnes ayant vues ce film.
     * 
     * @return La liste des personnes ayant vues ce film.
     */
    public List<Person> getPeople() {
        return new ArrayList<>(people.values());
    }
}
