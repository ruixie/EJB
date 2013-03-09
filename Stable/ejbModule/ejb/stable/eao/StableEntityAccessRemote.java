package ejb.stable.eao;

import javax.ejb.Remote;

import ejb.stablepkg.Stable;

@Remote
public interface StableEntityAccessRemote {
	public Stable findByStableNumber(long stableNumber);
	public Stable createStable(Stable stable);
	public Stable updateStable(Stable stable);
	public void deleteStable(long stableNumber);


}
