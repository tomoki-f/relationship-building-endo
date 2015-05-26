package jp.co.seattleconsulting.service;

import jp.co.seattleconsulting.entity.Employees;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

/**
 * relationship-buildingの処理クラス
 *
 * @author Endo
 */
public class RelationshipService extends S2AbstractService<Employees>{

	/**
	 * DBからId検索で１件のレコードを取得する.
	 *
	 * @param empNo
	 * @return １件のEntity
	 */
	public Employees findById(Integer empNo) {
		return select().id(empNo).getSingleResult();
	}

	public long getActiveCount() {

		return select().where(new SimpleWhere().eq("deleteFlag", 0)).getCount();
	}
}
