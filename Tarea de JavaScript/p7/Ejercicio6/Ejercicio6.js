class CambioMoneda{
    constructor(){
        this.apikey = "3b5372268a587e2cb74da25662fcb095";
        this.monedas = "EUR,USD,GBP,CAD,PLN,JPY,BGN,KRW,IDR,RUB";
        this.url = "http://apilayer.net/api/live?access_key="+this.apikey+"&currencies="+this.monedas+"&source=USD&format=1";
        this.error = "<h2>¡problemas! No puedo obtener información de <a href='https://currencylayer.com/'>Currencylayer</a></h2>";
        this.datos=null;
    }
    cargarDatos(adds){
        $("#Aviso").hide();
        $("#cifraFinal").hide();
        $.ajax({
            dataType: "json",
            url: this.url,
            method: 'GET',
            success: function(data){
                this.datos = data;
                var monedasAMostrar=adds.split(",");
                var s=document.getElementById('monedas');
                var c=document.getElementById('monedasIntroducidas');
                for (var x=0;x<monedasAMostrar.length;x++){
                    var valor = eval("this.datos.quotes.USD"+ monedasAMostrar[x]);
                    var nombre = monedasAMostrar[x];
                    var option=document.createElement("option"); 
                    option.value= valor;
                    option.text=nombre;
                    option.id=nombre;
                    s.appendChild(option);
                    var op2 = document.createElement("option");
                    op2.value=valor;
                    op2.text=nombre;
                    op2.id=nombre;
                    c.appendChild(op2);
                }
                $("#monedas #USD").attr("selected",true); 
            },
            error:function(){
                document.write(cambioMoneda.error);    
            }
        });
    }
    verJSON(){
        document.write("<h2>Datos en JSON desde <a href='https://currencylayer.com/'>Currencylayer</a></h2>");
        document.write("<h3>JSON</h3>")
        var str = JSON.stringify(cambioMoneda.datos, null, 2);
        document.write("<pre>" + str + "</pre>");
    }
    pasarDeXaY(){
        if(document.getElementById("CantidadIntroducida").value.length >0 
           && document.getElementById('monedasIntroducidas').value!="undefined"
            && document.getElementById('monedas').value!="undefined"){
            var valorMonedaEscogida = document.getElementById('monedasIntroducidas').value;
            var valorAcambiar=document.getElementById('monedas').value;
            $("#cifraFinal").html("<p>"+document.getElementById("CantidadIntroducida").value+ " "+$("#monedasIntroducidas option:selected").text()+" - "+eval("Math.round(100*("+document.getElementById("CantidadIntroducida").value+"*"+valorAcambiar+")/"+valorMonedaEscogida+")/100") +" "+ 
            $("#monedas option:selected").text() +"</p>");
            $("#cifraFinal").show();
            $("#Aviso").show();
        }
    }

    addNuevaMoneda(){
        if(document.getElementById("nuevasIniciales").value.length >0){
            this.monedas +=","+document.getElementById("nuevasIniciales").value;
            this.url = "http://apilayer.net/api/live?access_key="+cambioMoneda.apikey+"&currencies="+cambioMoneda.monedas+"&source=USD&format=1";
            this.cargarDatos(this.monedas);
            document.getElementById("nuevasIniciales").value="";
            $("#addN").after("<p class='Efimero'>Añadido Correctamente </p><p class='Efimero'>**Si ha introducido una iniciales erronean no se producirá ninguna conversión**</p>");
            $(".Efimero").fadeOut(5000);
        }
    }
}var cambioMoneda = new CambioMoneda();
