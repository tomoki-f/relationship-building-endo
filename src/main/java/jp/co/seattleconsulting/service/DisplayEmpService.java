package jp.co.seattleconsulting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.co.seattleconsulting.constant.RelationshipConstant;
import jp.co.seattleconsulting.dto.DisplayEmpDto;
import jp.co.seattleconsulting.entity.Employees;

import org.seasar.extension.jdbc.where.ComplexWhere;
import org.seasar.extension.jdbc.where.SimpleWhere;

/**
 * @author user
 *
 */
public class DisplayEmpService extends RelationshipService {

	protected RelationshipConstant relationshipConstant;

	/**
	 * 指定された従業員番号をもとに１つの社員データを獲得する.
	 *
	 * @param empNo
	 * @return 社員データ
	 */
	public DisplayEmpDto getDtoById(Integer empNo) {
		Employees employee = findById(empNo);
		DisplayEmpDto displayEmpDto = new DisplayEmpDto(employee);

		return displayEmpDto;
	}

	/**
	 * DBから全てのレコードを引き出し、論理削除をするかどうかの判断をする.
	 *
	 * @return 論理削除されていないEntityを格納したDtoインスタンス
	 */
	public List<DisplayEmpDto> getActiveDto() {
		List<Employees> employees = findAll();
		List<Employees> activeEmployees = new ArrayList<Employees>();
		for(Employees employee: employees){
			if(employee.deleteFlag == RelationshipConstant.DELETED) {
				continue;
			} else {
				activeEmployees.add(employee);
			}
		}
		List<DisplayEmpDto> displayEmpDtos = createDto(activeEmployees);
		return displayEmpDtos;
	}

	/**
	 * EntityをDtoインスタンスに格納する.
	 *
	 * @param employees
	 * @return Entityが格納されたDtoインスタンス
	 */
	public List<DisplayEmpDto> createDto(List<Employees> employees) {
		List<DisplayEmpDto> displayEmpDtos = new ArrayList<DisplayEmpDto>();
		for(Employees employee: employees) {
			DisplayEmpDto displayEmpDto = new DisplayEmpDto(employee);
			displayEmpDtos.add(displayEmpDto);
		}
		return displayEmpDtos;
	}

	/**
	 * EntityをDtoインスタンスに格納する.
	 *
	 * @param employees
	 * @return Entityが格納されたDtoインスタンス
	 */
	private List<DisplayEmpDto> createDto(Map<Integer, Employees> employees) {
		List<DisplayEmpDto> displayEmpDtos = new ArrayList<DisplayEmpDto>();
		for (Integer key : employees.keySet()) {
	        DisplayEmpDto displayEmpDto = new DisplayEmpDto(employees.get(key));
	        displayEmpDtos.add(displayEmpDto);
	    }

		return displayEmpDtos;
	}


	/**
	 * 編集途中
	 *
	 * @param keywords
	 * @return
	 */
	public List<DisplayEmpDto> getDtoByKeywords(String keywords) {
		Map<Integer, Employees> selectedEmployees = findByKeywords(keywords);
		List<DisplayEmpDto> displayEmpDtos = createDto(selectedEmployees);
		return displayEmpDtos;
	}


	public Map<Integer, Employees> findByKeywords(String keyword) {
		String[] keywords = keyword.split(" ");

		Map<Integer, Employees> selectedEmployees = new TreeMap<Integer, Employees>();

		for(int i = 0; i < keywords.length; i++){
			List<Employees> employees =
					select()
					.where(
						    new ComplexWhere()
						      .contains("empName", keywords[i])
						      .or().contains("empFurigana", keywords[i])
						      .or().contains("birthday", keywords[i])
						      .or().contains("tel", keywords[i])
						      .or().contains("note", keywords[i])
						    , new SimpleWhere()
						      .eq("deleteFlag", 0)).getResultList();

			for(Employees employee: employees) {
				selectedEmployees.put(employee.empNo, employee);
			}
		}
		return selectedEmployees;
	}

	public List<Employees> selectPerPage(String pageno) {

		final int PER_PAGE = 10;
		return select()
				.where(new SimpleWhere().eq("deleteFlag", 0))
				.orderBy("empNo")
				.limit(PER_PAGE)
				.offset((Integer.parseInt(pageno)-1)*PER_PAGE)
				.getResultList();
	}

	public long getSerchedCount(String keyword) {
		String[] keywords = keyword.split(" ");
		long numOfSerchedCount = 0;

		for(int i = 0; i < keywords.length; i++) {
			numOfSerchedCount +=
					select()
					.where(
						    new ComplexWhere()
						      .contains("empName", keywords[i])
						      .or().contains("empFurigana", keywords[i])
						      .or().contains("birthday", keywords[i])
						      .or().contains("tel", keywords[i])
						      .or().contains("note", keywords[i])
						    , new SimpleWhere()
						      .eq("deleteFlag", 0)).getCount();
		}
		return numOfSerchedCount;
	}
}
