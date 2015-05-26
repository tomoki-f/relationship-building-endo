<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
  <link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
	<div class="header"><tiles:insert template="/WEB-INF/view/common/header.jsp" flush="true"/></div>
<h1>新規登録</h1>
<h2>以下のフォームに記入してください。</h2>
<html:errors/>
<s:form>
<p><label>名前(全角25文字以内)<span class="required">※必須</span>：<input type="text" name="empName" id="empName" maxlength="25" placeholder="師亜取太郎" value="${registerEmpForm.empName}"></label></p>
<p><label>フリガナ(全角25文字以内)：<input type="text" maxlength="50" name="empFurigana" id="empFurigana" placeholder="シアトルタロウ" value="${registerEmpForm.empFurigana}"></label></p>
<p>生年月日：
	<select name="birthYear" id="birthYear">
		<option value="">----</option>
		<script>
			for(var i = 1900; i <= new Date().getFullYear(); i++) {
				document.write("<option value=" + i + ">" + i + "</option>");
			}
		</script>
	</select>
	年
	<select name="birthMonth" id="birthMonth">
		<option value="">--</option>
		<script>
			for(var j = 1; j <= 12; j++) {
				document.write("<option value=" + j + ">" + j + "</option>");
			}
		</script>
	</select>
	月
	<select name="birthDay" id="birthDay">
		<option value="">--</option>
		<script>
			for(var k = 1; k <=31; k++) {
				document.write("<option value=" + k + ">" + k + "</option>");
			}
		</script>
	</select>
	日
</p>
<p><label>電話番号：<input type="tel" maxlength="13" name="tel" id="tel" placeholder="xxx-xxxx-xxxx"></label></p>
<p><label>ノート：<input type="text" maxlength="200" name="note" id="note"></label></p>
<p>この社員と：
	<input type="radio" name="status" value="1">話した
	<input type="radio" name="status" value="0">話してない
</p>
<input type="submit" name="goToConfirmation" value="確認画面へ">
</s:form>
<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true"/>
</body>
</html>