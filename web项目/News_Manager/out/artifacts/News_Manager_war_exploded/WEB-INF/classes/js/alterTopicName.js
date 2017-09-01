/**
 * Created by chaersi on 2017/8/5.
 */
var xmlHttp;
function createXMLHttp() {
    if(window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
    }else{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function altetTopicName(names) {
    createXMLHttp();
    var oldName=names.innerHTML;
    var newName=window.prompt("请输入新的名字：");
    xmlHttp.open("get","AlterTopicServlet?oldName="+oldName+"&newName="+newName);
    xmlHttp.onreadystatechange=altetTopicNamecallback;
    xmlHttp.send(null);
}
function altetTopicNamecallback() {
    if(xmlHttp.readyState==4){
        if(xmlHttp.status==200){
            var text=xmlHttp.responseText;
            if(text=="true"){
                alert("修改成功，点击确定刷新页面！");
                window.location.reload();
            }else if(text =="-1"){
                alert("新的标题名不能为空！");
            }else if(text=="-2"){
                alert("新的标题名格式不正确！");
            }else{
                alert("修改不成功，请稍后重试！");
            }
        }
    }
}
function deleteTopicName(names) {
    createXMLHttp();
    var oldName=names.innerHTML;
    if(window.confirm("点击确定，删除主题："+oldName)){
        xmlHttp.open("get","DeleteTopicServlet?oldName="+oldName);
        xmlHttp.onreadystatechange=deleteTopicNamecallback;
        xmlHttp.send(null);
    }
}
function deleteTopicNamecallback() {
    if(xmlHttp.readyState==4){
        if(xmlHttp.status==200){
            var text=xmlHttp.responseText;
            if(text=="true"){
                alert("删除成功，点击确定刷新页面！");
                window.location.reload();
            }else if(text=="-1"){
                alert("主题下面还有新闻，不能删除！");
            }else{
                alert("删除不成功，请稍后重试！");
            }
        }
    }
}

