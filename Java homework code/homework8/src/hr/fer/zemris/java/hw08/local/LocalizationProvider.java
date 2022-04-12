package hr.fer.zemris.java.hw08.local;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationProvider extends AbstractLocalizationProvider {

	
	private static LocalizationProvider instance = new LocalizationProvider();
	private String language;
	private ResourceBundle bundle;
	
	private LocalizationProvider() {
		setLanguage("hr");
	}
	
	public static LocalizationProvider getInstance() {
		return instance;
	}
	
	public void setLanguage(String lang) {
		this.language = lang;
		Locale locale = Locale.forLanguageTag(this.language);
		this.bundle = ResourceBundle.getBundle(
				"hr.fer.zemris.java.tecaj_10.local.Poruke", 
				locale);
		
		fire();
	}
	
	
	@Override
	public String getString(String key) {
		try {
			return bundle.getString(key);
		}
		catch(Exception noResource) {
			return "$" + key + "$";
			}
	}

}
