class Mapa{
    constructor(){
        this.map=null;
        this.json=null;
        this.conOp=false;
        this.sinOp=false;
        this.coordenaXinicial=0;
        this.coordenaYinicial=0;
        this.color=''; 
    }

    pintarMapa() {
        if(this.validarDatosIntroducidos()){
            this.crearJsonConOpciones();
            this.map = new google.maps.Map(document.getElementById('map'), {
                zoom: 4,
                center: {lat: this.coordenaYinicial, lng: this.coordenaXinicial}
            });

            // Load GeoJSON.
            this.map.data.addGeoJson(this.json);
            //map.data.loadGeoJson('datosLetras.json');

            // Set the stroke width, and fill color for each polygon
            this.map.data.setStyle({
              fillColor: this.color,
              strokeWeight: 1
            });
        }
    }
    inicializar(){
        document.getElementById("sinOpciones").style.display="none";
        document.getElementById("conOpciones").style.display="none";
        document.getElementById("pintar").style.display="none";
    }
    
    crearJsonConOpciones(){
        this.color=document.getElementById('color').value;
        if(this.sinOp){
            this.coordenaXinicial= eval(document.getElementById('lng').value);
            this.coordenaYinicial=eval(document.getElementById('lat').value);
        }
        if(this.conOp){
            this.coordenaXinicial= eval(document.getElementById('city').value.split(',')[1]);
            this.coordenaYinicial=eval(document.getElementById('city').value.split(',')[0]);
        }
        var formaSeleccionada=document.getElementById('forma').value;
        if(formaSeleccionada=='cuadrado'){
            this.json={
                    "type": "FeatureCollection",
                    "features": [
                    {
                        "type": "Feature",
                        "geometry": {
                        "type": "Polygon",
                        "coordinates": [
                                [
                                [this.coordenaXinicial, this.coordenaYinicial], [this.coordenaXinicial+10, this.coordenaYinicial], [this.coordenaXinicial+10, this.coordenaYinicial-7], [this.coordenaXinicial, this.coordenaYinicial-7], [this.coordenaXinicial, this.coordenaYinicial]
                                ]
                            ]
                        }
                    }
                    ]
            };
        }
        else if(formaSeleccionada=='triangulo'){
            this.json={
                    "type": "FeatureCollection",
                    "features": [
                    {
                        "type": "Feature",
                        "geometry": {
                        "type": "Polygon",
                        "coordinates": [
                                [
                                [this.coordenaXinicial, this.coordenaYinicial], [this.coordenaXinicial+10, this.coordenaYinicial-10], [this.coordenaXinicial-10, this.coordenaYinicial-10], [this.coordenaXinicial, this.coordenaYinicial]
                                ]
                            ]
                        }
                    }
                    ]
            };
        }
        else if(formaSeleccionada=='rectangulo'){
            this.json={
                    "type": "FeatureCollection",
                    "features": [
                    {
                        "type": "Feature",
                        "geometry": {
                        "type": "Polygon",
                        "coordinates": [
                                [
                                [this.coordenaXinicial, this.coordenaYinicial], [this.coordenaXinicial+20, this.coordenaYinicial], [this.coordenaXinicial+20, this.coordenaYinicial-8], [this.coordenaXinicial, this.coordenaYinicial-8], [this.coordenaXinicial, this.coordenaYinicial]
                                ]
                            ]
                        }
                    }
                    ]
            };
        }
    }

    aMano(){
        document.getElementById("sinOpciones").style.display="";
        document.getElementById("conOpciones").style.display="none";
        document.getElementById("pintar").style.display="";
        this.sinOp=true;
        this.conOp=false;
    }

    selectCity(){
        document.getElementById("sinOpciones").style.display="none";
        document.getElementById("conOpciones").style.display="";
        document.getElementById("pintar").style.display="";
        this.conOp=true;
        this.sinOp=false;
    }
    validarDatosIntroducidos(){
        if(this.sinOp){
            if(eval(document.getElementById('lng').value)> -169 && eval(document.getElementById('lng').value)< 169
              && eval(document.getElementById('lat').value)> -79 && eval(document.getElementById('lat').value)< 79){  
                return true;
            }else{
                alert("valores incorrectos");
                return false;
            }

        }return true;
    }
}
var mapa=new Mapa();