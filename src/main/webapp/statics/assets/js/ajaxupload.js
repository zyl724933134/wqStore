jQuery.extend({
    

    createUploadIframe: function(id, uri)
    {
            //create frame
            var frameId = 'jUploadFrame' + id;
            var iframeHtml = '<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute; top:-9999px; left:-9999px"';
            if(window.ActiveXObject)
            {
                if(typeof uri== 'boolean'){
                    iframeHtml += ' src="' + 'javascript:false' + '"';

                }
                else if(typeof uri== 'string'){
                    iframeHtml += ' src="' + uri + '"';

                }    
            }
            iframeHtml += ' />';
            jQuery(iframeHtml).appendTo(document.body);

            return jQuery('#' + frameId).get(0);            
    },
    createUploadForm: function(id, fileElementId, data)
    {
        //create form    
        var formId = 'jUploadForm' + id;
        var fileId = 'jUploadFile' + id;
        var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');    
        if(data)
        {
            for(var i in data)
            {
                jQuery('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(form);
            }            
        }
        /*  原始代码：支持单文件上传
        var oldElement = jQuery('#' + fileElementId);
        var newElement = jQuery(oldElement).clone();
        jQuery(oldElement).attr('id', fileId);
        jQuery(oldElement).before(newElement);
        jQuery(oldElement).appendTo(form);
		*/
        //-----------------------------
        //支持多文件上传
        if(fileElementId instanceof Array){
        	for(var i in fileElementId){ 
        		var oldElement = jQuery('#' + fileElementId[i]); 
        		var newElement = jQuery(oldElement).clone(); 
        		jQuery(oldElement).attr('id', fileId); 
        		jQuery(oldElement).before(newElement); 
        		jQuery(oldElement).appendTo(form); 
        	} 
        }else{
        	var oldElement = jQuery('#' + fileElementId);
            var newElement = jQuery(oldElement).clone();
            jQuery(oldElement).attr('id', fileId);
            jQuery(oldElement).before(newElement);
            jQuery(oldElement).appendTo(form);
        }
        
        
        //-----------------------------

        
        //set attributes
        jQuery(form).css('position', 'absolute');
        jQuery(form).css('top', '-1200px');
        jQuery(form).css('left', '-1200px');
        jQuery(form).appendTo('body');        
        return form;
    },

    ajaxFileUpload: function(s) {
			var name=$('#'+s.fileElementId).attr("name");
			var formData = new FormData(); formData.append(name, $('#'+s.fileElementId)[0].files[0]);
			$.ajax({  
                type : 'POST',  
                //contentType:"multipart/form-data",  
                url : s.url,  
               	async: false,  
          		cache: false,  
          		contentType: false,  
         		processData: false,  
                data: formData,  
                success : function(data) {  
                	s.success( data, status )
                	//$("#"+setValuename).val(data.result);
                },  
                error : function() {  
                    alert("上传失败");  
                }  
            }); 
        return ;    
    },

    uploadHttpData: function( r, type ) {
        var data = !type;
        data = type == "xml" || data ? r.responseXML : r.responseText;
        // If the type is "script", eval it in global context
        if ( type == "script" )
            jQuery.globalEval( data );
        // Get the JavaScript object, if JSON is used.
        if ( type == "json" )

            // 返回的json串前加了这句代码<pre style="word-wrap: break-word; white-space: pre-wrap;">返回的Json<pre>
             /**-----处理上传返回的json格式 start----**/   
             if(data.indexOf('{') != -1){
                data = data.substring(data.indexOf('{'),data.lastIndexOf('}')+1);
             }        
             /**-----处理上传返回的json格式 end----**/
            eval( "data = " + data );
        // evaluate scripts within html
        if ( type == "html" )
            jQuery("<div>").html(data).evalScripts();

        return data;
    },

  // jquery高版本没有此函数，将低版本的此函数复制过来解决handleError错误

    handleError: function( s, xhr, status, e )         {
        // If a local callback was specified, fire it
        if ( s.error ) {
            s.error.call( s.context || s, xhr, status, e );
        }

        // Fire the global callback
        if ( s.global ) {
            (s.context ? jQuery(s.context) : jQuery.event).trigger( "ajaxError", [xhr, s, e] );
        }
    }
})