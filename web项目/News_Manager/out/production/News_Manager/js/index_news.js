/**
 * Created by chaersi on 2017/8/6.
 */
var xmlHttp;
function createXMLHttp() {
    if(window.xmlHttp){
        xmlHttp=new XMLHttpRequest();
    }else{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
}

