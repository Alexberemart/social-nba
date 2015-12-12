angular.module('app.Controllers')
    .controller('main',
    function ($scope, $http, $location, $window, $q, $state, urlConstantsFact, $filter) {

        $scope.dateFromFilter = null;
        $scope.dateToFilter = null;

        $scope.addExtraQueryParams = function (params) {

            var dateFromFilterMilli = 0;
            var dateToFilterMilli = 0;

            if ($scope.dateFromFilter != null && $scope.dateFromFilter != "") {
                dateFromFilterMilli = $scope.dateFromFilter;
            }

            if ($scope.dateToFilter != null && $scope.dateToFilter != "") {
                dateToFilterMilli = $scope.dateToFilter;
            }

            params['dateFromFilter'] = dateFromFilterMilli;
            params['dateToFilter'] = dateToFilterMilli;
            return params;
        };

        $scope.$watchGroup(['dateFromFilter', 'dateToFilter'], function (newValue) {
            if (newValue[0] !== -1) {
                $('#users-table').bootstrapTable('refresh', {silent: true});
            }
        });

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
                    toolbar: "#custom-toolbar-player-entries",
                    toolbarAlign: "left",
                    queryParams: $scope.addExtraQueryParams,
                    search: true,
                    searchTimeOut: 1000,
                    searchAlign: 'left',
                    sidePagination: 'server',
                    buttonsAlign: 'right',
                    showColumns: true,
                    showRefresh: true,
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
                            field: 'player.name',
                            title: 'Nombre completo',
                            visible: true,
                            sortable: true
                        },
                        {
                            field: 'match.date',
                            title: 'Fecha',
                            visible: true,
                            sortable: true,
                            formatter: function (value) {
                                return filteredDate = $filter('date')(value, "dd/MM/yyyy");
                            }
                        },
                        {
                            field: 'ranking',
                            title: 'Valor',
                            visible: true,
                            sortable: true
                        },
                        {
                            field: 'points',
                            title: 'Puntos',
                            visible: true,
                            sortable: true
                        },
                        {
                            field: 'rebounds',
                            title: 'Rebotes',
                            visible: true,
                            sortable: true
                        },
                        {
                            field: 'assists',
                            title: 'Asistencias',
                            visible: true,
                            sortable: true
                        },
                        {
                            field: 'steals',
                            title: 'Robos',
                            visible: false,
                            sortable: true
                        },
                        {
                            field: 'blocks',
                            title: 'Tapones',
                            visible: false,
                            sortable: true
                        },
                        {
                            field: 'turnovers',
                            title: 'Perdidas',
                            visible: false,
                            sortable: true
                        },
                        {
                            field: 'personalFouls',
                            title: 'Personales',
                            visible: false,
                            sortable: true
                        },
                        {
                            field: 'fieldGoals',
                            title: 'Tiros de Campo Anotados',
                            visible: false,
                            sortable: true
                        },
                        {
                            field: 'fieldGoalAttempts',
                            title: 'Tiros de Campo intentados',
                            visible: false,
                            sortable: true
                        },
                        {
                            field: 'freeThrows',
                            title: 'Tiros libres anotados',
                            visible: false,
                            sortable: true
                        },
                        {
                            field: 'freeThrowAttempts',
                            title: 'Tiros libres intentados',
                            visible: false,
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
