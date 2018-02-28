class Meteo{
    constructor(){
        this.apikey = "47b790fd0fc41878c80c57c9846132cb";
        this.ciudad = "Oviedo";
        this.unidades = "&units=metric";
        this.idioma = "&lang=es";
        this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + this.ciudad + this.unidades + this.idioma + "&APPID=" + this.apikey;
        this.error = "<h2>¡problemas! No puedo obtener información de <a href='http://openweathermap.org'>OpenWeatherMap</a></h2>";
        this.datos = null;
    }
    cargarDatos(){
        $.ajax({
            dataType: "json",
            url: this.url,
            method: 'GET',
            success: function(data){
                this.datos = data;
                
                //this.verJSON();
                document.write("<h2>Datos en JSON desde <a href='http://openweathermap.org'>OpenWeatherMap</a></h2>");
                document.write("<h3>JSON</h3>")
                var str = JSON.stringify(this.datos, null, 2);
                document.write("<pre>" + str + "</pre>");
                
                //this.verDatos(); 
                document.write("<h3>Datos</h3>")
                document.write("<p>Ciudad: " + this.datos.name + "</p>");
                document.write("<p>País: " + this.datos.sys.country + "</p>");
                document.write("<p>Latitud: " + this.datos.coord.lat + " grados</p>");
                document.write("<p>Longitud: " + this.datos.coord.lon + " grados</p>");
                document.write("<p>Temperatura: " + this.datos.main.temp + " grados Celsius</p>");
                document.write("<p>Temperatura máxima: " + this.datos.main.temp_max + " grados Celsius</p>");
                document.write("<p>Temperatura mínima: " + this.datos.main.temp_min + " grados Celsius</p>");
                document.write("<p>Presión: " + this.datos.main.pressure + " milímetros</p>");
                document.write("<p>Humedad: " + this.datos.main.humidity + "%</p>"); 
                document.write("<p>Amanece a las: " + new Date(this.datos.sys.sunrise *1000).toLocaleTimeString() + "</p>"); 
                document.write("<p>Oscurece a las: " + new Date(this.datos.sys.sunset *1000).toLocaleTimeString() + "</p>"); 
                document.write("<p>Dirección del viento: " + this.datos.wind.deg + "  grados</p>");
                document.write("<p>Velocidad del viento: " + this.datos.wind.speed + " metros/segundo</p>");
                document.write("<p>Hora de la medida: " + new Date(this.datos.dt *1000).toLocaleTimeString() + "</p>");
                document.write("<p>Fecha de la medida: " + new Date(this.datos.dt *1000).toLocaleDateString() + "</p>");
                document.write("<p>Descripción: " + this.datos.weather[0].description + "</p>");
                document.write("<p>Visibilidad: " + this.datos.visibility + " metros</p>");
                document.write("<p>Nubosidad: " + this.datos.clouds.all + " %</p>");
                
                
                document.body.firstElementChild.style.textAlign="center";
                document.body.style.marginLeft="5%";
                document.body.firstElementChild.style.marginLeft="5%";
                document.body.firstElementChild.style.marginRight="10%";
            },
            error:function(){
                document.write(this.error);    
            }
        });
    }
}
var meteo = new Meteo();