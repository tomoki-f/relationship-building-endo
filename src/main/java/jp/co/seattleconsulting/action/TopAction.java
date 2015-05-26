/**
 *
 */
package jp.co.seattleconsulting.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.dto.LoginDto;
import jp.co.seattleconsulting.service.TopService;

import org.seasar.struts.annotation.Execute;

/**
 * TOP画面で行われる処理の制御を行うクラス.
 *
 * @author Endo
 */
public class TopAction {

	@Resource
	protected TopService topService;

	public LoginDto loginDto;

	public int countOfActive;
	public int countOfTalked;
	public int countOfNotTalked;
	public double parcentageOfTalked;
	public double parcentageOfNotTalked;

	/**
	 * TOP画面に遷移する.
	 *
	 * @return TOP画面のパス
	 */
	@Execute(validator = false)
	public String index() {
		countOfActive = topService.getCountOfActive();
		countOfTalked = topService.getCountOfTalked();
		countOfNotTalked = topService.getCountOfNotTalked();
		parcentageOfTalked = topService.getParcentageOfTalked();
		parcentageOfNotTalked = 100 - topService.getParcentageOfTalked();

		return "top.jsp";
	}
}
