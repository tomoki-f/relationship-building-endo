package jp.co.seattleconsulting.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.dto.LoginDto;
import jp.co.seattleconsulting.entity.Login;
import jp.co.seattleconsulting.form.LoginForm;
import jp.co.seattleconsulting.service.LoginService;

import org.seasar.framework.beans.util.Beans;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

/**
 * @author user
 *
 */
public class LoginAction {

	@ActionForm
	@Resource
	protected LoginForm loginForm;

	@Resource
	protected LoginService loginService;

	public LoginDto loginDto;

	@Required
	public String userName;

	@Required
	public String password;

	public String message;

	private boolean errorMessage;

	@Execute(validator = false)
	public String index() {

		if(errorMessage == true) {
			message = "ユーザー名またはパスワードが違います。";
			errorMessage = false;

		}
		 return "login.jsp";
	 }

	@Execute(redirect=true, validator = true, input = "login.jsp")
	public String login() {

		String returnUrl;

		// 入力パラメータ
		userName = loginForm.userName;
		password = loginForm.password;
		//loginDto.userName = userName;

		// ユーザ情報取得
		Login user = loginService.findByNameAndPassword(userName, password);



		// ログイン成功した場合
		if(user != null) {

			// 遷移先判定
			returnUrl = "/top/";

			LoginDto loginDto = SingletonS2Container.getComponent(LoginDto.class);

			Beans.copy(user, loginDto).execute();

			loginDto.isLogin = true;

		// ログインエラー
		}else {

			errorMessage = true;

			returnUrl = "index";

		}

		return returnUrl;
	}

	@Execute(validator = false)
	public String timeout() {
		return "/login/timeout.jsp";
	}

	@Execute(validator = false)
	public String goToLogin() {
		return "/login/";
	}
}
