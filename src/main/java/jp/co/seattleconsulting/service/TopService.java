package jp.co.seattleconsulting.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.co.seattleconsulting.constant.RelationshipConstant;
import jp.co.seattleconsulting.entity.Employees;

/**
 * @author user
 *
 */
public class TopService extends RelationshipService{


    /**
     * 論理削除されていないレコードの件数を返します。
     *
     * @return 論理削除されていないレコード数
     */
    public int getCountOfActive() {
    	List<Employees> employees = findAll();
		List<Employees> activeEmployees = new ArrayList<Employees>();
		for(Employees employee: employees){
			if(employee.deleteFlag == RelationshipConstant.DELETED) {
				continue;
			} else {
				activeEmployees.add(employee);
			}
		}
        return activeEmployees.size();
    }

    /**
     * 話したことのある社員数を返す.
     *
     * @return 話したことのある社員数
     */
	public int getCountOfTalked() {
    	List<Employees> employees = findAll();
		List<Employees> talkedEmployees = new ArrayList<Employees>();
		for(Employees employee: employees){
			if(employee.deleteFlag == RelationshipConstant.DELETED || employee.status == 0) {
				continue;
			} else {
				talkedEmployees.add(employee);
			}
		}
		return talkedEmployees.size();
	}

	/**
	 * 話したことのない社員数を返す.
	 *
	 * @return 話したことのない社員数
	 */
	public int getCountOfNotTalked() {
    	List<Employees> employees = findAll();
		List<Employees> NottalkedEmployees = new ArrayList<Employees>();
		for(Employees employee: employees){
			if(employee.deleteFlag == RelationshipConstant.DELETED || employee.status == 1) {
				continue;
			} else {
				NottalkedEmployees.add(employee);
			}
		}
		return NottalkedEmployees.size();
	}

	/**
	 * 論理削除されたレコードを除いた全体の社員数に対して、話したことある社員数の割合を返す.
	 *
	 * @return 全体に占める話したことのある社員数の割合
	 */
	public double getParcentageOfTalked() {
		float parcentageOfTalkedBefore = getCountOfTalked() / (float)getCountOfActive() * 100;
		BigDecimal bd = new BigDecimal(String.valueOf(parcentageOfTalkedBefore));
		double parcentageOfTalked = bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
		return parcentageOfTalked;
	}

	/**
	 * 論理削除されたレコードを除いた全体の社員数に対して、話したことのない社員数の割合を返す.
	 *
	 * @return 全体に占める話したことのない社員数の割合
	 */
	public double getParcentageOfNotTalked() {
		float parcentageOfNotTalkedBefore = getCountOfNotTalked() / (float)getCountOfActive() * 100;
		BigDecimal bd = new BigDecimal(String.valueOf(parcentageOfNotTalkedBefore));
		double parcentageOfNotTalked = bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
		return parcentageOfNotTalked;
	}

}
