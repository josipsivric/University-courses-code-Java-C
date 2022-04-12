package hr.fer.zemris.java.hw08.local;

public interface ILocalizationProvider {
	
	public void addLocalizationListener(ILocalizationListener loc);
	
	public void removeLocalizationListener(ILocalizationListener loc);
	
	public String getString(String key);
}
