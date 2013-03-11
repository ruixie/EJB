package ejb.facade;

import javax.ejb.Local;

import ejb.stablepkg.Horse;

@Local
public interface FacadeLocal {
	public Horse createHorse(Horse horse);
}
