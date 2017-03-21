
$(document).ready(function () {
    $("#testTrans").click(function () {
        try {
            processTrans();
        } catch (e) {
            alert(e);
        }
    });
    $("#transType").change(function () {
        var transType = $(this).val();
        $("#input").val(transType);
        $("#input").focus();
        updateInput();
    });

    for (var i in wmapi){
        var obj = wmapi[i];
        if(obj.n){
            $("#transType").append('<option value=\''+obj.v+'\'>'+obj.n+'</option>');   
        }
    }
    
    //#百度外卖下单
    $(".wmCreateOrder").click(function(){
        var params = $("#input").val();
        if(params==""){
            params = $(this).attr("data-params");
            $("#input").val(params);
            //return;
        }
        $("#status").html("发送交易报文...");
        var url = $(this).attr("data-url");
        var mercId = $("#mercId").val();
        url = url.replace("{mercId}",mercId);
        $.post(url,{params:params},function (outputJson) {
            $("#status").html("解析返回结果成功.");
            $("#output").val($.formatJson(outputJson));
        },"json");
    });
    
    
});



function processTrans() {
    if ($("#input").val()) {
        $("#status").html("发送交易报文...");
        //var name = $("#transType").val();
        var inputValue = $("#input").val();
        $.post($("#webServiceUrl").val(),{params:inputValue},function (outputJson) {
            $("#status").html("解析返回结果成功.");
            $("#output").val($.formatJson(outputJson));
        },"json");
    }
}

function updateInput() {
    var input = $("#input").val();
    if (!input) return false;
    var json = $.parseJSON(input);

    //update submit time
    json.header.submitTime = (new Date()).Format("yyyyMMddHHmmss");

    //assign value
    //$("#input").val($.toJSON(json));
    $("#input").val($.formatJson(json));
    return true;
}

//---------------------------------------------------
// 日期格式化
// 格式 YYYY/yyyy/YY/yy 表示年份
// MM/M 月份
// W/w 星期
// dd/DD/d/D 日期
// hh/HH/h/H 时间
// mm/m 分钟
// ss/SS/s/S 秒
//---------------------------------------------------
Date.prototype.Format = function (formatStr) {
    var str = formatStr;
    var week = ['日', '一', '二', '三', '四', '五', '六'];

    str = str.replace(/yyyy|YYYY/, this.getFullYear());
    str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));

    var month = this.getMonth() + 1;
    str = str.replace(/MM/, month > 9 ? month.toString() : '0' + month);
    str = str.replace(/M/g, month);

    str = str.replace(/w|W/g, week[this.getDay()]);

    str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
    str = str.replace(/d|D/g, this.getDate());

    str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
    str = str.replace(/h|H/g, this.getHours());
    str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
    str = str.replace(/m/g, this.getMinutes());

    str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
    str = str.replace(/s|S/g, this.getSeconds());

    return str;
};
