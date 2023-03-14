function endereco() {
							
	jQuery('#txt_firstCapitalendereco').keyup(function() 
		{
			var str = jQuery('#txt_firstCapitalendereco').val();
						       
								
			var spart = str.split(" ");
			for ( var i = 0; i < spart.length; i++ )
			{
				var j = spart[i].charAt(0).toUpperCase();
				spart[i] = j + spart[i].substr(1);
			}
			jQuery('#txt_firstCapitalendereco').val(spart.join(" "));
							
});
};