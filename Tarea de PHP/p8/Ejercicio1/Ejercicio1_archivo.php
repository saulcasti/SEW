<?php
        class ArchivoTexto {
              
            protected $fileName;
            
            function __construct($fileName) {
                $this->fileName = $fileName;
            }
                
                
            function createFile(){
                $file = fopen($this->fileName,"w");
                fclose($file);
            }
                
            function writeFile($text){
                $file = fopen($this->fileName,"w");
                fwrite($file,$text);
                fclose($file);
            }
                
            function modifyFile($text){
                $current = file_get_contents($this->fileName);
                if ($current !== false){
                    $current .= $text;
                    file_put_contents( $this->fileName,$current);
                } else{
                    echo "<p>ERROR: el archivo no existe</p>";
                }
            }
                
                
            function viewFile(){
                echo "<h3>El fichero ",$this->fileName," contiene: </h3>";
                if(file_exists($this->fileName)){
                    $file = fopen($this->fileName,"r");
                    echo "<ul>";
                    while (!feof($file)) {
                        $line = fgets($file); 
                        echo "<li>".$line ."</li>";
                    }
                    echo "</ul>";
                    fclose( $file);
                }else{
                    echo "<p>##Fichero no encontrado</p>";
                }
            }    
                
                
            function deleteInfoFile(){
                $file = fopen($this->fileName,"w");
            }  
                
            function deleteFile(){
                unlink($this->fileName);    
            }     
                   
        }
      
    ?> 