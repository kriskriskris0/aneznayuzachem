let	id-name = 321;
let routeId = 2;

// Создаем экземпляр класса XMLHttpRequest
const request = new XMLHttpRequest();

// Указываем путь до файла на сервере, который будет обрабатывать наш запрос
const url = "BusController.java";

// Так же как и в GET составляем строку с данными, но уже без пути к файлу
const params = "id-name=" + id-name+ "&routeId=" + routeId;

/* Указываем что соединение	у нас будет POST, говорим что путь к файлу в переменной url, и что запрос у нас
асинхронный, по умолчанию так и есть не стоит его указывать, еще есть 4-й параметр пароль авторизации, но этот
	параметр тоже необязателен.*/
request.open("POST", url, true);

//В заголовке говорим что тип передаваемых данных закодирован.
request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

request.addEventListener("readystatechange", () => {

    if(request.readyState === 4 && request.status === 200) {
		console.log(request.responseText);
    }
});

//	Вот здесь мы и передаем строку с данными, которую формировали выше. И собственно выполняем запрос.
request.send(params);





$(document).on('click', '.todo-link', function(){
    var link = $(this);
    var todoId = link.data('id');
    $.ajax({
        method: "GET",
        url: '/todo-list/' + todoId,
        success: function(response)
        {
            if($('.todo-div > span').is('#' + todoId)){
                return;
            }
            link.parent().append(codeDataTodo(response, todoId));
        },
        error: function(response)
        {
            if(response.status == 404) {
                alert('Дело не найдено!');
            }
        }
    });
    return false;
});


//Update _todo and show updating _todo form
$(document).on('click', '#show-update-todo-list', function(){
    var buttonUpdate = $(this);
    var todoId = buttonUpdate.data('id');
    var todoName = buttonUpdate.data('name');
    var todoDescription = buttonUpdate.data('description');
    var todoDate = buttonUpdate.data('date');
    todoFormNameAndButton('Изменить дело', 'Изменить', 'update-todo');
    todoInputValue(todoName, todoDescription, todoDate);
    $('#todo-form').css('display', 'flex');
    $('#update-todo').click(function() {
        var data = $('#todo-form form').serialize();
        $.ajax({
            method: "PUT",
            url: '/todo-list/' + todoId,
            data: data,
            success: function(response) {
                $('#todo-form').css('display', 'none');
                response.date = response.date.slice(0,10);
                $('.todo-div#' + todoId  + ' > a').text(response.name);
                $('.todo-div#' + todoId +' > span').replaceWith(codeDataTodo(response, todoId));
            }
        });
        return false;
    });
});