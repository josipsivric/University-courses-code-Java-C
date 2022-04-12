package hr.fer.zemris.java.hw08.local;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLocalizationProvider implements
		ILocalizationProvider {
	
	List<ILocalizationListener> listeners = new ArrayList<ILocalizationListener>();

	@Override
	public void addLocalizationListener(ILocalizationListener loc) {
		if(!listeners.contains(loc))
			listeners.add(loc);

	}

	@Override
	public void removeLocalizationListener(ILocalizationListener loc) {
		if(listeners.contains(loc))
			listeners.remove(loc);
	}

	public void fire() {
		ILocalizationListener[] array = listeners.toArray(
				new ILocalizationListener[listeners.size()]
						);
		
		for(ILocalizationListener l : array)
			l.localizationChanged();
	}
}
