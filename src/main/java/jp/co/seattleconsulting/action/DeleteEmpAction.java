package jp.co.seattleconsulting.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.dto.DeleteEmpDto;
import jp.co.seattleconsulting.form.DeleteEmpForm;
import jp.co.seattleconsulting.service.DeleteEmpService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 論理削除の制御を行うクラス.
 *
 * @author Endo
 */
public class DeleteEmpAction {

	@ActionForm
	@Resource
	protected DeleteEmpForm deleteEmpForm;

	@Resource
	protected DeleteEmpService deleteEmpService;

	public DeleteEmpDto deleteEmpDto;

	/**
	 * 削除確認画面に遷移する.
	 *
	 * @return 削除確認画面のパス
	 */
	@Execute(validator = false)
	public String index() {
		deleteEmpDto = deleteEmpService.getDtoById(deleteEmpForm.empNo);
		return "delete.jsp";
	}

	/**
	 * 論理削除処理を制御する.
	 *
	 * @return 削除完了画面のパス
	 */
	@Execute(validator = false)
	public String goToComplete() {
		deleteEmpService.delete(deleteEmpForm.empNo);

		return "complete.jsp";
	}
}
