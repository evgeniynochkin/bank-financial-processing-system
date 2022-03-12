<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bank financial processing system</title>
	<style>
html,
body {
    margin:0;
    padding:0;
    color:#000;
    background:#fff;
}
#body {
    width:960px;
    margin:0 auto;
    background:#ddd;
}
#header {
    padding:10px;
    background:#fdd;
}
#content-1 {
    float:left;
    width:300px;
    padding:10px;
    background:#bfb;
}
#content-2-1 {
    float:left;
    width:300px;
    padding:10px;
    background:#ddf;
}
#content-2-2 {
    float:right;
    width:300px;
    padding:10px;
    background:#dff;
}
#footer {
    padding:10px;
    background:#ff9;
}
/* Облегчение отмены обтекания элементов */
.cf:after {
	display:block;
	clear:both;
	height:0;
	visibility:hidden;
	content:" ";
	font-size:0;
}
/* Не пройдет проверку – используйте условный комментарий */
.cf {*zoom:1;}
	</style>
</head>
<body>
	<div id="body">
		<div id="header" class="cf">
			<h1>Bank financial processing system</h1>
			<p>${message} </p>
		</div>
		<div id="main" class="cf">
			<div id="content-1">
                <form action="../clients/main" method="GET" >

                    <button id="all" name="find" class="btn btn-default" value="all">
                        Назад
                    </button>
                </form>
			</div>
			<div id="content-2">
				<div id="content-2-1">
                    <div class="form-group">
                        <p>
                            <c:forEach items="${clientsList1}" var="clients">
                                login: ${clients.userLogin} <br>
                                Firstname: ${clients.firstName} <br>
                                MiddleName: ${clients.middleName} <br>
                                LastName: ${clients.lastName} <br>
                                Birthday: ${clients.birthday} <br>
                                Passport: ${clients.passport} <br>
                                PassportOrg: ${clients.passportOrg} <br>
                                PassportDate: ${clients.passportDate} <br>
                                Email: ${clients.email} <br>
                                Phone: ${clients.phone} <br>
                                <hr>
                            </c:forEach>
                        </p>
                    </div>
                </div>
                <div id="content-2-2">
                    <p>
                        <c:forEach items="${clientsList2}" var="clients">
                            login: ${clients.userLogin} <br>
                            Firstname: ${clients.firstName} <br>
                            MiddleName: ${clients.middleName} <br>
                            LastName: ${clients.lastName} <br>
                            Birthday: ${clients.birthday} <br>
                            Passport: ${clients.passport} <br>
                            PassportOrg: ${clients.passportOrg} <br>
                            PassportDate: ${clients.passportDate} <br>
                            Email: ${clients.email} <br>
                            Phone: ${clients.phone} <br>
                            <hr>
                        </c:forEach>
                    </p>
                    <p><form class="form-horizontal"></form></p>
				</div>
			</div>
		</div>
		<div id="footer" class="cf">
			<p>

            </p>
		</div>
	</div>
</body></html>