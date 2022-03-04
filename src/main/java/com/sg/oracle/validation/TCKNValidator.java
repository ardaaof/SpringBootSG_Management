package com.sg.oracle.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import com.sg.oracle.sg_management.utility.Util;

public class TCKNValidator implements Validator {

    private static final int TCKN_DIGIT = 11;
    private static final FacesMessage ERROR_TCKN_DIGIT = new FacesMessage("TCKN "+TCKN_DIGIT+" HANELI OLMALIDIR");
    private static final FacesMessage ERROR_TCKN_NEGATIVE = new FacesMessage("TCKN NEGATIF OLAMAZ.");
    private static final FacesMessage ERROR_TCKN_FORMAT = new FacesMessage("TC format error.");
    private static final FacesMessage ERROR_TCKN_ALGORITHM = new FacesMessage("TCKN ALGORITMASINA UYGUN OLMAYAN VERI GIRILEMEZ.");


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String strTCKN = value.toString();
        Long TCKN = Long.parseLong(strTCKN);
        try {
            if (TCKN<0)
            {
                throw new ValidatorException(ERROR_TCKN_NEGATIVE);
            }
            else if (strTCKN.length()!=TCKN_DIGIT)
            {
                throw new ValidatorException(ERROR_TCKN_DIGIT);
            }
            else if (!Util.isValidTCKN(strTCKN))
            {
                throw new ValidatorException(ERROR_TCKN_ALGORITHM);
            }
        }
        catch (NumberFormatException e)
        {
            throw new ValidatorException(ERROR_TCKN_FORMAT);
        }

        /*if (tcknString.length() != 11) {
            throw new ValidatorException(ERROR_11HANE);
        } else if (tcknLong < 0) {
            throw new ValidatorException(ERROR_NEGATIVE);
        } else if (!com.sg.oracle.sg_management.utility.Util.isValidTCKN(tcknString)) {
            throw new ValidatorException(ERROR_GECERSIZ_TC);
        }
         */

    }
}
