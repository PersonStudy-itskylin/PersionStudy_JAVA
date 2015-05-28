function getPageAdwordService(result) {
    if (result.skuExtInfo != null && result.skuExtInfo != "") {
        var productExt = "<font color=\"#ef0000\">����Ʒ" + result.skuExtInfo + "</font>";
        $("#nocoupon").html(productExt);
        $("#nocoupon").show();
    }
    if (result.promotionInfoList.length > 0) {
        var skuId = result.skuId;
        var jsonData = result.promotionInfoList;
        //��Ʒ������Ϣ
        var unitInfor = "<table cellspacing='0' cellpadding='0' border='0'><tr><td valign='top'>������Ϣ��</td><td>";
        var tag = 0;
        $.each(jsonData, function(i, item) {
            //��Ʒ����
            if (item.promoType == 1) {

                var userleverPriceInfo = "";
                //��Ա����
                var level = item.userLevel;
                //������
                var price = item.price;
                //����
                var score = item.score;
                //ֱ��
                var discount = item.discount;
                //ȯ
                var coupon = item.adwordCouponList;
                //��С������
                var minNum = item.minNum;

                <!--ƴ�ӵ�Ʒ������Ϣ-->
                var discountInfo = "";
                if (minNum > 1) {
                    discountInfo += "�����Żݼۣ���" + price + ",�蹺��" + minNum + "������������";
                } else {
                    if (level <= 50 && discount > 0 && skuId.length != 10) {
                        discountInfo += "���Żݣ�" + discount;
                    }
                    else if (level > 50 && price > 0) {
                        userleverPriceInfo = getCustomerLevel(level) + "�����ϻ�Ա�ۣ���" + price;
                        discountInfo += userleverPriceInfo;
                    }
                }
                if (score > 0) {
                    discountInfo += " ����" + score + "����";
                }
                if (coupon != null && coupon.length > 0) {
                    $.each(coupon, function(name, value) {
                        if (value.type == 1) {
                            if (value.key != null && value.key != "") {
                                if (value.adWord == null) {
                                    value.adWord = "";
                                }
                                if (value.adWord != null && value.adWord.length > 0) {
                                    discountInfo += " ���ͣ�" + value.couponQouta + "Ԫ��Ʒ����Ӿ�ȯ��" + value.adWord + ")";
                                }
                                else {
                                    discountInfo += " ���ͣ�" + value.couponQouta + "Ԫ��Ʒ����Ӿ�ȯ";
                                }

                            }
                            else {
                                discountInfo += " ���ͣ�" + value.couponQouta + "Ԫ���Ӿ�ȯ";
                            }
                        }
                    });
                }
                if (discountInfo.length > 0) {
                    unitInfor += "<div><font color='red'>" + discountInfo +"</font></div>";
                    tag = 1;
                }
                $("#promotion1").html(userleverPriceInfo);
            }
            //�ⶥ����
            if (item.promoType == 15) {
                var adword = item.adword;
                var bookTopAdword = "����Ʒ����ͼ��ⶥ�ۿۻ";
                if (adword != null && adword != "") {
                    unitInfor += "<div><font color=\"#ef0000\">" + adword + "</font></div>";
                }
                else {
                    unitInfor += "<div><font color=\"#ef0000\">" + bookTopAdword + "</font></div>";
                }
                tag = 1;
            }


            //��Ʒ����
            if (item.promoType == 4) {
                var giftfujianList = item.adwordGiftSkuList;
                var couponList = item.adwordCouponList;
                var score = item.score;
                var minNum = item.minNum;
                var jq = 0;
                var giftList = [];
                var fujianList = [];
                if (giftfujianList != null && giftfujianList.length > 0) {
                    $.each(giftfujianList, function(x, gift) {
                        if (gift.giftType == 2)
                            giftList[giftList.length] = gift;
                        if (gift.giftType == 1)
                            fujianList[fujianList.length] = gift;
                    });
                }
                if (couponList != null && couponList.length > 0) {
                    $.each(couponList, function(y, coupon) {
                        if (coupon.type == 1) {
                            jq = jq + coupon.couponQouta;
                        }
                    });
                }
                <!--ƴ����Ʒ������Ϣ-->
                var giftTotalInfo = "<span class=\"fl\"><font color=\"red\">��&nbsp;&nbsp;&nbsp;&nbsp;Ʒ</font>��</span><div id=\"i-largess\" class=\"fl\">";
                var giftInfo = "";
                if (giftList.length > 0) {
                    $.each(giftList, function(a, giftItem) {
                        if (giftItem.giftState != 1 && (giftItem.imagePath == "" || giftItem.imagePath == null)) {
                            giftInfo += giftItem.name + " <font color=red>��" + giftItem.number + "</font>";
                        }
                        else {
                            var wstatestr = "<a target = '_blank' href='http://www.360buy.com/product/" + giftItem.skuId + "\.html'>" + giftItem.name + "</a>"
                                + " <font color='red'>��" + giftItem.number + "</font>";
                            if (giftItem.imagePath != null && giftItem.imagePath != "") {
                                var imgPath = "<a target='_blank' href='http://www.360buy.com/bigimage.aspx?id="
                                    + giftItem.skuId + "\&type=1'><img src='http://img10.360buyimg.com/n5/" + giftItem.imagePath + "' /></a>";
                                giftInfo += "<div> " + imgPath + wstatestr + "</div>";
                            } else {
                                giftInfo += "<div> " + wstatestr + "</div>";
                            }
                        }
                    });
                }

                if (score > 0) {
                    giftInfo += "<div> " + "���ͣ�" + score + "���� </div>";
                }
                if (jq > 0) {
                    if (score > 0)
                        giftInfo += "<div> " + "���͵��Ӿ�ȯ��" + jq + "Ԫ </div>";
                    else
                        giftInfo += "<div> ���͵��Ӿ�ȯ��" + jq + "Ԫ </div>";
                }
                if (giftInfo != "") {
                    giftTotalInfo += giftInfo + "</div>";
                    $("#liLargess").html(giftTotalInfo);
                    $("#liLargess").show();
                }

                <!--ƴ�Ӹ�����Ϣ-->
                if (fujianList.length > 0) {
                    var fujianInfo = "<div id='fujianContent'>";
                    $.each(fujianList, function(b, fjItem) {
                        if ((fjItem.imagePath == "" || fjItem.imagePath == null) && fjItem.giftState != 1) {
                            fujianInfo += "<div>" + fjItem.name + " �� " + fjItem.number + "</div>";
                        } else {
                            fujianInfo += "<div><a target = '_blank' href='http://www.360buy.com/product/"
                                + fjItem.skuId + "\.html'>" + fjItem.name + "</a> �� " + fjItem.number + "</div>";
                        }
                    });
                    fujianInfo += "</div>";
                    if ($("#fujianContent").length <= 0) {
                        $("#bzqd").append(fujianInfo);
                    }
                }
            }

            //������������
            if (item.promoType == 10) {
                //�� ������
                var FULL_REFUND = 1;
                //ÿ��������
                var FULL_REFUND_PER = 2;
                //�Ӽ۹�
                var EXTRA_PRICE = 4;
                //��������
                var FULL_LADDER = 6;
                //�����ٷֱ�
                var PERCENT = 8;
                //������������������
                var fullRefundType = item.fullRefundType;
                var reward = item.reward;
                var needMoney = item.needMondey;
                var addMoney = item.addMoney;
                var topMoney = item.topMoney;
                var percent = item.percent;
                var score = item.score;
                var couponList = item.adwordCouponList;
                var haveGifts = item.haveFullRefundGifts;
                var jq = 0;
                var fullLadderList = item.fullLadderDiscountList;
                var adwordLink = item.adwordUrl;

                <!--ƴ������������Ϣ-->
                var fullRefundInfo = "";
                if (couponList != null && couponList.length > 0) {
                    $.each(couponList, function(z, couponValue) {
                        if (couponValue.type == 1) {
                            jq = jq + coupon.couponQouta;
                        }
                    });
                }

                if (fullRefundType == FULL_REFUND) {
                    fullRefundInfo = "����Ʒ�μ��������������Ʒ��" + needMoney + "Ԫ���ɼ�" + reward + "Ԫ�ֽ�";
                    if (haveGifts) {
                        fullRefundInfo = "������Ʒ��" + needMoney + "Ԫ�������ȵ��ȵ����꼴ֹ";
                    } else if (jq > 0) {
                        fullRefundInfo = "����Ʒ�μ��������������Ʒ��" + needMoney + "Ԫ���ɷ�" + jq + "Ԫ��ȯ";
                    }
                } else if (fullRefundType == FULL_REFUND_PER) {
                    if (reward > 0) {
                        fullRefundInfo = "����Ʒ�μ��������������Ʒÿ��" + needMoney + "Ԫ���ɼ�" + reward + "Ԫ�ֽ�";
                        if (topMoney > 0) {
                            fullRefundInfo += "������Ż�" + topMoney + "Ԫ�ֽ�";
                        }
                    } else {
                        if (haveGifts) {
                            fullRefundInfo = "������Ʒÿ��" + needMoney + "Ԫ�������ȵ��ȵ����꼴ֹ";
                        } else if (jq > 0) {
                            fullRefundInfo = "����Ʒ�μ��������������Ʒÿ��" + needMoney + "Ԫ���ɷ�" + jq + "Ԫ��ȯ";
                        }
                    }
                } else if (fullRefundType == EXTRA_PRICE) {
                    if (addMoney > 0) {
                        fullRefundInfo = "������Ʒ��" + needMoney + "Ԫ��" + addMoney + "Ԫ�������ȵ��ȵ����꼴ֹ";
                    }
                } else if (fullRefundType == PERCENT) {
                    if (percent > 0) {
                        percent = percent * 100;
                        fullRefundInfo = "����Ʒ�μ��������������Ʒ��" + needMoney + "Ԫ���ɼ�" + percent + "%";
                    }
                } else if (fullRefundType == FULL_LADDER) {
                    if (fullLadderList != null && fullLadderList.length > 0) {
                        fullRefundInfo = "����Ʒ�μӽ����������������Ʒ<br/>";
                        $.each(fullLadderList, function(z, fullLadderValue) {
                            if (fullLadderValue.needMoney > 0 && fullLadderValue.rewardMoney > 0) {
                                fullRefundInfo = fullRefundInfo + "��" + fullLadderValue.needMoney + "��" + fullLadderValue.rewardMoney + "Ԫ��";
                            }
                        });
                        fullRefundInfo = fullRefundInfo.substring(0, fullRefundInfo.length - 1)
                    }
                }

                var fullRefundTotalInfo = "";
                if (fullRefundInfo != "") {
                    if(adwordLink != null && adwordLink.length > 0) {
                        fullRefundInfo = "<a target=\"_blank\" style='color: red' href=\"" + adwordLink + "\">" + fullRefundInfo + "</a>";
                    }
                    fullRefundTotalInfo = "<table cellspacing='0' cellpadding='0' border='0'><tr><td valign='top' width='60'>������Ϣ��</td><td><font color='red'>"
                        + fullRefundInfo + "</red></td></tr></table>";
                }

                $("#mfms").html(fullRefundTotalInfo);
                $("#mfms").show();

            }

        });
        if (tag == 1) {
            unitInfor += "</td></tr></table>";
            $("#cx").html(unitInfor);
            $("#cx").show();
        }
    }

}

function getCustomerLevel(level) {
    switch (level) {
        case 50:
            return "ע���û�";
        case 56:
            return "�����û�";
        case 59:
            return "ע���û�";
        case 60:
            return "ͭ���û�";

        case 61:
            return "�����û�";

        case 62:
            return "�����û�";

        case 63:
            return "��ʯ�û�";

        case 64:
            return "������";

        case 65:
            return "VIP";

        case 66:
            return "����Ա��";

        case -1:
            return "δע��";

        case 88:
            return "˫���û�";

        case 90:
            return "��ҵ�û�";

        case 103:
            return "�����û�";

        case 104:
            return "�����û�";

        case 105:
            return "�����û�";
    }
    return "δ֪";
}

function refreshPack() {
    var skuId = $("#name").attr("pshowskuid");

    if (skuId % 1 == 0) {
        $.ajax({
			url:"http://jprice.360buy.com/pageadword/"+skuId +"-1-1.html",
			dataType:"script",
			cache:true,
			scriptCharset:"utf-8"
		})
    } else {
        $.getJSONP(
            //"promotioninfo.aspx?callback=getPacks&pid="+so,
            "http://price.360buy.com/promotioninfo.aspx?callback=getPacks&pid=" + skuId,
            getPacks);
    }
}

function getPacks(result) {
    /*
     if (result.pack != null && result.pack != "")
     {
     $("#suit").html(result.pack);
     $("#suit").show();
     $("#suit").jdTab(
     {
     event:"click"
     },setSuitWidth)
     setSuitWidth("",$("#suit").find(".tabcon").eq(0));
     }
     */
    if (result.largess != null && result.largess != "") {
        $("#liLargess").html(result.largess);
        $("#liLargess").show();
    }

    if (result.fujian != null && result.fujian != "") {
        if ($("#fujianContent").length <= 0)
            $("#bzqd").append(result.fujian);

    }

    if (result.product != null && result.product != "") {
        $("#cx").html(result.product);
        $("#cx").show();
    }

    if (result.price != null && result.price != "") {
        $("#promotion1").html(result.price);
    }

    if (result.ext != null && result.ext != "") {
        $("#nocoupon").html(result.ext);
        $("#nocoupon").show();
    }

    if (result.oldtonew != null && result.oldtonew != "") {
        $("#service-trade").html(result.oldtonew);
        var iplocation = null;
        if (getCookie) iplocation = getCookie("ipLocation");
        if ((iplocation && result.oldtonew.indexOf(iplocation) > 0) || !iplocation) {
            $("#service-trade").show();
        } else {
            $("#service-trade").hide();
        }
    }
    if (result.mfms != null && result.mfms != "") {
        $("#mfms").html(result.mfms);
        $("#mfms").show();
    }
//	if(result.promoKey != null && result.promoKey != "")
//	{
//	    $("#choose").find("a").filter(".btn-append").each(function(){
//
//	        if(this.href != null && this.href != undefined && this.href.toLowerCase().indexOf('initcart.aspx') != -1)
//	        {
//	           this.href +="&promId="+result.promoKey;
//	        }
//	    });
//	}
}
refreshPack();