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

                    <a href="#"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/hobbit_cover.jpg" alt="cover" class="cover" /></a>

                    <div class="hero">

                        <div class="details">

                            <div class="title1">${content.title} (${content.year}) <span>${content.rated}</span></div>

                            <!-- TODO: 평점, like, 처리 -->
                            <fieldset class="rating">
                                <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                                <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
                                <input type="radio" id="star4" name="rating" value="4" checked /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                                <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
                                <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                                <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
                                <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                                <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
                                <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                                <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                            </fieldset>

                            <span class="likes">109 likes</span>

                        </div> <!-- end details -->

                    </div> <!-- end hero -->

                    <div class="description">

                        <div class="column1">
                            <span class="tag">action</span>
                            <span class="tag">fantasy</span>
                            <span class="tag">adventure</span>
                        </div>

                        <div class="column2">
                            Director: ${content.director}<br/>
                            Actors: ${content.actor}
                        </div>
                        <div class="column2">
                            ${content.plot}
                        </div>
                        <div class="column2 awards">
                            <c:if test="${not empty content.awardWin && content.awardWin ne 0}">
                                ${content.awardWin} <c:if test="${content.awardWin eq 1}">win</c:if><c:if test="${content.awardWin ne 1}">wins</c:if>
                            </c:if>
                            <c:if test="${not empty content.awardNominate && content.awardNominate ne 0}">
                            <img class="nomination" src="/dist/assets/img/nominated.png"/>
                            ${content.awardNominate} nominated
                            </c:if>
                            <c:if test="${!empty content.awardMajor}">
                            ${content.awardMajor}
                            ${content.awardMajorType}
                            </c:if>
                        </div>
                    </div> <!-- end description -->

                </div> <!-- end container -->
            </div> <!-- end movie-card -->
        </main>
        <%@include file="../include/main_footer.jsp"%>
    </div>
</div>

<%@ include file="../include/plugin_js.jsp"%>
</body>
</html>
