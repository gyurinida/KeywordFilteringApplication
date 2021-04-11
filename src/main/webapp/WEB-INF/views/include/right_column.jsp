<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<div class="detail_aside_wrap">
    <aside class="detail_aside">
        <div class="aside_banner">
        </div><hr class="hidden">
        <div class="aside_contents aside_best">
            <h2 class="aside_contents_title">MOVIE TOP 10</h2>
            <ul>
            </ul>
        </div><hr class="hidden">
    </aside>
</div>

<script>
    $(window).ready(function() {
        var selType = "movie";

        //탭 클릭시 selType 값 바꾸기 코드 추가

        $.ajax({
            type: "get",
            url: "/ranking",
            async: false,
            data: {
                selType: selType,
            },
            success: function (result) {
                var eachContent = '';
                $.each(result.contents, function(key, value) {
                    eachContent += '<li id="'+ value.contentId  +'">' +
                                        '<a href="#">' +
                                            '<span class="best_rank">' +  (key+1) + '위</span>' +
                                            '<span class="best_title">' +
                                                '<span class="title">' +
                                                value.title
                                                '</span>' +
                                                '<span class="title_fadeout"></span>' +
                                            '</span>' +
                                        '</a>' +
                                    '</li>';
                })
                $(".aside_contents > ul").html(eachContent);
            }
        })

        //read 페이지 이동
        $(document).on("click",".aside_contents > ul > li" ,function(){
            var id = $(this).attr('id');
            var link =  '/read?contentId=' + id;
            $(location).attr('href',link);
        })
    })
</script>