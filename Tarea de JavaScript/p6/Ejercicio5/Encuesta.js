class Cuestionario {
    
    constructor(){}
    
    rellenarEdad(){
        var s=document.getElementById('edad'); 
        for(var i=1;i<=100;i++){
            var option=document.createElement("option"); 
            option.value=i; 
            option.text=i;
            s.appendChild(option);
        }
    }
    formatoEmail(){
        if(this.validateForm()) {
            var datos="Nombre:%20" +document.getElementById('nombre').value +
                ".%0AApellidos:%20" +document.getElementById('apellido').value + 
                ".%0AEdad:%20" +document.getElementById('edad').value +
                ".%0ASexo:%20" +document.getElementById('sexo').value;
            var email=".%0AEmail:%20" +document.getElementById('email').value;
            var notaComodidad=".%0ANota Comodidad:" + this.getComodidad();
            var notaEstetica=".%0ANota Estetica:"+this.getEstetica();
            var notaFuncionalidad=".%0ANota Funcionalidad:"+this.getFuncionalidad();
            var notaMedia=".%0ANota Media:"+(eval(this.getComodidad()+"*2+"+ this.getEstetica() +"+"+this.getFuncionalidad()+"*3")/7).toFixed(2);
            var recomendari=".%0A";
            if(this.getRecomendari()==true) recomendari+="Recomendaría la aplicación." 
            else recomendari+="No recomendaría la aplicación." 

            window.open("mailto:UO251370@uniovi.es?subject=Resultado%20Encuesta&body="  +datos+ email + 
                        notaComodidad + notaEstetica + notaFuncionalidad + notaMedia + recomendari);

            document.getElementById('nombre').value ='';
            document.getElementById('apellido').value ='';
            document.getElementById('email').value ='';
        }
        
    }
    
    getComodidad(){
        for(var i=0;i<document.getElementsByName("valoracionComodidad").length;i++)
            if(document.getElementsByName("valoracionComodidad")[i].checked) 
                    return document.getElementsByName('valoracionComodidad')[i].value;
        
    }
    getEstetica(){
        for(var i=0;i<document.getElementsByName("valoracionEstetica").length;i++)
            if(document.getElementsByName("valoracionEstetica")[i].checked) 
                    return document.getElementsByName('valoracionEstetica')[i].value;
        
    }
    getFuncionalidad(){
        for(var i=0;i<document.getElementsByName("valoracionFuncionalidad").length;i++)
            if(document.getElementsByName("valoracionFuncionalidad")[i].checked) 
                    return document.getElementsByName('valoracionFuncionalidad')[i].value;
        
    }
    getRecomendari(){
        return document.getElementById('recomendaria').checked;
    }
    
    validateForm() {
       if (document.getElementById('acepto').checked && document.getElementById('nombre').value !='' 
          && document.getElementById('apellido').value !='' && document.getElementById('email').value !='') {
           if(document.getElementById('email').value.search('@') >0){
               if(document.getElementById('email').value.split('@')[0].length >0 && document.getElementById('email').value.split('@')[1].length >0)
                    return true;
               else{
                   alert("El email debe de tener texto a ambos lados del @");
                   return false;
               }
           }
           else{
               alert("El email debe de tener @");
               return false;
           }
        }
        else {alert("Faltan campos o no has marcado la casilla de: Estoy de acuerdo con los terminos y condiciones");return false; }
        }

}
var cuestionario = new Cuestionario();
