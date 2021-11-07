         /*MOTOS*/

function traerInformacion(){
    $.ajax({
        url:'http://168.138.149.45:8080/api/Motorbike/all',
        data:"{}",
        type:'GET',
        dataType:'json',
        contentType:"application/json; charset=utf-8",
        success : function(respuesta){
            console.log(respuesta);
            $("#resultado").empty();
            pintarRespuesta(respuesta.items);
        }
    });
}
function pintarRespuesta(items){
    let miTabla ='<table>';
    for (i=0; i<items.length; i++){
        miTabla += '<tr>';
        miTabla += '<td>'+items[i].id+'</td>';
        miTabla += '<td>'+items[i].name+'</td>';
        miTabla += '<td>'+items[i].brand+'</td>';
        miTabla += '<td>'+items[i].model+'</td>';
        miTabla += '<td>'+items[i].category_id+'</td>';
        miTabla += "<td><button onclick='rellenarCampos("+items[i].id+")'>Editar</button>";
        miTabla += "<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
    

        
        miTabla += '</tr>';
    }
    miTabla +='</table>';
    $("#resultado").append(miTabla);

}
function guardarInformacion(){
    let myData ={
        id:$("#id").val(),
        name:$("#name").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'http://168.138.149.45:8080/api/Motorbike/save',
        type: "POST",
        data: myData,
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
        $("#id").val("");
        $("#name").val("");
        $("#brand").val("");
        $("#model").val("");
        $("#category_id").val("");
        traerInformacion("");
            alert("se ha guardado.")
        }
});
}
function rellenarCampos(codigo){
    $.ajax({
        url:'http://168.138.149.45:8080/api/Motorbike/'+codigo,
        type: "GET",
        data: "{}",
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
            for(i=0; i<respuesta.items.length; i++){
            $("#id").val(respuesta.items[i].id);
            $("#name").val(respuesta.items[i].name);
            $("#brand").val(respuesta.items[i].brand);
            $("#model").val(respuesta.items[i].model);
            $("#category_id").val(respuesta.items[i].category_id);
            $("#id").attr("readonly",true);
                
            }
        }     
    });
}
function editarInformacion(){
    let myData ={
        id:$("#id").val(),
        name:$("#name").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
      
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/moto/moto',
        type: "PUT",
        data: dataToSend,
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
        $("#id").val("");
        $("#name").val("");
        $("#brand").val("");
        $("#model").val("");
        $("#category_id").val("");
        $("#id").attr("readonly",false);
        traerInformacion("");
            alert("se ha Actualizado.")
        }
});
}
function borrarElemento(idElemento){
    let myData ={
        id:idElemento
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/moto/moto',
        type: "DELETE",
        data: dataToSend,
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
       
        traerInformacion();
            alert("se ha Eliminado.")
        }
});
}






/* CLIENTE */




function traerInformacion2(){
    $.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client',
        data:"{}",
        type:'GET',
        dataType:'json',
        contentType:"application/json; charset=utf-8",
        success : function(respuesta){
           // console.log(respuesta);
            $("#resultado").empty();
            pintarRespuesta2(respuesta.items);
        }
    });
}
function pintarRespuesta2(items){
    let miTabla ='<table>';
    for (i=0; i<items.length; i++){
        miTabla += '<tr>';
        miTabla += '<td>'+items[i].id+'</td>';
        miTabla += '<td>'+items[i].name+'</td>';
        miTabla += '<td>'+items[i].email+'</td>';
        miTabla += '<td>'+items[i].age+'</td>';
        //miTabla += '<td>'+items[i].category_id+'</td>';
        miTabla += "<td><button onclick='rellenarCampos2("+items[i].id+")'>Editar</button>";
        miTabla += "<td><button onclick='borrarElemento2("+items[i].id+")'>Borrar</button>";
    

        
        miTabla += '</tr>';
    }
    miTabla +='</table>';
    $("#resultado").append(miTabla);

}
function guardarInformacion2(){
    let myData ={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
       // category_id:$("#category_id").val(),
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client',
        type: "POST",
        data: myData,
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
        $("#id").val("");
        $("#name").val("");
        $("#email").val("");
        $("#age").val("");
       // $("#category_id").val("");
        traerInformacion2("");
            alert("se ha guardado.")
        }
});
}
function rellenarCampos2(codigo){
    $.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client/'+codigo,
        type: "GET",
        data: "{}",
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
            for(i=0; i<respuesta.items.length; i++){
            $("#id").val(respuesta.items[i].id);
            $("#name").val(respuesta.items[i].name);
            $("#email").val(respuesta.items[i].email);
            $("#age").val(respuesta.items[i].age);
            //$("#category_id").val(respuesta.items[i].category_id);
            $("#id").attr("readonly",true);
                
            }
        }     
    });
}
function editarInformacion2(){
    let myData ={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
        //category_id:$("#category_id").val(),
      
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client',
        type: "PUT",
        data: dataToSend,
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
        $("#id").val("");
        $("#name").val("");
        $("#email").val("");
        $("#age").val("");
        //$("#category_id").val("");
        $("#id").attr("readonly",false);
        traerInformacion2("");
            alert("se ha Actualizado.")
        }
});
}
function borrarElemento2(idElemento){
    let myData ={
        id:idElemento
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client',
        type: "DELETE",
        data: dataToSend,
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
       
        traerInformacion2();
            alert("se ha Eliminado.")
        }
});
}

/*MENSAJE*/



function traerInformacion3(){
    $.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message',
        data:"{}",
        type:'GET',
        dataType:'json',
        contentType:"application/json; charset=utf-8",
        success : function(respuesta){
          //  console.log(respuesta);
            $("#resultado").empty();
            pintarRespuesta3(respuesta.items);
        }
    });
}
function pintarRespuesta3(items){
    let miTabla ='<table>';
    for (i=0; i<items.length; i++){
        miTabla += '<tr>';
        miTabla += '<td>'+items[i].id+'</td>';
        miTabla += '<td>'+items[i].messagetext+'</td>';
       // miTabla += '<td>'+items[i].brand+'</td>';
       // miTabla += '<td>'+items[i].model+'</td>';
        //miTabla += '<td>'+items[i].category_id+'</td>';
        miTabla += "<td><button onclick='rellenarCampos3("+items[i].id+")'>Editar</button>";
        miTabla += "<td><button onclick='borrarElemento3("+items[i].id+")'>Borrar</button>";
    

        
        miTabla += '</tr>';
    }
    miTabla +='</table>';
    $("#resultado").append(miTabla);

}
function guardarInformacion3(){
    let myData ={
        id:$("#id").val(),
        messagetext:$("#messagetext").val(),
      //  brand:$("#brand").val(),
       // model:$("#model").val(),
       // category_id:$("#category_id").val(),
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message',
        type: "POST",
        data: myData,
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
        $("#id").val("");
        $("#messagetext").val("");
       // $("#brand").val("");
       // $("#model").val("");
       // $("#category_id").val("");
        traerInformacion3("");
            alert("se ha guardado.")
        }
});
}
function rellenarCampos3(codigo){
    $.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message/'+codigo,
        type: "GET",
        data: "{}",
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
            for(i=0; i<respuesta.items.length; i++){
            $("#id").val(respuesta.items[i].id);
            $("#messagetext").val(respuesta.items[i].messagetext);
           // $("#brand").val(respuesta.items[i].brand);
           // $("#model").val(respuesta.items[i].model);
           // $("#category_id").val(respuesta.items[i].category_id);
            $("#id").attr("readonly",true);
                
            }
        }     
    });
}
function editarInformacion3(){
    let myData ={
        id:$("#id").val(),
        messagetext:$("#messagetext").val(),
        //brand:$("#brand").val(),
        //model:$("#model").val(),
        //category_id:$("#category_id").val(),
      
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message',
        type: "PUT",
        data: dataToSend,
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
        $("#id").val("");
        $("#messagetext").val("");
       // $("#brand").val("");
       // $("#model").val("");
       // $("#category_id").val("");
        $("#id").attr("readonly",false);
        traerInformacion3("");
            alert("se ha Actualizado.")
        }
});
}
function borrarElemento3(idElemento){
    let myData ={
        id:idElemento
    };

let dataToSend=JSON.stringify(myData);
$.ajax({
        url:'https://gd0524e8ffa6b62-bdmotos.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message',
        type: "DELETE",
        data: dataToSend,
        contentType:"application/JSON",
        datatype: "json",
        success:function(respuesta){
        $("#resultado").empty();
       
        traerInformacion3();
            alert("se ha Eliminado.")
        }
});
}