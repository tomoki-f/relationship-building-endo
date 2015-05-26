package jp.co.seattleconsulting.action;

import javax.annotation.Resource;

import jp.co.seattleconsulting.dto.RegisterEmpDto;
import jp.co.seattleconsulting.form.RegisterEmpForm;
import jp.co.seattleconsulting.service.RegisterEmpService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


/**
 * 新規登録の制御を行うクラス.
 *
 * @author Endo
 *
 */
public class RegisterEmpAction {

	@ActionForm
	@Resource
	public RegisterEmpForm registerEmpForm;

	@Resource
	protected RegisterEmpService registerEmpService;

	public RegisterEmpDto registerEmpDto;

	/**
	 * 社員情報の新規登録画面に遷移する.
	 *
	 * @return 新規登録画面
	 */
	@Execute(validator = false)
	public String index() {
		return "register.jsp";
	}

	/**
	 * 社員情報の新規登録確認画面に遷移する.
	 *
	 * @return 新規登録の確認画面のパス
	 */
	@Execute(validator = true, input="/registerEmp/")
	public String goToConfirmation() {

		return "confirmation.jsp";
	}

	/**
	 * Dtoクラスにフォームから得た値を格納して、新規登録完了画面に遷移する.
	 *
	 * @return 新規登録の完了画面のパス
	 */
	@Execute(validator = false)
	public String goToComplete() {

		RegisterEmpDto registerEmpDto = new RegisterEmpDto();
		registerEmpDto.empName = registerEmpForm.empName;
		registerEmpDto.empFurigana = registerEmpForm.empFurigana;
		registerEmpDto.birthYear = registerEmpForm.birthYear;
		registerEmpDto.birthMonth = registerEmpForm.birthMonth;
		registerEmpDto.birthDay = registerEmpForm.birthDay;
		registerEmpDto.birthday = registerEmpForm.birthYear + "/" + registerEmpForm.birthMonth + "/" + registerEmpForm.birthDay;
		registerEmpDto.tel = registerEmpForm.tel;
		registerEmpDto.note = registerEmpForm.note;
		registerEmpDto.status = registerEmpForm.status;

		registerEmpService.insert(registerEmpDto);

		return "complete.jsp";
	}
}
