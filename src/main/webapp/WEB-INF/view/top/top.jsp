<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SeCoRe -トップ画面-</title>
  <link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
	<div class="header"><tiles:insert template="/WEB-INF/view/common/header.jsp" flush="true"/></div>
	<s:form>
	<h1>こんにちは${loginDto.userName}さん</h1>
	<div id="dashboard">
		<div id="talked">
			<p>あなたが話した人は全体の</p>
			<p>${parcentageOfTalked}％です</p>
		</div>
		<p>あなたが話していない人は全体の</p>
		<p>${parcentageOfNotTalked}％です</p>
	</div>
	<div id="detail_dashboard">
		<p>登録人数</p>
		<p>${countOfActive}人</p>
		<p>話した人数</p>
		<p>${countOfTalked}人</p>
		<p>話していない人数</p>
		<p>${countOfNotTalked}人</p>
	</div>
	</s:form>
	<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true"/>
</body>
</html>
<!-- changed  -->