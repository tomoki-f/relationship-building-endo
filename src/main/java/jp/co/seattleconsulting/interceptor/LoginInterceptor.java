package jp.co.seattleconsulting.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import jp.co.seattleconsulting.dto.LoginDto;
import jp.co.seattleconsulting.service.LoginService;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.struts.annotation.Execute;

/**
 * @author user
 *
 */
public class LoginInterceptor extends AbstractInterceptor {

	@Resource
    protected LoginService loginService;

	@Resource
	protected LoginDto loginDto;

	private static final long serialVersionUID = 1L;

	public HttpSession session;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {


		try {
			loginDto = SingletonS2Container.getComponent(LoginDto.class);

			// 実行メソッドではない もしくは ログインセッションあり
			if(!isExecuteMethod(invocation) || isLoggedIn(loginDto)) {
				return invocation.proceed();
			}else if(session.isNew()){
				return "/login/timeout";
			} else {
				return "/login/";
			}
		} catch (ClassCastException e) {
			return "/login/";
		}
	}

	/**
	 * 実行メソッドかどうかを判断
	 * @param invocation
	 * @return true:実行メソッド  false:実行メソッドではない
	 */
	private boolean isExecuteMethod(MethodInvocation invocation) {
		return invocation.getMethod().isAnnotationPresent(Execute.class);
	}

	/**
	 *セッション上にDtoがあるか、あった場合はisLoginがtrueか。
	 * @param loginDto
	 * @return 上記の条件を満たしていればtrue
	 */
	private boolean isLoggedIn(LoginDto loginDto) {

		// Sessionにユーザー情報が登録されているかチェック
		return (loginDto != null && loginDto.isLogin);
	}
}
