class Adivina {
    
    constructor(){
        this.conOpciones = false;
        this.sinOpciones =false;
    }
    borrar(){
        
        document.getElementById("mercedesOpc").style.display="none";
        document.getElementById("mercedesLinea").style.display="none";
        document.getElementById("mercedesImg").style.display="none";
        
        document.getElementById("ePOpc").style.display="none";
        document.getElementById("ePLinea").style.display="none";
        document.getElementById("ePImg").style.display="none";
        
        document.getElementById("cCOpc").style.display="none";
        document.getElementById("cCLinea").style.display="none";
        document.getElementById("cCImg").style.display="none";
        
        document.getElementById("USAOpc").style.display="none";
        document.getElementById("USALinea").style.display="none";
        document.getElementById("USAImg").style.display="none";
        
        document.getElementById("OKmerce").style.display="none";
        document.getElementById("MALmerce").style.display="none";
        
        document.getElementById("OKcc").style.display="none";
        document.getElementById("MALcc").style.display="none";
        
        document.getElementById("OKeP").style.display="none";
        document.getElementById("MALeP").style.display="none";
        
        document.getElementById("OKUSA").style.display="none";
        document.getElementById("MALUSA").style.display="none";
        
        document.getElementById("comp").style.display="none";
    }
    
    habilitarCon(){
        this.borrar();
        this.conOpciones = true;
        this.sinOpciones =false;
        
        document.getElementById("mercedesOpc").style.display="";
        document.getElementById("mercedesImg").style.display="";
        
        document.getElementById("ePOpc").style.display="";
        document.getElementById("ePImg").style.display="";
        
        document.getElementById("cCOpc").style.display="";
        document.getElementById("cCImg").style.display="";
        
        document.getElementById("USAOpc").style.display="";
        document.getElementById("USAImg").style.display="";
        
        document.getElementById("comp").style.display="";
    }
    habilitarSin(){
        this.borrar();
        this.conOpciones = false;
        this.sinOpciones =true;
        
        document.getElementById("mercedesLinea").style.display="";
        document.getElementById("mercedesImg").style.display="";
        

        document.getElementById("ePLinea").style.display="";
        document.getElementById("ePImg").style.display="";
        
        document.getElementById("cCLinea").style.display="";
        document.getElementById("cCImg").style.display="";
        
        document.getElementById("USALinea").style.display="";
        document.getElementById("USAImg").style.display="";
        
        document.getElementById("comp").style.display="";
    }
    
    comprobar(){
        var numero=0;
        if(this.conOpciones){
           numero= this.comprobarCon(numero);
        }
        else if (this.sinOpciones){
            numero= this.comprobarSin(numero);
        }
        var parrafo = document.createElement('p');
        parrafo.appendChild(document.createTextNode("Has acertado "+numero +" marcas"));
        document.getElementById("comp").after(parrafo);
    }
    comprobarSin(a){
        if(document.getElementById("mercedes").value.toUpperCase() =="MERCEDES"){
            document.getElementById("OKmerce").style.display="";
            document.getElementById("MALmerce").style.display="none";
            a++;
        }else{
            document.getElementById("OKmerce").style.display="none";
            document.getElementById("MALmerce").style.display="";
        }
        if(document.getElementById("cC").value.toUpperCase() =="COCO CHANEL"){
            document.getElementById("OKcc").style.display="";
            document.getElementById("MALcc").style.display="none";
            a++;
        }else{
            document.getElementById("OKcc").style.display="none";
            document.getElementById("MALcc").style.display="";
        }
        if(document.getElementById("eP").value.toUpperCase() =="EMILIO PUCCI"){
           document.getElementById("OKeP").style.display="";
           document.getElementById("MALeP").style.display="none";
            a++;
        }else{
            document.getElementById("OKeP").style.display="none";
            document.getElementById("MALeP").style.display="";
        }
        
        if(document.getElementById("USA").value.toUpperCase() =="QUIKSILVER"){
           document.getElementById("OKUSA").style.display="";
           document.getElementById("MALUSA").style.display="none";
            a++;
        }else{
            document.getElementById("OKUSA").style.display="none";
            document.getElementById("MALUSA").style.display="";
        }
        return a;
    }
    comprobarCon(a){
            if(document.getElementsByName("mercedesOp")[0].checked){
                document.getElementById("OKmerce").style.display="";
                document.getElementById("MALmerce").style.display="none";
                a++;
            }else{
                document.getElementById("OKmerce").style.display="none";
                document.getElementById("MALmerce").style.display="";
            }
            
            if(document.getElementsByName("cCOp")[1].checked){
                document.getElementById("OKcc").style.display="";
                document.getElementById("MALcc").style.display="none";
                a++;
            }else{
                document.getElementById("OKcc").style.display="none";
                document.getElementById("MALcc").style.display="";
            }
            
            if(document.getElementsByName("ePOp")[1].checked){
                document.getElementById("OKeP").style.display="";
               document.getElementById("MALeP").style.display="none";
                a++;
            }else{
                document.getElementById("OKeP").style.display="none";
                document.getElementById("MALeP").style.display="";
            }
            
            if(document.getElementsByName("USAOp")[0].checked){
                document.getElementById("OKUSA").style.display="";
                document.getElementById("MALUSA").style.display="none";
                a++;
            }else{
                document.getElementById("OKUSA").style.display="none";
                document.getElementById("MALUSA").style.display="";
            } 
        return a;
    }

}
var adivina = new Adivina();
