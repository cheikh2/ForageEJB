<div class="navbar navbar-default">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li><a href="index.php">Home</a></li>
                <li><a href="Client">Client</a></li>
             	<li><a href="Village">Village</a></li>
             	
             	 <li><% if (session != null) {
         			if (session.getAttribute("user") != null) {
            		String name = (String) session.getAttribute("user");
            		out.print(name);
         			} else {
            		response.sendRedirect("index.jsp");
         			}
      				}
   					%>
   				</li>
            </ul>
        </div>
    </div>