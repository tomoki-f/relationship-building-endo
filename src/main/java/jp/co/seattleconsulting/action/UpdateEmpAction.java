package jp.co.seattleconsulting.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.dto.UpdateEmpDto;
import jp.co.seattleconsulting.form.UpdateEmpForm;
import jp.co.seattleconsulting.service.UpdateEmpService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 社員情報更新処理の制御を行う.
 *
 * @author Endo
 */
public class UpdateEmpAction {

	@ActionForm
	@Resource
	protected UpdateEmpForm updateEmpForm;

	@Resource
	protected UpdateEmpService updateEmpService;

	public UpdateEmpDto updateEmpDto;

	public String birthYear;

	public String birthMonth;

	public String birthDay;

	/**
	 * 既にDBに格納されている値を取得し、更新画面に遷移する.
	 *
	 * @return 更新画面のパス
	 */
	@Execute(validator = false)
	public String index() {
		updateEmpDto = updateEmpService.getDtoById(updateEmpForm.empNo);
		String[] birthday = updateEmpDto.birthday.split("/");
		birthYear = birthday[0];
		birthMonth = birthday[1];
		birthDay = birthday[2];
		return "update.jsp";
	}

	@Execute(validator = true, input="/updateEmp/")
	public String goToConfirmation() {
		return "confirmation.jsp";
	}

	/**
	 * 更新処理を制御し、更新完了画面に遷移する.
	 *
	 * @return 更新完了画面のパス
	 */
	@Execute(validator = false)
	public String goToComplete() {
		UpdateEmpDto updateEmpDto = new UpdateEmpDto();
		updateEmpDto.empName = updateEmpForm.empName;
		updateEmpDto.empFurigana = updateEmpForm.empFurigana;
		updateEmpDto.birthday = updateEmpForm.birthYear + "/" + updateEmpForm.birthMonth + "/" + updateEmpForm.birthDay;
		updateEmpDto.tel = updateEmpForm.tel;
		updateEmpDto.note = updateEmpForm.note;
		updateEmpDto.status = updateEmpForm.status;

		updateEmpService.update(updateEmpForm.empNo,updateEmpDto);

		return "complete.jsp";
	}

}
