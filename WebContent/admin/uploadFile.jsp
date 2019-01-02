<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP-Servlet Upload file</title>
</head>
<body>
  <h2>Demo JSP-Servlet Upload File</h2>
  <form method="post" action="/ShopOnline/UploadFileServlet" enctype="multipart/form-data">
    Select file to upload: <input type="file" name="file" size="60" /><br /><br /> 
    <input type="submit" value="Upload" />
  </form>
  <h2>${requestScope.message}</h2>
</body>
</html>