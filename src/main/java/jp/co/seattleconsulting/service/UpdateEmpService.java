/**
 *
 */
package jp.co.seattleconsulting.service;

import java.sql.Timestamp;

import jp.co.seattleconsulting.dto.UpdateEmpDto;
import jp.co.seattleconsulting.entity.Employees;

/**
 * @author user
 *
 */
public class UpdateEmpService extends RelationshipService{

	/**
	 * 指定された従業員番号をもとに１つの社員データを獲得する.
	 *
	 * @param empNo
	 * @return 社員データ
	 */
	public UpdateEmpDto getDtoById(Integer empNo) {
		Employees employee = findById(empNo);
		UpdateEmpDto updateEmpDto = new UpdateEmpDto(employee);

		return updateEmpDto;
	}


	/**
	 * Dtoで運ばれてきた値をEntityに上書きする.
	 *
	 * @param empNo
	 * @param updateEmpDto
	 * @return 更新されたEntityをDBで更新する処理
	 */
	public int update(Integer empNo, UpdateEmpDto updateEmpDto) {
		Employees entity = findById(empNo);
		entity.empName = updateEmpDto.empName;
		entity.empFurigana = updateEmpDto.empFurigana;
		entity.birthday = updateEmpDto.birthday;
		entity.tel = updateEmpDto.tel;
		entity.note = updateEmpDto.note;
		entity.status = updateEmpDto.status;
		entity.updateDate = new Timestamp(System.currentTimeMillis());

		return update(entity);
	}

}
