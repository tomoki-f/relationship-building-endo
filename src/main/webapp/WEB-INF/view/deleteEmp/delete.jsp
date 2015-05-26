<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
  <link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
<h1>削除</h1>
<h2>以下の内容を削除します。</h2>
	<table>
		<tr>
			<th>名前：</th>
			<td>${deleteEmpDto.empName}</td>
		</tr>
		<tr>
			<th>フリガナ：</th>
			<td>${deleteEmpDto.empFurigana}</td>
		</tr>
		<tr>
			<th>生年月日：</th>
			<td>${deleteEmpDto.birthday}</td>
		</tr>
		<tr>
			<th>電話番号：</th>
			<td>${deleteEmpDto.tel}</td>
		</tr>
		<tr>
			<th>ノート：</th>
			<td>${deleteEmpDto.note}</td>
		</tr>
		<tr>
			<th>この社員さんと：</th>
			<td><script>if(${deleteEmpDto.status} == 0) {document.write("話していない")} else {document.write("話した")}</script></td>
		</tr>
	</table>
<s:form>
<input type="submit" name="goToComplete" value="削除">
<a href="javascript:history.back();"><input type="button" value="キャンセル"></a>
</s:form>
<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true"/>
</body>
</html>