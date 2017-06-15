<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:attribute name="header">      				
		<title>SpringHibernateTest App</title>
    </jsp:attribute>

	<jsp:attribute name="footer">
      
    </jsp:attribute>

	<jsp:body>
					<br>
			<div style="text-align:center">
				<h2>
					Hey You..!! This is your 1st Spring MCV Tutorial..<br> <br>
				</h2>
			</div>
			
			<hr>
				
			<div style="text-align:center">
				<h3>
					<a href="welcome.html">Click here to See Welcome Message... </a>(to
					check Spring MVC Controller... @RequestMapping("/welcome"))
				</h3>
			</div>
			
			<hr>
			
			
    </jsp:body>
</t:template>