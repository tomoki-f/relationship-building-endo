<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
 <link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
	<div class="header"><tiles:insert template="/WEB-INF/view/common/header.jsp" flush="true"/></div>
<h1>確認</h1>
<p>以下の内容で登録します</p>
<p>名前：${f:h(empName)}</p>
<p>フリガナ：${f:h(empFurigana)}</p>
<p>生年月日：${f:h(birthYear)}/${f:h(birthMonth)}/${f:h(birthDay)}</p>
<p>電話番号：${f:h(tel)}</p>
<p>ノート：${f:h(note)}</p>
<p>この社員さんと：<script>if(${f:h(status)} == 0) {document.write("話していない")} else {document.write("話した")}</script></p>

<s:form>
<input type="submit" name="goToComplete" value="登録">
<a href="javascript:history.back();"><input type="button" value="戻る"></a>
</s:form>
<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true"/>
</body>
</html>