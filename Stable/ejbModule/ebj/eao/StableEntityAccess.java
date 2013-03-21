package ebj.eao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ejb.stablepkg.Stable;

/**
 * Session Bean implementation class StableEntityAccess
 */
@Stateless
@LocalBean
public class StableEntityAccess implements StableEntityAccessLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StableEntityAccess() {
		// TODO Auto-generated constructor stub
	}

	public Stable findByStableNumber(long stableNumber) {
		return entityManager.find(Stable.class, stableNumber);
	}

	public Stable createStable(Stable stable) {
		entityManager.persist(stable);
		return stable;
	}

	public Stable updateStable(Stable stable) {
		entityManager.merge(stable);
		return stable;
	}

	public void deleteStable(long stableNumber) {
		Stable stable = this.findByStableNumber(stableNumber);
		if (stable != null) {
			entityManager.remove(stable);
		}
	}
	
	public List<Stable> findAllStables() {
		TypedQuery<Stable> query = entityManager.createNamedQuery("Stable.findAll", Stable.class);
		List<Stable> results = query.getResultList();
		return results; 
	}

}
