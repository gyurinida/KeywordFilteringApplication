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
                                <form action="/user/signUp" method="post" onsubmit="return validateForm();">
                                    <div class="form-row">
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <label class="small mb-1" for="userId">아이디</label>
                                                <input class="form-control py-4" id="userId" name="userId" type="text" placeholder="아이디를 입력하세요" />
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1">중복 확인</label>
                                                <div id="dupCheck" class="btnCheck" onclick="dupCheck();">미확인</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row"> <!-- 비밀번호 -->
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="small mb-1" for="userPw">비밀번호</label>
                                                <input class="form-control py-4" id="userPw" name="userPw" type="password" placeholder="비밀번호를 입력하세요" />
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="small mb-1" for="confirmPw">비밀번호 확인</label>
                                                <input class="form-control py-4" id="confirmPw" type="password" placeholder="비밀번호를 한 번 더 입력하세요" />
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
<script>
    var checkedId = "";
    function dupCheck() {
        var uncheckedId = $('[name=userId]').val();
        if(uncheckedId===""){
            alert("아이디를 입력 후 중복 확인 버튼을 눌러주세요!");
            return;
        }

        $.ajax({
            type: "get",
            url: "/user/dupCheck",
            data: {
                uncheckedId: uncheckedId
            },
            success: function (result) {
                if(result===1){
                    alert("이미 존재하는 아이디입니다.");
                }
                else if(result===0){
                    alert("사용 가능한 아이디입니다.");
                    checkedId = uncheckedId;
                    $('#dupCheck').css('background-color', '#007bff');
                    $('#dupCheck').addClass("checked");
                    $('#dupCheck').html("확인됨");
                }
            }
        });
    }

    // 회원가입 유효성 검사
    function validateForm(){

        // 아이디 중복체크 확인 여부
        if(!$('#dupCheck').hasClass('checked')){
            alert("아이디 중복확인을 해주세요.");
            return false;
        }
        const curId = $('[name=userId]').val();
        if(curId!==checkedId){
            alert("현재 입력한 아이디와 중복 체크한 아이디가 서로 다릅니다.");
            $('#dupCheck').css('background-color', 'lightskyblue');
            $('#dupCheck').removeClass("checked");
            $('#dupCheck').html("미확인");
            $('#userId').focus();
            return false;
        }

        // 비밀번호
        if($('[name=userPw]').val()==="" || $('[name=userPw]').val()===undefined){
            alert("비밀번호는 최소 1자리여야 합니다.");
            $('#userPw').focus();
            return false;
        }
        if($('[name=userPw]').val()!==$('#confirmPw').val()){
            alert("비밀번호 값이 서로 다릅니다.");
            $('#confirmPw').focus();
            return false;
        }
        return true;
    }
</script>
</body>
</html>
