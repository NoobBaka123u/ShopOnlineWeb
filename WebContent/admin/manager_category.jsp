

<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager category</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
<%
CategoryDAO dao = new CategoryDAO();
ArrayList<Category>listCategory = dao.getListCategory();
%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Quan li danh muc</h3>

                    <a href="/ShopOnline/admin/insert_category.jsp" >Them danh muc</a>
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">Ma danh muc</th>
                            <th class="data">Ten danh muc</th>
                            
                            <th class="data" width="75px">Tuy chon</th>
                        </tr>
                         <%
                            int count = 0;
                            for(Category category : listCategory){
                                count++;
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%=count%></td>
                            <td class="data"><%=category.getCategoryID()%></td>
                            <td class="data"><%=category.getCategoryName()%></td>
                           
                            <td class="data" width="75px">
                        <center>
                            <a href="/ShopOnline/admin/update_category.jsp?command=update&category_id=<%=category.getCategoryID()%>">Sua</a>&nbsp;&nbsp;||&nbsp;&nbsp;
                            <a href="/ShopOnline/ManagerCategoryServlet?command=delete&category_id=<%=category.getCategoryID()%>">Xoa</a>
                        </center>
                        </td>
                        </tr>
                       <%}%>
                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
