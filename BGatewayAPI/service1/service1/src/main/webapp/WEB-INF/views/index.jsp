<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lab7</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<div class="col-md-4 me-auto ms-auto mt-4">
		<form class="d-flex text-center justify-content-around" action="" method="get">
			<button formaction="/mail" type="submit" class="btn btn-primary">Mail</button>
			<button formaction="/home/index" type="submit" class="btn btn-info">Interceptor</button>
			<button formaction="/login" type="submit" class="btn btn-secondary">Auth Interceptor</button>
		</form>
	</div>
</body>
</html>