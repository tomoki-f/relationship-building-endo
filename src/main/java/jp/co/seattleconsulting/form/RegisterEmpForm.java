package jp.co.seattleconsulting.form;

import java.io.Serializable;

import jp.co.seattleconsulting.dto.RelationshipViewDto.RelationshipDto;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

/**
 * 新規社員情報登録時にクライアントサイドから値を得る.
 *
 * @author Endo
 */
@Component(instance = InstanceType.SESSION)
public class RegisterEmpForm implements Serializable{
    private static final long serialVersionUID = 1L;

	public RelationshipDto relationshipDto;

	public Integer empNo;

	@Required
	@Maxlength(maxlength=50)
	public String empName;

	@Mask(mask = "^[\u30A0-\u30FF]+$", msg = @Msg(key = "errors.katakana"))
	@Maxlength(maxlength=50)
	public String empFurigana;

	public String birthYear;

	public String birthMonth;

	public String birthDay;

	@Mask(mask = "^\\d{2,3}-\\d{2,4}-\\d{4}$", msg = @Msg(key = "errors.phone"))
	@Maxlength(maxlength=13)
	public String tel;

	@Maxlength(maxlength=400)
	public String note;

	public Integer status;

}
