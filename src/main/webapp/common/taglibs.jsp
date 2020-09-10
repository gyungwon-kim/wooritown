<%@ 
taglib uri="http://www.springframework.org/tags" prefix="spring" %><%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ 
taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><%@
taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" 
%>

<%//@ taglib prefix="fnc" uri="/WEB-INF/tlds/function.tld" %>

<%@page import="com.soft.web.global.CommonConf"%><%@page import="java.util.Map"
%><%
pageContext.setAttribute("cr", "\r"); //Space
pageContext.setAttribute("cn", "\n"); //Enter
pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
pageContext.setAttribute("br", "<br>\r"); //br
%>
<c:set var="pageUrl" value="${requestScope['javax.servlet.forward.request_uri']}" />