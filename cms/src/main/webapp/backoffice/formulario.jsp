<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

<main class="container">

	 <h1>${titulo}</h1>
        <form action="backoffice/participantes-editar" method="post" class="w-50">

			<p class="text-warning">ID esta oculto</p>
            <input type="text" 
                   name="id"                   
                   id="id"
                   value="${participante.id}"
                   required            
                   readonly       
                   class="form-control">

            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" 
                   name="nombre"                   
                   id="nombre"
                   value="${participante.nombre}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="Nombre sin apellidos">

            <label for="apellidos" class="form-label">Apellidos:</label>
            <input type="text" 
                    name="apellidos" 
                    id="apellidos"
                    value="${participante.apellidos}"
                    required                      
                    class="form-control" 
                    placeholder="escribe los 2 apellidos">

                    
            <label for="email" class="form-label">Email:</label>
            <input type="email" 
                    name="email"
                    id="email" 
                    value="${participante.email}"
                    required                      
                    class="form-control" 
                    placeholder="tu@correo.com">
                    
            <label for="avatar" class="form-label">Avatar:</label>
            <input type="text" 
                    name="avatar"
                    id="avatar" 
                    value="${participante.avatar}"
                    required                      
                    class="form-control" 
                    placeholder="url de la imagen para el avatar">       

            <input type="submit" value="${ ( participante.id == 0 ) ? 'Crear' : 'Editar' }" class="btn btn-block btn-primary mt-4">
        </form>

</main> 

<jsp:include page="../plantillas/footer.jsp"/>