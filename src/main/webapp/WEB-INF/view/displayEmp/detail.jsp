<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
<link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
	<h1>詳細</h1>
	<table>
		<tr>
			<th>名前：</th>
			<td>${displayEmpDto.empName}</td>
		</tr>
		<tr>
			<th>フリガナ：</th>
			<td>${displayEmpDto.empFurigana}</td>
		</tr>
		<tr>
			<th>生年月日：</th>
			<td>${displayEmpDto.birthday}</td>
		</tr>
		<tr>
			<th>電話番号：</th>
			<td>${displayEmpDto.tel}</td>
		</tr>
		<tr>
			<th>ノート：</th>
			<td>${displayEmpDto.note}</td>
		</tr>
		<tr>
			<th>この社員さんと：</th>
			<td><script>if(${displayEmpDto.status} == 0) {document.write("話していない")} else {document.write("話した")}</script></td>
		</tr>
	</table>
	<a href="javascript:history.back();"><input type="button" value="戻る"></a>
	<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true" />
</body>
</html>