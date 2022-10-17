
var menuJson=[
    {
        'id':'1.1',
        'pid':'1',
        'name':'首页',
        'url':'../function/home/home.html',
        'ico':'123456',
    },
    {
        'id':'1.2',
        'pid':'1',
        'name':'管理',
        'url':'../function/home/management.html',
        'ico':'123456',
    },
	{
        'id':'1.3',
        'pid':'1',
        'name':'帮助',
        'url':'../function/home/help.html',
        'ico':'123456',
    },
    {
        'id':'1.1.1',
        'pid':'1.1',
        'name':'数据展示',
        'url':'../function/home/data_show.html',
        'ico':'iconfont iconYYGK',
    },
    {
        'id':'1.1.2',
        'pid':'1.1',
        'name':'查询信息',
        'url':'../function/home/search_data.html',
        'ico':'iconfont iconYYGK',
    },
    {
        'id':'1.2.1',
        'pid':'1.2',
        'name':'班级管理',
        'url':'../function/class/class.html',
        'ico':'iconfont iconYYGK',
    },
	{
        'id':'1.2.2',
        'pid':'1.2',
        'name':'教师管理',
        'url':'../function/teacher/teacher.html',
        'ico':'iconfont iconYYGK',
    },
	{
        'id':'1.2.3',
        'pid':'1.2',
        'name':'学生管理',
        'url':'../function/student/student.html',
        'ico':'iconfont iconYYGK',
    },
	{
        'id':'1.2.4',
        'pid':'1.2',
        'name':'创建',
        'url':'../function/home/add.html',
        'ico':'123456',
    },
    {
        'id':'1.1.1.1',
        'pid':'1.1.1',
        'name':'班级数据',
        'url':'../function/class/class_data.html',
        'ico':'123456',
    },
    {
        'id':'1.1.1.2',
        'pid':'1.1.1',
        'name':'学生数据',
        'url':'../function/student/student_data.html',
        'ico':'123456',
    },
];
console.log(menuJson);

/*↓↓字数获取↓↓*/
function titleLength(str) {
    var strLength = 0;
    var list = str.split("");
    for (var i = 0; i < list.length; i++) {
        if (str.charCodeAt(i) > 0 && str.charCodeAt(i) < 128)
            strLength = strLength + 0.5;
        else
            strLength = strLength + 1;
    }
    return strLength;
}
/* ↑↑字数获取↑↑*/

/*↓↓页面初始化↓↓*/
$(".body_con_div").css({
    'height' :$(window).height()-60
});

function html1(name,url,id) {
    return "<li id='"+id+"'>\n" +
        "                    <label>\n" +
        "                        <span>"+name+"</span>\n" +
        "                        <i class='iconfont iconxiajiantou'></i>\n" +
        "                        <a href='"+url+"' title='"+name+"' target='mainFrame'></a>\n" +
        "                    </label>\n" +
        "                    <ol>\n" +
        "                       \n" +
        "                    </ol>\n" +
        "                </li>";
}
function html2(name,url,id,ico) {
    return "<li id='"+id+"'>\n" +
        "                            <label>\n" +
        "                                <div>\n" +
        "                                    <i class='"+ico+"'></i>\n" +
        "                                    <span>"+name+"</span>\n" +
        "                                </div>\n" +
        "                                <i class='iconfont iconyoujiantou'></i>\n" +
        "                                <a href='"+url+"' title='"+name+"' target='mainFrame'></a>\n" +
        "                            </label>\n" +
        "                            <dl>\n" +
        "                                \n" +
        "                            </dl>\n" +
        "                        </li>";
}
function html3(name,url,id) {
    return "<li id='"+id+"'>\n" +
        "                                    <label>\n" +
        "                                        <span>"+name+"</span>\n" +
        "                                        <i class='iconfont iconyoujiantou'></i>\n" +
        "                                        <a href='"+url+"' title='"+name+"' target='mainFrame'></a>\n" +
        "                                    </label>\n" +
        "                                    <div class='body_sanji'></div>\n" +
        "                                </li>";
}

function html_wuxian_bor(pid,top,wuxianji) {
    return "<div  class='body_sanji_div' pid='"+pid+"' wuxianji='"+wuxianji+"'>\n" +
        "                <ul class='body_sanji_div_bor'  style='top: "+top+"px;'>\n" +
        "                    \n" +
        "                </ul>\n" +
        "            </div>"
}
function html_wuixan_li(id,pid,name,url) {
    return" <li id='"+id+"' pid='"+pid+"'>\n" +
        "                        <span>"+name+"</span>\n" +
        "                        <i class='iconfont iconyoujiantou'></i>\n" +
        "                        <a href='"+url+"' title='"+name+"'></a>\n" +
        "                    </li>"
}

var nav_one_json = {}; //一级导航json
var nav_two_json = {}; //二级导航json
var nav_three_json = {}; //三级导航json

/*↓↓一级导航↓↓*/
for (var i in menuJson) {
    if(menuJson[i]['pid'] == "1"){
        nav_one_json[i] = menuJson[i]['id'];
        var yiji_yuan = $(".body_left ul").html();
        yiji_yuan = yiji_yuan+html1(menuJson[i]['name'],menuJson[i]['url'],menuJson[i]['id']);
        $(".body_left ul").html(yiji_yuan);
    }
}
/* ↑↑一级导航↑↑*/

/*↓↓二级导航↓↓*/
var erji_i = 0;
for (var i in nav_one_json){
    var yiji_id =  nav_one_json[i];
    var neirong = "";
    for(var x in menuJson){
        if(menuJson[x]['pid'] == yiji_id){
            neirong = $("li[id='"+yiji_id+"'] ol").html();
            neirong = neirong+html2(menuJson[x]['name'],menuJson[x]['url'],menuJson[x]['id'],menuJson[x]['ico']);
            $("li[id='"+yiji_id+"'] ol").html(neirong);
            nav_two_json[erji_i] = menuJson[x]['id'];
            erji_i++;
        }
    }
}
/* ↑↑二级导航↑↑*/

/*↓↓三级导航↓↓*/
var sanji_i = 0;
for (var i in nav_two_json){
    var erji_id =  nav_two_json[i];
    var neirong = "";
    for(var x in menuJson){
        if(menuJson[x]['pid'] == erji_id){
            neirong = $("li[id='"+erji_id+"'] dl").html();
            neirong = neirong+html3(menuJson[x]['name'],menuJson[x]['url'],menuJson[x]['id']);
            $("li[id='"+erji_id+"'] dl").html(neirong);
            nav_three_json[sanji_i] = menuJson[x]['id'];
            sanji_i++;
        }
    }
}
console.log(nav_three_json);
/* ↑↑三级导航↑↑*/

/*↓↓四级导航↓↓*/
var siji_i = 0;
for (var i in nav_three_json){
    var sanji_id =  nav_three_json[i];
    var neirong = "";
    var ju_top = $("dl li[id='"+sanji_id+"']").offset().top;
    ju_top = ju_top-60;
    var bor_html = html_wuxian_bor(sanji_id,ju_top,'off');
    $("dl li[id='"+sanji_id+"']").children(".body_sanji").html(bor_html);
    for(var x in menuJson){
        if(menuJson[x]['pid'] == sanji_id){
            var siji_data = $(".body_sanji_div[pid='"+sanji_id+"']").children(".body_sanji_div_bor").html();
            siji_data = siji_data + html_wuixan_li(menuJson[x]['id'],menuJson[x]['pid'],menuJson[x]['name'],menuJson[x]['url']);
            $(".body_sanji_div[pid='"+sanji_id+"']").children(".body_sanji_div_bor").html(siji_data);
        }
    }
}
$(".body_sanji").css({
    'height' :$(window).height()-60
});
/* ↑↑四级导航↑↑*/

/* ↑↑前三级数据渲染↑↑*/

var body_left_on1li = $(".body_left ul >li").length;
var body_left_on2li = $(".body_left ol >li").length;
var body_left_on3li = $(".body_left dl >li").length;
var onli = (body_left_on1li+body_left_on2li+body_left_on3li) * 50;
$(".body_left").css({
    'max-height': onli+'px'
});

var body_left_ul_bian1 = 0;
var body_left_ul_bian2 = 0;
var body_left_ul_on = 0;
var body_left_ul = $(".body_left ul >li").length;
for (var i=0;i<body_left_ul;i++){
    body_left_ul_bian1 = $(".body_left ul >li").eq(i).children('ol').children('li').length;
    body_left_ul_bian2 = $(".body_left ul >li").eq(i).children('ol').children('li').children('dl').children('li').length;
    body_left_ul_on = (body_left_ul_bian1+body_left_ul_bian2 + 1) * 50;
    $(".body_left ul >li").eq(i).css({
        'max-height': body_left_ul_on+'px'
    });
    $(".body_left ul >li").eq(i).attr('max_h',body_left_ul_on+'px')
}

/* ↑↑页面初始化↑↑*/

/*↓↓一级导航展开收起↓↓*/
$(".body_left ul >li >label").on('click',function () {
   var max_h = $(this).parent('li').attr("max_h");
   var ul_he = $(this).parent('li').css("max-height");
   if(ul_he == max_h){
       $(this).parent('li').animate({'max-height':'40px'});
       $(this).parent('li').children('label').children('i').css({
           'transform':'rotate(-90deg)'
       });
   }else{
       $(this).parent('li').animate({'max-height':max_h});
       $(this).parent('li').children('label').children('i').css({
           'transform':'rotate(0)'
       });
   }
});
/* ↑↑一级导航展开收起↑↑*/




/*↓↓触摸高亮↓↓*/
$(".body_sanji_div_bor li").live({
    mouseover: function () {
        $(this).parent(".body_sanji_div_bor").children('li').css({
            'color':'#000',
            'background':'#fff'
        });
        $(this).css({
            'color':'#1d8ff0',
            'background':'#E7E7E7'
        })
    }
});
/* ↑↑触摸高亮↑↑*/

var jinru_ids = "";
$(".body_sanji_div").live({
    mouseover: function () {
        var pid = $(this).attr('pid');
        var cahndu1 = titleLength(jinru_ids);
        var cahndu2 = titleLength(pid);
        if(cahndu1 > cahndu2){
            // 回退
            console.log("回退");
            $(this).nextAll().remove();
        }
    },
    mouseout: function () {
        var pid = $(this).attr('pid');
        jinru_ids = pid;
    }
});

/*↓↓移出删除↓↓*/
$(".body_sanji").hover(function(){

},function(){
    $(".body_sanji_div[wuxianji='on']").remove();
});
/* ↑↑移出删除↑↑*/

/* ↑↑无限极结束↑↑*/