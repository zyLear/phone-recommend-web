/**
 * Created by Administrator on 2017/6/6.
 */


var likePage = 2;
var currentPeopleId=1;
var currentPhoneId=20000;


$.fn.longPress = function (fn) {
    var timeOut = undefined;
    var $this = this;
    for (var i = 0; i < this.length; i++) {
        this[i].addEventListener('touchstart', function (event) {
            timeOut = setTimeout(function () {
                fn($this);
            }, 500);
        }, false);
        this[i].addEventListener('touchmove', function (event) {
            clearTimeout(timeOut);
        });
        this[i].addEventListener('touchend', function (event) {
            clearTimeout(timeOut);
        }, false);
    }
}






// function longPress($this) {
//     alert($this.attr('href'));
// }


function forEach() {
    var i = 0;
    $('.list-group-item').each(function () {
        if (i >= (likePage - 2) * 20) {
            myThis=$(this);
            $(this).longPress(function ($this) {
                //alert($this.attr('href'));
                // $('#test-btn').click();
                currentPhoneId = $this.attr('phoneId');
                $('#modal').modal('show');
              //  alert($this.attr('phoneId'));
            });

            $(this).click(function () {
                // alert($(this).attr('phoneId'));
                // var phoneId = $(this).attr('phoneId');
                // $.post("changePeopleProfiles.do",{'peopleId':currentPeopleId,'phoneId':phoneId});
                // $('#modal').modal('show');
                // return false;
            })
        }
        i++;
    });
}

$(document).ready(function () {

    currentPeopleId = $('#myId').attr('myId');


    $('#removeLike').click(function () {
        $('#modal').modal('hide');

        $.post("removeLike.do",{'peopleId':currentPeopleId,'phoneId':currentPhoneId},function (data,status) {
            if(status=='success'&&data=='success') {
                $('#modal').modal('hide');
                $('[phoneId=' + currentPhoneId.toString()+']').hide();
                $('#info').text('取消收藏成功');
                $('#message').modal('show');
            }else{
                $('#info').text('取消收藏失败');
                $('#message').modal('show');
            }
        })
    })

   

    forEach();
    $('#likeLoadMore').click(function () {
        $.post("getRecommendPhoneInfoByPage.do", {peopleId: currentPeopleId,page: likePage},
            function (data, status) {
                var dataObj = eval("(" + data + ")");
                var phoneInfoItems = $('#phoneInfoItems');
                var string = "";
                for (var i = 0; i < dataObj.phoneInfos.length; i++) {
                    string = string + switchString(dataObj.phoneInfos[i].id,dataObj.phoneInfos[i].link, dataObj.phoneInfos[i].img, dataObj.phoneInfos[i].title, dataObj.phoneInfos[i].price,
                             dataObj.phoneInfos[i].brand,dataObj.phoneInfos[i].size,dataObj.phoneInfos[i].ram,dataObj.phoneInfos[i].pixel,dataObj.phoneInfos[i].rom,dataObj.phoneInfos[i].cpu);
                }
                phoneInfoItems.append(string);
                likePage++;
                forEach();
            });
    })
})

/*onclick="changePeopleProfiles(1,'+id+')"*/
function switchString(id,link, img, title, price,brand,size,ram,pixel,rom,cpu) {
    return '<a href="' + link + '" class="list-group-item myItem"  phoneId="'+id+'">' +
        '<div class="row">' +
        '<div class="col-xs-3" style="margin-top:15px;margin-bottom: 15px;">' +
        '<img src="' + img + '" alt="" class="img-rounded">' +
        '</div>' +
        '<div class="col-xs-9" >' +
        '<h5 class="list-group-item-heading">' + title + '</h5>' +
        '<h5  style="color: red;margin: 3px;">' + price + '￥</h5>' +
        '<table class="show-table" style=" width: 100%;table-layout: fixed; font-size: 12px;">'+
        '<tr><th>品牌:</th><td>'+brand+'</td><th>尺寸:</th><td>'+size +'</td></tr>'+
        '<tr><th>运行内存:</th><td>'+ram+'</td><th>像素:</th><td>'+pixel +'</td></tr>'+
        '<tr><th>机身内存:</th><td>'+rom+'</td><th>CUP核数:</th><td>'+cpu +'</td></tr>'+
        '</table>'+
        '</div>' +
        '</div>' +
        '</a>';


}


function changePeopleProfiles(peopleId, phoneId) {
    $.post("changePeopleProfiles.do", {"peopleId": peopleId, "phoneId": phoneId}, function (data,status) {
        alert(data);
    })
}






