angular.module('app.services', []).factory('ServiceDetails', function($resource) {
  return $resource('/api/v1/ServiceDetails/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
