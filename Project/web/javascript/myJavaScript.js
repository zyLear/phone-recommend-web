/**
 * Created by Administrator on 2017/6/6.
 */

var current = "15"
//var currentPage = 2;
var currentPeopleId=1;
var currentPhoneId=20000;
// var timeOutEvent = 0;





var translation=new Object()

// alert(aa.bbb);
// alert(JSON.stringify(aa));
translation.currentPage=2;

translation.searchTitle = "";

translation.startPrice = 0;

translation.endPrice = 200000;

translation.brandApple = 0;

translation.brandMi = 0;

translation.brandHonor = 0;

translation.brandSamsung = 0;

translation.brandMeizu = 0;

translation.brandHuawei = 0;

translation.brandOppo = 0;

translation.brandVivo = 0;

translation.brandNokia = 0;

translation.brandLetv = 0;

translation.brandOther = 0;

translation.sizeLess3p0 = 0;

translation.size3p0to4p5 = 0;

translation.size4p6to5p0 = 0;

translation.size5p1to5p5 = 0;

translation.sizeGreater5p5 = 0;

translation.sizeOther = 0;

translation.ram2 = 0;

translation.ram3 = 0;

translation.ram4 = 0;

translation.ram6 = 0;

translation.ramOther = 0;

translation.pixelLess500 = 0;

translation.pixel500to1000 = 0;

translation.pixel1001to1600 = 0;

translation.pixelGreater1600 = 0;

translation.pixelOther = 0;

translation.rom8 = 0;

translation.rom16 = 0;

translation.rom32 = 0;

translation.rom64 = 0;

translation.rom128 = 0;

translation.romOther = 0;

translation.cpu1 = 0;

translation.cpu2 = 0;

translation.cpu4 = 0;

translation.cpu6 = 0;

translation.cpu8 = 0;

translation.cpuOther = 0;

translation.sort = 0;




$.fn.longPress = function (fn) {
    var timeOut = undefined;
    var $this = this;
    //alert(this.attr('href'));
    for (var i = 0; i < this.length; i++) {
        this[i].addEventListener('touchstart', function (event) {
            timeOut = setTimeout(function () {
                fn($this);
            }, 600);
        }, false);
        this[i].addEventListener('touchmove', function (event) {
            clearTimeout(timeOut);
        });
        this[i].addEventListener('touchend', function (event) {
            clearTimeout(timeOut);
        }, false);
    }
}


$.fn.outout = function () {
    alert(this);
    alert($(this));
    alert(this.attr('id'));
    alert($(this).attr('id'));
};

$.fn.myTest = function () {
    fn(1);
};




function switchProperty(sign){
    switch (Number(sign)){
        case 1 : translation.brandApple=1-translation.brandApple; break;
        case 2 : translation.brandMi=1-translation.brandMi; break;
        case 3 : translation.brandHonor=1-translation.brandHonor; break;
        case 4 : translation.brandSamsung=1-translation.brandSamsung; break;
        case 5 : translation.brandMeizu=1-translation.brandMeizu; break;
        case 6 : translation.brandHuawei=1-translation.brandHuawei; break;
        case 7 : translation.brandOppo=1-translation.brandOppo; break;
        case 8 : translation.brandVivo=1-translation.brandVivo; break;
        case 9 : translation.brandNokia=1-translation.brandNokia; break;
        case 10 : translation.brandLetv=1-translation.brandLetv; break;
        case 11 : translation.brandOther=1-translation.brandOther; break;

        case 12 : translation.sizeLess3p0=1-translation.sizeLess3p0; break;
        case 13 : translation.size3p0to4p5=1-translation.size3p0to4p5; break;
        case 14 : translation.size4p6to5p0=1-translation.size4p6to5p0; break;
        case 15 : translation.size5p1to5p5=1-translation.size5p1to5p5; break;
        case 16 : translation.sizeGreater5p5=1-translation.brandHuawei; break;
        case 17 : translation.sizeOther=1-translation.sizeOther; break;

        case 18 : translation.ram2=1-translation.ram2; break;
        case 19 : translation.ram3=1-translation.ram3; break;
        case 20 : translation.ram4=1-translation.ram4; break;
        case 21 : translation.ram6=1-translation.ram6; break;
        case 22 : translation.ramOther=1-translation.ramOther; break;

        case 23 : translation.pixelLess500=1-translation.pixelLess500; break;
        case 24 : translation.pixel500to1000=1-translation.pixel500to1000; break;
        case 25 : translation.pixel1001to1600=1-translation.pixel1001to1600; break;
        case 26 : translation.pixelGreater1600=1-translation.pixelGreater1600; break;
        case 27 : translation.pixelOther=1-translation.pixelOther; break;

        case 28 : translation.rom8=1-translation.rom8; break;
        case 29 : translation.rom16=1-translation.rom16; break;
        case 30 : translation.rom32=1-translation.rom32; break;
        case 31 : translation.rom64=1-translation.rom64; break;
        case 32 : translation.rom128=1-translation.rom128; break;
        case 33 : translation.romOther=1-translation.romOther; break;

        case 34 : translation.cpu1=1-translation.cpu1; break;
        case 35 : translation.cpu2=1-translation.cpu2; break;
        case 36 : translation.cpu4=1-translation.cpu4; break;
        case 37 : translation.cpu6=1-translation.cpu6; break;
        case 38 : translation.cpu8=1-translation.cpu8; break;
        case 39 : translation.cpuOther=1-translation.cpuOther; break;
        default : break;
    }
}

function addNewBorder(myThis) {
    myThis.removeClass('btn-old-border');
    myThis.addClass('btn-border');
}

function addOldBorder(myThis) {
    myThis.removeClass('btn-border');
    myThis.addClass('btn-old-border');
}

function forEachPhoneItems() {
    var i = 0;
    $('.list-group-item').each(function () {
        if (i >= (translation.currentPage - 2) * 20) {
            $(this).longPress(function ($this) {
                //alert($this.attr('href'));
                // $('#test-btn').click();
                //$('.bs-example-modal-sm').modal('toggle');
                currentPhoneId = $this.attr('phoneId');
                $('#modal').modal('show');
            });

            $(this).click(function () {
               // alert('test onClick()');
               //  var phoneId = $(this).attr('phoneId');
               //  $.post("changePeopleProfiles.do",{'peopleId':currentPeopleId,'phoneId':phoneId});
               //  $('#modal').modal('show');
               //  return false;
            })
        }
        i++;
    });
}

function forEachBtnAddEvent(){
    var signNumber=1;
    $('.nav.navbar-nav tr [name="myBtn"]').each(function () {
        $(this).attr('sign',signNumber);
        $(this).click(function () {
            $(this).toggleClass('btn-old-berder');
            $(this).toggleClass('btn-border');
            switchProperty($(this).attr('sign'));
        });
        signNumber++;
    })
}

function initSortBtn(){
    $('#count').click(function () {
        if(translation.sort==0) {
            return;
        }else{
            translation.sort=0;
            addNewBorder($(this));
            addOldBorder($('#priceAsc'));
            addOldBorder($('#priceDesc'));
            addOldBorder($('#costPerformance'));
        }
    });

    $('#priceAsc').click(function () {
        if(translation.sort==1) {
            return;
        }else{
            translation.sort=1;
            addNewBorder($(this));
            addOldBorder($('#count'));
            addOldBorder($('#priceDesc'));
            addOldBorder($('#costPerformance'));
        }
    });

    $('#priceDesc').click(function () {
        if(translation.sort==2) {
            return;
        }else{
            translation.sort=2;
            addNewBorder($(this));
            addOldBorder($('#priceAsc'));
            addOldBorder($('#count'));
            addOldBorder($('#costPerformance'));
        }
    });

    $('#costPerformance').click(function () {
        if(translation.sort==3) {
            return;
        }else{
            translation.sort=3;
            addNewBorder($(this));
            addOldBorder($('#priceAsc'));
            addOldBorder($('#priceDesc'));
            addOldBorder($('#count'));
        }
    });
}

$(document).ready(function () {
    forEachPhoneItems();
    forEachBtnAddEvent();
    initSortBtn();

    currentPeopleId = $('#myId').attr('myId');

    $('#like').click(function () {
        $('#modal').modal('hide');
        $.post("like.do",{'peopleId':currentPeopleId,'phoneId':currentPhoneId},function (data,status) {
            if(status=='success'&&data=='success') {
                $('#info').text('添加收藏成功');
                $('#message').modal('show');
            }else{
                $('#info').text('你已经收藏过了');
                $('#message').modal('show');
            }
        })
    });

    $('#search').click(function () {
        var searchText = $('#searchText').val();
        var startPrice=$('#startPrice').val();
        var endPrice = $('#endPrice').val();
        if(isNaN(startPrice)||isNaN(endPrice)) {
            alert('输入错误！');
            return;
        }else{
            translation.searchTitle=searchText;
            translation.startPrice=Number(startPrice);
            translation.endPrice=Number(endPrice);
            translation.currentPage=1;
            //alert(JSON.stringify(translation));
            $.post('findPhoneInfoBySelect.do',{'translation':JSON.stringify(translation)},function (data,status) {
                //正在加载
                var phoneInfoItems = $('#phoneInfoItems');
                phoneInfoItems.html('<div>正在加载</div>');

                if(status=='success'&&data!='failure'){
                    var dataObj= eval('('+data+')');
                    var string = "";
                    for (var i = 0; i < dataObj.phoneInfos.length; i++) {
                        string = string + switchString(dataObj.phoneInfos[i].id,dataObj.phoneInfos[i].link, dataObj.phoneInfos[i].img, dataObj.phoneInfos[i].title, dataObj.phoneInfos[i].price,
                                dataObj.phoneInfos[i].brand,dataObj.phoneInfos[i].size,dataObj.phoneInfos[i].ram,dataObj.phoneInfos[i].pixel,dataObj.phoneInfos[i].rom,dataObj.phoneInfos[i].cpu);
                    }
                    phoneInfoItems.html(string);
                    translation.currentPage++;
                    forEachPhoneItems();
                }
            })
        }
    });

    $('#allPhoneLoadMore').click(function () {
    //     $.post("getPhoneInfoByPage.do", {page: currentPage},
    //         function (data, status) {
    //             var dataObj = eval('(' + data + ')');
    //             var phoneInfoItems = $('#phoneInfoItems');
    //             var string = "";
    //             for (var i = 0; i < dataObj.phoneInfos.length; i++) {
    //                 string = string + switchString(dataObj.phoneInfos[i].id,dataObj.phoneInfos[i].link, dataObj.phoneInfos[i].img, dataObj.phoneInfos[i].title, dataObj.phoneInfos[i].price,
    //                         dataObj.phoneInfos[i].brand,dataObj.phoneInfos[i].size,dataObj.phoneInfos[i].ram,dataObj.phoneInfos[i].pixel,dataObj.phoneInfos[i].rom,dataObj.phoneInfos[i].cpu);
    //             }
    //             phoneInfoItems.append(string);
    //             currentPage++;
    //             forEach();
    //         });
    // });
        $.post('findPhoneInfoBySelect.do',{'translation':JSON.stringify(translation)},function (data,status) {
            //正在加载
            var phoneInfoItems = $('#phoneInfoItems');
            phoneInfoItems.append('<div id="loading">正在加载</div>');

            if (status == 'success' && data != 'failure') {
                var dataObj = eval('(' + data + ')');
                var string = "";
                for (var i = 0; i < dataObj.phoneInfos.length; i++) {
                    string = string + switchString(dataObj.phoneInfos[i].id, dataObj.phoneInfos[i].link, dataObj.phoneInfos[i].img, dataObj.phoneInfos[i].title, dataObj.phoneInfos[i].price,
                             dataObj.phoneInfos[i].brand, dataObj.phoneInfos[i].size, dataObj.phoneInfos[i].ram, dataObj.phoneInfos[i].pixel, dataObj.phoneInfos[i].rom, dataObj.phoneInfos[i].cpu);
                }
                $('#loading').remove();
                phoneInfoItems.append(string);
                translation.currentPage++;
                forEachPhoneItems();
            }else{
                $('#loading').remove();
            }
        })
    })
})

function switchString(id,link, img, title, price,brand,size,ram,pixel,rom,cpu) {
    return '<a href="' + link + '" class="list-group-item myItem" phoneId="'+id+'">' +
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

    // '<div class="col-xs-10">'+'<a href="' + link + '" class="list-group-item myItem">' +
    // '<div class="row">' +
    // '<div class="col-xs-3">' +
    // '<img src="' + img + '" alt="' + title + '" class="img-rounded">' +
    // '</div>' +
    // '<div class="col-xs-9" >' +
    // '<h4 class="list-group-item-heading">' + title + '</h4>' +
    // '<p class="list-group-item-text">' + price + '</p>' +
    // '</div>' +
    // '</div>' +
    // '</a>'+ '</div> <div class="col-xs-2"></div>';



}


// function changePeopleProfiles(peopleId, phoneId) {
//     $.post("changePeopleProfiles.do", {"peopleId": peopleId, "phoneId": phoneId}, function (data,status) {
//         alert(data);
//     })
// }






