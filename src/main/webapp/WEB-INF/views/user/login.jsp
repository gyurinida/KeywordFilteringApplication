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
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                            <div class="card-body">
                                <form action="${path}/user/loginPost" method="post">
                                    <div class="form-group">
                                        <label class="small mb-1" for="userId" >ID</label>
                                        <input class="form-control py-4" id="userId" name="userId" type="text" placeholder="Enter your ID" />
                                    </div>
                                    <div class="form-group">
                                        <label class="small mb-1" for="userPw">Password</label>
                                        <input class="form-control py-4" id="userPw" name="userPw" type="password" placeholder="Enter password" />
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox">
                                            <input class="custom-control-input" id="useCookie" name="useCookie" type="checkbox" />
                                            <label class="custom-control-label" for="useCookie">로그인 유지</label>
                                        </div>
                                    </div>
                                    <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <a class="small" href="password.html">Forgot Password?</a>
                                        <button type="submit" class="btn btn-primary">Login</button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center">
                                <div class="small"><a href="/user/signUp">Need an account? Sign up!</a></div>
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
<script>
    var msg = "${msg}";
    if(msg==="REGISTERED")
        alert("회원가입이 완료되었습니다. 로그인해주세요:)");
    else if(msg==="FAILURE")
        alert("아이디와 비밀번호를 확인해주세요");

</script>

</body>
</html>
