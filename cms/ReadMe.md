# CMS Participantes

Proyecto Web **Java EE** siguiendo el patrón de **MVC** contra una bbdd **sqlite**
CMS para gestionar diferentes tablas de la bbdd. 


![screenshot 1]( https://github.com/robertocrash/proyectoF/blob/master/cms/Captura1.PNG)


## Técnologia

- Maven 4.0.0
- Java 8
- Java Servlet Api 3.1.0
- JSP 2.2
- JSTL 1.2
- Bootstrap 5.0.0
- FontAwesome 5.15.3


Para ver mas detalles sobre las depencias (jars) de este proyecto mirar el [pom.xml](https://github.com/elorrieta-errekamari-institutua/cms_participantes/blob/master/pom.xml)

## Instalación Proyecto

Abrir eclipse y usar la opción de **Import > Existing Maven Project**
Seleccionar la carpeta donde se ha bajado el proyecto para que encuentre el fichero **pom.xml**
Esperar unos segundos a que configure el proyecto


## configuración de la bbdd

La base de datos es el fichero **cms.db**

Para realizar la conexión a la bbdd cambiar el siguiente fichero **src\main\java\com\elorrieta\cms\modelo\dao\ConnectionHelper.java**
Solo debemos cambiar la siguiente variable con la ruta de la bbdd 

`
private static final String DIRECCION_BBDD = "jdbc:sqlite:C:\\desarrolloJava\\workspace\\cms\\personajes.db";
`




## Ejecutar Proyecto

Al ser un proyecto web necesitamos un servidor de aplicaciones, en nuestro caso recomendamos **Apache Tomcat 8.5**.

Podemos navegar por los diferentes enlaces de la cabecera puesto que son públicos, por ejemplo JavaDoc y Calculadora.
Si queremos entrar a los paneles de Administración deberemos *Iniciar Sesión*.
Tenemos dos roles diferentes:

1. Administrador   **[admin,admin]** : Permisos Totales para cambiar cualquier participante
2. Usuario Normal  **[pepe, 12345]** : Solo podemos ver los datos del usuario

#### UI para usuario administrador con rol = 2
![UI para usuario administrador]( screenshot3.jpg?raw=true)

#### UI para usuario normal con rol = 1
![UI para usuario normal]( screenshot4.jpg?raw=true)

## Estructura Clases del proyecto

Interesante consultar la documentacion **JavaDoc API**

Model Vista Controlador

- **vista** puedes encontrar las JSPs, css, imagenes, js en `src/main/webapp`
- **modelo** Los DAOs se encargan de conectar Java con la bbdd son los encargados de las consultas SQL `src/main/java/com/elorrieta/cms/modelo`
- **controlador** Controladores o Servlets `src/main/java/com/elorrieta/cms/controladores`

![estructura proyecto]( screenshot5.jpg?raw=true)