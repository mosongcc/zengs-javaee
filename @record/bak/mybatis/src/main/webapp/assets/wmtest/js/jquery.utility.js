function ajaxPost(url, data, success, error) {
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType: "text",
        success: success,
        error: error
    });
}

function ajaxPostJason(url, data, success, error) {
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        data: data,
        dataType: "json",
        success: function (responseJson) {
            var json = eval('(' + responseJson.d + ')');
            success(json);
        },
        error: error
    });
}

function ajaxJsonp(url, data, success, error) {
    $.ajax({
        type: "GET",
        url: url + "?callback=?",
        dataType: "jsonp",
        jsonp: "callback",
        data: data,
        success: success,
        error: error,
        complete: function () {
        }
    });
}

function diableText(control) {
    if (!(control instanceof jQuery)) {
        control = $(control);
    }

    control.attr("readonly", "readonly").css("background-color", "#EFEFEF");
}

function enableText(control) {
    if (!(control instanceof jQuery)) {
        control = $(control);
    }

    control.removeAttr("readonly").css("background-color", "");
}

jQuery.extend(
 {
     /**
     * @see  将json字符串转换为对象
     * @param   json字符串
     * @return 返回object,array,string等对象
     */
     evalJSON: function (strJson) {
         return eval("(" + strJson + ")");
     }
 });

jQuery.extend(
 {
     /**
     * @see  将javascript数据类型转换为json字符串
     * @param 待转换对象,支持object,array,string,function,number,boolean,regexp
     * @return 返回json字符串
     */
     toJSON: function (object) {
         if (object == null) return "";
         var type = typeof object;
         if ('object' == type) {
             if (Array == object.constructor)
                 type = 'array';
             else if (RegExp == object.constructor)
                 type = 'regexp';
             else
                 type = 'object';
         }
         switch (type) {
             case 'undefined':
             case 'unknown':
                 return;
                 break;
             case 'function':
             case 'boolean':
             case 'regexp':
                 return object.toString();
                 break;
             case 'number':
                 return isFinite(object) ? object.toString() : 'null';
                 break;
             case 'string':
                 return '"' + object.replace(/(\\|\")/g, "\\$1").replace(/\n|\r|\t/g,
       function () {
           var a = arguments[0];
           return (a == '\n') ? '\\n' :
                       (a == '\r') ? '\\r' :
                       (a == '\t') ? '\\t' : ""
       }) + '"';
                 break;
             case 'object':
                 if (object === null) return 'null';
                 var results = [];
                 for (var property in object) {
                     var value = jQuery.toJSON(object[property]);
                     if (value !== undefined)
                         results.push(jQuery.toJSON(property) + ':' + value);
                 }
                 return '{' + results.join(',') + '}';
                 break;
             case 'array':
                 var results = [];
                 for (var i = 0; i < object.length; i++) {
                     var value = jQuery.toJSON(object[i]);
                     if (value !== undefined) results.push(value);
                 }
                 return '[' + results.join(',') + ']';
                 break;
         }
     }
 });

$.fn.onlyFloat = function () {
    $(this).css("ime-mode", "disabled");
    this.bind("keypress", function () {
        if (event.result) {
            return true;
        }
        if (event.keyCode == 46) {
            if (this.value.indexOf(".") != -1) {
                return false;
            }
        } else {
            return event.keyCode >= 48 && event.keyCode <= 57;
        }
    });
    this.bind("blur", function () {
        if (this.value.lastIndexOf(".") == (this.value.length - 1)) {
            this.value = this.value.substr(0, this.value.length - 1);
        } else if (isNaN(this.value)) {
            this.value = "";
        }
    });
    this.bind("paste", function () {
        var s = clipboardData.getData('text');
        if (!/\D/.test(s));
        value = s.replace(/^0*/, '');
        return false;
    });
    this.bind("dragenter", function () {
        return false;
    });
    this.bind("keyup", function () {
        if (/(^00*)/.test(this.value)) {
            this.value = this.value.replace(/^00*/, '0');
        }
    });
};

$.fn.onlyInteger = function () {
    $(this).css("ime-mode", "disabled");
    this.bind("keypress", function () {
        if (event.result) {
            return true;
        }
        return event.keyCode >= 48 && event.keyCode <= 57;
    });
    this.bind("blur", function () {
        if (isNaN(this.value)) {
            this.value = "";
        }
    });
    this.bind("paste", function () {
        return false;
    });
    this.bind("dragenter", function () {
        return false;
    });
    this.bind("keyup", function () {
        //if (/(^00*)/.test(this.value)) {
        //    this.value = this.value.replace(/^00*/, '0');
        //}
    });
};

$.fn.onlyNo = function () {
    $(this).css("ime-mode", "disabled");
    this.bind("keypress", function () {
        if (event.result) {
            return true;
        }

        return (event.keyCode >= 48 && event.keyCode <= 57) ||
            (event.keyCode >= 65 && event.keyCode <= 90) ||
            (event.keyCode >= 97 && event.keyCode <= 122);
    });
    this.bind("blur", function () {
    });
    this.bind("paste", function () {
        return false;
    });
    this.bind("dragenter", function () {
        return false;
    });
    this.bind("keyup", function () {
    });
};

$.fn.allowChinese = function () {
    $(this).css("ime-mode", "");
    this.bind("keypress", function () {
        if (event.result) {
            return true;
        }
        return (event.keyCode >= 48 && event.keyCode <= 57) ||
            (event.keyCode >= 65 && event.keyCode <= 90) ||
            (event.keyCode >= 97 && event.keyCode <= 122) ||
            (/[\u4E00-\u9FA5]/g.test(String.fromCharCode(event.keyCode)));
    });
    this.bind("blur", function () {
    });
    this.bind("paste", function () {
        return false;
    });
    this.bind("dragenter", function () {
        return false;
    });
    this.bind("keyup", function () {
    });
};

//字符串长度计数，汉字等双字节算两个
String.prototype.len = function () {
    var arr = this.match(/[^\x00-\xff]/ig);
    return this.length + (arr == null ? 0 : arr.length);
}

$.fn.setMaxLength = function (maxLength) {
    $(this).attr("maxlength", maxLength);
    this.bind("keypress", function () {
        var currentLen = this.value.len();
        if (currentLen == maxLength) {
            return false;
        }
        if (currentLen + String.fromCharCode(event.keyCode).len() > maxLength) {
            return false;
        }
        return true;
    });
    this.bind("blur", function () {
        if (this.value.len() > maxLength) {
            this.value = this.value.substr(0, maxLength - 1);
            if (this.value.len() > maxLength) {
                this.value = this.value.substr(0, maxLength - 2);
            }
        }
    });
    this.bind("paste", function () {
        return false;
    });
    this.bind("dragenter", function () {
        return false;
    });
    this.bind("keyup", function () {
        if (this.value.len() > maxLength) {
            this.value = this.value.substr(0, maxLength - 1);
            if (this.value.len() > maxLength) {
                this.value = this.value.substr(0, maxLength - 2);
            }
        }
    });
};

function setScrollGrid(tableId, twidth, theight) {
    var jqTable = $("#" + tableId);

    var jqTheadTds = jqTable.find("th");
    if (jqTheadTds.size() <= 0) {
        return;
    }

    //    var tableDivId = tableId + "_div";
    //    var theadDivId = tableId + "_thead";
    //    var contentDivId = tableId + "_content";
    var tableDiv = document.createElement("DIV");
    var theadDiv = document.createElement("DIV");
    var contentDiv = document.createElement("DIV");
    var jqTableDiv = $(tableDiv);
    var jqTheadDiv = $(theadDiv);
    var jqContentDiv = $(contentDiv);

    jqTableDiv.addClass("tableDiv");
    jqTheadDiv.addClass("theadDiv");
    jqContentDiv.addClass("contentDiv");

    jqContentDiv.get(0).onscroll = function () { jqTheadDiv.get(0).style.posLeft = -jqContentDiv.get(0).scrollLeft; };

    $(tableDiv).append(theadDiv);
    $(tableDiv).append(contentDiv);

    jqTable.before($(tableDiv));

    $(contentDiv).append(jqTable);

    jqTableDiv.width(twidth);

    jqContentDiv.width(twidth);
    jqContentDiv.height(theight);

    $("<table class='commGrid_GridMain commGrid_GridMain_Cloned'></table>").append(jqTheadTds.first().parent().detach()).appendTo(jqTheadDiv);

    //    var newTitle = "";

    //    for (var i = 0; i < jqTheadTds.size(); i++) {
    //      var tempTd = jqTheadTds.get(i);
    //      newTitle += "<span class='theadTd' style='width:" + (tempTd.clientWidth) + "px'>" + tempTd.innerText + "</span>";
    //    }

    //    jqTheadDiv.html(newTitle);

    //    jqTheadTds.first().parent().remove();
}

jQuery.extend({
    formatJson: function (jsonObj) {
        var jsonUtil = {
            //定义换行符
            n: "\n",
            //定义制表符
            //t: "\t",
            t: "    ",
            //转换String
            convertToString: function (obj) {
                return jsonUtil.__writeObj(obj, 1);
            },
            //写对象
            __writeObj: function (obj    //对象
        , level             //层次（基数为1）
        , isInArray) { //此对象是否在一个集合内
                //如果为空，直接输出null
                if (obj == null) {
                    return "null";
                }
                //为普通类型，直接输出值
                if (obj.constructor == Number || obj.constructor == Date || obj.constructor == String || obj.constructor == Boolean) {
                    var v = obj.toString();
                    var tab = isInArray ? jsonUtil.__repeatStr(jsonUtil.t, level - 1) : "";
                    if (obj.constructor == String || obj.constructor == Date) {
                        //时间格式化只是单纯输出字符串，而不是Date对象
                        return tab + ("\"" + v + "\"");
                    } else if (obj.constructor == Boolean) {
                        return tab + v.toLowerCase();
                    } else {
                        return tab + (v);
                    }
                }

                //写Json对象，缓存字符串
                var currentObjStrings = [];
                //遍历属性
                for (var name in obj) {
                    var temp = [];
                    //格式化Tab
                    var paddingTab = jsonUtil.__repeatStr(jsonUtil.t, level);
                    temp.push(paddingTab);
                    //写出属性名
                    temp.push("\"" + name + "\": ");

                    var val = obj[name];
                    if (val == null) {
                        temp.push("null");
                    } else {
                        var c = val.constructor;

                        if (c == Array) { //如果为集合，循环内部对象
                            temp.push(jsonUtil.n + paddingTab + "[" + jsonUtil.n);
                            var levelUp = level + 2; //层级+2

                            var tempArrValue = []; //集合元素相关字符串缓存片段
                            for (var i = 0; i < val.length; i++) {
                                //递归写对象                         
                                tempArrValue.push(jsonUtil.__writeObj(val[i], levelUp, true));
                            }

                            temp.push(tempArrValue.join("," + jsonUtil.n));
                            temp.push(jsonUtil.n + paddingTab + "]");
                        } else if (c == Function) {
                            temp.push("[Function]");
                        } else {
                            //递归写对象
                            temp.push(jsonUtil.__writeObj(val, level + 1));
                        }
                    }
                    //加入当前对象“属性”字符串
                    currentObjStrings.push(temp.join(""));
                }
                return (level > 1 && !isInArray ? jsonUtil.n : "")                       //如果Json对象是内部，就要换行格式化
            + jsonUtil.__repeatStr(jsonUtil.t, level - 1) + "{" + jsonUtil.n     //加层次Tab格式化
            + currentObjStrings.join("," + jsonUtil.n)                       //串联所有属性值
            + jsonUtil.n + jsonUtil.__repeatStr(jsonUtil.t, level - 1) + "}"; //封闭对象
            },
            __isArray: function (obj) {
                if (obj) {
                    return obj.constructor == Array;
                }
                return false;
            },
            __repeatStr: function (str, times) {
                var newStr = [];
                if (times > 0) {
                    for (var i = 0; i < times; i++) {
                        newStr.push(str);
                    }
                }
                return newStr.join("");
            }
        };

        return jsonUtil.convertToString(jsonObj);
    }
});

