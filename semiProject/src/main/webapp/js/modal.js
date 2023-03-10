
var Avgrund = (function(){

	var container = document.documentElement,
		popup = document.querySelector( '.avgrund-popup-animate' ),
		cover = document.querySelector( '.avgrund-cover' ),
		currentState = null;

	container.classList.add( 'avgrund-ready' );

	// esc로  창 닫기
	function onDocumentKeyUp( event ) {

		if( event.keyCode === 27 ) {
			deactivate();
		}

	}

	// 외부 클릭시 비활성화
	function onDocumentClick( event ) {

		if( event.target === cover ) {
			deactivate();
		}

	}

	function activate( state ) {

		document.addEventListener( 'keyup', onDocumentKeyUp, false );
		document.addEventListener( 'click', onDocumentClick, false );
		document.addEventListener( 'touchstart', onDocumentClick, false );

		popup.classList.remove( currentState );
		popup.classList.add( 'no-transition' );
		if(state)
			popup.classList.add( state );

		setTimeout( function() {
			popup.classList.remove( 'no-transition' );
			container.classList.add( 'avgrund-active' );
		}, 0 );

		currentState = state;

	}

	function deactivate() {

		document.removeEventListener( 'keyup', onDocumentKeyUp, false );
		document.removeEventListener( 'click', onDocumentClick, false );
		document.removeEventListener( 'touchstart', onDocumentClick, false );

		container.classList.remove( 'avgrund-active' );
		popup.classList.remove( 'avgrund-popup-animate' );

	}

	function disableBlur() {

		document.documentElement.classList.add( 'no-blur' );

	}

	function show( selector ) {

		popup = document.querySelector( selector );
		popup.classList.add( 'avgrund-popup-animate' );
		activate();
		return this;

	}

	function hide() {

		deactivate();

	}

	return {

		activate: activate,
		deactivate: deactivate,
		disableBlur: disableBlur,
		show: show,
		hide: hide

	}

})();
