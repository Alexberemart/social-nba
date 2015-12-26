angular.module('app.Factory')
    .factory('jobOptions', function ($http, $q, $log, urlConstantsFact) {
        var ONE_DAY_IN_MILLIS = 86400000;
        var OPTIONS_KEY = 'jobOptions';

        var instance = {};

        instance.getOptions = function () {
            //var hattrickOptions = appSession.get(OPTIONS_KEY, null);
            var hattrickOptions = null;

            if (!!hattrickOptions) {
                var span = (new Date(hattrickOptions.date + ONE_DAY_IN_MILLIS)).getTime();
                var today = (new Date()).getTime();
                if (today > span) {
                    //appSession.put(OPTIONS_KEY, null);
                    return instance.getOptions();
                } else {
                    return $q.when(hattrickOptions.options);
                }
            } else {
                return $http
                    .get(urlConstantsFact.GET_JOB_OPTIONS_URL())
                    .then(function (response) {
                        //appSession.put(OPTIONS_KEY, {
                        //    date: (new Date()).getTime(),
                        //    options: response.data
                        //});

                        return response.data;
                    })
                    .catch(function (response) {
                        $log.error('Error getting hattrick options', response);
                    });
            }
        };

        return instance;
    });
