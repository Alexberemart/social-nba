angular.module('app.Controllers')
    .controller('job',
        function ($scope, $http, $location, $window, $q, $state, urlConstantsFact, $compile, options) {

            $scope.dateFromFilter = null;
            $scope.dateToFilter = null;
            $scope.showDetails = {value: false};
            $scope.jobOptions = options;
            var addButton = true;

            $scope.newJob = function () {
                initJobOnEdit();
                $scope.showJobDetails();
            };

            $scope.closeJob = function () {
                initJobOnEdit();
                $scope.hideJobDetails();
            };

            $scope.showJobDetails = function () {
                $scope.showDetails.value = true;

                $('#job-detail').show();
                $('#jobs-table').bootstrapTable('resetView');

                $('#one').removeClass('start')
                    .attr('style', 'flex-basis: 60%');
            };

            $scope.hideJobDetails = function () {
                $scope.showDetails.value = false;

                $('#job-detail').hide();
                $('#jobs-table').bootstrapTable('resetView');

                $('#one').addClass('start')
                    .removeAttr('style');
            };

            $scope.init = function () {

                $scope.$evalAsync(function () {

                    // http://bootstrap-table.wenzhixin.net.cn/documentation/
                    $('#jobs-table').bootstrapTable({
                        method: 'get',
                        url: urlConstantsFact.GET_ALL_JOBS(),
                        cache: false,
                        striped: true,
                        pagination: true,
                        pageNumber: 1,
                        pageSize: 10,
                        pageList: [10, 25, 50, 100, 200],
                        toolbarAlign: "left",
                        searchTimeOut: 1000,
                        searchAlign: 'left',
                        sidePagination: 'server',
                        buttonsAlign: 'right',
                        showColumns: true,
                        onPostBody: addNewJobButton,
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
                                field: 'type',
                                title: 'Tipo',
                                visible: true,
                                sortable: true
                            },
                            {
                                field: 'priority',
                                title: 'Prioridad',
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

            function addNewJobButton() {
                var domElement = $('div[title="Columnas"]');
                if (addButton && (domElement.length !== 0)) {
                    var buttonTpl = '<button class="btn btn-default" ng-click="newJob()" ng-disabled="internal == \'true\'"><i class=" fa fa-user-plus"></i></button>';
                    var button = $compile(angular.element(buttonTpl))($scope);

                    $('div[title="Columnas"]')
                        .addClass('btn-group')
                        .prepend(button)
                        .parent()
                        .removeClass('btn-group');

                    addButton = false;
                }
            }

            function initJobOnEdit() {
                $scope.jobOnEdit = {
                    parameters: [
                        {order: null}
                    ]
                };
            }

            $scope.newParameter = function () {
                $scope.jobOnEdit.parameters.push({order: null});
            };

            $scope.removeParameter = function (parameter) {
                var index = $scope.jobOnEdit.parameters.indexOf(parameter);
                $scope.jobOnEdit.parameters.splice(index, 1);
                if ($scope.jobOnEdit.parameters.length === 0) {
                    $scope.newParameter();
                }
            };

            $scope.saveJob = function () {
                $http.post(urlConstantsFact.GET_ALL_JOBS(), $scope.jobOnEdit);
            }
        });
