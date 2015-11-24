angular.module('app.Controllers')
    .controller('index2',
    function ($scope, $http, $location, $window, $q, $state, urlConstantsFact, $filter) {

        $scope.numberOfTwitByplayer = [];
        $scope.playerEntries = [];
        $scope.predicate = "resultsNumber";
        $scope.reverse = true;

        $http.get(urlConstantsFact.GET_PLAYER_TWITS_COUNT())
            .success(function (data) {
                $scope.numberOfTwitByplayer = data;
            })
    });
