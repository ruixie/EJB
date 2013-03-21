package ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import ejb.stablepkg.Horse;
import ejb.stablepkg.Stable;

@Remote
public interface FacadeRemote {
	public Horse createHorse(Horse horse);
	public Horse findHorseByNumber(long horseNumber);
	public Stable findStableByNumber(long stableNumber);
	public Stable createStable(Stable stable);
	public Stable updateStable(Stable stable);
	public List<Stable> findAllStables();
}
