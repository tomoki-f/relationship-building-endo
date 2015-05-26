package jp.co.seattleconsulting.action;

import org.seasar.framework.aop.annotation.InvalidateSession;
import org.seasar.struts.annotation.Execute;

/**
 * ログイン情報を保持しているセッションを破棄し、ログアウトする.
 *
 * @author Endo
 */
public class LogoutAction {

	/**
	 * ログインしているユーザー情報を破棄してログイン画面に遷移する.
	 *
	 * @return ログイン画面のパス
	 */
	@Execute(validator = false, redirect = true)
	@InvalidateSession
	public String index() {
		return "/login/";
	}
}
