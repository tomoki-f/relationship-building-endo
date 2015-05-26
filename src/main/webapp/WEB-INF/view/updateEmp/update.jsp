<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
<link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
	<h1>更新</h1>
	<html:errors/>
	<s:form>
		<p>
			<label>名前(全角25文字以内)<span class="required">※必須</span>：<input
				type="text" maxlength="50" name="empName" id="empName"
				value="${updateEmpDto.empName}"></label>
		</p>
		<p>
			<label>フリガナ(全角25文字以内)：<input type="text" name="empFurigana"
				id="empFurigana" value="${updateEmpDto.empFurigana}"></label>
		</p>
		<p>
			生年月日： <select name="birthYear" id="birthYear">
				<script>
			for(var i = 1900; i <= new Date().getFullYear(); i++) {
				if(i == ${f:h(birthYear)}) {
					document.write("<option selected value=" + i + ">" + i + "</option>")
				} else {
					document.write("<option value=" + i + ">" + i + "</option>");
				}
			}
		</script>
			</select> 年 <select name="birthMonth" id="birthMonth">
				<script>
			for(var j = 1; j <=12; j++) {
				if(j == ${f:h(birthMonth)}) {
					document.write("<option selected value=" + j + ">" + j + "</option>")
				} else {
					document.write("<option value=" + j + ">" + j + "</option>");
				}			}
		</script>
			</select> 月 <select name="birthDay" id="birthDay">
				<script>
			for(var k = 1; k <=31; k++) {
				if(k == ${f:h(birthDay)}) {
					document.write("<option selected value=" + k + ">" + k + "</option>")
				} else {
					document.write("<option value=" + k + ">" + k + "</option>");
				}			}
		</script>
			</select> 日
		</p>
		<p>
			<label>電話番号 例)xxx-xxxx-xxxx：<input type="tel" maxlength="13"
				name="tel" id="tel" value="${updateEmpDto.tel}"></label>
		</p>
		<p>
			<label>ノート：<input type="text" maxlength="200" name="note"
				id="note" value="${updateEmpDto.note}"></label>
		</p>
		<p>
			この社員と：
			<script>if(${updateEmpDto.status} == 1) {
				document.write("<input type='radio' name='status' value='1' checked >話した<input type='radio' name='status' value='0'>話してない");
			} else {
				document.write("<input type='radio' name='status' value='1'>話した<input type='radio' name='status' value='0' checked >話してない");
			}
	</script>
			<input type="submit" name="goToConfirmation" value="確認画面へ">
	</s:form>
	<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true" />
</body>
</html>