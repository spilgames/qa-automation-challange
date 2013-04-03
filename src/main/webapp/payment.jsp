<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
{"payment":
  {
  <c:choose>
    <c:when test="${fn:length(it.error) > 0}">
       "error": "${it.error}"
    </c:when>
    <c:otherwise>
        "amount":${it.amount}
    </c:otherwise>
  </c:choose>
  }
}
