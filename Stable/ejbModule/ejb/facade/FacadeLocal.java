package ejb.facade;

import java.util.List;

import javax.ejb.Local;

import ejb.stablepkg.Horse;
import ejb.stablepkg.Stable;

@Local
public interface FacadeLocal {
	public Horse createHorse(Horse horse);
	public Horse findHorseByNumber(long horseNumber);
	public Stable findStableByNumber(long stableNumber);
	public Stable createStable(Stable stable);
	public Stable updateStable(Stable stable);
	public List<Stable> findAllStables();
}
