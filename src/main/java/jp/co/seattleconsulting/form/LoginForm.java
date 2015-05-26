package jp.co.seattleconsulting.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

/**
 * @author user
 *
 */
@Component(instance = InstanceType.SESSION)
public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Required
	@Mask(mask = "takayuki15", msg = @Msg(key = "errors.userName"))
	public String userName;

	@Required
	@Mask(mask = "ySvHVnK4", msg = @Msg(key = "errors.password"))
	public String password;


}
