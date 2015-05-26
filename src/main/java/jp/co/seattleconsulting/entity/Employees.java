/**
 *
 */
package jp.co.seattleconsulting.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author user
 *
 */
@Entity
@Table(name = "employees")
public class Employees {

	/**
	 *
	 */
	@Id
	@GeneratedValue
	@Column(name = "emp_no")
	public Integer empNo;
	/**
	 *
	 */
	@Column(name = "emp_name")
	public String empName;
	/**
	 *
	 */
	@Column(name = "emp_furigana")
	public String empFurigana;
	/**
	 *
	 */
	public String birthday;
	/**
	 *
	 */
	public String tel;
	/**
	 *
	 */
	public String note;
	/**
	 *
	 */
	@Column(name = "delete_flag")
	public Integer deleteFlag;
	/**
	 *
	 */
	public Integer status;
	/**
	 *
	 */
	@Column(name = "registration_date")
	public Timestamp registrationDate;
	/**
	 *
	 */
	@Column(name = "update_date")
	public Timestamp updateDate;

	/**
	 * @return empNo
	 */
	public Integer getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo セットする empNo
	 */
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName セットする empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return empFurigana
	 */
	public String getEmpFurigana() {
		return empFurigana;
	}

	/**
	 * @param empFurigana セットする empFurigana
	 */
	public void setEmpFurigana(String empFurigana) {
		this.empFurigana = empFurigana;
	}

	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel セットする tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note セットする note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return deleteFlag
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag セットする deleteFlag
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status セットする status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return registrationDate
	 */
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate セットする registrationDate
	 */
	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}
