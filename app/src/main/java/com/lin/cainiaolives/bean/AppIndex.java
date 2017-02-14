package com.lin.cainiaolives.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linxiangqu on 2016/8/20.
 */
public class AppIndex implements Serializable{

    /**
     * stateCode : 0
     * msg : 成功
     * advListDTO : [{"advId":1,"advClass":0,"advImg":"/XRMall/mallImg/0001.jpg"},{"advId":2,"advClass":0,"advImg":"/XRMall/mallImg/0002.jpg"},{"advId":3,"advClass":0,"advImg":"/XRMall/mallImg/0003.jpg"},{"advId":4,"advClass":0,"advImg":"/XRMall/mallImg/0004.jpg"},{"advId":5,"advClass":0,"advImg":"/XRMall/mallImg/0005.jpg"},{"advId":7,"advClass":0,"advImg":"/XRMall/u/cms/www/201606/27093739j7tw.jpg"}]
     * goodsClassListDTO : [{"gcId":1,"gcName":"男女服装","gcImage":"/XRMall/mallImg/NNFZ.png","gcParentId":null},{"gcId":2,"gcName":"鞋包配饰","gcImage":"/XRMall/mallImg/XBPS.png","gcParentId":null},{"gcId":3,"gcName":"美容美妆","gcImage":"/XRMall/mallImg/MRMZ.png","gcParentId":null},{"gcId":4,"gcName":"运动户外","gcImage":"/XRMall/mallImg/YDHW.png","gcParentId":null},{"gcId":5,"gcName":"数码家电","gcImage":"/XRMall/mallImg/SMJD.png","gcParentId":null},{"gcId":6,"gcName":"家居家装","gcImage":"/XRMall/mallImg/JJJZ.png","gcParentId":null},{"gcId":7,"gcName":"食品保健","gcImage":"/XRMall/mallImg/SPBJ.png","gcParentId":null},{"gcId":8,"gcName":"母婴用品","gcImage":"/XRMall/mallImg/MYYP.png","gcParentId":null},{"gcId":9,"gcName":"文化娱乐","gcImage":"/XRMall/mallImg/WHYL.png","gcParentId":null},{"gcId":10,"gcName":"话费网游","gcImage":"/XRMall/mallImg/HFWY.png","gcParentId":null},{"gcId":11,"gcName":"票务旅游","gcImage":"/XRMall/mallImg/PWLY.png","gcParentId":null},{"gcId":27,"gcName":"一级分类测试1","gcImage":"/XRMall/u/cms/www/201604/28094333g2dp.jpg","gcParentId":null}]
     * goodsGoodsTodayListDTO : [{"goodsId":3,"goodsName":"MIZUNO美津浓 K1GR160370 入门基础 男慢跑鞋 MIZUNO SPARK 银/蓝/亮绿 42","goodsSubtitle":null},{"goodsId":2,"goodsName":"New Balance（NB）ML574TSY 574男女款 复古鞋跑步鞋 情侣休闲鞋 US 8码 41.5码","goodsSubtitle":null},{"goodsId":24,"goodsName":"2016新款夏季短袖真丝睡裙女100%桑蚕丝睡衣家居服真丝睡衣","goodsSubtitle":"杭州市 著名商标 新款上市 优雅真丝睡裙"}]
     * mallTopicDTOs : [{"topicId":1,"title":"蒙牛","subTitle":"不是所有的牛奶都叫\u2026\u2026","image":"/XRMall/u/cms/www/201607/21160134oyno.jpg"},{"topicId":2,"title":"蒙牛","subTitle":"不是所有的","image":"/XRMall/u/cms/www/201607/21160228ydgs.jpg"},{"topicId":4,"title":"大米","subTitle":"买买买，美美美","image":"/XRMall/u/cms/www/201607/21160023jqlv.jpg"}]
     */

    private int stateCode;
    private String msg;
    /**
     * advId : 1
     * advClass : 0
     * advImg : /XRMall/mallImg/0001.jpg
     */

    private List<AdvListDTOBean> advListDTO;
    /**
     * gcId : 1
     * gcName : 男女服装
     * gcImage : /XRMall/mallImg/NNFZ.png
     * gcParentId : null
     */

    private List<GoodsClassListDTOBean> goodsClassListDTO;
    /**
     * goodsId : 3
     * goodsName : MIZUNO美津浓 K1GR160370 入门基础 男慢跑鞋 MIZUNO SPARK 银/蓝/亮绿 42
     * goodsSubtitle : null
     */

    private List<GoodsGoodsTodayListDTOBean> goodsGoodsTodayListDTO;
    /**
     * topicId : 1
     * title : 蒙牛
     * subTitle : 不是所有的牛奶都叫……
     * image : /XRMall/u/cms/www/201607/21160134oyno.jpg
     */

    private List<MallTopicDTOsBean> mallTopicDTOs;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<AdvListDTOBean> getAdvListDTO() {
        return advListDTO;
    }

    public void setAdvListDTO(List<AdvListDTOBean> advListDTO) {
        this.advListDTO = advListDTO;
    }

    public List<GoodsClassListDTOBean> getGoodsClassListDTO() {
        return goodsClassListDTO;
    }

    public void setGoodsClassListDTO(List<GoodsClassListDTOBean> goodsClassListDTO) {
        this.goodsClassListDTO = goodsClassListDTO;
    }

    public List<GoodsGoodsTodayListDTOBean> getGoodsGoodsTodayListDTO() {
        return goodsGoodsTodayListDTO;
    }

    public void setGoodsGoodsTodayListDTO(List<GoodsGoodsTodayListDTOBean> goodsGoodsTodayListDTO) {
        this.goodsGoodsTodayListDTO = goodsGoodsTodayListDTO;
    }

    public List<MallTopicDTOsBean> getMallTopicDTOs() {
        return mallTopicDTOs;
    }

    public void setMallTopicDTOs(List<MallTopicDTOsBean> mallTopicDTOs) {
        this.mallTopicDTOs = mallTopicDTOs;
    }

    public static class AdvListDTOBean {
        private int advId;
        private int advClass;
        private String advImg;

        public int getAdvId() {
            return advId;
        }

        public void setAdvId(int advId) {
            this.advId = advId;
        }

        public int getAdvClass() {
            return advClass;
        }

        public void setAdvClass(int advClass) {
            this.advClass = advClass;
        }

        public String getAdvImg() {
            return advImg;
        }

        public void setAdvImg(String advImg) {
            this.advImg = advImg;
        }
    }

    public static class GoodsClassListDTOBean {
        private int gcId;
        private String gcName;
        private String gcImage;
        private Object gcParentId;

        public int getGcId() {
            return gcId;
        }

        public void setGcId(int gcId) {
            this.gcId = gcId;
        }

        public String getGcName() {
            return gcName;
        }

        public void setGcName(String gcName) {
            this.gcName = gcName;
        }

        public String getGcImage() {
            return gcImage;
        }

        public void setGcImage(String gcImage) {
            this.gcImage = gcImage;
        }

        public Object getGcParentId() {
            return gcParentId;
        }

        public void setGcParentId(Object gcParentId) {
            this.gcParentId = gcParentId;
        }
    }

    public static class GoodsGoodsTodayListDTOBean {
        private int goodsId;
        private String goodsName;
        private Object goodsSubtitle;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public Object getGoodsSubtitle() {
            return goodsSubtitle;
        }

        public void setGoodsSubtitle(Object goodsSubtitle) {
            this.goodsSubtitle = goodsSubtitle;
        }
    }

    public static class MallTopicDTOsBean {
        private int topicId;
        private String title;
        private String subTitle;
        private String image;

        public int getTopicId() {
            return topicId;
        }

        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
