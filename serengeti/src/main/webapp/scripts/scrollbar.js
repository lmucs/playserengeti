//var scrollbar = function(){
//		//Get our elements for faster access and set overlay width
//		var div = $('div.hor_menu'),
//			ul = $('ul.hor_menu'),
//			ulPadding = 15;
//		
//		//Get menu width
//		var divWidth = div.width();
//	
//		//Remove scrollbars	
//		div.css({overflow: 'hidden'});
//		
//		//Find last image container
//		var lastLi = ul.find('li:last-child');
//		
//		//When user move mouse over menu
//		div.mousemove(function(e){
//			//As images are loaded ul width increases,
//			//so we recalculate it each time
//			var ulWidth = lastLi[0].offsetLeft + lastLi.outerWidth() + ulPadding;	
//			var left = (e.pageX - div.offset().left) * (ulWidth-divWidth) / divWidth;
//			div.scrollLeft(left);
//		});
//};

var scrollbar = function(idsToTouch){
	//Remove scrollbars	
	$('div.hor_menu').css({overflow: 'hidden'});
	
	var i = 0;
	var divs = [];
	var uls = [];
	var lastLis = [];
	for (i = 0; i < idsToTouch.length; i++) {
		//Get our elements for faster access and set overlay width
		divs[i] = $('div.' + idsToTouch[i]);
		uls[i] = $('ul.' + idsToTouch[i]);
		var ulPadding = 15;
		
		//Get menu width
		var divWidth = divs[i].width();
	
		//Find last image container
		lastLis[i] = uls[i].find('li:last-child');
		
		//When user move mouse over menu
		divs[i].mousemove(createHandler(divs[i], lastLis[i]));
	}
};

var createHandler = function(div, lastLi) {
	return function(e) {
		//As images are loaded ul width increases,
		//so we recalculate it each time
		var ulWidth = lastLi[0].offsetLeft + lastLi.outerWidth() + 15;	
		var left = (e.pageX - div.offset().left) * (ulWidth-div.width()) / div.width();
		div.scrollLeft(left);
	};
};
