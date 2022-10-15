var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {

        $("#mi-perfil-btn").attr("href", "profile.html?username=" + username);

        $("#user-saldo").html(user.saldo.toFixed(2) + "$");

        getMaquinas(false, "ASC");

        $("#ordenar-genero").click(ordenarMaquinas);
    });
});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
   } 
    function getMaquinas(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMaquinaListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarMaquinas(parsedResult);
            } else {
                console.log("Error recuperando los datos de las peliculas");
            }
        }
    });
}

function mostrarMaquinas(maquinas) {

    let contenido = "";

    $.each(maquinas, function (index, maquina) {

        maquina = JSON.parse(maquina);
        
            contenido += '<tr><th scope="row">' + maquina.id + '</th>' +
                    '<td>' + maquina.Nombre + '</td>' +
                    '<td>' + maquina.Referencia + '</td>' +
                    '<td>' + maquina.Modelo + '</td>' +
                    '<td>' + maquina.Potencia + '</td>' +
                    '<td>' + maquina.Capacidad + '</td>' +
                    '<td>' + maquina.Otros + '</td>' +
                    '<td>' + maquina.Stock + '</td>' +
                    '<td><button class="btn btn-success">Rentar</button></td></tr>'

        
    });
    $("#maquinas-tbody").html(contenido);
}

function ordenarMaquinas() {
    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getMaquinas(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getMaquinas(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getMaquinas(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}
