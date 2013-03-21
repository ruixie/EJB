package ebj.eao;

import java.util.List;

import javax.ejb.Local;

import ejb.stablepkg.Stable;

@Local
public interface StableEntityAccessLocal {
	public Stable findByStableNumber(long stableNumber);
	public Stable createStable(Stable stable);
	public Stable updateStable(Stable stable);
	public void deleteStable(long stableNumber);
	public List<Stable> findAllStables();
}
