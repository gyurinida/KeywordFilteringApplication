<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<%@include file="include/head.jsp"%>

<body class="sb-nav-fixed">

<%@include file="include/main_header.jsp"%>

<div id="layoutSidenav">

    <%@include file="include/left_column.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <h1 class="mt-4">디즈니 컨텐츠</h1>
                <div class="mt-4">
                    <div class="card mb-4">
                        <div class="card-header">
                            <div class="row align-middle">
                                <div class="col-lg-auto col-md-auto nopadding">
                                    <h4>
                                        <i class="fas fa-search"></i>
                                        키워드로 검색
                                    </h4>
                                </div>
                                <div class="col-lg-9 col-md-7 nopadding" >
                                    <sub>키워드로 마음에 드는 컨텐츠를 찾아보세요!</sub>
                                </div>
                                <div class="col-lg-auto col-md-auto nopadding">
                                    <button class="btn btn-secondary">전체 해제</button>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-3">
                                    <h5>TYPE</h5>
                                    <div id="list-example1" class="list-group" style="height: 200px; overflow-y: scroll">
                                        <c:forEach items="${keywordMaker.totalType}" var="contentType">
                                            <a class="list-group-item list-group-item-action" href="#list-item-1">${contentType}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <h5>GENRE</h5>
                                    <div id="list-example2" class="list-group" style="height: 200px; overflow-y: scroll">
                                        <c:forEach items="${keywordMaker.totalGenre}" var="contentGenre">
                                            <a class="list-group-item list-group-item-action" href="#list-item-1">${contentGenre}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <h5>RATED</h5>
                                    <div id="list-example3" class="list-group" style="height: 200px; overflow-y: scroll">
                                        <c:forEach items="${keywordMaker.totalRated}" var="contentRated">
                                            <a class="list-group-item list-group-item-action" href="#list-item-1">${contentRated}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <h5>RUNNING TIME</h5>
                                    <div id="list-example4" class="list-group" style="height: 200px; overflow-y: scroll">
                                        <a class="list-group-item list-group-item-action" href="#list-item-1">1h 미만</a>
                                        <a class="list-group-item list-group-item-action" href="#list-item-1">1h 이상 2h 미만</a>
                                        <a class="list-group-item list-group-item-action" href="#list-item-1">2h 미만</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ResultWrapper">
                        <div class="EmptyResult">
                        </div>
                        <div class="Result">
                            <div class="SelectedKeywordLists">
                                <h2 class="invisible">선택된 키워드</h2>
                                <ul class="KeywordLists">
                                    <li class="Keyword">
                                        <button aria-label="선택 해제" class="btn btn-primary Keyword_DeleteButton" data-tag-id="2612">
                                            <span class="Keyword_Hash">#</span>fantasy
                                            <svg class="RSGIcon RSGIcon-close RSGIcon-close2 DeleteIcon" viewBox="0 0 48 48" width="48" height="48">
                                                <path d="M48 5.3L29.3 24 48 42.7 42.7 48 24 29.3 5.3 48 0 42.7 18.7 24 0 5.3 5.3 0 24 18.7 42.7 0 48 5.3z"></path>
                                            </svg>
                                        </button>
                                    </li>
                                </ul>
                            </div>
                            <header class="ResultHeader">
                                <div class="ResultCounter">
                                    <span class="ResultCounter_Number">374</span> 건의 작품이 있습니다.
                                </div>
                                <div class="tab">
                                    <label class="switch">
                                        <input type="radio" name="filter">
                                        <span class="slider">최신순</span>
                                    </label>
                                    <label class="switch">
                                        <input type="radio" name="filter">
                                        <span class="slider">imdb 평점순</span>
                                    </label>
                                    <label class="switch">
                                        <input type="radio" name="filter">
                                        <span class="slider">자체 평점순</span>
                                    </label>
                                    <label class="switch">
                                        <input type="radio" name="filter">
                                        <span class="slider">리뷰 많은순</span>
                                    </label>
                                </div>
                            </header>
                            <div class="ResultLists">
                                <div class="movie_card" id="bright">
                                    <div class="info_section">
                                        <div class="movie_header">
                                            <img class="locandina" src="https://occ-0-2568-2567.1.nflxso.net/art/5f5cb/3d5923c65399954d27493f553900df9daea5f5cb.jpg"/>
                                            <h1>Catch me if you can</h1>
                                            <h4>2002, David Ayer</h4>
                                            <span class="minutes">117 min</span>
                                            <span class="rated">PG</span>
                                            <div class="star-ratings-sprite"><span style="width:52%" class="star-ratings-sprite-rating"></span></div>
                                        </div>
                                        <div class="movie_desc">
                                            <p class="text">
                                                A seasoned FBI agent pursues Frank Abagnale Jr. who, before his 19th birthday, successfully forged millions of dollars' worth of checks while posing as a Pan Am pilot, a doctor, and a legal prosecutor. A seasoned FBI agent pursues Frank Abagnale Jr. who, before his 19th birthday, successfully forged millions of dollars' worth of checks while posing as a Pan Am pilot, a doctor, and a legal prosecutor. A seasoned FBI agent pursues Frank Abagnale Jr. who, before his 19th birthday, successfully forged millions of dollars' worth of checks while posing as a Pan Am pilot, a doctor, and a legal prosecutor.
                                            </p>
                                        </div>
                                        <div class="movie_genre">
                                            <ul>
                                                <li><i>#fantasy</i></li>
                                                <li><i>#fantasy</i></li>
                                                <li><i>#fantasy</i></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="blur_back bright_back"></div>
                                </div>
                                <div class="movie_card" id="bright2">
                                    <div class="info_section">
                                        <div class="movie_header">
                                            <img class="locandina" src="https://occ-0-2568-2567.1.nflxso.net/art/5f5cb/3d5923c65399954d27493f553900df9daea5f5cb.jpg"/>
                                            <h1>Catch me if you can</h1>
                                            <h4>2002, David Ayer</h4>
                                            <span class="minutes">117 min</span>
                                            <span class="rated">PG</span>
                                            <div class="star-ratings-sprite"><span style="width:52%" class="star-ratings-sprite-rating"></span></div>
                                        </div>
                                        <div class="movie_desc">
                                            <p class="text">
                                                A seasoned FBI agent pursues Frank Abagnale Jr. who, before his 19th birthday, successfully forged millions of dollars' worth of checks while posing as a Pan Am pilot, a doctor, and a legal prosecutor. A seasoned FBI agent pursues Frank Abagnale Jr. who, before his 19th birthday, successfully forged millions of dollars' worth of checks while posing as a Pan Am pilot, a doctor, and a legal prosecutor. A seasoned FBI agent pursues Frank Abagnale Jr. who, before his 19th birthday, successfully forged millions of dollars' worth of checks while posing as a Pan Am pilot, a doctor, and a legal prosecutor.
                                            </p>
                                        </div>
                                        <div class="movie_genre">
                                            <ul>
                                                <li><i>#fantasy</i></li>
                                                <li><i>#fantasy</i></li>
                                                <li><i>#fantasy</i></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="blur_back bright_back"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="include/main_footer.jsp"%>
    </div>
</div>

<%@ include file="include/plugin_js.jsp"%>

//키워드 선택 전 후 화면 변화에 대한 제어
<script>
    $(document).ready(function() {
        //기본 설정
        //$(".EmptyResult").show();
        //$(".Result").hide();

        //$("span.more").click(function() {
            //3000 : 3초, 'slow', 'normal', 'fast'
           // $("#moreRegion").show('3000'); //천천히 보이기
           // $(this).hide('fast');//more버튼 숨기기
       // });
    });
</script>

</body>
</html>
