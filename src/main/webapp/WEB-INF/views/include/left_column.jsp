<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <a class="nav-link" href="/">
                    <div class="sb-nav-link-icon"><i class="fas fa-home"></i></div>
                    Home
                </a>
                <c:if test="${not empty login}">
                <a class="nav-link" href="#">
                    <div class="sb-nav-link-icon"><i class="fas fa-shopping-cart"></i></div>
                    카트
                </a>
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                    마이페이지
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" onclick="goMyInfo()" style="cursor:pointer">내 정보</a>
                        <a class="nav-link" onclick="goMyLikes()" style="cursor:pointer">즐겨찾기</a>
                    </nav>
                </div>
                </c:if>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            Start Bootstrap
        </div>
    </nav>
    <script>
        function goMyInfo(){
            self.location = "/user/myInfo?userId="+"${login.userId}";
        }
        function goMyLikes(){
            self.location = "/user/myLikes?userId="+"${login.userId}";
        }
    </script>
</div>