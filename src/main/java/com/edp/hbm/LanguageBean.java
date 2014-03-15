package com.edp.hbm;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "languageMBean")
@SessionScoped
public class LanguageBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1400222915795226683L;

	private Locale locale;
	private String language;

	@PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        language = locale.getLanguage(); 
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
    	language = locale.getLanguage(); 
        return language;
    }

    public void setLanguage(String language) {
    	this.language = language;
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

}
