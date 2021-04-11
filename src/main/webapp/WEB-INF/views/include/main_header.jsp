<!-- Navbar -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Keyword Filtering</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
    <%-- 검색 TODO: 엔터 비활성화 --%>
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
            <select class="input-group-prepend" name="searchType" id="searchType">
                <option value="t" <c:out value="${searchCriteria.searchType==null or searchCriteria.searchType eq 't'?'selected':''}"/> >Title</option>
                <option value="c" <c:out value="${searchCriteria.searchType eq 'c'?'selected':''}"/> >Celeb</option>
            </select>
            <input class="form-control" type="text" id="searchInput" value="${searchCriteria.searchKeyword}" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" id="searchBtn"><i class="fas fa-search"></i></button>
            </div>
        </div>
    </form>

    <!-- 로그인 메뉴 -->
    <c:if test="${not empty login}">
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user fa-fw"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <div class="dropdown-item">
                    <img src="/dist/assets/img/${login.userImg}" class="img-thumbnail" style="width:40%; float: none;" alt="User Image">
                </div>
                <div class="dropdown-item">
                    <span>${login.userName}님 반갑습니다.</span>
                </div>
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/user/logout">Logout</a>
            </div>
        </li>
    </ul>
    </c:if>
    <c:if test="${empty login}"><ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="${path}/user/login">로그인</a>
                <a class="dropdown-item" href="${path}/user/signUp">회원가입</a>
            </div>
        </li>
    </ul>
    </c:if>
</nav>

<script>
    $("#searchBtn").on("click", function(){
        self.location =
            "/search?page=1&perPageNum=10"
            + "&searchType=" + $("select option:selected").val()
            + "&searchKeyword=" + encodeURIComponent($("#searchInput").val());
    });
</script>