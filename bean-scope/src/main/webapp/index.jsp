<?xml version="1.0" encoding="UTF-8" ?>
<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
                    pageEncoding="UTF-8" />
<html>
<head>
    <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
</head>
<body>
\${userObject.name} : ${userObject.name} <br>
\${sessionScope: userObject.name} : ${sessionScope.keySet()} <br>
\${applicationScope: scopedTarget.user.name} : ${applicationScope['scopedTarget.user'].name}<br>
\${sessionScope: scopedTarget.user.name} : ${sessionScope['scopedTarget.user'].name}<br>

</body>
</html>