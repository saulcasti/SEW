<!DOCTYPE html>
<html lang="es">
<head>
    <title>InsertarFila</title>
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
             $db = new mysqli('localhost', 'pepito', 'password2017', 'zoo');
            if($db->connect_error) {
                echo "<p>ERROR de conexión:".$db->connect_error."</p>";
                exit();
            } else {echo "<p>##Conexión establecida##</p>";}
            $consultaPre = $db->prepare("INSERT INTO animal (animalID, name, species, size) VALUES (?,?,?,?)");   
        
            $consultaPre->bind_param('ssss', 
                    $_POST["animalID"],$_POST["name"],$_POST["species"], $_POST["size"]);    
            $consultaPre->execute();
            echo "<p>Número de filas agregadas: ".$consultaPre->affected_rows."</p>";
            $consultaPre->close();
            $db->close();
     
        ?> 
    </section>

</body>
</html>