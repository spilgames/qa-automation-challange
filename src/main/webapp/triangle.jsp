<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
{"triangle":
  {
  <c:if test="${fn:length(it.area) > 0}">
    "area":${it.area}
  </c:if>
  <c:if test="${fn:length(it.perimeter) > 0}">
    "perimeter":${it.perimeter}
  </c:if>

  }
}
