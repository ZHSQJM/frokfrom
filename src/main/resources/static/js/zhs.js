$(document).ready(function(){
    var elements = document.getElementsByClassName("zhs-url");
    Array.prototype.forEach.call(elements, function (element) {
        //var url = element.getElementsByTagName('a');
        $(element.parentNode).removeClass("nav-item-has-subnav")
    });
    Array.prototype.forEach.call(elements, function (element) {
        //var url = element.getElementsByTagName('a');
       var murl =  $(element).attr('href');
        var curentUrl = window.location.pathname;
        if(curentUrl==murl){
            var parent = $(element).parent();
            parent.addClass("active");
            $(parent).parent().parent().addClass("active open")
        }
    });
});


function turnPage(page) {
    console.log(page)
    var url = window.location.href;
    if(getUrlParam("page")){
        url =replaceParamVal(url,"page",page);
    }else{

        if(!isHasParam(url)){
            //如果当前地址没有其他参数的时候
            url += "?page="+page;
        }else{
            //如果当前地址没有其他参数的时候
            url += "&page="+page;
        }
        //如果当前页面有其他的参数
    }
    window.location.href =url;
    //当前请求路径

    //alert(url);
}
function  isHasParam(url) {
   var oUrl =  url.toString();
    if(oUrl.indexOf("?") != -1){
        return true
    }
    return false;
}
function replaceParamVal(url,paramName,replaceVal) {
    var oUrl = url.toString();
    var re=eval('/('+ paramName+'=)([^&]*)/gi');
    var nUrl = oUrl.replace(re,paramName+'='+replaceVal);
    return nUrl;
}

function getUrlParam(name) {
// 取得url中?后面的字符
    var query = window.location.search.substring(1);
// 把参数按&拆分成数组
    var param_arr = query.split("&");
    for (var i = 0; i < param_arr.length; i++) {
        var pair = param_arr[i].split("=");
        if (pair[0] == name) {
            return pair[1];
        }
    }
    return (false);
}

function  httpForm(idName,method,url,data,funOk) {
    $(idName).ajaxSubmit({
        type: method, // 提交方式 get/post
        url: url, // 需要提交的 url
        data:data,
        success: function(rt) { // data 保存提交后返回的数据，一般为 json 数据
            // 此处可对 data 作相关处理
            if(rt.code==0){
                funOk(rt);
                lightyear.loading('hide');
                lightyear.notify('成功', 'success', 1000);
            }else{
                lightyear.loading('hide');
                lightyear.notify('服务器错误，请稍后再试~', 'danger', 100);
            }
        },
        error: function(){
            lightyear.loading('hide');
            lightyear.notify('服务器错误，请稍后再试~', 'danger', 100);
        }
    });
}
//自己分装的ajax请求
function  http(url,method,data,funOk,flag) {
    $.ajax({
        type : method,
        url : url,
        data: data,
        error : function() {
            lightyear.loading('hide');
            lightyear.notify('服务器错误，请稍后再试~', 'danger', 100);
        },
        success : function(res) {
            funOk(res);
            if(flag){
                lightyear.loading('hide');
                lightyear.notify('成功', 'success', 1000);
            }
        }
    });
}

function  confirm(url,funOk) {
    $.confirm({
        title: '警告',
        content: '确定删除该条数据 无法恢复',
        type: 'red',
        typeAnimated: true,
        buttons: {
            tryAgain: {
                text: '确定',
                btnClass: 'btn-red',
                action: function(){
                    http(url,"delete",null,function ok(res) {
                        funOk(res)
                        console.log(res)
                    },true)
                }
            },
            close: {
                text: '关闭'
            }
        }
    });
}
