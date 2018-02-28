class Calculadora {
    
    constructor(){
        this.resultado = null;
        this.cuenta= null;
        this.signoPulsado=false;
        this.primeraVez = true;
        this.memoria = 0;
        this.reemplazar=false;
        this.puntoPuesto=false;
        this.signos=['+','-','/','*'];
    }
    
    load(){
        this.resultado = document.getElementsByName("resultado")[0];
        this.cuenta= document.getElementsByName("cuenta")[0];
    }
    addNuevo(x){  
        if(this.primeraVez==true){
            this.cuenta.value='';
        }
        if(this.signoPulsado==false){
           
            this.primeraVez = false;
            if(this.isSigno(x)==true){
                this.signoPulsado=true;
                this.cuenta.value +=this.resultado.value + x;
                this.reemplazar=false;
                this.puntoPuesto=false;
                
            }else if(x=='.' && (this.puntoPuesto==false)){
                if( this.reemplazar==false){
                    this.resultado.value += x; 
                }
                else{
                    this.resultado.value = x;
                    this.reemplazar=false;
                }
                this.puntoPuesto=true;
                
            }else if(x!='.'){
                if( this.reemplazar==false){
                    this.resultado.value += x; 
                }
                else{
                    this.resultado.value = x; 
                    this.reemplazar=false;
                }
            }
        }
        else{
            this.primeraVez = false;
            if(this.isSigno(x)==false){
                if(x=='.' && (this.puntoPuesto==false)){
                    this.resultado.value = x; 
                    this.puntoPuesto=true;
                     this.signoPulsado=false;
                    this.reemplazar=false;
                }else if(x!='.'){
                    this.resultado.value = x; 
                    this.signoPulsado=false;
                    this.reemplazar=false;
                }
            }else{
                    
                    var res = this.cuenta.value.slice(0,this.cuenta.value.length -1);//Eliminamos el signo anterior
                    this.cuenta.value = res;
                    this.reemplazar=false;
                    this.puntoPuesto=false;
            }
        }
        
    }
    
    isSigno(x){
        for(var i=0; i<this.signos.length;i++){
            if(x==this.signos[i]){
                return true;
            }
        }return false;
    } 
    
    calcular(){
        this.primeraVez = true;
        this.reemplazar=true;
        this.puntoPuesto=false;
        this.cuenta.value +=this.resultado.value;
        if(this.cuenta!='' || this.cuenta!='+' || this.cuenta!='-' || this.cuenta!='/' || this.cuenta!='*'){
            if(this.cuenta.value.search('=')==-1){
                this.resultado.value=eval(this.cuenta.value);
                this.cuenta.value += '=' + eval(this.cuenta.value);
                
            }else{
                var pos = this.cuenta.value.split('=');
                var cuenta1 = pos[pos.length-1];
                this.resultado.value=eval(cuenta1);
                this.cuenta.value += '=' + eval(cuenta1);
                
            }
        }
    }
    
    borrar(){
        if(this.resultado.value.length==0){
            this.cuenta.value=''; //Si el resultado esta vacio eliminamos toda la cuenta que se estaba realizando.
            this.memoria=0; //Si el resultado esta vacio eliminamos la memoria que tuviese
        }
        else{
            var res = this.resultado.value.slice(0,this.resultado.value.length -1);//Eliminamos el signo anterior
            this.resultado.value = res;
        }
    }
    
    mMas(){
        this.memoria= eval(this.resultado.value +"+" +this.memoria);
    }
    
    mMenos(){
        this.memoria=eval("-"+this.resultado.value +"+"+ this.memoria);
    }
    mrc(){
        if(this.primeraVez==true){
            this.cuenta.value='';
        }
        this.reemplazar=true;
        this.resultado.value = this.memoria;
    }
    
}
var calculadora = new Calculadora();
