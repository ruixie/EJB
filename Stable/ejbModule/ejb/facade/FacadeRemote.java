package ejb.facade;

import javax.ejb.Remote;

import ejb.stablepkg.Horse;

@Remote
public interface FacadeRemote {
	public Horse createHorse(Horse horse);

}
