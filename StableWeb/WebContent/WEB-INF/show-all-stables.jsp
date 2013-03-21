<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "ejb.stablepkg.Stable"
    import = "java.util.List"
%>
<html lang="en">
  <head>

    <title>The Stable - All Stables</title>
    
    <!--  INCLUDE HEADER -->
	<jsp:include page="static-content/header.jsp" />

  </head>

  <body>
	<!--  INCLUDE NAVIGATION -->
	<jsp:include page="static-content/nav.jsp" />
    <div class="container">
    <br><br>
    <h1>All the stables</h1>
    
    <% List<Stable> stableList = (List<Stable>)request.getAttribute("allStables"); %>

     <table class="table table-striped">
              <thead>
                <tr>
                  <th>Stable Number</th>
                  <th>Stable Name</th>
                </tr>
              </thead>
              <tbody>
              <% for(Stable s : stableList) {
            	  out.println("<tr><td>" + 
              		s.getStableNumber() + 
              		"</td><td>" +
            		s.getStableName() +
            		"</td></tr>");
              }
              
              %>
              
              </tbody>
            </table>
            
            <form action="/StableWeb/Stable" method="post">
            	<fieldset>
    				<legend>Add new Stable</legend>
    				<label>Number</label>
    				<input type="text" name="stableNumber" placeholder="Stable number">
    				<label>Name</label>
    				<input type="text" name="stableName" placeholder="Stable name">
    			
    				<button type="submit" class="btn">Submit</button>
  				</fieldset>
            
            </form>
      <hr>

    </div> <!-- /container -->

	<!--  INCLUDE JAVACSRIPT -->
	<jsp:include page="static-content/javascript-includes.jsp" />


  </body>
</html>
