package jp.co.seattleconsulting.dto;

import java.util.ArrayList;
import java.util.List;

import jp.co.seattleconsulting.entity.Employees;

/**
 * relationship-buildingのDtoクラス
 *
 * @author Endo
 */
public class RelationshipViewDto {

	public List<RelationshipDto> relationshipDtos = new ArrayList<>();

	public static class RelationshipDto {
		public RelationshipDto() {}

		public RelationshipDto(Integer empNo, String empName, String empFurigana, String birthday, String tel, String note,Integer deleteFlag, Integer status) {
			this.empNo = empNo;
			this.empName = empName;
			this.empFurigana = empFurigana;
			this.birthday = birthday;
			this.tel = tel;
			this.note = note;
			this.deleteFlag = deleteFlag;
			this.status = status;
		}

		public RelationshipDto(Employees employees) {
			this.empNo = employees.empNo;
			this.empName = employees.empName;
			this.empFurigana = employees.empFurigana;
			this.birthday = employees.birthday;
			this.tel = employees.tel;
			this.note = employees.note;
			this.deleteFlag = employees.deleteFlag;
			this.status = employees.status;
		}

		public Integer empNo;
		public String empName;
		public String empFurigana;
		public String birthday;
		public String tel;
		public String note;
		public Integer deleteFlag;
		public Integer status;

		public String birthYear;
		public String birthMonth;
		public String birthDay;
	}



}
