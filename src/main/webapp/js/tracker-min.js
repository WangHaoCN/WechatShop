!function(){function e(e){return encodeURIComponent(e)}function a(a,n){var i=$(a);if("id"in a&&a.id){if(i.data("stime")&&(new Date).getTime()-i.data("stime")<800)return void i.data("stime",(new Date).getTime());i.data("stime",(new Date).getTime());for(var r=i.serializeArray(),o={},c=!1,u=0,m=r.length;m>u;u++){var s=r[u],d=a[s.name];(!d||"length"in d||"true"!=d.getAttribute("data-untrack"))&&(c||("SELECT"==d.tagName||"INPUT"==d.tagName&&("checkbox"==d.type||"radio"==d.type)?s.value&&"0"!=s.value&&(c=!0):$.trim(s.value)&&(c=!0)),s.name in o?($.isArray(o[s.name])||(o[s.name]=[o[s.name]]),o[s.name].push(s.value)):o[s.name]=s.value)}if(c){for(var h,l=$.param(o),f=new Image,v="tracker.php?url="+e(document.URL)+"&id=form."+a.id+"&type="+n+"&data="+e(l),w=document.cookie,u=0,m=t.length;m>u;u++){h=new RegExp(t[u]+"=([^;]+)");var g=h.exec(w);g&&g[1]&&(v+="&"+t[u]+"="+g[1])}var p=i.data("urls");p&&p.indexOf(v)>-1||(p?p.push(v):p=[v],i.data("urls",p),v+="&t="+(new Date).getTime(),f.src="http://tracker.hunbasha.cn/"+v)}}}var t=["jid","jhu"],n=window.console&&window.console.warn,i=/^1[3|4|5|8|7]\d{9}$/,r=$("form[data-track=true]").submit(function(){try{a(this,"submit")}catch(e){n&&console.warn(e)}});r.each(function(){for(var e=this,t=0,n=this.elements.length;n>t;t++){var r=$(this.elements[t]);if(r.attr("name")){var o=r.data("track-rule");if(o)switch(o){case"change":r.on("change",function(){a(e,o)});break;case"mobile":r.on("blur",function(){this.value&&i.test(this.value)&&a(e,o)})}}}}),$(window).on("unload",function(){r.each(function(){try{a(this,"unload")}catch(e){n&&console.warn(e)}})})}();