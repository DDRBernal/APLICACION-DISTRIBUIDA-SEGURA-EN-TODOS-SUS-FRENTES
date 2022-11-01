var app = (function(){

    function login(name,passwd){
        apiclient.login(name,passwd);
    }

    return {
        login : login
    }

})();