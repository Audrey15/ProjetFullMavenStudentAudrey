package org.formation.jsf.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class LanguageController {

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	private String language = locale.getLanguage();

	public List<SelectItem> getLocales() {
		Iterator<Locale> locales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();

		List<SelectItem> ret = new ArrayList<SelectItem>();
		while (locales.hasNext()) {
			Locale l = locales.next();
			ret.add(new SelectItem(l.getLanguage(), l.getDisplayName(locale)));
		}
		return ret;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	// méthode pour changer la langue qui passe par la méthode de modification
	public String changeLanguage(String language) {
		updateLanguage(language);
		return "";
	}

	// Methode pour modifier la langue
	private void updateLanguage(String lang) {
		language = lang;
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		System.out.println("update " + lang);
	}

	// Méthode pour évenements 
	public void processMyChange(ValueChangeEvent evt) {
		updateLanguage(evt.getNewValue().toString());

	}
	
}
