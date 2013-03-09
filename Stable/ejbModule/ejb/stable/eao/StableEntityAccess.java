package ejb.stable.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.stablepkg.Stable;

/**
 * Session Bean implementation class StableEntityAccess
 */
@Stateless
public class StableEntityAccess implements StableEntityAccessLocal {

	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager entityManager;
	
	
    /**
     * Default constructor. 
     */
    public StableEntityAccess() {
        // TODO Auto-generated constructor stub
    }
    
    
    public Stable findByStableNumber(long stableNumber){
    	return entityManager.find(Stable.class, stableNumber);
    }
    
    public Stable createStable(Stable stable){
    	entityManager.persist(stable);
    	return stable;
    }
    
    public Stable updateStable(Stable stable){
    	entityManager.merge(stable);
    	return stable;
    }
    
    public void deleteStable(long stableNumber) { 
    	Stable stable = this.findByStableNumber(stableNumber); 
    	if (stable != null) {
    		entityManager.remove(stable);
    	}
    }

}
