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
            <div class="container-fluid">
                <div class="ResultWrapper">
                    <!-- 결과 갯수, 정렬 버튼 -->
                    <header class="ResultHeader">
                        <div class="ResultCounter">
                            총 <span class="ResultCounter_Number">${pageMaker.totalCount}</span> 건의 작품이 있습니다.
                        </div>
                        <div class="tab">
                            <form id="sortingForm">
                                <input type="hidden" name="searchType" value="${pageMaker.criteria.searchType}">
                                <input type="hidden" name="searchKeyword" value="${pageMaker.criteria.searchKeyword}">
                                <input type="hidden" name="page" value="1">
                                <input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">
                                <input type="hidden" name="selSort" value="${selSort}">
                            </form>
                            <label class="switch" id="Latest">
                                <input type="radio" name="filter" <c:if test="${selSort eq 'Latest'}">checked</c:if>>
                                <span class="slider">최신순</span>
                            </label>
                            <label class="switch" id="imdb_rating">
                                <input type="radio" name="filter" <c:if test="${selSort eq 'imdb_rating'}">checked</c:if>>
                                <span class="slider">imdb 평점순</span>
                            </label>
                            <label class="switch" id="self_rating">
                                <input type="radio" name="filter" <c:if test="${selSort eq 'self_rating'}">checked</c:if>>
                                <span class="slider">자체 평점순</span>
                            </label>
                            <label class="switch" id="Most_reviews">
                                <input type="radio" name="filter" <c:if test="${selSort eq 'Most_reviews'}">checked</c:if>>
                                <span class="slider">리뷰 많은순</span>
                            </label>
                        </div>
                    </header>
                    <!-- 검색 결과 리스트 -->
                    <div class="resultLists">
                        <c:forEach items="${contents}" var="content">
                            <c:set var="cId" value="${content.contentId}"/>
                            <div class="movie_card" id="${content.contentId}">
                                <c:if test="${not empty login}">
                                <div class="action-likes">
                                    <input type="checkbox" class="like-checkbox" id="like-${content.contentId}" <c:if test="${not empty likes.get(cId)}">checked</c:if>/>
                                    <label for="like-${content.contentId}">
                                        <svg id="heart-svg" class="likes-svg" viewBox="467 392 58 57" xmlns="http://www.w3.org/2000/svg">
                                            <g id="Group" fill="none" fill-rule="evenodd" transform="translate(467 392)">
                                                <path d="M29.144 20.773c-.063-.13-4.227-8.67-11.44-2.59C7.63 28.795 28.94 43.256 29.143 43.394c.204-.138 21.513-14.6 11.44-25.213-7.214-6.08-11.377 2.46-11.44 2.59z" id="heart" fill="#AAB8C2"/>
                                                <circle id="main-circ" fill="#E2264D" opacity="0" cx="29.5" cy="29.5" r="1.5"/>

                                                <g id="grp7" opacity="0" transform="translate(7 6)">
                                                    <circle id="oval1" fill="#9CD8C3" cx="2" cy="6" r="2"/>
                                                    <circle id="oval2" fill="#8CE8C3" cx="5" cy="2" r="2"/>
                                                </g>

                                                <g id="grp6" opacity="0" transform="translate(0 28)">
                                                    <circle id="oval1" fill="#CC8EF5" cx="2" cy="7" r="2"/>
                                                    <circle id="oval2" fill="#91D2FA" cx="3" cy="2" r="2"/>
                                                </g>

                                                <g id="grp3" opacity="0" transform="translate(52 28)">
                                                    <circle id="oval2" fill="#9CD8C3" cx="2" cy="7" r="2"/>
                                                    <circle id="oval1" fill="#8CE8C3" cx="4" cy="2" r="2"/>
                                                </g>

                                                <g id="grp2" opacity="0" transform="translate(44 6)">
                                                    <circle id="oval2" fill="#CC8EF5" cx="5" cy="6" r="2"/>
                                                    <circle id="oval1" fill="#CC8EF5" cx="2" cy="2" r="2"/>
                                                </g>

                                                <g id="grp5" opacity="0" transform="translate(14 50)">
                                                    <circle id="oval1" fill="#91D2FA" cx="6" cy="5" r="2"/>
                                                    <circle id="oval2" fill="#91D2FA" cx="2" cy="2" r="2"/>
                                                </g>

                                                <g id="grp4" opacity="0" transform="translate(35 50)">
                                                    <circle id="oval1" fill="#F48EA7" cx="6" cy="5" r="2"/>
                                                    <circle id="oval2" fill="#F48EA7" cx="2" cy="2" r="2"/>
                                                </g>

                                                <g id="grp1" opacity="0" transform="translate(24)">
                                                    <circle id="oval1" fill="#9FC7FA" cx="2.5" cy="3" r="2"/>
                                                    <circle id="oval2" fill="#9FC7FA" cx="7.5" cy="2" r="2"/>
                                                </g>
                                            </g>
                                        </svg>
                                    </label>
                                </div>
                                </c:if>
                                <div class="info_section">
                                    <div class="movie_header">
                                        <img class="locandina" src="${content.poster}"/>
                                        <h1>${content.title}</h1>
                                        <h4 style="display: inline-block">${content.year}, ${content.director}</h4>
                                        <div style="display: block">
                                            <span class="boxinfo">${content.runtime} min</span>
                                            <span class="boxinfo">${content.rated}</span>
                                            <div class="star-ratings-sprite"><span style="width:${content.imdbRating*10}%" class="star-ratings-sprite-rating"></span></div>
                                            <div class="main_awards">
                                                <div class="awards_icon"><i class="fas fa-medal"></i></div>
                                                    ${content.awardWin}
                                                <div class="awards_icon"><i class="fas fa-award"></i></div>
                                                    ${content.awardNominate}
                                                <div class="awards_icon"><i class="fas fa-trophy"></i></div>
                                                    ${content.awardMajor} ${content.awardMajorType}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="movie_desc">
                                        <p class="text">
                                                ${content.plot}
                                        </p>
                                    </div>
                                    <div class="movie_genre">
                                        <ul>
                                            <c:forEach items="${genres.get(cId)}" var="genre">
                                                <li><i>#${genre}</i></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <div class="blur_back bright_back" style="background-image: url('${content.poster}');"></div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- 페이징 -->
                    <div class="box-footer">
                        <div class="text-center">
                            <form id="pagingForm">
                                <input type="hidden" name="searchType" value="${pageMaker.criteria.searchType}">
                                <input type="hidden" name="searchKeyword" value="${pageMaker.criteria.searchKeyword}">
                                <input type="hidden" name="page" value="${pageMaker.criteria.page}">
                                <input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">
                                <input type="hidden" name="selSort" value="${selSort}">
                            </form>
                            <ul class="pagination">
                                <c:if test="${pageMaker.prev}">
                                    <li class="paginate_button page-item previous">
                                        <a href="${pageMaker.startPage-1}" class="page-link">이전</a>
                                    </li>
                                </c:if>
                                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                                    <li class="paginate_button page-item <c:out value="${pageMaker.criteria.page==idx?'active':''}"/>" >
                                        <a href="${idx}" class="page-link">${idx}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageMaker.next && pageMaker.endPage>0}">
                                    <li class="paginate_button page-item next">
                                        <a href="${pageMaker.endPage+1}" class="page-link">다음</a>
                                    </li>
                                </c:if>
                            </ul>
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
    var userId = "${login.userId}";
    $(document).on("click",".info_section",function(){
        var contentId = $(this).parent().attr('id');
        var link =  '/read?contentId=' + contentId;
        $(location).attr('href',link);
    });

    $(".pagination li a").on("click", function (event) {
        event.preventDefault();
        var listPageForm = $("#pagingForm");
        listPageForm.find("[name='page']").val($(this).attr("href"));
        listPageForm.attr("action", "search").attr("method", "get");
        listPageForm.submit();
    });

    //정렬탭 제어 함수
    $(document).on("click",".tab label",function(){
        var selSort = "${selSort}";
        var sortId = $(this).attr('id');
        if(selSort !== sortId){
            var listPageForm = $("#sortingForm");
            listPageForm.find("[name='selSort']").val(sortId);
            listPageForm.attr("action", "search").attr("method", "get");
            listPageForm.submit();
        }
    })
</script>
</body>
</html>
