var dye=function(){
	$.ajax({
        url:"../dgrc/main/disease",
        type:"GET",
        data:{title:'*'+$("#input2").val()+'*'},
        dataType:"json",
        json:"callback",  //Jquery生成验证参数的名称
        
        success:function(data){  //成功的回调函数
            //console.log("data.toString:"+data[0].id);
			console.log("dye of disease");
            if (null != data && "" != data){
                console.log("data.id:"+data[0].id);
                group.message_items=data[0];
                intro.name=data[0].academicName;
                research.name=data[0].academicName;
                refresh_disease();
            }else{
                console.log("ID IS NULL");
            }
            //console.log("data.data:"+data.data);
            //console.log("data.id:"+data.id);
        },
        error: function (e) {
        	console.log("dye of drug");
            alert("error");
        }
    });
}
$("#searcher_targets").attr("checked","true");
var scheck=function(){
    if ($("input[name='searcher']:checked").val()=="disease") {
        dye();
    }else{
        sform.submit();
    }
}
$(document).ready(function(){
    // console.log(disease);
    group.message_items=disease[0];
    intro.name=disease[0].academicName;
    research.name=disease[0].academicName;
    refresh_disease();
});