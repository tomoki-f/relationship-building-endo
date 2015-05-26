<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SeCoRe -ログイン-</title>
  <link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
<h1>ログイン</h1>
<html:errors/>
${message}
<s:form>
<div class="login"><label>ユーザー名(半角英数字):<input type="text" name="userName" placeholder="User Name"/></label>
</div><br>
<div class="login"><label>パスワード(半角英数字):<input type="password" name="password" placeholder="Password"/></label>
</div><br>
<input type="submit" name="login" value="ログイン">
</s:form>
<tiles:insert template="/WEB-INF/view/common/footer.jsp" flush="true"/>
</body>
</html>