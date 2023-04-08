$(function(){
   const appendTask = function(data){
      let taskCode = '<a href="#" class="task-link" data-id=" + data.id + ">' + data.name + '</a><br>S';
      $('#task-list').append('<div> + taskCode + </div>');
   };

   $.get('/tasks/', function(response){
      for(i in response){
         appendTask(response[i]);
      }
   });

   $('#show-add-task-form').click(function(){
      $('#task-form').css('display', 'flex');
   });

   $('#task-form').click(function(event){
      if(event.target === this){
         $(this).css('display', 'none');
      }
   });

   $(document).on('click', '.task-link', function(){
      let link = $(this);
      let taskId = link.data('id');
      $.ajax({
         method: "GET",
         url: '/tasks/' + taskId,
         success: function(response){
            let code = '<span>Время создания: + recponce.time + </span>';
            link.parent().append(code);
         },
         error: function(recponce){
            if(recponce.status == 404){
               alert('Задача не найдена!');
            }
         };
      });
      return false;
   });

   $('#save-task').click(function(){
      let data = $('task-form form').serialize();
      $.ajax({
         method: "POST",
         url: '/tasks/',
         data: data,
         success: function(response){
            $('#task-form').css('display', 'none');
            let task = {};
            task.id = response;
            let dataArray = $('#task-form form').serializeArray();
            for(i in dataArray){
               task[dataArray[i]['name']] = dataArray[i]['value'];
            }
            appendTask(task);
         }
      });
      return false;
   });
});