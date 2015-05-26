package jp.co.seattleconsulting.action;

import java.util.List;

import javax.annotation.Resource;

import jp.co.seattleconsulting.dto.DisplayEmpDto;
import jp.co.seattleconsulting.entity.Employees;
import jp.co.seattleconsulting.form.DisplayEmpForm;
import jp.co.seattleconsulting.service.DisplayEmpService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author user
 *
 */
public class DisplayEmpAction {

	@ActionForm
	@Resource
	public DisplayEmpForm displayEmpForm;

	@Resource
	protected DisplayEmpService displayEmpService;

	public List<DisplayEmpDto> displayEmpDtos;

	public DisplayEmpDto displayEmpDto;

	public List<Employees> employees;

	public String link;


	/**
	 * 一覧表示画面に遷移する.
	 *
	 * @return 一覧表示画面のパス
	 */
	@Execute(validator = false)
	public String index() {

		return "page/1";
	}

	@Execute(validator = false, urlPattern = "page/{pageno}")
	public String page() {

		final int PER_PAGE = 10;
		int totalEmp = (int)displayEmpService.getActiveCount();
		link = makePagingLink(Integer.parseInt(displayEmpForm.pageno), totalEmp, PER_PAGE);
		displayEmpDtos = displayEmpService.createDto(displayEmpService.selectPerPage(displayEmpForm.pageno));

		return "index.jsp";
	}

	private String makePagingLink(int currentPageNo, int totalEmp, int perPage) {

		int pageNum = (int)Math.ceil(totalEmp / (float)perPage);
		String[] links = new String[pageNum];

		for(int i = 1; i <= pageNum; i++) {
			if(i == currentPageNo) {
				links[i-1] = String.format("<span class='pagelink-fontsize'><b>%d</b></span>", currentPageNo);
			} else {
				links[i-1] = String.format("<<a class='pagelink-fontsize' title='Page %d' href='/relationship-building/displayEmp/page/%d'>%d</a>", i, i, i);
			}
		}
		return implode(" ", links);
	}

	private String makePagingSearchedLink(int currentPageNo, int totalEmp, int perPage) {

		int pageNum = (int)Math.ceil(totalEmp / (float)perPage);
		String[] links = new String[pageNum];

		for(int i = 1; i <= pageNum; i++) {
			if(i == currentPageNo) {
				links[i-1] = String.format("<span class='pagelink-fontsize'><b>%d</b></span>", currentPageNo);
			} else {
				links[i-1] = String.format("<<a class='pagelink-fontsize' title='Page %d' href='/relationship-building/displayEmp/search/%d'>%d</a>", i, i, i);
			}
		}
		return implode(" ", links);
	}

	private static String implode(String glue, String[] pieces) {

		StringBuffer buf = new StringBuffer();
		for(int i = 0; i < pieces.length; i++) {
			buf.append(pieces[i]);
			if(i == pieces.length -1) {
				break;
			}
			buf.append(glue);
		}
		return buf.toString();
	}

	@Execute(validator = false)
	public String searchEmp() {

		return "search/1";
	}

	@Execute(validator = false, urlPattern = "search/{pageno}")
	public String search() {

		final int PER_PAGE = 10;
		long totalEmp = displayEmpService.getSerchedCount(displayEmpForm.keywords);
		link = makePagingSearchedLink(Integer.parseInt(displayEmpForm.pageno), (int)totalEmp, PER_PAGE);
		displayEmpDtos = displayEmpService.getDtoByKeywords(displayEmpForm.keywords);

		return "index.jsp";
	}


	/**
	 * 社員情報更新画面に遷移する.
	 *
	 * @return 更新画面のパス
	 */
	@Execute(validator = false)
	public String goToUpdate() {
		return "/updateEmp?empNo=" + displayEmpForm.empNo + "&redirect=true";
	}

	/**
	 * 削除画面に遷移する.
	 *
	 * @return 削除画面のパス
	 */
	@Execute(validator = false)
	public String goToDelete() {
		return "/deleteEmp?empNo=" + displayEmpForm.empNo + "&redirect=true";
	}

	/**
	 * 社員情報の詳細画面に遷移する.
	 *
	 * @return 詳細画面のパス
	 */
	@Execute(validator = false)
	public String goToDetail() {
		displayEmpDto = displayEmpService.getDtoById(displayEmpForm.empNo);
		return "detail.jsp";
	}
}
