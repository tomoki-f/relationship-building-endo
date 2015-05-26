<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
<link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
	<div class="header">
		<tiles:insert template="/WEB-INF/view/common/header.jsp" flush="true" />
	</div>
	${link}
	<s:form>
		<input type="text" name="keywords" id="serchBar" value="${displayEmpForm.keywords}">
		<input type="submit" name="searchEmp" id="searchButton" value="検索">
	</s:form>
	<div id="index">
		<table>
			<tr>
				<td>名前</td>
				<td>生年月日</td>
				<td>電話番号</td>
				<td>会話</td>
				<td></td>
			</tr>
			<c:forEach var="employee"
				items="${displayEmpDtos}">
				<tr>
					<s:form>
						<td><input type="submit" class="detail_btn" name="goToDetail"
							value="${employee.empName}"></td>
						<td>${employee.birthday}</td>
						<td>${employee.tel}</td>
						<td><script>if(${employee.status} == 1) {document.write("✔");} else { document.write("");}</script></td>
						<td><input type="submit" name="goToUpdate" value="更新"><input
							type="hidden" name="empNo" value="${employee.empNo}"><input
							type="submit" name="goToDelete" value="削除"></td>
					</s:form>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${displayEmpDtos.size()==0}">
			<p>該当するデータが見つかりません</p>
		</c:if>
	</div>
	<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true" />
</body>
</html>