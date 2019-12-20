var time=new Date();
var str='';
function getWeek(on){
    var week='';
    switch(on){
        case 0:
            week='星期日';
            break;
        case 1:
            week='星期一';
            break;
        case 2:
            week='星期二';
            break;
        case 3:
            week='星期三';
            break;
        case 4:
            week='星期四';
            break;
        case 5:
            week='星期五';
            break;
        case 6:
            week='星期六';
            break;
    }
    return week;
}
function Mun(no){
    if(no.toString().length==1){
        no='0'+no;
    }
    return no;
}

function getTime(){
    var time=new Date();
    var year=time.getFullYear();
    var mourth=time.getMonth()+1;
    var day=time.getDate();
    var hours=time.getHours();
    var minet=Mun(time.getMinutes());
    var second=Mun(time.getSeconds());
    var week=getWeek(time.getDay());
    str=year+'-'+mourth+'-'+day+'<br>  '+hours+':'+minet+':'+second+' <br> '+week;
    document.getElementById("new").innerHTML=str;
}
setInterval('getTime()',1000 );