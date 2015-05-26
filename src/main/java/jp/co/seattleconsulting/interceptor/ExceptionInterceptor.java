package jp.co.seattleconsulting.interceptor;




import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

/**
 *
 * @author Endo
 */
public class ExceptionInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	public static final String LOGFILE = "Error.log";

	private static final Logger logger = Logger.getLogger(ExceptionInterceptor.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		try {
			return invocation.proceed();
		} catch(Exception ex) {

			// 設定ファイルを読み込む
			PropertyConfigurator.configure("C:/pleiades/workspace/relationship-building/src/main/resources/log4j.properties");

			logger.error(ex + "のエラーが発生しました。");

			return "/error.jsp";
		}
	}
}