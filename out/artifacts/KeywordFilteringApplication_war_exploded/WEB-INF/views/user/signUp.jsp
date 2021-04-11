<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<%@include file="../include/head.jsp"%>

<body class="sb-nav-fixed">
<%@include file="../include/main_header.jsp"%>
<div id="layoutSidenav">

    <%@include file="../include/left_column.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                            <div class="card-body">
                                <form action="${path}/user/signUp" method="post">
                                    <div class="form-group">
                                        <label class="small mb-1" for="userId">아이디</label>
                                        <input class="form-control py-4" id="userId" name="userId" type="text" placeholder="아이디를 입력하세요" />
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="small mb-1" for="userPw">비밀번호</label>
                                                <input class="form-control py-4" id="userPw" name="userPw" type="password" placeholder="비밀번호를 입력하세요" />
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputConfirmPassword">비밀번호 확인</label>
                                                <input class="form-control py-4" id="inputConfirmPassword" type="password" placeholder="비밀번호를 한 번 더 입력하세요" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="small mb-1" for="userName">이름</label>
                                        <input class="form-control py-4" id="userName" name="userName" type="text" placeholder="이름을 입력하세요" />
                                    </div>
                                    <div class="form-group">
                                        <label class="small mb-1" for="userEmail">이메일</label>
                                        <input class="form-control py-4" id="userEmail" name="userEmail" type="email" aria-describedby="emailHelp" placeholder="이메일 주소를 입력하세요" />
                                    </div>
                                    <div class="form-group mt-4 mb-0">
                                        <button type="submit" class="btn btn-primary btn-block ">가입</button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center">
                                <div class="small"><a href="/user/login">Have an account? Go to login</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="../include/main_footer.jsp"%>
    </div>
</div>

<%@ include file="../include/plugin_js.jsp"%>
</body>
</html>
