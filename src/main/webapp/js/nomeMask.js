function nomeCompleto() {
							
	jQuery('#txt_firstCapital').keyup(function() 
		{
			var str = jQuery('#txt_firstCapital').val();
						       
								
			var spart = str.split(" ");
			for ( var i = 0; i < spart.length; i++ )
			{
				var j = spart[i].charAt(0).toUpperCase();
				spart[i] = j + spart[i].substr(1);
			}
			jQuery('#txt_firstCapital').val(spart.join(" "));
							
});
};