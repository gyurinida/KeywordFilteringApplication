<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!--JSTL 과 EL 을 사용하기 위해 -->
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Keyword Filtering Application</title>
    <link rel="stylesheet" href="https://unpkg.com/nouislider@10.0.0/distribute/nouislider.css">
    <link rel="stylesheet" href="https://unpkg.com/nouislider@10.0.0/distribute/nouislider.min.css">
    <link href="/dist/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.7.0/js/all.js"></script>
    <link href="/dist/css/movieCard.css?a" rel="stylesheet" />
    <link href="/dist/css/comments.css?a" rel="stylesheet" />
    <link href="/dist/css/pagination.css?a" rel="stylesheet" />
    <link href="/dist/css/likes.css?a" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <link href="/dist/css/slick-extra.css?a" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="/slick/slick-theme.css"/>
</head>