package jp.co.seattleconsulting.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * @author user
 *
 */
@Component(instance = InstanceType.SESSION)
public class LoginDto implements Serializable {
    private static final long serialVersionUID = 1L;
    public String userName;
    public String password;
    public boolean isLogin = false;
}