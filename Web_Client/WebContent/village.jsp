<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clients</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>

<div class="container col-md-5 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">Ajout_Village</div>
				<div class="panel-body">
				<form action="Village" method="post">
				 <div class="form-group">
					<label>Nom_Village</label>
					<input class="form-control" type="text" name="libelle"/>
				</div>
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
				</div>
			</div>
		</div>

		<div class="container col-md-5 col-xs-12">
            <div class="panel panel-primary">
               <div class="panel-heading">Liste_village</div>
                 <div class="panel-body">
                    <table class="table table-bordered">
						<tr>
							<th>ID</th><th>Libelle</th><th>Modifier</th><th>Supprimer</th>
								</tr>
									<c:forEach items="${village}" var="v">
									<tr>
									<td><c:out value="${v.id}"/></td>
									<td><c:out value="${v.libelle}"/></td>
									<td><a href="Edit.php?id=${cl.id}">Edit</a></td>
									<td><a onclick="return confirm('Etes vous sûre ?')" href="Supprime.php?id=${cl.id}">Supprimer</a></td>
									</tr>
								</c:forEach>
					</table>	  
            	</div>
        	</div>
        </div>
	</body>
</html>