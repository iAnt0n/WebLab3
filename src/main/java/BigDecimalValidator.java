import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.math.BigDecimal;
import java.util.Map;

@FacesValidator("bigDecimalValidator")
public class BigDecimalValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        final Map<String, Object> attributes = uiComponent.getAttributes();
        final BigDecimal min = new BigDecimal(attributes.get("min").toString());
        final BigDecimal max = new BigDecimal(attributes.get("max").toString());
        final FacesMessage msg = new FacesMessage(String.format("Y must be in (%s; %s)", min.toString(), max.toString()));
        BigDecimal value = new BigDecimal(o.toString());
        if (value.compareTo(min) <= 0 || value.compareTo(max) >= 0) {
            throw new ValidatorException(msg);
        }
    }
}

