<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소설게시판</title>
<link rel="stylesheet" href="/css/bookList.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="page-content">
        <div class="book-wrap">
            <ul class="book-list-header">
                <li>전체 소설</li>
                <li>최신순</li>
                <li>인기순</li>
                <li>완결</li>
                <li>
                    <select>
                        <option>1</option>
                        <option>2</option>
                    </select>
                </li>
            </ul>
        </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>