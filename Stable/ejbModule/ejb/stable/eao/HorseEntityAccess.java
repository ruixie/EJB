package ejb.stable.eao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.stablepkg.Horse;
import ejb.stablepkg.Stable;

/**
 * Session Bean implementation class HorseEntityAccess
 */
@Stateless
public class HorseEntityAccess implements HorseEntityAccessLocal {

	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public HorseEntityAccess() {
        // TODO Auto-generated constructor stub
    }
    
    
    public Horse findByHorseNumber(long horseNumber){
    	return entityManager.find(Horse.class, horseNumber);
    }
    
    public Horse createHorse(Horse horse){
    	entityManager.persist(horse);
    	return horse;
    }
    
    public Horse updateHorse(Horse horse){
    	entityManager.merge(horse);
    	return horse;
    }
    
    public void deleteHorse(long horseNumber) { 
    	Horse horse = this.findByHorseNumber(horseNumber); 
    	if (horse != null) {
    		entityManager.remove(horse);
    	}
    }

}
