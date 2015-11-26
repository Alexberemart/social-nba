angular.module('app.Factory')
    .factory('urlConstantsFact', function ($location) {

        var result;

        //var prefix = 'http://192.168.1.254:8080/HT/Services';
        //var prefix = 'http://localhost:8080/htultimate/rest';
        //var prefix2 = 'http://someone:mypass@localhost:8080/htultimate/rest';
        var prefix = '/socialNBA/rest';
        //var prefix = 'http://alexberemart.synology.me:8080/HT/Services';

        return{
            GET_PLAYER_TWITS_COUNT: function () {
                return prefix + '/Twit/getPlayerTwitsCount';
            },
            GET_ALL_PLAYER_ENTRIES: function () {
                return prefix + '/playerEntry';
            },
            GET_ALL_REST_SERVICE_LOG: function () {
                return prefix + '/restServiceLog';
            }
        };
    });
