
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
        this.soloSignos=false;
    }
    
    load(){
        this.resultado = document.getElementsByName("resultado")[0];
        this.cuenta= document.getElementsByName("cuenta")[0];
    }
    
    addNuevo(x){  
        if(this.soloSignos==true){
            if(this.isSigno(x)==true){
                this.cuenta.value +=x;
                this.soloSignos=false;
            }
        }
        else{
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
                        if(this.isSigno(this.cuenta.value.charAt(this.cuenta.value.length))== true){
                            var res = this.cuenta.value.slice(0,this.cuenta.value.length -1);//Eliminamos el signo anterior
                            this.cuenta.value = res;
                            this.reemplazar=false;
                            this.puntoPuesto=false;
                        }
                }
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
        if(this.primeraVez==false){
            this.primeraVez = true;
            this.reemplazar=true;
            this.puntoPuesto=false;
            this.cuenta.value +=this.resultado.value;
            if(this.cuenta.value!='' && this.isSigno(this.cuenta.value) == false){
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
class CalculadoraCientifica extends Calculadora{
    constructor(){
        super();
        this.signos=['+','-','/','*','%','**'];
        this.numeroParentesisA=0;
        this.numeroParentesisC=0;
    }
    cuentaCient(tipo){
        if(this.resultado.value.length>0){
            if(this.primeraVez==true){
                this.cuenta.value='';
            }
            this.hacerCuentaCientifica(tipo);
            
            this.primeraVez = true;
            this.reemplazar=true;
            this.puntoPuesto=false;
            if(this.cuenta.value!='' && this.isSigno(this.cuenta.value) == false){
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
    }

    hacerCuentaCientifica(tipo){
        var resultAnterior= this.resultado.value;
            if(tipo=='cuadrado'){
                this.resultado.value=eval(this.resultado.value + "*" + this.resultado.value);
                this.cuenta.value +=resultAnterior+"**2";
            }
            else if(tipo=='seno'){
                this.resultado.value=eval("Math.sin("+this.resultado.value+")" );
                this.cuenta.value +="Math.sin("+resultAnterior+")";
            }
            else if(tipo=='coseno'){
                this.resultado.value=eval("Math.cos("+this.resultado.value+")" );
                this.cuenta.value +="Math.cos("+resultAnterior+")";
            }
            else if(tipo=='tangente'){
                this.resultado.value=eval("Math.tan("+this.resultado.value+")" );
                this.cuenta.value +="Math.tan("+resultAnterior+")";
            }
            else if(tipo=='raizCuadrada'){
                this.resultado.value=eval(this.resultado.value + "**(1/2)");
                this.cuenta.value +=resultAnterior+"**(1/2)";
            }
            else if(tipo=='diezElevadoX'){
                this.resultado.value=eval("10**("+this.resultado.value+")" );
                this.cuenta.value +="10**("+resultAnterior+")";
            }
            else if(tipo=='log10'){
                this.resultado.value=eval("Math.log10("+this.resultado.value+")" );
                this.cuenta.value +="Math.log10("+resultAnterior+")";
            }
            else if(tipo=='eElevadoX'){
                this.resultado.value=eval("Math.E**("+this.resultado.value+")" );
                this.cuenta.value +="Math.E**("+resultAnterior+")";
            }
            else if(tipo=='n!'){
                this.resultado.value=eval(this.factorial(this.resultado.value));
                this.cuenta.value +=this.factorial(resultAnterior);
            }
            else if(tipo=='cambioSigno'){
                this.resultado.value=eval("-("+this.resultado.value+")" );
                this.cuenta.value +="-("+resultAnterior+")";
            }
    }
    
    factorial (n) {
        var total = "1"; 
        for (var i=2; i<=eval(n); i++) {
            total += "*"+ i; 
        }
        return total; 
    }
    
    borrarTodo(){
        this.memoria='';
        this.resultado.value='';
        this.cuenta.value='';
    }
    addParentesisA(){
         this.primeraVez = false;
        this.cuenta.value +="(";
    }
    addParentesisC(){
        var cuentaAbiertos = 0;
        var posicion = this.cuenta.value.indexOf("(");
        while ( posicion != -1 ) {
           cuentaAbiertos++;
           posicion = this.cuenta.value.indexOf("x",posicion+1);
        }
        var cuentaCerrados = 0;
        posicion = this.cuenta.value.indexOf(")");
        while ( posicion != -1 ) {
           cuentaCerrados++;
           posicion = this.cuenta.value.indexOf("x",posicion+1);
        }
        if(cuentaAbiertos>cuentaCerrados)
            this.soloSignos=true;
            if(this.isSigno(this.cuenta.value.charAt(this.cuenta.value.length))== true)
                this.cuenta.value +=")";
            else if(this.resultado.value.length>0){
                 this.cuenta.value +=this.resultado.value;
                this.cuenta.value +=")";
                this.resultado.value=this.cuenta.value;
            }
         
    }
}
var calculadora = new CalculadoraCientifica();
