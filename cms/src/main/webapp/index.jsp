<jsp:include page="plantillas/cabecera.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>

    <div class="container w-50">

        <h1>Iniciar Sesi�n</h1>

        <form action="login" method="post">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" 
                       name="nombre" 
                       id="nombre"
                       required 
                       autofocus 
                       class="form-control" 
                       placeholder="Nombre o Nick">

                <label for="contraseina" class="form-label">contrase�a:</label>
                <input type="password" 
                       name="contraseina" 
                       id="contraseina"
                       required 
                       class="form-control" 
                       placeholder="M�nimo 4 M�ximo 8" >

                <input type="submit" value="Enviar" class="btn btn-block btn-primary mt-4">
        </form>


    </div>

 <jsp:include page="plantillas/footer.jsp"/>