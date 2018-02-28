<!DOCTYPE html>
<html lang="es">
<head>
    <title>Crear tabla</title>
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
            $db->select_db("zoo");
          
            $crearTabla = "CREATE TABLE IF NOT EXISTS animal (id INT NOT NULL AUTO_INCREMENT, 
                        animalID VARCHAR(255) NOT NULL,
                        name VARCHAR(255) NOT NULL, 
                        species VARCHAR(255) NOT NULL,
                        size VARCHAR(255) NOT NULL,  
                        PRIMARY KEY (id))";
            
            if($db->query($crearTabla) === TRUE){
                 echo "<p>Tabla ANIMAL creada con éxito (o ya existe)</p>";
            } else { 
                echo "<p>ERROR en la creación de la tabla ANIMAL</p>";
                exit();
            }   
            
            $db->close();    
        ?> 
    </section>

</body>
</html>