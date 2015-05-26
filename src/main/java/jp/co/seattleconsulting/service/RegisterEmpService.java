/**
 *
 */
package jp.co.seattleconsulting.service;

import java.sql.Timestamp;

import jp.co.seattleconsulting.constant.RelationshipConstant;
import jp.co.seattleconsulting.dto.RegisterEmpDto;
import jp.co.seattleconsulting.entity.Employees;

/**
 * @author user
 *
 */
public class RegisterEmpService extends RelationshipService{

	protected RelationshipConstant relationshipConstant;


	/**
	 * Dtoクラスに格納している情報をEntityに格納する.
	 *
	 * @param registerEmpDto
	 * @return DBにEntityを格納する処理
	 */
	public int insert(RegisterEmpDto registerEmpDto) {
		Employees entity = new Employees();
		entity.empName = registerEmpDto.empName;
		entity.empFurigana = registerEmpDto.empFurigana;
		entity.birthday = registerEmpDto.birthday;
		entity.tel = registerEmpDto.tel;
		entity.note = registerEmpDto.note;
		entity.status = registerEmpDto.status;
		entity.deleteFlag = RelationshipConstant.ACTIVE;
		entity.registrationDate = new Timestamp(System.currentTimeMillis());
		entity.updateDate = new Timestamp(System.currentTimeMillis());

		return insert(entity);
	}

}
