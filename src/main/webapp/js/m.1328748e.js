(function(){hapj(function(c){c({_tag:["b"],support:function(h){h.on("click",function(){var j=h.attr("shuo_id");c.lib.ajax({url:"/m/shuo/_support",type:"POST",data:{shuo_id:j},dataType:"json",success:function(k){var l=k.data;if(k.err=="hapn.ok"){c.ui.dialog.ok(l.data.msg,function(){if(typeof(l.peostr)!="undefined"){var m=$(h).parent().parent().parent().next();m.find("#sup_peo_"+j).html(l.peostr)}if(typeof(l.numstr)!="undefined"){if($(h).hasClass("faved")){$(h).removeClass("faved").addClass("nofaved")}else{$(h).removeClass("nofaved").addClass("faved")}$(h).next().html(l.numstr)}if(!(l.peostr)&&!(l.numstr)){m.find("hr").show()}else{m.find("hr").hide()}})}else{c.ui.dialog.error("系统错误")}}})})}});if(c.conf.get("shuo.comment")){$(".comment_b").on("click",function(k){var h=$(this).attr("sid");var j=c.ui.id("user.mcomment").tmpl({shuo_id:h});$("body").append(j);$(".commentbox").show().find("input").click(function(){$(".commentbox").remove()});$(".commentbox .com_mask").click(function(l){l.stopPropagation();$(".commentbox").remove()});$("#commt").on("click",function(){var l=$(this).parent().children("input[name=shuo_id]").val();var m=$(this).parent().children("textarea[name=content]").val();c.lib.ajax({url:"/m/shuo/_addpost",type:"POST",data:{shuo_id:l,content:m},dataType:"json",success:function(n){var o=n.data;if(n.err=="hapn.ok"){c.ui.dialog.ok("评论成功")}else{c.ui.dialog.error("系统错误")}}})})});$(".comment_p").on("click",function(k){var h=$(this).attr("pid");var j=c.ui.id("user.mpost").tmpl({post_id:h});$("body").append(j);$(".commentbox").show().find("input").click(function(){$(".commentbox").remove()});$(".commentbox .com_mask").click(function(l){l.stopPropagation();$(".commentbox").remove()});$("#comt").on("click",function(){var l=$(this).parent().children("input[name=post_id]").val();var m=$(this).parent().children("textarea[name=content]").val();c.lib.ajax({url:"/m/shuo/_addcomment",type:"POST",data:{post_id:h,content:m},dataType:"json",success:function(n){var o=n.data;if(n.err=="hapn.ok"){c.ui.dialog.ok("回复成功")}else{c.ui.dialog.error("系统错误")}}})})})}if(hapj.browser.ciwApp){c.ui("header").hide();c.ui("#hdclone").hide();c.ui("footer").hide();var a=/(hunshasheying|dapinpaisheying|zhimingsheying|hunjiashoushi|xiyanjiudian|xinjijiudian|zhimingcanyin|hunlifuwu|hunshalifu|nanshilifu|nvshihunsha|jiehunbaihuo|lvyou|lvyousheying|lvyouhunli|dujialvyou|jiazhuang|chuguichudian|weiyutaoci|dibanmenchuang|zhuzhaijiaju|jiajuruanzhuang|jichujiancai|dajiadian|zhuangxiugongsi)\/(\d+)\/?(product)?\/?(\d+)?(\.html)?([\?\#]|$)/;$("a").each(function(){var h=$(this).attr("href"),j=a.exec(h);if(j){switch(j[3]){case undefined:this.href='ciw://mall/store/detail?params={"store_id":'+j[2]+"}";break;case"product":if(j[4]){this.href='ciw://mall/product/detail/?params={"product_id":'+j[4]+"}"}break}}})}else{}var f=document.referrer,d=/^http:\/\/[a-z]{2,4}(\.jiehun\.com\.cn|\.[a-zA-Z]{2,15}\.hapn\.cc)?/i,e=location.pathname,g=/m\/expo\/jie\//,b=/m\/expo([\?\#\/]|$)/;$(".back").click(function(){if(!d.test(f)||b.test(e)){$(this).attr("href","/m")}})});hapj(function(a,b){b(".commt").click(function(){alert(123)})});hapj.ui.fn.touchable=function(c){if(!c.direction){c.direction="h"}var b,a,e,d;this.on("touchstart",function(f){if(f.touches.length!=1){return}var g=f.touches[0];b=g.pageX;a=g.pageY}).on("touchmove",function(f){if(f.touches.length!=1){return}var g=f.touches[0];e=g.pageX;d=g.pageY;if(c.direction=="h"){if(Math.abs(d-a)<Math.abs(e-b)){return false}}else{if(Math.abs(d-a)>Math.abs(e-b)){return false}}}).on("touchend",function(j){if(!e&&!d){return}var g=e-b,f=d-a,k=g>0,h=f>0;g=Math.abs(g);f=Math.abs(f);if(c.direction=="h"){if(g>50&&g>f){if(k){c.right&&c.right()}else{c.left&&c.left()}}}else{if(f>50&&f>f){if(h){c.bottom&&c.bottom()}else{c.top&&c.top()}}}return false})}})();(function(H){var editor=function(textarea){var webkitVerson=navigator.userAgent.match(/AppleWebKit\/(\d*.\d*)/);if(webkitVerson){var verson=webkitVerson[1];if(verson<533.2&&verson!=533){return}}var _doc=document,_win=window,_text=H.ui._id(textarea),_form=_text.form,bookmark,last=false,uploadImgForm='<form method="post" style="opacity:0;" id="upload_form" action="/util/image/_upload/?rules=editor&watermark=1" name="formupload" target="normalupload" enctype="multipart/form-data" >						<input type="file" name="upload" id="file_img" /></form>',editHtml='<div class="editor" id="editor_box">					<header><ul id="toolbar"><li class="emot">&nbsp;</li><li class="pic" > &nbsp;<span id="pic_note"></span></li>	</ul> </header>					<div id="editor" class="edit_content" contenteditable="true"></div>				</div> ';H.ui(_text.parentNode).append(editHtml);_text.style.display="none";H.ui._id("editor").style.height=parseInt(_text.style.height)-36+"px";H.ui(document.body).append(uploadImgForm);var iframe='<iframe scrolling="auto" id="iframe_data" frameborder="no" marginheight="0" style="display:none;" name="normalupload"></iframe>';H.ui(document.body).append(iframe);var fileImg=H.ui.id("file_img"),fileImgElem=H.ui._id("file_img"),iframe=H.ui.id("iframe_data"),picNote=H.ui.id("pic_note");editorElem=H.ui._id("editor"),emots={"default":{height:24,width:24,name:"默认",list:{angry:"发火",awkward:"尴尬",bye:"再见",crazy:"抓狂",cry:"哭",curse:"骂人",cute:"可怜",despise:"鄙视",doubt:"疑问",envy:"羡慕",fastcry:"快哭了",knock:"敲打",laugh:"大笑",mad:"生气",ohmy:"惊讶",panic:"惊恐",proud:"得意",quiet:"安静",sad:"难过",shutup:"闭嘴",shy:"害羞",sleep:"睡觉",smile:"微笑",struggle:"奋斗",titter:"偷笑",tongue:"吐舌头",wail:"大哭",wronged:"委屈"}},lvdouwa:{count:53,height:24,line:7,name:"绿豆蛙",width:24},tusiji:{count:40,height:24,line:7,name:"兔斯基",width:24}};var saveBookmark=function(){var rng=getRng();rng=rng.cloneRange?rng.cloneRange():rng;bookmark={top:0,rng:rng}};var loadBookmark=function(){if(!bookmark){last=true}else{last=false;var rng=bookmark.rng;var sel=getSel();sel.removeAllRanges();sel.addRange(rng);bookmark=null}};var getSel=function(){return _doc.selection?_doc.selection:_win.getSelection()};var getRng=function(bNew){var sel,rng;if(!bNew){sel=getSel();rng=sel.createRange?sel.createRange():sel.rangeCount>0?sel.getRangeAt(0):null}if(!rng){rng=_doc.body.createTextRange?_doc.body.createTextRange():_doc.createRange()}return rng};var pasteHTML=function(sHtml){loadBookmark();if(last){H.ui(editorElem).append(sHtml)}else{var sel=getSel(),rng=getRng();if(rng.insertNode){rng.insertNode(rng.createContextualFragment(sHtml))}else{if(sel.type.toLowerCase()==="control"){sel.clear();rng=getRng()}rng.pasteHTML(sHtml)}}};fileImg.on("change",function(){var val=this.value,imgStyle=val.substring(val.lastIndexOf(".")+1,val.length);if(imgStyle!="jpg"&&imgStyle!="jpeg"&&imgStyle!="gif"&&imgStyle!="png"&&imgStyle!="JPG"&&imgStyle!="JPEG"){picNote.addClass("red").html("图片格式错误!");this.value=""}else{picNote.removeClass("red");picNote.html("上传中..");H.ui._id("upload_form").submit()}});H.ui._id("iframe_data").onload=function(){var html=this.contentWindow.document.body.innerHTML;if(html!=""){var html=html.replace(/<\/?pre>/g,""),obj=eval("("+html.replace(/<\/?pre>/g,"")+")");if(obj.err=="hapn.ok"){var src=obj.data.urls.per8,osrc=obj.data.url,w=obj.data.width,h=obj.data.height;pasteHTML('<img src="'+src+'" srcbig="'+osrc+'" ostyle="width:'+w+"px;height:"+h+'px"  />');fileImgElem.value="";picNote.html("")}else{picNote.addClass("red").html("上传失败！")}}};H.ui(editorElem).on("click",function(e){if(e.target.innerHTML){saveBookmark()}});H.ui(editorElem).on("keyup",function(){saveBookmark()});H.ui.id("toolbar").on("click",function(e){var elem=e.target,cname=elem.className;if(elem.nodeName!="LI"){return}if(cname=="pic"){H.ui._id("file_img").click()}if(cname=="emot"){var arr=[];for(i in emots["default"].list){arr.push('<a emot="default,'+i+'" style="background:url(http://'+hapj.staticHost+"/static/js/ext/editor/xheditor_emot/default/"+i+'.gif) no-repeat"></a>')}if(H.ui("#xheEmot").length==0){var html='<div class="xheEmot" id="xheEmot">									<ul><li class="default on">默认</li><li class="lvdouwa">绿豆蛙</li><li class="tusiji">兔斯基</li></ul>									<div>'+arr.join("")+"</div></div>";H.ui(elem).append(html);var ulElem=document.querySelector("#xheEmot>ul"),emotPannel=document.querySelector("#xheEmot>div");H.ui(ulElem).on("click",function(e){var tusiji=[],lvdouwa=[],elem=e.target,cname=elem.className;if(elem.nodeName!="LI"){return}for(var i=1;i<emots.tusiji.count;i++){tusiji.push('<a emot="tusiji,'+i+'" style="background:url(http://'+hapj.staticHost+"/static/js/ext/editor/xheditor_emot/tusiji/"+i+'.gif) no-repeat" >')}for(var i=1;i<emots.lvdouwa.count;i++){lvdouwa.push('<a emot="lvdouwa,'+i+'" style="background:url(http://'+hapj.staticHost+"/static/js/ext/editor/xheditor_emot/lvdouwa/"+i+'.gif) no-repeat" >')}H.ui(ulElem).tag("li").removeClass("on");switch(cname){case"default":H.ui(emotPannel).html(arr.join(""));elem.className+=" on";break;case"tusiji":H.ui(emotPannel).html(tusiji.join(""));elem.className+=" on";break;case"lvdouwa":H.ui(emotPannel).html(lvdouwa.join(""));elem.className+=" on";break}});H.ui(emotPannel).on("click",function(e){var elem=e.target;if(elem.nodeName!="A"){return}var emotArr=elem.getAttribute("emot").split(","),src="http://"+hapj.staticHost+"/static/js/ext/editor/xheditor_emot/"+emotArr[0]+"/"+emotArr[1]+".gif";pasteHTML('<img src="'+src+'" srcbig="'+src+'" />');H.ui("#xheEmot").hide()})}else{H.ui("#xheEmot").show()}}});H.ui(editorElem).on("focus",function(e){if(H.ui("#xheEmot").length>0){H.ui("#xheEmot").hide()}});H.ui(_form).on("submit",function(){_text.value=editorElem.innerHTML.replace(/src=\"\/?[^\"]*\"/g,"").replace(/ostyle/g,"style").replace(/srcbig/g,"src")})};H.set("editor",editor)})(hapj);hapj.set("mobileinit",{init:function(){if(hapj.ui.id("doc").length=="0"){return}var l=hapj,f=l.ui._id("header"),g=l.ui._id("sidenav"),d=0,c=0,a=20,m=document.body.scrollHeight,k=l.ui._id("doc");document.body.style.height=m+"px";k.style.height=m+"px";k.style.position="absolute";k.style.top=f.offsetHeight+"px";k.style.left="0";var n=l.ui("#sites"),b=n.tag("ul").menuable();n.tag("dt").on("click",function(j){if(n.tag("ul").css("display")=="none"){b.show(j)}else{b.hide()}return false});l.ui("#home").on("click",function(o){l.ui(g).show();g.style.marginLeft="-80%";d=-80;var j=function(){if(d<0){d+=a;c+=a;setTimeout(j,10);f.style.marginLeft=c+"%";k.style.marginLeft=c+"%";g.style.marginLeft=d+"%"}else{g.style.marginLeft="0";f.style.marginLeft="80%";k.style.marginLeft="80%"}};j();return false});l.ui(g).on("click",function(p){var o=p.target;if(o.className=="sidenav"){d=parseInt(g.style.marginLeft);c=parseInt(f.style.marginLeft);var j=function(){if(d>-80){d-=a;c-=a;setTimeout(j,10);g.style.marginLeft=d+"%";f.style.marginLeft=c+"%";k.style.marginLeft=c+"%"}else{f.style.marginLeft=0;l.ui(g).hide()}};j()}});var e=l.ui._id("hd"),h=e.offsetHeight;e.style.position="fixed";l.ui._id("bd").style.marginTop=h+"px";setTimeout(function(){window.scrollTo(0,1)},0)},showImg:function(){var d=hapj,a=d.ui("#showImg"),f=d.ui.id("showBox"),c=f.tag("img"),e=c[0],b=new Image(),g="data:image/gif;base64,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";a.on("click",function(n){var k=n.target;if(k.nodeName!="IMG"||!k.getAttribute("b-img")){return}var j=document.body,o=j.clientWidth-10,p=document.documentElement.clientHeight,q=j.scrollHeight,l=d.ui._id("imgbox"),h=d.ui._id("imgboxbd");f.show();f.css("height",q+"px");var m=navigator.userAgent;if(m.indexOf("MQQBrowser")>0){l.style.position="absolute";l.style.top=j.scrollTop+"px"}h.style.display="table-cell";h.style.height=p+"px";h.style.width=(o+10)+"px";e.src=g;b.src=k.getAttribute("b-img");b.onload=function(){e.src=b.src;setTimeout(function(){e.style.maxWidth=o+"px";e.style.maxHeight=p+"px"},10)}});f.on("click",function(){e.src=g;f.hide();b.src=""})}});