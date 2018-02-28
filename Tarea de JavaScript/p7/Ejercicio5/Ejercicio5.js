
$(document).ready(function(){
    var yaHaSalido=false;
    var yaHaSalidoCajon=false;
    var dondeSeSituaCollar=Math.random() >= 0.5;
    
    $("#islaCofre").click(function(){
        if(yaHaSalido==false){
            $("#cofre").animate({left: '35%'});
            if(dondeSeSituaCollar==true){
                $("#moneda").hide();
                $("#moneda").animate({left: '35%'});
            }
            else{
              $("#collarDibujo").hide();
                $("#collarDibujo").animate({left: '35%'});  
            }
            yaHaSalido=true;
        }
    });
    $("#cofre").click(function(){
        if(dondeSeSituaCollar==true){
            $("#moneda").show();
            $("#moneda").animate({left: '57%'});
        }else{
            $("#collarDibujo").show();
            $("#collarDibujo").animate({left: '57%'});
        }
        $("#ocultarTodoIsla").css("visibility","visible");
        $("#ocultarTodoIsla").show();
    });
     $("#ocultarTodoIsla").click(function(){
         if(dondeSeSituaCollar==true){
            $("#moneda").animate({left: '12%'});
            $("#moneda").hide();
        }else{
           $("#collarDibujo").animate({left: '12%'});
            $("#collarDibujo").hide();
        }
         $("#cofre").animate({left: '12%'});
        $("#ocultarTodoIsla").hide();
         yaHaSalido=false;
    });
    
    
    $("#armario").click(function(){
        if(yaHaSalidoCajon==false){
            $("#cajon").fadeIn(3000);
            yaHaSalidoCajon=true;
        }
    });
    $("#cajon").click(function(){
        if(dondeSeSituaCollar==true){
            $("#collar").fadeIn(590);
        }else{
            $("#reloj").fadeIn(590);
        }
        $("#ocultarTodoArmario").css("visibility","visible");
        $("#ocultarTodoArmario").show();
    });
     $("#ocultarTodoArmario").click(function(){
        if(dondeSeSituaCollar==true){
            $("#collar").fadeToggle(400);
        }else{
            $("#reloj").fadeToggle(400);
        }
        $("#cajon").fadeToggle(1000);
        $("#ocultarTodoArmario").hide();
         yaHaSalidoCajon=false;
    });
    
    $("#collar").click(function(){
        $("body").html("<body><h1>ENHORABUENA</h1><h2>HAS ENCONTRADO EL COLLAR</h2></body>");
        $("h1").css("font-size","360%");
        $("h2").css("font-size","350%").slideUp(1000).slideDown(2000).slideUp(1000).slideDown(2000);
        $("h1").css("color","#ffffff");
        $("h2").css("color","#ffffff");
        $("body").css("background","#000000");
    });
    $("#collarDibujo").click(function(){
      $("body").html("<body><h1>ENHORABUENA</h1><h2>HAS ENCONTRADO EL COLLAR</h2></body>");
        $("h1").css("font-size","360%");
        $("h2").css("font-size","350%").slideUp(1000).slideDown(2000).slideUp(1000).slideDown(2000);
        $("h1").css("color","#ffffff");
        $("h2").css("color","#ffffff");
        $("body").css("color","#ffffff");
        $("body").css("background","#000000");
    });
    
});