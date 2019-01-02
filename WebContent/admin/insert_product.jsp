<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
<%
            String error = "";
            if(request.getParameter("error")!=null){
                error = (String) request.getParameter("error");
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Thong tin san pham</h3>

                    

                    <form action="/ShopOnline/ManagerProductServlet" method="post">
                    <table width="95%">
                    <%=error%>
                        <tr>
                            <td style="float: right"><b>Tên san pham:</b></td>
                            <td><input type="text" class="sedang" name="tensp"></td>
                            </tr>
                         <tr>   <td style="float: right"><b>Hinh anh:</b></td>
                            <td><input type="text" class="sedang" name="hinhAnh"></td>
                            </tr>
                            <tr>
                            <td style="float: right"><b>Gia:</b></td>
                            <td><input type="text" class="sedang" name="gia"></td>
                            </tr>
                            <tr>
                            <td style="float: right"><b>Mo ta:</b></td>
                            <td><input type="text" class="sedang" name="moTa"></td>
                            </tr>
                            <tr>
                            <td style="float: right"><b>ID danh muc:</b></td>
                            <td><input type="text" class="sedang" name="IDDanhMuc"></td>
                            
                        </tr>
                        <tr><td></td><td>
                                <input type="hidden" name="command" value="insert">
                                <input type="submit" class="button" value="Lưu dữ liệu">
                            </td>
                        </tr>
                    </table>
                    </form>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
