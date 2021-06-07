<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

<main class="container">

	<h1>Estas en tu Perfil de Usuario</h1>
	${usuario_logeado }

</main> 

<jsp:include page="../plantillas/footer.jsp"/>