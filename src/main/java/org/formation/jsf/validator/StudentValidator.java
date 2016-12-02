package org.formation.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class StudentValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent arg1, Object arg2) throws ValidatorException {
		String mail = (String) arg2;

		if (mail != null) {
			int result1 = mail.indexOf("@");
			int result2 = mail.indexOf(".");
			if ((result1 == -1) && (result2 == -1)) {

				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Adresse email invalide, format exigé xxx@xxx.xx",
						"Adresse email invalide, format exigé xxx@xxx.xx"));
			}

			}

		}

	}


