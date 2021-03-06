// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services', 'ionic-material', 'ionMdInput'])

.run(function($ionicPlatform) {
    $ionicPlatform.ready(function() {
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
        // for form inputs)
        if (window.cordova && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        }
        if (window.StatusBar) {
            // org.apache.cordova.statusbar required
            StatusBar.styleDefault();
        }
    });
})

.config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {

    // Turn off caching for demo simplicity's sake
    $ionicConfigProvider.views.maxCache(0);

    /*
    // Turn off back button text
    $ionicConfigProvider.backButton.previousTitleText(false);
    */

    $stateProvider.state('app', {
        url: '/app',
        abstract: true,
        templateUrl: 'templates/menu.html',
        controller: 'AppCtrl'
    })

    .state('app.activity', {
        url: '/activity',
        views: {
            'menuContent': {
                templateUrl: 'templates/Query1.html',
                controller: 'ActivityCtrl'
            },
            'fabContent': {
                controller: ''
            }
        }
    })

    .state('app.Query2', {
        url: '/Query2',
        views: {
            'menuContent': {
                templateUrl: 'templates/Query2.html',
                controller: 'ActivityCtrl'
            },
            'fabContent': {
                template: '',
                controller: ''
            }
        }
    })

    .state('app.Query2Results', {
        url: '/Query2Results',
        views: {
            'menuContent': {
                templateUrl: 'templates/Query2Results.html',
                controller: ''
            },
            'fabContent': {
                template: '',
                controller: ''
            }
        }
    })
	

    .state('app.extraInfo', {
        url: '/extraInfo',
        views: {
            'menuContent': {
                templateUrl: 'templates/extraInfo.html',
                controller: ''
            },
            'fabContent': {
                template: '',
                controller: ''
                }
            }
        })
    

    .state('app.gallery', {
        url: '/gallery',
        views: {
            'menuContent': {
                templateUrl: 'templates/gallery.html',
                controller: 'GalleryCtrl'
            },
            'fabContent': {
                template: '<button id="fab-gallery" class="button button-fab button-fab-top-right expanded button-energized-900 drop"><i class="icon ion-heart"></i></button>',
                controller: function ($timeout) {
                    $timeout(function () {
                        document.getElementById('fab-gallery').classList.toggle('on');
                    }, 600);
                }
            }
        }
    })

    .state('app.login', {
        url: '/login',
        views: {
            'menuContent': {
                templateUrl: 'templates/login.html',
                controller: 'LoginCtrl'
            },
            'fabContent': {
                template: ''
            }
        }
    })
	
	.state('app.solveAmbiguity', {
        url: '/solveAmbiguity',
        views: {
            'menuContent': {
                templateUrl: 'templates/solveAmbiguity.html',
                controller: ''
            },
            'fabContent': {
                template: '',
                controller: ''
                }
            }
        })
	
	.state('app.solveAmbiguityArrests', {
        url: '/solveAmbiguityArrests',
        views: {
            'menuContent': {
                templateUrl: 'templates/solveAmbiguityArrests.html',
                controller: ''
            },
            'fabContent': {
                template: '',
                controller: ''
                }
            }
        })
	
	.state('app.solveAmbiguityAwards', {
        url: '/solveAmbiguityAwards',
        views: {
            'menuContent': {
                templateUrl: 'templates/solveAmbiguityAwards.html',
                controller: ''
            },
            'fabContent': {
                template: '',
                controller: ''
                }
            }
        })

    .state('app.InteractiveSearch', {
        url: '/Search',
        views: {
            'menuContent': {
                templateUrl: 'templates/InteractiveSearch.html',
                controller: 'InteractiveSearchCtrl'
            },
            'fabContent': {
                template: '<button id="fab-search" ng-click="searchPopUp()" class="button button-fab button-fab-bottom-right button-energized-900" ><i class="icon ion-plus"></i></button>',
                controller: 'AddQueryCtrl'
            }
        }
    })
	
	.state('app.dynamicQueryResults', {
        url: '/dynamicQuery',
        views: {
            'menuContent': {
                templateUrl: 'templates/dynamicQuery.html',
                controller: ''
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })
	
	
	.state('app.AwardsParams', {
        url: '/AwardsInsertParams',
        views: {
            'menuContent': {
                templateUrl: 'templates/AwardsParameters.html',
                controller: 'ActivityCtrl'
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })
	
	.state('app.dynamicInput', {
        url: '/dynamicInput',
        views: {
            'menuContent': {
                templateUrl: 'templates/dynamicInput.html',
                controller: ''
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })

    .state('app.AwardsResults', {
        url: '/Awards',
        views: {
            'menuContent': {
                templateUrl: 'templates/awards.html',
                controller: ''
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })
	
	.state('app.ArrestsParams', {
        url: '/ArrestsInsertParams',
        views: {
            'menuContent': {
                templateUrl: 'templates/ArrestsParameters.html',
                controller: 'ActivityCtrl'
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })

    .state('app.ArrestsResults', {
        url: '/Arrests',
        views: {
            'menuContent': {
                templateUrl: 'templates/arrests.html',
                controller: ''
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })
	
	.state('app.SameOccupationResults', {
        url: '/SameOccupationResults',
        views: {
            'menuContent': {
                templateUrl: 'templates/SameOccupationCouples.html',
                controller: ''
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })

    .state('app.profile', {
        url: '/Queries',
        views: {
            'menuContent': {
                templateUrl: 'templates/profile.html',
                controller: 'ProfileCtrl'
            },
            'fabContent': {
                controller: function ($timeout) {
                    /*$timeout(function () {
                        document.getElementById('fab-profile').classList.toggle('on');
                    }, 800);*/
                }
            }
        }
    })

    ;

    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/app/Search');
});
