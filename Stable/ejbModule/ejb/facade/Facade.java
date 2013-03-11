package ejb.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ebj.eao.HorseEntityAccessLocal;
import ebj.eao.StableEntityAccessLocal;
import ejb.stablepkg.Horse;

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

	public Horse createHorse(Horse horse) {
		return horseEALocal.createHorse(horse);
	}

}
