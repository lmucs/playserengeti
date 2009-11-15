//
//var scrollbar = function(idsToTouch){
//	//Remove scrollbars	
//	$('div.hor_menu').css({overflow: 'hidden'});
//	
//	var i = 0;
//	var divs = [];
//	var uls = [];
//	var lastLis = [];
//	for (i = 0; i < idsToTouch.length; i++) {
//		//Get our elements for faster access and set overlay width
//		divs[i] = $('div.' + idsToTouch[i]);
//		uls[i] = $('ul.' + idsToTouch[i]);
//		var ulPadding = 15;
//		
//		//Get menu width
//		var divWidth = divs[i].width();
//	
//		//Find last image container
//		lastLis[i] = uls[i].find('li:last-child');
//		
//		//When user move mouse over menu
//		divs[i].mousemove(createHandler(divs[i], lastLis[i]));
//	}
//};
//
//var createHandler = function(div, lastLi) {
//	return function(e) {
//		//As images are loaded ul width increases,
//		//so we recalculate it each time
//		var ulWidth = lastLi[0].offsetLeft + lastLi.outerWidth() + 15;	
//		var left = (e.pageX - div.offset().left) * (ulWidth-div.width()) / div.width();
//		div.scrollLeft(left);
//	};
//};


//
//
//
//var idsToTouch = ['scrollContent'];
//
//
//var moveRightVar=null;
//var moveLeftVar=null;
//
////specify speed of scroll (greater=faster)
//var speed=5
//var i = 0;
//
//
////	var crossobj=document.getElementById("scrollContent");
//	var crossobj = idsToTouch[i];
//	var contentWidth = crossobj.offsetWidth;
//	
//	function moveRight(){
//		if (parseInt(crossobj.style.left,10)>=(contentWidth*(-1)+100)){
//			crossobj.style.left=parseInt(crossobj.style.left,10)-speed+"px";
//	        }
//		moveRightVar=setTimeout(moveRight,20);
//		}
//
//	function moveLeft(){
//		if (parseInt(crossobj.style.left,10)<=0){
//			crossobj.style.left=parseInt(crossobj.style.left,10)+speed+"px";
//	        }
//		moveLeftVar=setTimeout(moveLeft,20);
//
//	}
//
//	function getContent_Width(){
//	      contentWidth=crossobj.offsetWidth;
//	}
//	window.onload=getContent_Width();
