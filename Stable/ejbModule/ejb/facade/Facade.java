package ejb.facade;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ebj.eao.HorseEntityAccessLocal;
import ebj.eao.StableEntityAccessLocal;
import ejb.stablepkg.Horse;
import ejb.stablepkg.Stable;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@LocalBean
public class Facade implements FacadeRemote, FacadeLocal {

	@EJB
	StableEntityAccessLocal stableEALocal;
	@EJB
	HorseEntityAccessLocal horseEALocal;

	/**
	 * Default constructor.
	 */
	public Facade() {
		// TODO Auto-generated constructor stub
	}

	
	
	// ****** Pony methods *****
	public Horse createHorse(Horse horse) {
		return horseEALocal.createHorse(horse);
	}
	
	public Horse findHorseByNumber(long horseNumber){
		return horseEALocal.findByHorseNumber(horseNumber);
	}
	
	
	// ****** Stable methods *****
	public Stable findStableByNumber(long stableNumber){
		return stableEALocal.findByStableNumber(stableNumber);
	}
	
	public Stable createStable(Stable stable) {
		return stableEALocal.createStable(stable);
	}
	
	public Stable updateStable(Stable stable){
		return stableEALocal.updateStable(stable);
	}
	
	

}
