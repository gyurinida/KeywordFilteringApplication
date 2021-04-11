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
            <div class="movie-card">

                <div class="containerMC">

                    <a href="#"><img src="${content.poster}" alt="cover" class="cover" /></a>

                    <div class="hero" id="${content.contentId}"><%-- style="background-image: url('${content.poster}');"--%>
                        <c:if test="${not empty login}">
                        <div class="action-likes">
                            <input type="checkbox" class="like-checkbox" id="like-${content.contentId}" />
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
                        <div class="details">
                            <div class="title1">${content.title} (${content.year}) <span>${content.rated}</span></div>

                            <div class="fixed-rating"><i class="fas fa-star"></i><span class="svg-text">${content.imdbRating}</span></div>
                            <!-- TODO: 별점 반영 -->
                            <div class="fixed-rating"><i class="fas fa-star"></i><span class="svg-text">${content.rating}</span></div>
                            <!-- TODO: 좋아요 실시간 카운트 반영 -->
                            <div class="fixed-likes"><i class="fas fa-heart"></i><span id="totalLikesCnt" class="svg-text">${content.likesCnt}</span></div>

                        </div> <!-- end details -->

                    </div> <!-- end hero -->

                    <div class="description">

                        <div class="column1">
                            <c:forEach items="${keywordMaker.myGenre}" var="myGenre">
                                <span class="tag">${myGenre}</span>
                            </c:forEach>
                        </div>

                        <div class="column2">
                            Director: ${content.director}<br/>
                            Actors: ${content.actor}
                        </div>
                        <div class="column2">
                            ${content.plot}
                        </div>
                        <div class="column2">
                            <c:if test="${not empty content.awardWin && content.awardWin ne 0}">
                                <span class="awards"><i class="fas fa-medal"></i><span class="svg-text">${content.awardWin}</span> <c:if test="${content.awardWin eq 1}">win</c:if><c:if test="${content.awardWin ne 1}">wins</c:if></span>
                            </c:if>
                            <c:if test="${not empty content.awardNominate && content.awardNominate ne 0}">
                                <span class="awards"><i class="fas fa-award"></i><span class="svg-text">${content.awardNominate}</span> nominated</span>
                            </c:if>
                            <c:if test="${!empty content.awardMajor}">
                                <span class="awards"><i class="fas fa-trophy"></i><span class="svg-text">${content.awardMajor}</span> ${content.awardMajorType}</span>
                            </c:if>
                        </div>
                    </div> <!-- end description -->

                </div> <!-- end container -->
            </div> <!-- end movie-card -->

            <!-- 리뷰 작성 -->
            <div class="comments">
                <!-- 내 리뷰 상단 고정 -->
                <div class="comment-wrap myComment">
                </div>
                <!-- 리뷰 갯수 메뉴 -->
                <div class="comment-menu commentMenu">
                </div>
                <!-- 리뷰 목록 -->
                <div class="commentList">
                </div>
                <!-- 페이징 목록 -->
                <div class="text-center">
                    <div class="pagination pg-container"></div>
                </div>
            </div>
        </main>
        <%@include file="../include/main_footer.jsp"%>
    </div>
</div>
<%@ include file="../include/plugin_js.jsp"%>
<script>
    var contentId = "${content.contentId}";
    var mine = false;   // 내 리뷰 존재 유무
    var reviewPageNum = 1;  // 리뷰 페이징 번호
    var userId = "${login.userId}";

    function myLikes(){
        $.ajax({
            type: "get",
            url: "/likes",
            data: {
                contentId: contentId,
                userId: "${login.userId}"
            },
            success: function (result) {
                if(!result){
                    $("input:checkbox[id='like-${content.contentId}']").attr("checked", false);
                }
                else {
                    $("input:checkbox[id='like-${content.contentId}']").attr("checked", true);
                }
            }
        });
    }

    function myComment() {
        if(${empty login}){
            mine = false;
            var myReviewDiv = '';
            myReviewDiv += '<div class="photo"><div class="avatar"></div><div class="writer"></div>';
            myReviewDiv += '<div class="rating">';
            for(var i=0; i<5; i++)
                myReviewDiv += '<span class="fixed-none"></span>';
            myReviewDiv += '</div></div>';
            myReviewDiv += '<div class="comment-block"><p class="comment-text">리뷰를 남기려면 로그인이 필요합니다.</p></div>';
            $(".myComment").html(myReviewDiv);
            return;
        }

        $.ajax({
            type: "get",
            url: "/reviews/mine",
            data: {
                contentId: contentId,
                userId: "${login.userId}"
            },
            success: function (result) {
                var myReviewDiv = '';
                if(!result){
                    mine = false;
                    myReviewDiv += '<div class="photo"><div class="avatar"></div><div class="writer">${login.userName}</div>';
                    myReviewDiv += '<fieldset class="rating"> ' +
                        '<input type="radio" id="star10" name="rating" value="10" /><label class = "full" for="star10"></label> ' +
                        '<input type="radio" id="star9" name="rating" value="9" /><label class="half" for="star9"></label> ' +
                        '<input type="radio" id="star8" name="rating" value="8" /><label class = "full" for="star8"></label> ' +
                        '<input type="radio" id="star7" name="rating" value="7" /><label class="half" for="star7"></label> ' +
                        '<input type="radio" id="star6" name="rating" value="6" /><label class = "full" for="star6"></label> ' +
                        '<input type="radio" id="star5" name="rating" value="5" /><label class="half" for="star5"></label> ' +
                        '<input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4"></label> ' +
                        '<input type="radio" id="star3" name="rating" value="3" /><label class="half" for="star3"></label> ' +
                        '<input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2"></label> ' +
                        '<input type="radio" id="star1" name="rating" value="1" /><label class="half" for="star1"></label> ' +
                        '</fieldset></div>';
                    myReviewDiv += '<div class="comment-block"><form action="">';
                    myReviewDiv += '<textarea id="newReviewText" cols="30" rows="3" placeholder="Add review..."></textarea>';
                    myReviewDiv += '<input id="newReviewWriter" type="text" value="${login.userId}" readonly hidden>';
                    myReviewDiv += '<div class="bottom-comment"><ul class="comment-actions">';
                    myReviewDiv += '<li class="comment-delete" onclick="commentAdd();">Reply</li>';
                    myReviewDiv += '</ul></div></form></div>';
                }
                else{
                    mine = true;
                    var formattedTime, dateStr='';
                    if(result.updateDate!==result.regDate){
                        formattedTime = new Date(result.updateDate).toISOString().slice(0, 19).replace('T', ' ');
                        dateStr = '(수정됨)';
                    }
                    var formattedTime = new Date(result.updateDate).toISOString().slice(0, 19).replace('T', ' ');

                    myReviewDiv += '<div class="photo"><div class="avatar"></div><div class="writer">'+result.reviewWriter+'</div>';
                    myReviewDiv += '<div class="rating commentRating'+result.reviewNo+'">';
                    for(var i=0; i<(result.reviewRating-result.reviewRating%2)/2; i++)
                        myReviewDiv += '<span class="fixed-full"></span>';
                    if(result.reviewRating%2===1)
                        myReviewDiv += '<span class="fixed-half"></span>';
                    for(var i=0; i<5-(result.reviewRating-result.reviewRating%2)/2; i++)
                        myReviewDiv += '<span class="fixed-none"></span>';
                    myReviewDiv += '</div></div>';
                    myReviewDiv += '<div class="comment-block commentContent'+result.reviewNo+'"><p class="comment-text">'+result.reviewText+'</p>';
                    myReviewDiv += '<div class="bottom-comment"><div class="comment-date">'+formattedTime+dateStr+'</div>';
                    if("${login.userId}"===result.reviewWriter) {
                        myReviewDiv += '<ul class="comment-actions">';
                        myReviewDiv += '<li class="comment-modify" onclick="commentUpdate('+result.reviewNo+',\''+result.reviewText+'\','+result.reviewRating+');return false;"> 수정 </li>';
                        myReviewDiv += '<li class="comment-delete" onclick="commentDelete('+result.reviewNo+');"> 삭제</li></ul>';
                    }
                    myReviewDiv += '</div> </div>';
                }
                $(".myComment").html(myReviewDiv);
            }
        });
    }

    function commentList(reviewsUri, pageNum){
        $.ajax({
            type: "get",
            url: reviewsUri,
            data: {
                contentId: contentId,
                page: pageNum
            },
            success: function(result){
                var reviewNum = result.pageMaker.totalCount;
                $(".commentMenu").html(reviewNum+'개의 Review');

                var eachReview ='';
                $.each(result.reviews, function(key, value){
                    var formattedTime, dateStr='';
                    if(value.updateDate!==value.regDate){
                        formattedTime = new Date(value.updateDate).toISOString().slice(0, 19).replace('T', ' ');
                        dateStr = '(수정됨)';
                    }
                    formattedTime = new Date(value.regDate).toISOString().slice(0, 19).replace('T', ' ');

                    // TODO: 리뷰 목록에서 작성자 이미지 불러오기 해야 함
                    eachReview += '<div class="comment-wrap"><div class="photo"><div class="avatar"></div><div class="writer">'+value.reviewWriter+'</div>';
                    eachReview += '<div class="rating">';
                    for(var i=0; i<(value.reviewRating-value.reviewRating%2)/2; i++)
                        eachReview += '<span class="fixed-full"></span>';
                    if(value.reviewRating%2===1)
                        eachReview += '<span class="fixed-half"></span>';
                    for(var i=0; i<5-(value.reviewRating-value.reviewRating%2)/2; i++)
                        eachReview += '<span class="fixed-none"></span>';
                    eachReview += '</div></div>';
                    eachReview += '<div class="comment-block commentContent"><p class="comment-text">'+value.reviewText+'</p>';
                    eachReview += '<div class="bottom-comment"><div class="comment-date">'+formattedTime+dateStr+'</div></div> </div> </div>';
                });

                $(".commentList").html(eachReview);
                printCommentPaging(result.pageMaker, $(".pagination"));
            }
        });
    }

    // 페이징 목록
    function printCommentPaging(pageMaker, targetArea) {
        var str = "<span>";

        // 이전 버튼
        if(pageMaker.prev){
            str += "<a class='pg-index' href='"+(pageMaker.startPage-1)+"'>이전</a>";
        }
        // 페이지 번호 버튼
        for(var i = pageMaker.startPage, len=pageMaker.endPage; i<=len; i++){
            //var strClass = pageMaker.criteria.page==i?'class=active':'';
            str += "<a class='pg-index' href='"+i+"'>"+i+"</a>";
        }
        // 다음 버튼
        if(pageMaker.next){
            str += "<a class='pg-index' href='"+(pageMaker.endPage+1)+"'>다음</a>";
        }
        str += "</span>";
        if(pageMaker.totalCount>0){
            str += '<svg class="pg-svg" viewBox="0 0 100 100"><path class="pg-path" d="m 7.1428558,49.999998 c -1e-7,-23.669348 19.1877962,-42.8571447 42.8571442,-42.8571446 23.669347,0 42.857144,19.1877966 42.857144,42.8571446" /></svg>';
            str += '<svg class="pg-svg" viewBox="0 0 100 100"><path class="pg-path" d="m 7.1428558,49.999998 c -1e-7,23.669347 19.1877962,42.857144 42.8571442,42.857144 23.669347,0 42.857144,-19.187797 42.857144,-42.857144" /> </svg>';
        }
        targetArea.html(str);
        commentPagingCSS();
    }

    // 페이징 목록 css
    function commentPagingCSS(){
        const c = document.querySelector('.pg-container');
        const indexList = Array.from(document.querySelectorAll('.pg-index'));
        let cur = -1;
        indexList.forEach((index, i) => {
            index.addEventListener('click', function(){
                c.className = 'pg-container';
                void c.offsetWidth; // Reflow
                c.classList.add('open');
                c.classList.add('i'+(i+1));
                if (cur>i) {
                    c.classList.add('flip');
                }
                cur = i;
            });
        });
    }

    // 페이징 번호 클릭 이벤트
    $('.pagination').on("click", "a", function (event) {
        event.preventDefault();
        reviewPageNum = $(this).attr("href");
        commentList("/reviews/allPaging", reviewPageNum);
    })

    // 리뷰 등록 처리
    function commentAdd(text) {
        var reviewRating = $('[name=rating]:checked').val();
        var reviewWriter = $("#newReviewWriter").val();
        var reviewText = $("#newReviewText").val();

        $.ajax({
            type: "post",
            url: "/reviews/",
            headers: {
                "Content-type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            dataType: "text",
            data: JSON.stringify({
                contentId: contentId,
                reviewText: reviewText,
                reviewWriter: reviewWriter,
                reviewRating: reviewRating
            }),
            success: function (result) {
                if (result == "regSuccess") {
                    alert("리뷰가 등록되었습니다.");
                    myComment()
                    reviewPageNum = 1;
                    commentList("/reviews/allPaging", reviewPageNum);
                }
            }
        });
    }

    // 리뷰 수정 버튼 누름
    function commentUpdate(no, text, rval){
        var modifyForm = '';
        modifyForm += '<textarea type="text" name="content_'+no+'">'+text+'</textarea>';
        modifyForm += '<div class="bottom-comment"><ul class="comment-actions">';
        modifyForm += '<li class="comment-delete"><a onclick="commentUpdateProc('+no+');return false;">수정완료</a></li>';
        modifyForm += '</ul></div>';

        var modifyRating = '';
        modifyRating += '<fieldset class="rating">';
        for(var i=10; i>0; i--){
            modifyRating += '<input type="radio" id="star'+i+'" name="rating" value="'+i+'" ';
            if(i==rval)
                modifyRating += 'checked';
            var className = i%2==0?'full':'half';
            modifyRating += ' /><label class = "'+className+'" for="star'+i+'"></label>';
        }
        modifyRating += '</fieldset>';
        $('.commentContent'+no).html(modifyForm);
        $('.commentRating'+no).html(modifyRating);
    }

    // 리뷰 수정 처리
    function commentUpdateProc(no){
        var updateContent = $('[name=content_'+no+']').val();
        var updateRating = $('[name=rating]:checked').val();
        $.ajax({
            type: 'put',
            url: '/reviews/'+ no,
            headers: {
                "Content-type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            dataType: "text",
            data: JSON.stringify({
                contentId: contentId,
                reviewText: updateContent,
                reviewRating: updateRating
            }),
            success: function(result){
                if(result=="modSuccess"){
                    alert("리뷰가 수정되었습니다.");
                    myComment();
                    commentList("/reviews/allPaging", reviewPageNum);
                }
            }
        });
    }

    // 리뷰 삭제
    function commentDelete(no){
        $.ajax({
            type: 'delete',
            url: '/reviews/'+no,
            success: function(result){
                if(result=="delSuccess"){
                    alert("댓글이 삭제되었습니다.");
                    myComment();
                    commentList("/reviews/allPaging", reviewPageNum);
                }
            }
        });
    }

    $(document).ready(function () {
        myLikes();
        myComment();
        commentList("/reviews/allPaging", reviewPageNum);

        // 배경 이미지 적용
        var cssStr = "<style>.hero:before {\n" +
            "    content: '';\n" +
            "    width: 100%;\n" +
            "    height: 100%;\n" +
            "    position: absolute;\n" +
            "    overflow: hidden;\n" +
            "    top: 0;\n" +
            "    left: 0;\n" +
            "    background: red;\n" +
            "    background: url('${content.poster}');\n" +
            "    background-size: cover;\n"+
            "    z-index: -1;\n" +
            "    -webkit-transform: skewY(-2.2deg);\n" +
            "    transform: skewY(-2.2deg);\n" +
            "    -webkit-transform-origin: 0 0;\n" +
            "    transform-origin: 0 0;\n" +
            "    -webkit-backface-visibility: hidden;\n" +
            "}</style>";
        $('head').append(cssStr);
    });

</script>
</body>
</html>
