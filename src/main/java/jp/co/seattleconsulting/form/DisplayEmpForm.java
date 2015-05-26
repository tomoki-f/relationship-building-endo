package jp.co.seattleconsulting.form;

import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Required;

/**
 * 社員の登録情報表示時にクライアントサイドから値を得る.
 *
 * @author Endo
 */
public class DisplayEmpForm {

	public Integer empNo;
	public String keywords;
	@Required
	@IntegerType
	public String pageno;
}
