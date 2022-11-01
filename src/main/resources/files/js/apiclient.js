var apiclient = (function(){

    return {
        login:function(name,passwd){
            const post_request = $.ajax({
               url: "/checkLogin",
               type: "POST",
               data: '{ "name": '+ name +',"password": ' + passwd + '}',
               contentType: "application/json",
            });
        },
    }

})();