angular.module('app.Controllers')
    .controller('index2',
    function ($scope, $http, $location, $window, $q, $state, urlConstantsFact) {

        $scope.numberOfTwitByplayer = [];
        $scope.playerEntries = [];
        $scope.predicate = "resultsNumber";
        $scope.reverse = true;

        $http.get(urlConstantsFact.GET_PLAYER_TWITS_COUNT())
            .success(function (data) {
                $scope.numberOfTwitByplayer = data;
            })

        $scope.init = function () {

            $scope.$evalAsync(function () {

                // http://bootstrap-table.wenzhixin.net.cn/documentation/
                $('#users-table').bootstrapTable({
                    method: 'get',
                    url: urlConstantsFact.GET_ALL_PLAYER_ENTRIES(),
                    cache: false,
                    striped: true,
                    pagination: true,
                    pageNumber: 1,
                    pageSize: 10,
                    pageList: [10, 25, 50, 100, 200],
                    search: true,
                    searchTimeOut: 1000,
                    searchAlign: 'left',
                    sidePagination: 'server',
                    buttonsAlign: 'right',
                    showColumns: true,
                    formatRecordsPerPage: function (pageNumber) {
                        return pageNumber + ' Registros por pagina';
                    },
                    formatLoadingMessage: function () {
                        return 'Cargando, espere por favor…';
                    },
                    formatSearch: function () {
                        return 'Buscar';
                    },
                    formatRefresh: function () {
                        return 'Actualizar';
                    },
                    formatColumns: function () {
                        return 'Columnas';
                    },
                    formatNoMatches: function () {
                        return 'No se han encontrado registros con los criterios seleccionados';
                    },
                    formatShowingRows: function (pageFrom, pageTo, totalRows) {
                        return 'Mostrando ' + pageFrom + ' a ' + pageTo + ' de ' + totalRows + ' filas';
                    },
                    columns: [
                        {
                            field: 'name',
                            title: 'Nombre completo',
                            visible: true,
                            sortable: true
                        },
                        {
                            field: 'points',
                            title: 'Puntos',
                            visible: true,
                            sortable: true
                        }
                    ]
                });

                window.setTimeout(function () {
                    $scope.updateServiceEnabled = true;
                }, 1500);

            });
        };
    });
