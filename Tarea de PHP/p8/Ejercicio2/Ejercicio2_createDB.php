<!DOCTYPE html>
<html lang="es">
<head>
    <title>Creación de la base de datos</title>
    <meta charset="utf-8"/>
    <meta name="author" content="UO251370" /> 
      <link href="Ejercicio2.css" rel="stylesheet" />
</head>
    
<body>
    <header>
    <h1>Ejercicio 2</h1>

    <nav>
    <a href="Ejercicio2.html">INICIO</a>
    <a href="Ejercicio2_createDB.php">CREAR BD</a>
    <a href="Ejercicio2_createTable.php">CREAR TABLA</a>
    <a href="Ejercicio2_insert.html">INSERTAR</a>
    <a href="Ejercicio2_remove.html">BORRAR</a>
    <a href="Ejercicio2_search.html">BUSCAR</a>
</nav>
    </header>
    <section>
        <?php
        
             $db = new mysqli('localhost','pepito','password2017');
                         
            if($db->connect_error) {
                echo "<p>ERROR de conexión:".$db->connect_error.". No existe el usuario</p>";
                exit();
            } else {echo "<p>##Conexión establecida##</p>";}
            $cadenaSQL = "CREATE DATABASE IF NOT EXISTS zoo COLLATE utf8_spanish_ci";
            if($db->query($cadenaSQL) === TRUE){
                echo "<p>Base de datos ZOO creada con éxito (o ya existe)</p>";
            } else { 
                echo "<p>ERROR en la creación de la Base de Datos ZOO</p>";
                exit();
            }
     
        ?> 
    </section>

</body>
</html>