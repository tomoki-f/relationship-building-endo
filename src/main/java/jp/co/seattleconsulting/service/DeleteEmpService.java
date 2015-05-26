/**
 *
 */
package jp.co.seattleconsulting.service;

import java.sql.Timestamp;

import jp.co.seattleconsulting.constant.RelationshipConstant;
import jp.co.seattleconsulting.dto.DeleteEmpDto;
import jp.co.seattleconsulting.entity.Employees;

/**
 * @author user
 *
 */
public class DeleteEmpService extends RelationshipService{

	protected RelationshipConstant relationshipConstant;

	/**
	 * 指定された従業員番号をもとに１つの社員データを獲得する.
	 *
	 * @param empNo
	 * @return 社員データ
	 */
	public DeleteEmpDto getDtoById(Integer empNo) {
		Employees employee = findById(empNo);
		DeleteEmpDto deleteEmpDto = new DeleteEmpDto(employee);

		return deleteEmpDto;
	}

	/**
	 * 論理削除のステータスを削除状態にする.
	 *
	 * @param empNo
	 * @return 更新されたEntityをDBで更新する処理
	 */
	public int delete(Integer empNo) {
		Employees entity = findById(empNo);
		entity.deleteFlag = RelationshipConstant.DELETED;
		entity.updateDate = new Timestamp(System.currentTimeMillis());

		return update(entity);
	}
}
