angular.module('app.Controllers')
    .controller('restServiceLog',
    function ($scope, $http, $location, $window, $q, $state, urlConstantsFact, $filter) {

        $scope.init = function () {

            $scope.$evalAsync(function () {

                $('#rest-service-log-table').bootstrapTable({
                    method: 'get',
                    url: urlConstantsFact.GET_ALL_REST_SERVICE_LOG(),
                    cache: false,
                    striped: true,
                    pagination: true,
                    pageNumber: 1,
                    pageSize: 10,
                    pageList: [10, 25, 50, 100, 200],
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
                            field: 'date',
                            title: 'Fecha',
                            visible: true,
                            sortable: true,
                            formatter: function (value) {
                                return $filter('date')(value, "dd/MM/yyyy HH:mm:ss");
                            }
                        },
                        {
                            field: 'restServiceName',
                            title: 'Nombre Servicio',
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
