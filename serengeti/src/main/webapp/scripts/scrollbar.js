var moveRightVar=null;
var moveLeftVar=null;
var speed=5;

var scrollbar = function(leftArrowIds, scrollAreaIds, rightArrowIds){
	
	
	
	//specify speed of scroll (greater=faster)
	
	var divs = [];
	var i = 0;

		for (i = 0; i < leftArrowIds.length; i++) {
			var leftArrow = document.getElementById(leftArrowIds[i]);
			var scrollArea = document.getElementById(scrollAreaIds[i]);
			var rightArrow = document.getElementById(rightArrowIds[i]);

			leftArrow.onmouseover = createMoveLeftHandler(scrollArea);
			rightArrow.onmouseover = createMoveRightHandler(scrollArea);
		}

};

var createMoveRightHandler = function(div) {
	return function(e) {
		moveRightVar = setInterval(function() { moveRight(div); }, 20);
	};
};

var createMoveLeftHandler = function(div) {
	return function(e) {
		moveLeftVar = setInterval(function() { moveLeft(div); }, 20);
	};
};
		
		function moveRight(crossobj){
			var contentWidth = crossobj.offsetWidth;
			if (parseInt(crossobj.style.left,10)>=(contentWidth*(-1)+100)){
				crossobj.style.left=parseInt(crossobj.style.left,10)-speed+"px";
		        }
//			moveRightVar=setTimeout(moveRight,20);
			}

		function moveLeft(crossobj){
			var contentWidth = crossobj.offsetWidth;
			if (parseInt(crossobj.style.left,10)<=0){
				crossobj.style.left=parseInt(crossobj.style.left,10)+speed+"px";
		        }
//			moveLeftVar=setTimeout(moveLeft,20);

		}


		function getContent_Width(crossobj){
		      contentWidth=crossobj.offsetWidth;
		}
		window.onload=getContent_Width('recentlyCheckedIn');