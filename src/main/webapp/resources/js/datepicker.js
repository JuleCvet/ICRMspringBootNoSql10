var dates = ['01/01/2018', '01/06/2018', '03/30/2018','04/01/2018', '04/02/2018', '05/01/2018', '05/10/2018', '05/20/2018', 
		 '06/06/2018', '06/22/2018','06/23/2018', '11/03/2018', '12/24/2018',  '12/25/2018',  '12/26/2018',  '12/31/2018'];

$( function() {
    $( "#fromDate" ).datepicker({ firstDay: 1 , beforeShowDay: highlightDays});
  } );
  $( function() {
	    $( "#toDate" ).datepicker({ firstDay: 1 , beforeShowDay: highlightDays});
 } );
  function highlightDays(date) {
	    for (var i = 0; i < dates.length; i++) {
	        if (new Date(dates[i]).toString() == date.toString()) {
	            return [true, 'highlight'];
    }
}
return [true, ''];
}
