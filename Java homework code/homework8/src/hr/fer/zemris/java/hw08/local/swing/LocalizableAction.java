package hr.fer.zemris.java.hw08.local.swing;

import hr.fer.zemris.java.hw08.local.ILocalizationListener;
import hr.fer.zemris.java.hw08.local.ILocalizationProvider;

import javax.swing.AbstractAction;
import javax.swing.Action;

public abstract class LocalizableAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ILocalizationProvider provider;
	private String key;
	private ILocalizationListener listener = new ILocalizationListener() {
		
		@Override
		public void localizationChanged() {
			updateText();
			
		}
	};
	
	
	public LocalizableAction(ILocalizationProvider provider, String key) {
		super();
		this.provider = provider;
		this.key = key;
		this.provider.addLocalizationListener(listener);
		updateText();
	}


	private void updateText() {
		this.putValue(Action.NAME, provider.getString(key));
	}
	
	
	
	

}
