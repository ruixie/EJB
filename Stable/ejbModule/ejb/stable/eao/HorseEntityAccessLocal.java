package ejb.stable.eao;

import javax.ejb.Local;

import ejb.stablepkg.Horse;

@Local
public interface HorseEntityAccessLocal {

	public Horse findByHorseNumber(long horseNumber);
	public Horse createHorse(Horse horse);
	public Horse updateHorse(Horse horse);
	public void deleteHorse(long horseNumber);
}
