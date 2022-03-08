<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript" src="file.js"></script>
<head>

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
				<p>Левый столбец</p>
				<p>

                    Обслуживание клиента (если зарегистрирован)
                    <form name="newuserform" action="" method="POST" onsubmit="NewUser(this)" enctype="multipart/form-data">
                        <h4>Добавить нового пользователя</h4>
                        <div class="form-group">
                            <label for="formGroupLoginInput">Логин</label>
                            <input type="text" class="form-control" name="formlogin"
                                   id="formGroupLoginInput" placeholder="Логин"/>
                        </div>
                        <div class="form-group">
                            <label for="formGroupPasswordInput">Пароль</label>
                            <input type="text" class="form-control" name="formpassword"
                                   id="formGroupPasswordInput" placeholder="Пароль"/>
                        </div>
                        <div class="form-group">
                            <label for="formGroupUsernameInput">Имя</label>
                            <input type="text" class="form-control" name="formusername"
                                   id="formGroupUsernameInput" placeholder="Имя"/>
                        </div>
                        <button type="submit" class="btn btn-primary" value="save">Отправить</button>
                    </form>

				</p>
			</div>
			<div id="content-2">
				<div id="content-2-1">

                    <div class="form-group">
                        <p>
                        <form action="../clients/all" method="GET">
                            <button id="all" name="all" class="btn btn-default">
                                Получить всех!
                            </button>
                        </form>

                        <label class="col-md-4 control-label" for="registration">Регистрировать / Поиск</label></p>
                        <div class="col-md-8">
                            <button id="registration" name="registration" class="btn btn-default">Регистрация</button>



                            <form action="../clients/main" method="GET" >
                                <button id="find" value="all" name="find" class="btn btn-default">Поиск клиента</button>
                            </form>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="edit">Изменить / Удалить текущего</label>
                        <div class="col-md-8">
                            <button id="edit" name="edit" class="btn btn-default">Изменить</button>
                            <button id="delete" name="delete" class="btn btn-default">Удалить</button>
                        </div>
                    </div>

                </div>
                <div id="content-2-2">
                    <p></p>

                    <fieldset>

                        <!-- Form Name -->
                        <legend>Client of bank</legend>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userLogin">UserLogin</label>
                            <div class="col-md-4">
                                <input id="userLogin" name="userLogin" type="input" placeholder="userLogin" class="form-control input-md" value="${userData.userLogin}"> [NN U]
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="firstName">Имя </label>
                            <div class="col-md-4">
                                <input id="firstName" name="firstName" type="input" placeholder="Имя" class="form-control input-md" value="${userData.firstName}"> [NN]

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="secondName">Фамилия </label>
                            <div class="col-md-4">
                                <input id="secondName" name="secondName" type="input" placeholder="Фамилия" class="form-control input-md"  value="${userData.secondName}"> [NN]

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="middleName">Отчество</label>
                            <div class="col-md-4">
                                <input id="middleName" name="middleName" type="input" placeholder="Отчество" class="form-control input-md" value="${userData.middleName}">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="birthDay">День рождения </label>
                            <div class="col-md-4">
                                <input id="birthDay" name="birthDay" type="input" placeholder="День рождения" class="form-control input-md" value="${userData.birthDay}"> [NN]

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="passport">Паспорт </label>
                            <div class="col-md-4">
                                <input id="passport" name="passport" type="input" placeholder="Паспорт" class="form-control input-md" value="${userData.passport}"> [NN U]

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="passportOrg">Паспорт выдан </label>
                            <div class="col-md-4">
                                <input id="passportOrg" name="passportOrg" type="input" placeholder="Паспорт выдан" class="form-control input-md" value = "${userData.passportOrg}"> [NN]

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="passportDate">Дата выдачи </label>
                            <div class="col-md-4">
                                <input id="passportDate" name="passportDate" type="input" placeholder="Дата выдачи" class="form-control input-md" value="${userData.passportDate}"> [NN]

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="mail">Электронная почта</label>
                            <div class="col-md-4">
                                <input id="mail" name="mail" type="input" placeholder="Электронная почта" class="form-control input-md" value="${userData.mail}">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telephone">Телефон</label>
                            <div class="col-md-4">
                                <input id="telephone" name="telephone" type="input" placeholder="Телефон" class="form-control input-md" value="${userData.telephone}">
                            </div>
                        </div>



                    </fieldset>

                    <p>
                    <form class="form-horizontal">
                        </form>
                    </p>
				</div>
			</div>
		</div>
		<div id="footer" class="cf">
			<p>
                <p>Список:</p>
                <c:forEach items="${clientsList}" var="clients">
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
</body></html>